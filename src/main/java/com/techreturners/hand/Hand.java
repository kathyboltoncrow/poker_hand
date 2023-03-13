package com.techreturners.hand;

import java.util.List;

import com.techreturners.Card;
import com.techreturners.enums.Rank;

public interface Hand {

    public List<Card> getCards();
    public int getScore();
    public Rank getRank();
    public boolean beats(Hand otherHand);
    public String getDescription();

}