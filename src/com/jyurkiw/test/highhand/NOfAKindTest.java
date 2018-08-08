package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Hand;
import com.jyurkiw.highhand.HandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NOfAKindTest {
    // Four of a Kind
    @Test
    void fourVFourCompareGT() {
        Hand f4 = HandFactory.parseHand("4S:4H:4C:4D:5D");
        Hand f5 = HandFactory.parseHand("5S:5H:5C:5D:6D");

        assertEquals(1, f5.compareTo(f4));
    }

    @Test
    void fourVFourCompareLT() {
        Hand f4 = HandFactory.parseHand("4S:4H:4C:4D:5D");
        Hand f5 = HandFactory.parseHand("5S:5H:5C:5D:6D");

        assertEquals(-1, f4.compareTo(f5));
    }

    @Test
    void fourVFourCompareEQ() {
        Hand f4 = HandFactory.parseHand("4S:4H:4C:4D:5D");

        assertEquals(0, f4.compareTo(f4));
    }

    @Test
    void fourIsValid() {
        Hand f4 = HandFactory.parseHand("4S:4H:4C:4D:5D");

        assertTrue(f4.validate());
    }

    // Flush
    @Test
    void flushCompareToGT() {
        Hand gt = HandFactory.parseHand("3S:4S:5S:7S:9S");
        Hand lt = HandFactory.parseHand("2S:4S:5S:7S:9S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void flushCompareToLT() {
        Hand gt = HandFactory.parseHand("2S:3S:4S:7S:9S");
        Hand lt = HandFactory.parseHand("2S:3S:4S:7S:10S");

        assertEquals(-1, gt.compareTo(lt));
    }

    @Test
    void flushCompareEQ() {
        Hand hand = HandFactory.parseHand("2S:3S:4S:7S:10S");

        assertTrue(hand.validate());
    }

    @Test
    void flushValidate() {
        Hand hand = HandFactory.parseHand("2S:3S:4S:7S:9S");

        assertTrue(hand.validate());
    }

    // Three of a Kind
    @Test
    void threeOfAKindCompareToGT() {
        Hand gt = HandFactory.parseHand("4S:4D:4C:7S:9S");
        Hand lt = HandFactory.parseHand("3S:3D:3C:7S:9S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void threeOfAKindCompareToLT() {
        Hand gt = HandFactory.parseHand("4S:4D:4C:7S:9S");
        Hand lt = HandFactory.parseHand("3S:3D:3C:7S:9S");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void threeOfAKindCompareEQ() {
        Hand hand = HandFactory.parseHand("4S:4D:4C:7S:9S");

        assertTrue(hand.validate());
    }

    @Test
    void threeOfAKindValidate() {
        Hand hand = HandFactory.parseHand("4S:4D:4C:7S:9S");

        assertTrue(hand.validate());
    }

    // Pair
    @Test
    void pairCompareToGT() {
        Hand gt = HandFactory.parseHand("3S:3H:5S:5H:9S");
        Hand lt = HandFactory.parseHand("2S:2H:4S:4H:9S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void pairCompareToLT() {
        Hand gt = HandFactory.parseHand("3S:3H:5S:5H:9S");
        Hand lt = HandFactory.parseHand("2S:2H:4S:4H:9S");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void pairCompareEQ() {
        Hand hand = HandFactory.parseHand("3S:3H:5S:5H:9S");

        assertTrue(hand.validate());
    }

    @Test
    void pairValidate() {
        Hand hand = HandFactory.parseHand("3S:3H:5S:5H:9S");

        assertTrue(hand.validate());
    }

    @Test
    void pairValidTiePairHighCardWin() {
        Hand gt = HandFactory.parseHand("4S:4C:3S:2D:KH");
        Hand lt = HandFactory.parseHand("4D:4H:3D:2H:QD");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void twoPairValidTiePairHighCardWin() {
        Hand gt = HandFactory.parseHand("4S:4C:3S:3D:KH");
        Hand lt = HandFactory.parseHand("4D:4H:3D:3H:QD");

        assertEquals(1, gt.compareTo(lt));
    }
}