package com.bankwithmint.exercise.service;

import com.bankwithmint.exercise.entity.CardHit;
import com.bankwithmint.exercise.repo.CardHitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardHitService {

    private CardHitRepository cardHitRepository;

    @Autowired
    public CardHitService(CardHitRepository cardHitRepository) {
        this.cardHitRepository = cardHitRepository;
    }

    public CardHit createCardHit(String cardNumber){
        if(cardHitRepository.existsById(cardNumber)){
            Optional<CardHit> cardHit = cardHitRepository.findById(cardNumber);
            int count = cardHit.get().getHitCount();
            count++;
            cardHit.get().setHitCount(count);
            cardHitRepository.save(cardHit.get());
            return cardHit.get();
        }else{
            CardHit cardHit = new CardHit();
            cardHit.setCardNumber(cardNumber);
            cardHit.setHitCount(1);
            cardHitRepository.save(cardHit);
            return cardHit;
        }
    }

    public Page<CardHit> getAll(Pageable pageable){
        return cardHitRepository.findAll(pageable);
    }

    public long total(){
        return cardHitRepository.count();
    }

}
