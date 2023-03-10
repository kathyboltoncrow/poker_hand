package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;

import java.util.*;

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

    public int getKicker(){
        int highCard = 0;
        List<Integer> list = new ArrayList<>();
        for (Card card: hand) {
            list.add (card.getRank().getValue());
        }
        Collections.sort(list, Collections.reverseOrder());

        return list.get(0);
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
           if( card.getRank().equals(rank) ) {
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
    
    public boolean isStraightFlush() {
        if ( isStraight() && isFlush() ) {
            return true;
        }
        return false;
    }

    public String [] getHandScore() {
        String [] result = new String[2];
        String handScore;
        String handDescription;
        
        if (isStraightFlush()) {
            handScore = "100";
            handDescription = "Straight Flush";
        } else if (isFourOfaKind()) {
            handScore = "90";
            handDescription = "Four of a kind";
        } else if (isFullHouse()) {
            handScore = "80";
            handDescription = "Full House";
        } else if (isFlush()) {
            handScore = "70";
            handDescription = "Flush";
        } else if (isStraight()) {
            handScore = "60";
            handDescription = "Straight";
        } else if (isThreeOfaKind()) {
            handScore = "50";
            handDescription = "Three Of a Kind";
        } else if (isTwoPairs()) {
            handScore = "40";
            handDescription = "Two Pairs";
        } else if (isPair()) {
            handScore = "30";
            handDescription = "Pair";
        } else {
            handScore = "10";
            handDescription = " ";
        }
        result[0] = handScore;
        result[1] = handDescription;

        return result;
    }
    
}

