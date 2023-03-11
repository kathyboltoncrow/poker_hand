package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.List;

public class StraightHand extends AbstractHand {

    private static final int SCORE = 60;

    private Rank rank;
    public StraightHand(List<Card> cards) {
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
        return "Straight";
    }

    public static Card getHighCard(List<Card> cards){

        Card highCard = null;

        for (Card card: cards) {
            if(highCard == null){
                highCard = card;
            } else {
                if(card.getRank().getValue() > highCard.getRank().getValue() ){
                    highCard = card;
                }
            }
        }
        return highCard;
    }

}
