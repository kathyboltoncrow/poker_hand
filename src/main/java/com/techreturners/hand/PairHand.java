package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class PairHand extends AbstractHand {

    private static final int SCORE = 30;

    private Rank rank;


    public PairHand(List<Card> cards) {
        super(cards);
        this.rank = this.getPairRank();
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

        if (this.getScore() > otherHand.getScore()) {
            result = true;
        } else if ( this.getScore() == otherHand.getScore() ) {
            if ( this.rank.isGreater(otherHand.getRank()) ) {
                result = true;
            } else if ( this.rank == otherHand.getRank() ) {
                List<Card> myCards = new ArrayList<>(getCards());
                List<Card> otherCards = new ArrayList<>(otherHand.getCards());
                Card myHighCard, otherHighCard;

                for (int i = 0; i < 5; i++) {
                    myHighCard = AbstractHand.getHighCard(myCards);
                    otherHighCard = AbstractHand.getHighCard(otherCards);
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
            }
        }

        return result;
    }

    @Override
    public String getDescription() {
        return "Pair";
    }

    private Rank getPairRank(){
        for (Card card: super.getCards()) {
            Rank rank = card.getRank();
            if (super.countRank(rank) == 2) {
                return rank;
            }
        }
        return null;
    }
}
