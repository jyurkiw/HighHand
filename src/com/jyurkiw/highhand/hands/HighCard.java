package com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.CardCounter;
import com.jyurkiw.highhand.Hand;

public class HighCard extends Hand {
    public HighCard(String handCode) {
        super(handCode, 9);
    }

    public HighCard(String handCode, CardCounter cardCounter) {
        super(handCode, 9, cardCounter);
    }

    /**
     * Used to compare two hands to check for a winner.
     *
     * @param o The other hand to compare to.
     * @return 1 if this hand is greater, 0 if a tie, -1 if this hand is lesser.
     */
    @Override
    public int compareTo(Hand o) {
        return getHighCard().compareTo(o.getHighCard());
    }

    /**
     * Returns true if the hand's hand code is valid for the hand type.
     *
     * @return True if the hand is valid.
     */
    @Override
    public boolean validate() {
        return true;
    }
}
