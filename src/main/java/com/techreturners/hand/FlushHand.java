package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.List;

public class FlushHand extends AbstractHand {

    private static final int SCORE = 70;

    private Rank rank;

    public FlushHand(List<Card> cards) {
        super(cards);
        Card highCard = getHighCard(cards);
        this.rank = highCard.getRank();
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
        return "Flush";
    }

}
