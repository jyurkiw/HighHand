package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getCardValue() {
        Assertions.assertEquals("10", Card.getCardValue("10H"));
    }

    @Test
    void getCardSuit() {
        assertEquals("H", Card.getCardSuit("10H"));
    }

    @Test
    void compareToGreaterThan() {
        Card greaterThanCard = new Card("10H");
        Card lessThanCard = new Card("8S");

        int comparison = greaterThanCard.compareTo(lessThanCard);
        assertTrue(comparison > 0);
    }

    @Test
    void compareToEqual() {
        Card card1 = new Card("10H");
        Card card2 = new Card("10H");

        int comparison = card1.compareTo(card2);
        assertEquals(0, comparison);
    }

    @Test
    void compareToLessThan() {
        Card greaterThanCard = new Card("10H");
        Card lessThanCard = new Card("8S");

        int comparison = lessThanCard.compareTo(greaterThanCard);
        assertTrue(comparison < 0);
    }

    @Test
    void testToString() {
        Card stringCard = new Card("10H");

        assertEquals("10H", stringCard.toString());
    }

    @Test
    void getCardValueIndex() {
        int actualIndex = Card.getCardValueIndex("10H");

        assertEquals(9, actualIndex);
    }

    @Test
    void getCardSuitIndex() {
        int actualIndex = Card.getCardSuitIndex("10H");

        assertEquals(0, actualIndex);
    }

    @Test
    void getJokerValue() {
        int actualIndex = Card.getCardValueIndex("JOKER");

        assertEquals(0, actualIndex);
    }

    @Test
    void getJokerSuit() {
        String actualSuit = Card.getCardSuit("JOKER");

        assertEquals("JOKER", actualSuit);
    }

    // Joker tests
    @Test
    void isJoker() {
        Card joker = new Card("JOKER");

        assertTrue(joker.isJoker());
    }

    @Test
    void setJokerToCardSuit() {
        Card joker = new Card("JOKER");
        joker.setJoker("3H");

        assertEquals(0, joker.SuitIndex);
    }

    @Test
    void setJokerToCardValue() {
        Card joker = new Card("JOKER");
        joker.setJoker("3H");

        assertEquals(2, joker.ValueIndex);
    }

    @Test
    void setJokerToCardIsJoker() {
        Card joker = new Card("JOKER");
        joker.setJoker("3H");

        assertTrue(joker.isJoker());
    }

    @Test
    void resetJokerValue() {
        Card joker = new Card("JOKER");
        joker.setJoker("3H");
        joker.resetJoker();

        assertEquals(0, joker.ValueIndex);
    }

    @Test
    void resetJokerSuit() {
        Card joker = new Card("JOKER");
        joker.setJoker("3H");
        joker.resetJoker();

        assertEquals(4, joker.SuitIndex);
    }

    @Test
    void compareToJokerUnset() {
        Card joker = new Card("JOKER");
        Card ts = new Card("3S");

        assertEquals(-1, joker.compareTo(ts));
    }

    @Test
    void compareToJokerSetSame() {
        Card joker = new Card("JOKER");
        Card ts = new Card("3S");
        joker.setJoker("3S");

        assertEquals(0, joker.compareTo(ts));
    }

    @Test
    void compareToJokerSetHigh() {
        Card joker = new Card("JOKER");
        Card ts = new Card("3S");
        joker.setJoker("5S");

        assertEquals(1, joker.compareTo(ts));
    }

    @Test
    void compareToJokerSetLow() {
        Card joker = new Card("JOKER");
        Card ts = new Card("3S");
        joker.setJoker("2S");

        assertEquals(-1, joker.compareTo(ts));
    }
}