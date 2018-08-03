package com.jyurkiw.highhand;

import com.jyurkiw.highhand.Card;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Hand implements Comparable<Hand> {
    public ArrayList<Card> cards;
    public int handValue;

    /**
     * Construct a hand from a passed hand code.
     *
     * @param handCode A valid hand code (ex: 4H:4S:4D:4C:2H)
     */
    public Hand(String handCode) {
        cards = new ArrayList<>();
        for (String cardCode : handCode.split(":")) {
            cards.add(new Card(cardCode));
        }
        Collections.sort(cards, new CardSorter());

        handValue = 1000;
    }


    /**
     * Used to compare two hands to check for a winner.
     *
     * @param o The other hand to compare to.
     * @return 1 if this hand is greater, 0 if a tie, -1 if this hand is lesser.
     */
    @Override
    public abstract int compareTo(Hand o);

    public abstract boolean isValid();

    @Override
    public String toString() {
        StringBuilder codeBuilder = new StringBuilder();
        for (Card card : cards) {
            codeBuilder.append(card.toString());
        }

        return codeBuilder.toString();
    }
}
