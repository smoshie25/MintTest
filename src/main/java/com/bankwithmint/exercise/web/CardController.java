package com.bankwithmint.exercise.web;

import com.bankwithmint.exercise.entity.CardHit;
import com.bankwithmint.exercise.model.CardResponse;
import com.bankwithmint.exercise.model.response.CustomerResponse;
import com.bankwithmint.exercise.model.response.Payload;
import com.bankwithmint.exercise.service.CardHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path = "/card-scheme")
public class CardController {

    @Autowired
    CardHitService cardHitService;
    @Autowired
    KafkaTemplate<String,Payload> kafkaTemplate;

    public static final String uri = "https://lookup.binlist.net/";

    @RequestMapping(method = RequestMethod.GET,path = "/verify/{cardNum}")
    public CustomerResponse verify(@PathVariable(value = "cardNum") String cardNum) {

        CustomerResponse customerResponse = new CustomerResponse();

        CardResponse cardResponse = getDataItems(cardNum);
        if(cardResponse!=null){
            customerResponse.setSuccess(true);
            Payload payload = new Payload();
            payload.setScheme(cardResponse.getScheme());
            payload.setType(cardResponse.getType());
            payload.setBank(cardResponse.getBank().getName());
            customerResponse.setPayload(payload);
            cardHitService.createCardHit(cardNum);
        }else{
            customerResponse.setSuccess(false);
        }
        kafkaTemplate.send("com.ng.vela.even.card_verified",customerResponse.getPayload());
        return customerResponse;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/stats")
    public Page<CardHit> stats(Pageable pageable) {

        return cardHitService.getAll(pageable);
    }




    public static CardResponse getDataItems(String cardNum){

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                    uri+cardNum,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<CardResponse>() {
                    });
            CardResponse cardResponse = responseEntity.getBody();
            return cardResponse;
        }catch(HttpClientErrorException e){
            e.printStackTrace();
            return null;
        }

    }
}
