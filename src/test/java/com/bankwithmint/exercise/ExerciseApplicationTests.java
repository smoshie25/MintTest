package com.bankwithmint.exercise;

import com.bankwithmint.exercise.entity.CardHit;
import com.bankwithmint.exercise.model.CardResponse;
import com.bankwithmint.exercise.model.response.Payload;
import com.bankwithmint.exercise.service.CardHitService;
import com.bankwithmint.exercise.web.CardController;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import static com.bankwithmint.exercise.web.CardController.getDataItem;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExerciseApplicationTests {

    @Autowired
    CardHitService cardHitService;

    @Test
    void verify() {

        CardResponse cardResponse = getDataItem("45717360");
        if(cardResponse!=null){
            Payload payload = new Payload();
            payload.setScheme(cardResponse.getScheme());
            payload.setType(cardResponse.getType());
            payload.setBank(cardResponse.getBank().getName());
            CardHit cardHit = cardHitService.createCardHit("45717360");

            assertThat(cardHit.getHitCount()).isGreaterThan(0);
            assertThat(cardHit.getCardNumber()).isEqualTo("45717360");

            cardHitService.createCardHit("45717360");
            cardHit = cardHitService.createCardHit("45717360");
            assertThat(cardHit.getHitCount()).isEqualTo(3);
        }
    }


}
