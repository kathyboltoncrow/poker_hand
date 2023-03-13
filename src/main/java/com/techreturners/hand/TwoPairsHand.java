package com.techreturners.hand;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

import java.util.*;

public class TwoPairsHand extends AbstractHand {
    private static final int SCORE = 40;
    private Rank highPairRank = null;
    private Rank lowPairRank = null;
    private Rank kickerRank = null;

    public TwoPairsHand(List<Card> cards) {
        super(cards);
        extractRanks();
    }

    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public Rank getRank() {
        return highPairRank;
    }

    public boolean beats(Hand otherHand) {
        boolean result = false;

        if (this.getScore() > otherHand.getScore()) {
            result = true;
        } else if (this.getScore() == otherHand.getScore()) {
            TwoPairsHand other = (TwoPairsHand) otherHand;
            if (this.highPairRank.getValue() > other.highPairRank.getValue()) {
                result = true;
            } else if (this.highPairRank.getValue() == other.highPairRank.getValue()) {
                if (this.lowPairRank.getValue() > other.lowPairRank.getValue()) {
                    result = true;
                } else if(this.lowPairRank.getValue() == other.lowPairRank.getValue()){
                    if(this.kickerRank.getValue() > other.kickerRank.getValue()){
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String getDescription() {
        return "Two Pairs";
    }

    public void extractRanks() {

        for (Card card : super.getCards()) {
            Rank rank = card.getRank();
            if (countRank(rank) == 1) {
                kickerRank = rank;
            } else {
                if (highPairRank == null && lowPairRank == null) {
                    highPairRank = rank;
                } else if (rank.isGreater(highPairRank)) {
                    lowPairRank = highPairRank;
                    highPairRank = rank;
                } else{
                    lowPairRank = rank;
                }
            }
        }
    }
}
