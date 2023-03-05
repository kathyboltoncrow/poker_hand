package com.techreturners;

import com.techreturners.enums.Rank;
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

    public Card getHighCard(){
        Card highCard = null;

        for (Card card:hand) {
            if(highCard == null){
                highCard = card;
            } else {
                if(card.getRank().getValue() > highCard.getRank().getValue() ){
                    highCard = card;
                }
            }
        }
        return highCard;
    }

    public int countRank(Rank rank){
        int countRank = 0;
        for (Card card: hand) {
           if(rank.equals(card.getRank())) {
               countRank++;
           }
        }
        return countRank;
    }


    public boolean isPair(){
        for (Card card: hand) {
            Rank rank = card.getRank();
            if (countRank(rank) == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isTwoPairs(){
        Set<Rank> twoPairs = new HashSet<Rank>();

        for (Card card: hand) {
            Rank rank = card.getRank();
            if(! twoPairs.contains(rank)) {
                if (countRank(rank) == 2) {
                    twoPairs.add(rank);
                }
            }
        }
        if(twoPairs.size() == 2){
            return true;
        }
        return false;
    }

    public boolean isThreeOfaKind(){
        for (Card card: hand) {
            Rank rank = card.getRank();
            if (countRank(rank) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isFourOfaKind(){
        for (Card card: hand) {
            Rank rank = card.getRank();
            if (countRank(rank) == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraight(){
        Card card = getHighCard();
        Rank rank = card.getRank();
        int straightCount = 0;
        for(int i = 0; i < 5; i++){
            if (countRank(rank) == 1) {
                straightCount++;
            }
            rank = rank.getPrior();
        }

        boolean result = false;
        if (straightCount == 5) {
            result = true;
        }
        return result;
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

    public boolean isFullHouse() {
        if(isPair() && isThreeOfaKind()){
            return true;
        }
        return false;
    }
}

