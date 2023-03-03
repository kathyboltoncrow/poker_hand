package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;

public class Deck {

    private static Card [] deck;
    private static final int DECK_CARDS = 52;

    public Card [] initialiseDeck() {
        deck = new Card[DECK_CARDS];
        int index = 0;

        for(int i = 0; i < 13; i++){
            Rank value = Rank.values()[i];
            for(int j = 0; j < 4; j++){
                deck[index] = new Card(value, Suit.values()[j]);
                System.out.println(value.toString() + " of " + Suit.values()[j].toString());
                index++;
            }
        }
        return deck;
    }

}
