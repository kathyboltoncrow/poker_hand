package com.techreturners.enums;

import com.techreturners.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RankTest {

    @Test
    public void getPrior(){
        assertEquals(Rank.KING, Rank.ACE.getPrior());
        assertEquals(Rank.EIGHT, Rank.NINE.getPrior());
        assertEquals(Rank.NINE, Rank.TEN.getPrior());
        assertNull(Rank.TWO.getPrior());
    }

}
