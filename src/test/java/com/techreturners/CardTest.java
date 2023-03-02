package com.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void initCard(){
        Card theCard = new Card();
        assertEquals("C", theCard.getSuit());
    }
}
