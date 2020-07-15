package com.bankwithmint.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CardHit {


    @javax.persistence.Id
    private String CardNumber;

    private int HitCount;

    public CardHit() {
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public int getHitCount() {
        return HitCount;
    }

    public void setHitCount(int hitCount) {
        HitCount = hitCount;
    }
}
