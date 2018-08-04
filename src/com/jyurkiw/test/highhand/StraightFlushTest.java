package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.com.jyurkiw.highhand.hands.FiveOfAKind;
import com.jyurkiw.highhand.com.jyurkiw.highhand.hands.StraightFlush;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightFlushTest {

    @Test
    void compareToFiveOfAKind() {
        FiveOfAKind foak = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        StraightFlush sf = new StraightFlush("2D:3D:4D:5D:6D");

        assertEquals(-1, sf.compareTo(foak));
    }

    @Test
    void isValid() {
        StraightFlush sf = new StraightFlush("2D:3D:4D:5D:6D");

        assertTrue(sf.isValid());
    }

    @Test
    void isInvalid() {
        StraightFlush sf = new StraightFlush("2D:3D:4D:5D:7D");

        assertFalse(sf.isValid());
    }

    @Test
    void compareToGreaterThan() {
        StraightFlush lt = new StraightFlush("2D:3D:4D:5D:6D");
        StraightFlush gt = new StraightFlush("3S:4S:5S:6S:7S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void compareToLessThan() {
        StraightFlush lt = new StraightFlush("2D:3D:4D:5D:6D");
        StraightFlush gt = new StraightFlush("3S:4S:5S:6S:7S");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void compareToEqualTo() {
        StraightFlush sf1 = new StraightFlush("3D:4D:5D:6D:7D");
        StraightFlush sf2 = new StraightFlush("3S:4S:5S:6S:7S");

        assertEquals(0, sf1.compareTo(sf2));
    }

    // Joker tests
    @Test
    void isValidChangesJokerHighCardValid() {
        StraightFlush sf = new StraightFlush("3D:4D:5D:6D:JOKER");

        assertTrue(sf.isValid());
    }

    @Test
    void isValidChangesJokerHighCardIsJoker() {
        StraightFlush sf = new StraightFlush("3D:4D:5D:6D:JOKER");
        sf.isValid();
        assertTrue(sf.cards.get(0).isJoker());
    }

    @Test
    void isValidChangesJokerHighCardIsCard() {
        StraightFlush sf = new StraightFlush("3D:4D:5D:6D:JOKER");
        sf.isValid();
        assertEquals(new Card("7D"), sf.cards.get(0));
    }

    @Test
    void isValidChangesJokerLowCardValid() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:5D:6D");

        assertTrue(sf.isValid());
    }

    @Test
    void isValidChangesJokerLowCardJoker() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:5D:6D");
        sf.isValid();
        assertTrue(sf.cards.get(0).isJoker());
    }

    @Test
    void isValidChangesJokerLowCardCard() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:5D:6D");
        sf.isValid();
        assertEquals(new Card("7D"), sf.cards.get(0));
    }

    @Test
    void isValidChangesJokerMiddleValid() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:6D:7D");

        assertTrue(sf.isValid());
    }

    @Test
    void isValidChangesJokerMiddleJoker() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:6D:7D");
        sf.isValid();

        assertTrue(sf.cards.get(2).isJoker());
    }

    @Test
    void isValidChangesJokerMiddleCard() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:6D:7D");
        sf.isValid();

        assertEquals(new Card("5D"), sf.cards.get(2));
    }

    @Test
    void isInvalidChangesJokerValid() {
        StraightFlush sf = new StraightFlush("3D:4D:5D:8D:JOKER");

        assertFalse(sf.isValid());
    }

    @Test
    void isInvalidChangesJokerJoker() {
        StraightFlush sf = new StraightFlush("3D:4D:5D:8D:JOKER");
        sf.isValid();

        assertTrue(sf.cards.get(1).isJoker());
    }

    @Test
    void isInvalidChangesJokerCard() {
        StraightFlush sf = new StraightFlush("3D:4D:5D:8D:JOKER");
        sf.isValid();

        assertEquals(new Card("7D"), sf.cards.get(1));
    }

    @Test
    void compareToFiveOfAKindWithJoker() {
        FiveOfAKind foak = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:5D:6D");

        assertEquals(-1, sf.compareTo(foak));
    }

    @Test
    void isValidWithJoker() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:5D:7D");

        assertTrue(sf.isValid());
    }

    @Test
    void isInvalidWithJoker() {
        StraightFlush sf = new StraightFlush("JOKER:3D:4D:5D:8D");

        assertFalse(sf.isValid());
    }

    @Test
    void compareToGreaterThanWithJoker() {
        StraightFlush lt = new StraightFlush("2D:3D:4D:5D:6D");
        StraightFlush gt = new StraightFlush("JOKER:2S:3S:4S:5S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void compareToGreaterThanWithJokerMiddle() {
        StraightFlush lt = new StraightFlush("2D:3D:4D:5D:6D");
        StraightFlush gt = new StraightFlush("3S:4S:JOKER:6S:7S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void compareToLessThanWithJoker() {
        StraightFlush lt = new StraightFlush("2D:3D:JOKER:5D:6D");
        StraightFlush gt = new StraightFlush("4S:5S:6S:7S:8S");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void compareToEqualToWithJoker() {
        StraightFlush sf1 = new StraightFlush("JOKER:3D:4D:5D:6D");
        StraightFlush sf2 = new StraightFlush("3S:4S:5S:6S:7S");

        assertEquals(0, sf1.compareTo(sf2));
    }
}