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
        cards.add(new Card("3H"));
        cards.add(new Card("2H"));

        Collections.sort(cards, new CardSorter());

        assertEquals("3H", cards.get(0).toString());
        assertEquals("2H", cards.get(1).toString());
    }
}