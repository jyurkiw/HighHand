package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.hands.FiveOfAKind;
import com.jyurkiw.highhand.hands.Straight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

    @Test
    void compareToFiveOfAKind() {
        FiveOfAKind foak = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        Straight sf = new Straight("2D:3D:4D:5H:6H");

        assertEquals(-1, sf.compareTo(foak));
    }

    @Test
    void isValid() {
        Straight sf = new Straight("2D:3D:4D:5D:6D");

        assertTrue(sf.validate());
    }

    @Test
    void isInvalid() {
        Straight sf = new Straight("2D:3D:4D:5D:7D");

        assertFalse(sf.validate());
    }

    @Test
    void compareToGreaterThan() {
        Straight lt = new Straight("2D:3D:4D:5D:6D");
        Straight gt = new Straight("3S:4S:5S:6S:7S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void compareToLessThan() {
        Straight lt = new Straight("2D:3D:4D:5D:6D");
        Straight gt = new Straight("3S:4S:5S:6S:7S");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void compareToEqualTo() {
        Straight sf1 = new Straight("3D:4D:5D:6D:7D");
        Straight sf2 = new Straight("3S:4S:5S:6S:7S");

        assertEquals(0, sf1.compareTo(sf2));
    }

    // Joker tests
    @Test
    void isValidChangesJokerHighCardValid() {
        Straight sf = new Straight("3D:4D:5D:6D:JOKER");

        assertTrue(sf.validate());
    }

    @Test
    void isValidChangesJokerHighCardIsJoker() {
        Straight sf = new Straight("3D:4D:5D:6D:JOKER");
        sf.validate();
        assertTrue(sf.cards.get(0).isJoker());
    }

    @Test
    void isValidChangesJokerHighCardIsCard() {
        Straight sf = new Straight("3D:4D:5D:6D:JOKER");
        sf.validate();
        assertEquals(new Card("7D").ValueIndex, sf.cards.get(0).ValueIndex);
    }

    @Test
    void isValidChangesJokerLowCardValid() {
        Straight sf = new Straight("JOKER:3D:4D:5D:6D");

        assertTrue(sf.validate());
    }

    @Test
    void isValidChangesJokerLowCardJoker() {
        Straight sf = new Straight("JOKER:3D:4D:5D:6D");
        sf.validate();
        assertTrue(sf.cards.get(0).isJoker());
    }

    @Test
    void isValidChangesJokerLowCardCard() {
        Straight sf = new Straight("JOKER:3D:4D:5D:6D");
        sf.validate();
        assertEquals(new Card("7D").ValueIndex, sf.cards.get(0).ValueIndex);
    }

    @Test
    void isValidChangesJokerMiddleValid() {
        Straight sf = new Straight("JOKER:3D:4D:6D:7D");

        assertTrue(sf.validate());
    }

    @Test
    void isValidChangesJokerMiddleJoker() {
        Straight sf = new Straight("JOKER:3D:4D:6D:7D");
        sf.validate();

        assertTrue(sf.cards.get(2).isJoker());
    }

    @Test
    void isValidChangesJokerMiddleCard() {
        Straight sf = new Straight("JOKER:3D:4D:6D:7D");
        sf.validate();

        assertEquals(new Card("5D").ValueIndex, sf.cards.get(2).ValueIndex);
    }

    @Test
    void isInvalidChangesJokerValid() {
        Straight sf = new Straight("3D:4D:5D:8D:JOKER");

        assertFalse(sf.validate());
    }

    @Test
    void isInvalidChangesJokerJoker() {
        Straight sf = new Straight("3D:4D:5D:8D:JOKER");
        sf.validate();

        assertTrue(sf.cards.get(4).isJoker());
    }

    @Test
    void isInvalidChangesJokerCard() {
        Straight sf = new Straight("3D:4D:5D:8D:JOKER");
        sf.validate();

        assertEquals(new Card("JOKER").ValueIndex, sf.cards.get(4).ValueIndex);
    }

    @Test
    void compareToFiveOfAKindWithJoker() {
        FiveOfAKind foak = new FiveOfAKind("10H:10S:10C:10D:JOKER");
        Straight sf = new Straight("JOKER:3D:4D:5D:6D");

        assertEquals(-1, sf.compareTo(foak));
    }

    @Test
    void isValidWithJoker() {
        Straight sf = new Straight("JOKER:3D:4D:5D:7D");

        assertTrue(sf.validate());
    }

    @Test
    void isInvalidWithJoker() {
        Straight sf = new Straight("JOKER:3D:4D:5D:8D");

        assertFalse(sf.validate());
    }

    @Test
    void compareToGreaterThanWithJoker() {
        Straight lt = new Straight("2D:3D:4D:5D:6D");
        Straight gt = new Straight("JOKER:3S:4S:5S:6S");

        assertEquals(0, gt.compareTo(lt));
    }

    @Test
    void compareToGreaterThanWithJokerMiddle() {
        Straight lt = new Straight("2D:3D:4D:5D:6D");
        Straight gt = new Straight("3S:4S:JOKER:6S:7S");

        assertEquals(1, gt.compareTo(lt));
    }

    @Test
    void compareToLessThanWithJoker() {
        Straight lt = new Straight("2D:3D:JOKER:5D:6D");
        Straight gt = new Straight("4S:5S:6S:7S:8S");

        assertEquals(-1, lt.compareTo(gt));
    }

    @Test
    void compareToEqualToWithJoker() {
        Straight sf1 = new Straight("JOKER:3D:4D:5D:6D");
        Straight sf2 = new Straight("3S:4S:5S:6S:7S");

        sf1.validate();

        assertEquals(0, sf1.compareTo(sf2));
    }
}