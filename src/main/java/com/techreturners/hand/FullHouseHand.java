package com.techreturners.hand;

import com.techreturners.Card;

import java.util.List;

public class FullHouseHand extends ThreeOfAKindHand {

    private static final int SCORE = 80;

    public FullHouseHand(List<Card> cards) {
        super(cards);
    }

    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public String getDescription() {
        return "Full House";
    }

}
