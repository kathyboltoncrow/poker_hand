package com.techreturners;

import com.techreturners.enums.Rank;
import com.techreturners.enums.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void initCard(){
        Card theCard = new Card(Rank.TEN,Suit.HEARTS);
        assertEquals("TH", theCard.toString());
    }
}
