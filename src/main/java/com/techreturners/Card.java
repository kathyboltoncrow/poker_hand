package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }


    @Override
    public String toString() {
        return String.valueOf(rank.toChar()) + String.valueOf(suit.toChar());
    }

}
