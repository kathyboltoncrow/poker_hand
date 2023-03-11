package com.techreturners.hand;

import com.techreturners.enums.Rank;

public interface Hand {

    public int getScore();

    public Rank getRank();

    public boolean beats(Hand otherHand);
    public String getDescription();

}
