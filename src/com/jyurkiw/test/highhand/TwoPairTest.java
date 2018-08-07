package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Hand;
import com.jyurkiw.highhand.HandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairTest {

    @Test
    void compareToGT() {
        Hand gt = HandFactory.parseHand("5H:5S:4H:4S:2D");
        Hand lt = HandFactory.parseHand("3H:3S:4H:4S:2D");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void compareToLT() {
        Hand gt = HandFactory.parseHand("5H:5S:4H:4S:2D");
        Hand lt = HandFactory.parseHand("3H:3S:4H:4S:2D");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void compareToEQ() {
        Hand gt = HandFactory.parseHand("5H:5S:4H:4S:2D");

        assertEquals(0, gt.compareTo(gt));
    }

    @Test
    void validate() {
        Hand hand = HandFactory.parseHand("5H:5S:4H:4S:2D");

        assertTrue(hand.validate());
    }
}