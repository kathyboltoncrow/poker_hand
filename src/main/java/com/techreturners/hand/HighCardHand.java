package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class HighCardHand extends AbstractHand {
    private static final int SCORE = 10;
    private Rank rank;
    private String highCardName;

    public HighCardHand(List<Card> cards) {
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
    public String getDescription() {
        return "High Card";
    }

    @Override
    public boolean beats(Hand otherHand) {
        boolean result = false;

        if ( this.getScore() == otherHand.getScore() ) {

            List<Card> myCards = new ArrayList<>(getCards());
            List<Card> otherCards = new ArrayList<>(otherHand.getCards());
            Card myHighCard, otherHighCard;

            for (int i = 0; i < 5; i++) {
                myHighCard = HighCardHand.getHighCard(myCards);
                otherHighCard = HighCardHand.getHighCard(otherCards);
                int myHighCardValue = myHighCard.getRank().getValue();
                int otherHighCardValue = otherHighCard.getRank().getValue();

                if ( myHighCardValue == otherHighCardValue ) {
                    myCards.remove(myHighCard);
                    otherCards.remove(otherHighCard);

                } else if ( myHighCardValue > otherHighCardValue ) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if (this.getScore() > otherHand.getScore()) {
            result = true;
        }

        return result;
    }

}
