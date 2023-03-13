package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;
import com.techreturners.hand.*;

import java.util.*;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void printHand(){
        StringBuffer sb = new StringBuffer();
        for (Card card: cards) {
            sb.append(card.toString() + ",");
        }
        System.out.println(sb);
    }

    public Card getHighCard(){

        Card highCard = null;
        for (Card card: cards) {
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
        for (Card card: cards) {
           if( card.getRank().equals(rank) ) {
               countRank++;
           }
        }
        return countRank;
    }

    public boolean isPair(){
        for (Card card: cards) {
            Rank rank = card.getRank();
            if (countRank(rank) == 2) {

                return true;
            }
        }
        return false;
    }

    public boolean isTwoPairs(){
        Set<Rank> twoPairs = new HashSet<Rank>();

        for (Card card: cards) {
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
        for (Card card: cards) {
            Rank rank = card.getRank();
            if (countRank(rank) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isFourOfaKind(){
        for (Card card: cards) {
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
        for(int i = 0; i < 5 && rank != null; i++){
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

        for (Card card : cards) {
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
        if (isStraight() && isFlush() ) {
            return true;
        }
        return false;
    }

    public AbstractHand getHand() {
        AbstractHand playerHand;

        if (isStraightFlush()) {
            playerHand = new StraightFlushHand(cards);
        } else if (isFourOfaKind()) {
            playerHand = new FourOfAKindHand(cards);
        } else if (isFullHouse()) {
            playerHand = new FullHouseHand(cards);
        } else if (isFlush()) {
            playerHand = new FlushHand(cards);
        } else if (isStraight()) {
            playerHand = new StraightHand(cards);
        } else if (isThreeOfaKind()) {
            playerHand = new ThreeOfAKindHand(cards);
        } else if (isTwoPairs()) {
            playerHand = new TwoPairsHand(cards);
        } else if (isPair()) {
            playerHand = new PairHand(cards);
        } else {
            playerHand = new HighCardHand(cards);
        }
        return playerHand;
    }
}