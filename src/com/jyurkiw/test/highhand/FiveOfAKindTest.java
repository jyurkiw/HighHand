package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.hands.FiveOfAKind;
import com.jyurkiw.highhand.hands.StraightFlush;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiveOfAKindTest {
    @Test
    void testGreaterThanHand() {
        FiveOfAKind gt = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        FiveOfAKind lt = new FiveOfAKind("9H:9S:9C:9D:JOKER");

        assertTrue(gt.compareTo(lt) == 1);
    }

    @Test
    void testEqualHand() {
        FiveOfAKind gt = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        FiveOfAKind lt = new FiveOfAKind("10H:10S:10C:10D:JOKER");

        assertTrue(gt.compareTo(lt) == 0);
    }

    @Test
    void testLessThanHand() {
        FiveOfAKind gt = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        FiveOfAKind lt = new FiveOfAKind("9H:9S:9C:9D:JOKER");

        assertTrue(lt.compareTo(gt) == -1);
    }

    @Test
    void testStraightFlush() {
        FiveOfAKind foak = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        StraightFlush sf = new StraightFlush("2D:3D:4D:5D:6D");

        assertTrue(foak.compareTo(sf) == 1);
    }

    @Test
    void testOutOfOrderJokerIsValid() {
        FiveOfAKind hand = new FiveOfAKind("10H:10S:JOKER:10C:10D");

        assertTrue(hand.validate());
    }

    @Test
    void testValid() {
        FiveOfAKind hand = new FiveOfAKind("10H:10S:JOKER:10C:10D");

        assertTrue(hand.validate());
    }

    @Test
    void testInvalid() {
        FiveOfAKind hand = new FiveOfAKind("10H:10S:JOKER:10C:8D");

        assertFalse(hand.validate());
    }
}