package com.techreturners;

import com.techreturners.enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
