package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    private static Card [] deck;
    private static final int DECK_CARDS = 52;
    private static final int NUMBER_CARDS_PER_HAND = 5;

    public Card [] initialiseDeck() {
        deck = new Card[DECK_CARDS];
        int index = 0;

        for(int i = 0; i < 13; i++){
            Rank value = Rank.values()[i];
            for(int j = 0; j < 4; j++){
                deck[index] = new Card(value, Suit.values()[j]);
             //   System.out.println(value.toString() + " of " + Suit.values()[j].toString());
                index++;
            }
        }

        return deck;

    }

    public Card[] deal() {

        Card [] hand = new Card[NUMBER_CARDS_PER_HAND];

        List<Card> shuffledDeck = Arrays.asList(deck);
        Collections.shuffle(shuffledDeck);

        for(int i = 0; i < NUMBER_CARDS_PER_HAND; i++) {
            hand[i] = shuffledDeck.get(i);
        }
       // System.out.println(Arrays.stream(hand).toList().toString());
        return hand;
    }






}
