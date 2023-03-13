package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.List;

public class ThreeOfAKindHand extends AbstractHand {

    private static final int SCORE = 50;

    private Rank rank;


    public ThreeOfAKindHand(List<Card> cards) {
        super(cards);
        this.rank = getThreeOfaKindRank();
    }

    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean beats(Hand otherHand) {
        boolean result = false;

        if ( this.getScore() == otherHand.getScore() ) {
            if ( this.rank.getValue() > otherHand.getRank().getValue() ) {
                result = true;
            }
        } else if (this.getScore() > otherHand.getScore()) {
            result = true;
        }

        return result;
    }

    @Override
    public String getDescription() {
        return "Three Of a Kind";
    }

    private Rank getThreeOfaKindRank(){
        for (Card card: super.getCards()) {
            Rank rank = card.getRank();
            if (countRank(rank) == 3) {
                return rank;
            }
        }
        return null;
    }
}
