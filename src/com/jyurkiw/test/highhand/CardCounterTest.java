package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.CardCounter;
import com.jyurkiw.highhand.Hand;
import com.jyurkiw.highhand.HandFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CardCounterTest {

    @Test
    void countValues() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("8S"));
        cards.add(new Card("6S"));
        cards.add(new Card("2S"));
        cards.add(new Card("AS"));

        CardCounter counter = CardCounter.count(cards);

        assertEquals(4, counter.values.keySet().size());
    }

    @Test
    void countAces() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("8S"));
        cards.add(new Card("6S"));
        cards.add(new Card("2S"));
        cards.add(new Card("AS"));

        CardCounter counter = CardCounter.count(cards);

        int actual = counter.values.get(new Card("AS").ValueIndex);
        assertEquals(2, actual);
    }

    @Test
    void countSuits() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("8S"));
        cards.add(new Card("6H"));
        cards.add(new Card("2H"));
        cards.add(new Card("AD"));

        CardCounter counter = CardCounter.count(cards);

        assertEquals(3, counter.suits.keySet().size());
    }

    @Test
    void countHearts() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("8S"));
        cards.add(new Card("6H"));
        cards.add(new Card("2H"));
        cards.add(new Card("AD"));

        CardCounter counter = CardCounter.count(cards);

        int actual = counter.suits.get(new Card("AH").SuitIndex);
        assertEquals(2, actual);
    }

    @Test
    void getSingleCards() {
        Hand hand = HandFactory.parseHand("AS:8H:3D:5C:4C");

        CardCounter cc = CardCounter.count(hand.cards);

        assertEquals(5, cc.getSingleValues().size());
    }

    @Test
    void getSingleCardsOnePair() {
        Hand hand = HandFactory.parseHand("AS:8H:3D:5C:AC");

        CardCounter cc = CardCounter.count(hand.cards);

        assertEquals(3, cc.getSingleValues().size());
    }
}