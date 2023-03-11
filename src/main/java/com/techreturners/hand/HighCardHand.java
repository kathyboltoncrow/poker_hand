package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighCardHand extends AbstractHand {
    private static final int SCORE = 10;
    private Rank rank;
    private String highCardName;

    public HighCardHand(List<Card> cards) {
        super(cards);
        Card highCard = getHighCard(cards);
        this.rank = highCard.getRank();

        if(this.getRank().getValue() >= 2 && this.getRank().getValue() <= 9) {
            this.highCardName = this.getRank().toString();
        }else{
            this.highCardName = this.getRank().name();
        }
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
            } else if ( this.rank.getValue() == otherHand.getRank().getValue()){
                //todo get next highest
                //compare card ranks()

            }
        } else if (this.getScore() > otherHand.getScore()) {
            result = true;
        }

        return result;
    }

    @Override
    public String getDescription() {
        return "High Card: " + highCardName;
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

    public int compareCardRanks(){
        return 0;

    }

}
