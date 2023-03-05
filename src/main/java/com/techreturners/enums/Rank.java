package com.techreturners.enums;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String rank;
    private int value;

    // Constructor
    Rank (String r) {
        rank = r;
        char rankChar = rank.charAt(0);
        if(rankChar >= '2' && rankChar <= '9'){
            value = Integer.valueOf(rank);
        } else if (rank.equals("T")) {
            value = 10;
        } else if (rank.equals("J")) {
            value = 11;
        }else if (rank.equals("Q")) {
            value = 12;
        }else if (rank.equals("K")) {
            value = 13;
        }else if (rank.equals("A")) {
            value = 14;
        }
    }

    public String toString() {
        return rank;
    }
    public int getValue() {
        return value;
    }
}


