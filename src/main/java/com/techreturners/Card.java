package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final static Map<String, Card> deck = new HashMap<String, Card>();

    static {
        for (int i = 0; i < 13; i++) {
            Rank value = Rank.values()[i];
            for (int j = 0; j < 4; j++) {
                Suit suit = Suit.values()[j];
                Card card = new Card(value, suit);
                String code = new String(value.toString() + suit.toString());
                deck.put(code, card);
            }
        }

    }
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card getCard(String code) {
        return Card.deck.get(code);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }
}
