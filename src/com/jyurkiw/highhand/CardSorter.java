package com.jyurkiw.highhand;

import java.util.Comparator;

/**
 * Sorts card from high to low.
 */
public class CardSorter implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o2.compareTo(o1);
    }
}
