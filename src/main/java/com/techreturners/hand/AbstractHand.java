package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.List;

public abstract class AbstractHand implements Hand {

    private List<Card> cards;

    public AbstractHand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public int countRank(Rank rank){
        int countRank = 0;
        for (Card card: cards) {
            if( card.getRank().equals(rank) ) {
                countRank++;
            }
        }
        return countRank;
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
