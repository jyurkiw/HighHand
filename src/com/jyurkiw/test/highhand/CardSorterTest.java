package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.CardSorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CardSorterTest {
    @Test
    void BasicSortTest() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("2H"));
        cards.add(new Card("3H"));

        Collections.sort(cards, new CardSorter());

        assertEquals("3H", cards.get(0).toString());
        assertEquals("2H", cards.get(1).toString());
    }

    @Test
    void FullHandSortTest() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("2H"));
        cards.add(new Card("3H"));
        cards.add(new Card("5H"));
        cards.add(new Card("6H"));
        cards.add(new Card("KH"));

        Collections.sort(cards, new CardSorter());

        assertEquals("KH", cards.get(0).toString());
        assertEquals("6H", cards.get(1).toString());
        assertEquals("5H", cards.get(2).toString());
        assertEquals("3H", cards.get(3).toString());
        assertEquals("2H", cards.get(4).toString());
    }
}