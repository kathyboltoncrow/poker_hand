package com.techreturners.hand;

import com.techreturners.Card;

import java.util.List;

public abstract class AbstractHand implements Hand {

    private List<Card> cards;

    public AbstractHand(List<Card> cards) {
        this.cards = cards;
    }

}
