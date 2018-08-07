package com.jyurkiw.highhand;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Base class for all hand types. The hand class receives a hand code and converts it to a collection of card objects.
 *
 */
public abstract class Hand implements Comparable<Hand> {
    public ArrayList<Card> cards;
    public int handValue;

    protected boolean _hasJoker = false;
    protected Card _joker = null;

    public CardCounter cardCounter = null;

    /**
     * Construct a hand from a passed hand code.
     *
     * @param handCode A valid hand code (ex: 4H:4S:4D:4C:2H)
     */
    public Hand(String handCode) {
        cards = new ArrayList<>();
        for (String cardCode : handCode.split(":")) {
            Card card = new Card(cardCode);
            cards.add(card);

            if (cardCode.equalsIgnoreCase("JOKER")) {
                _joker = card;
                _hasJoker = true;
            }
        }

        cards.sort(new CardSorter());

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

    /**
     * Returns true if the hand's hand code is valid for the hand type.
     *
     * @return True if the hand is valid.
     */
    public abstract boolean validate();

    @Override
    public String toString() {
        StringBuilder codeBuilder = new StringBuilder();
        for (Card card : cards) {
            codeBuilder.append(card.toString());
        }

        return codeBuilder.toString();
    }

    /**
     * Returns true if the passed card is this hand's high card.
     * TODO: Unit test this.
     *
     * @param card The card to check.
     * @return True if card is the high card.
     */
    public boolean isHighCard(Card card) {
        return cards.get(0).compareTo(card) == 0;
    }

    /**
     * Returns the hand's high card.
     *
     * @return The hand's high card.
     */
    public Card getHighCard() {
        return cards.get(0);
    }

    /**
     * Returns true if the passed card is this hand's low card.
     * TODO: Unit test this.
     *
     * @param card The card to check.
     * @return True if card is the low card.
     */
    public boolean isLowCard(Card card) {
        return cards.get(cards.size() - 1).compareTo(card) == 0;
    }

    /**
     * Returns the hand's low card.
     *
     * @return The hand's low card.
     */
    public Card getLowCard() {
        return cards.get(cards.size() - 1);
    }
}
