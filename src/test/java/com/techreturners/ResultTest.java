package com.techreturners;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @ParameterizedTest(name = "{0}, ({1}, {2}, {3}, {4})")
    @CsvFileSource(files = "src/main/resources/test_data.csv")
    void result_GeneratePlayerAndHand(String player1, String cards1, String player2,
                                      String cards2, String result) {
        ArrayList<Card> handOne = new ArrayList<Card>();

        Player playerOne = new Player(player1);
        handOne.add(Card.getCard(cards1.substring(0,2)));
        handOne.add(Card.getCard(cards1.substring(3,5)));
        handOne.add(Card.getCard(cards1.substring(6,8)));
        handOne.add(Card.getCard(cards1.substring(9,11)));
        handOne.add(Card.getCard(cards1.substring(12,14)));
        playerOne.setCards(handOne);

        ArrayList<Card> handTwo = new ArrayList<Card>();

        Player playerTwo = new Player(player2);
        handTwo.add(Card.getCard(cards2.substring(0,2)));
        handTwo.add(Card.getCard(cards2.substring(3,5)));
        handTwo.add(Card.getCard(cards2.substring(6,8)));
        handTwo.add(Card.getCard(cards2.substring(9,11)));
        handTwo.add(Card.getCard(cards2.substring(12,14)));
        playerTwo.setCards(handTwo);

        assertEquals(5, handOne.size());
        assertEquals(5, handTwo.size());
        assertEquals(player1, playerOne.getName());
        assertEquals(player2, playerTwo.getName());

        Game game = new Game(playerOne, playerTwo);
        assertEquals(result, game.getResultText());

    }

}