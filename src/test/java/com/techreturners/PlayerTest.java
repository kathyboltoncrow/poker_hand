package com.techreturners;

import com.techreturners.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    public void isFlush() {
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("2H"));
        player.setCards(hand);
        assertTrue(player.isFlush());
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
        player.setCards(hand);
        assertFalse(player.isFlush());
    }

    @Test
    public void getHighCard(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("5S"));
        hand.add(Card.getCard("7D"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("9H"));
        hand.add(Card.getCard("TH"));
        player.setCards(hand);
        assertEquals("TH", player.getHighCard().toString());
    }

    @Test
    public void countRank(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("5S"));
        hand.add(Card.getCard("2D"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("9H"));
        hand.add(Card.getCard("9H"));
        player.setCards(hand);
        assertEquals(1,player.countRank(Rank.FIVE));
        assertEquals(2,player.countRank(Rank.TWO));
        assertEquals(2,player.countRank(Rank.NINE));
    }

    @Test
    public void isPair(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("6D"));
        hand.add(Card.getCard("8H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertTrue(player.isPair());
    }

    @Test
    public void isNotPair(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("7D"));
        hand.add(Card.getCard("8H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertFalse(player.isPair());

        hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("6D"));
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertFalse(player.isPair());
    }

    @Test
    public void isThreeOfaKind(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("6D"));
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertTrue(player.isThreeOfaKind());
    }

    @Test
    public void isNotThreeOfaKind(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("QD"));
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertFalse(player.isThreeOfaKind());
    }

    @Test
    public void isFullHouse(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("6D"));
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("9C"));
        player.setCards(hand);
        assertTrue(player.isFullHouse());
    }

    @Test
    public void isNotFullHouse(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("7D"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("9C"));
        player.setCards(hand);
        assertFalse(player.isFullHouse());
    }

    @Test
    public void isFourOfaKind(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("6D"));
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("6C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertTrue(player.isFourOfaKind());
    }

    @Test
    public void isNotFourOfaKind(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("QD"));
        hand.add(Card.getCard("6H"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertFalse(player.isFourOfaKind());
    }

    @Test
    public void isTwoPairs(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("8H"));
        hand.add(Card.getCard("6D"));
        hand.add(Card.getCard("8C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertTrue(player.isTwoPairs());
    }
    @Test
    public void isStraight(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("7H"));
        hand.add(Card.getCard("8D"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("TC"));
        player.setCards(hand);
        assertTrue(player.isStraight());

        hand = new ArrayList<Card>();
        hand.add(Card.getCard("2S"));
        hand.add(Card.getCard("3H"));
        hand.add(Card.getCard("4D"));
        hand.add(Card.getCard("5C"));
        hand.add(Card.getCard("6C"));
        player.setCards(hand);
        assertTrue(player.isStraight());

        hand = new ArrayList<Card>();
        hand.add(Card.getCard("TS"));
        hand.add(Card.getCard("JH"));
        hand.add(Card.getCard("QD"));
        hand.add(Card.getCard("KC"));
        hand.add(Card.getCard("AC"));
        player.setCards(hand);
        assertTrue(player.isStraight());
    }

    @Test
    public void isNotStraight(){
        Player player = new Player("White");
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(Card.getCard("6S"));
        hand.add(Card.getCard("7H"));
        hand.add(Card.getCard("8D"));
        hand.add(Card.getCard("9C"));
        hand.add(Card.getCard("AC"));
        player.setCards(hand);
        assertFalse(player.isStraight());

        hand = new ArrayList<Card>();
        hand.add(Card.getCard("2S"));
        hand.add(Card.getCard("2H"));
        hand.add(Card.getCard("4D"));
        hand.add(Card.getCard("5C"));
        hand.add(Card.getCard("6C"));
        player.setCards(hand);
        assertFalse(player.isStraight());
    }

}
