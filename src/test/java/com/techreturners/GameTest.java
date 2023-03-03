package com.techreturners;

import com.techreturners.enums.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void initialiseDeck(){
    Game game = new Game();
    Card [] deck = game.initialiseDeck();
    assertEquals(52,deck.length);
    }
    @Test
    public void initialiseHand(){
        Game game = new Game();
        Card [] deck = game.initialiseDeck();
        Card [] hand = game.deal();
        assertEquals(5,hand.length);
    }
}
