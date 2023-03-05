package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void initCard(){
        Card theCard = new Card(Rank.TWO,Suit.HEARTS);
        assertEquals("2H",theCard.getRank().toString() + theCard.getSuit().toString());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/card_data.csv")
    public void initCardP(Rank rank, Suit suit, String expected){
        Card theCard = new Card(rank, suit);
        assertEquals(expected,theCard.getRank().toString() + theCard.getSuit().toString());
    }

    @Test
    public void initCardNotation(){
        Card card = Card.getCard("2H");
        assertEquals(Rank.TWO, card.getRank());
        assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    public void initCardNotationInvalid(){
        Card card = Card.getCard("XX");
        assertNull(card);
        card = Card.getCard(null);
        assertNull(card);
    }
}
