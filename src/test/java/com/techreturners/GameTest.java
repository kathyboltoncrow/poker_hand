package com.techreturners;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;


public class GameTest {
    @Test
    public void initialiseDeck(){
    Game game = new Game();
    List<Card> deck = game.initialiseDeck();
    assertEquals(52,deck.size());
    }
    @Test
    public void initialiseHand(){
        Game game = new Game();
        List<Card> deck = game.initialiseDeck();
        List<Card> hand = game.deal();
        assertEquals(5,hand.size());
    }

    @Test
    public void dealHand(){
        Game game = new Game();
        List<Card> deck = game.initialiseDeck();
        List<Card> hand = game.deal();
        assertEquals(47,deck.size());
        assertEquals(5,hand.size());
    }

    @Test
    public void getPlayers(){
        Game game = new Game();
        Player white = new Player("White");
        Player black = new Player("Black");
    }

//    @Test
//    public void casinoDeal(){
//        Game game = new Game();
//        Player white = game.addPlayer("White");
//        Player black = game.addPlayer("Black");
//        game.casinoDeal();
//        assertEquals(42, game.getDeck().size());
//        white.printHand();
//        black.printHand();
//    }

}
