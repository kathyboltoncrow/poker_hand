package com.techreturners.enums;

public enum Suit {
    HEARTS("H"),
    SPADES("S"),
    CLUBS("C"),
    DIAMONDS("D");
    final String suit;
    Suit(String suit) {
        this.suit = suit;
    }
    public String toString() {
        return suit;
    }

}
