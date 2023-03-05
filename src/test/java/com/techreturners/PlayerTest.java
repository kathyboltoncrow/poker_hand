package com.techreturners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {


    @Test
    public void initialiseHand() {
        Game game = new Game();
        List<Card> deck = game.initialiseDeck();
        List<Card> hand = game.deal();
        assertEquals(5, hand.size());
    }

    @Test
    public void dealHand() {
        Game game = new Game();
        List<Card> deck = game.initialiseDeck();
        List<Card> hand = game.deal();
        assertEquals(47, deck.size());
        assertEquals(5, hand.size());
    }

    @Test
    public void getPlayers() {
        Game game = new Game();
        game.addPlayer("White");
        game.addPlayer("Black");
        Set<Player> players = game.getPlayers();
        assertEquals(2, players.size());
    }

    @Test
    public void casinoDeal() {
        Game game = new Game();
        Player white = game.addPlayer("White");
        Player black = game.addPlayer("Black");
        game.casinoDeal();
        assertEquals(42, game.getDeck().size());
        white.printHand();
        black.printHand();
    }

    @Test
    public void isFlush() {
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        player.setHand(hand);
        assertTrue(player.isFlush());
    }
    @Test
    public void getHighCard(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("7H"));
        hand.add(Card.getCard("8H"));
        hand.add(Card.getCard("9H"));
        hand.add(Card.getCard("TH"));
        player.setHand(hand);
        assertEquals("TH", player.getHighCard().toString());

    }
    @Test
    public void isNotFlush() {
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("2S"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        player.setHand(hand);
        assertFalse(player.isFlush());
    }

}
