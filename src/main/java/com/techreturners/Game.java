package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;

import java.util.*;

public class Game {

    private static final int DECK_CARDS = 52;
    private static final int NUMBER_CARDS_PER_HAND = 5;
    private List<Card> deck;


    public List<Card> initialiseDeck() {
        deck = new ArrayList<>(DECK_CARDS);

        for (int i = 0; i < 13; i++) {
            Rank value = Rank.values()[i];
            for (int j = 0; j < 4; j++) {
                Card card = new Card(value, Suit.values()[j]);
                deck.add(card);
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

        public List<Card> deal() {
            ArrayList<Card> hand = new ArrayList<Card>();
            for(int i = 0; i < NUMBER_CARDS_PER_HAND; i++) {
               hand.add(deck.get(i));
               deck.remove(i);
            }
            return hand;

         }

}







