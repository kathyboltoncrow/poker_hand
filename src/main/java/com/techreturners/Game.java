package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;
import com.techreturners.hand.Hand;

import java.util.*;

public class Game {

    private static final int DECK_CARDS = 52;
    private static final int NUMBER_CARDS_PER_HAND = 5;
    private List<Card> deck;
    private Player playerOne;
    private Player playerTwo;


    public Game() {
        this.playerOne = new Player(playerOne.getName());
        this.playerTwo = new Player(playerTwo.getName());
    }
    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getResultText() {
        StringBuilder result = new StringBuilder();
        Hand hand1 = playerOne.getHand();
        Hand hand2 = playerTwo.getHand();

        if (hand1.beats(hand2)) {
            result.append(playerOne.getName() + " wins. - with " +
                    playerOne.getHand().getDescription());
        } else if (hand2.beats(hand1)) {
            result.append(playerTwo.getName() + " wins. - with " +
                    playerTwo.getHand().getDescription());
        } else {
            result.append("Tie.");
        }
        return result.toString();
    }
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

    public List<Card> getDeck(){
        return this.deck;
    }

    public List<Card> deal() {
        ArrayList<Card> hand = new ArrayList<Card>();
        for (int i = 0; i < NUMBER_CARDS_PER_HAND; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
        return hand;
    }

}







