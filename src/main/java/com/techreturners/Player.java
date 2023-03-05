package com.techreturners;

import com.techreturners.enums.Suit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    public void printHand(){
        StringBuffer sb = new StringBuffer();
        for (Card card: hand) {
            sb.append(card.toString() + ",");
        }
        System.out.println(sb);
    }

    public boolean isStraightFlush(){
        boolean isStraightFlush = false;


        return isStraightFlush;
    }

    public boolean isFlush(){
        boolean isFlush = false;
        Set<Suit> suitsInHand = new HashSet<Suit>();

        for (Card card : hand) {
            suitsInHand.add(card.getSuit());
        }

        if(suitsInHand.size() == 1){
            isFlush = true;
        }

        return isFlush;
    }
}

