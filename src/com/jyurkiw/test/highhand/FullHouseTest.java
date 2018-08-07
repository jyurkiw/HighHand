package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Hand;
import com.jyurkiw.highhand.HandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseTest {

    @Test
    void compareTo() {
        Hand fh1 = HandFactory.parseHand("AS:AD:10D:10S:AC");
        Hand fh2 = HandFactory.parseHand("KS:KD:9D:9S:KC");

        assertEquals(1, fh1.compareTo(fh2));
    }

    @Test
    void isValid() {
        Hand hand = HandFactory.parseHand("AS:AD:10D:10S:AC");

        assertTrue(hand.validate());
    }
}