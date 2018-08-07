package com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Hand;

public class Pair extends Hand {
    public Pair(String handCode) {
        super(handCode);
    }

    /**
     * Used to compare two hands to check for a winner.
     *
     * @param o The other hand to compare to.
     * @return 1 if this hand is greater, 0 if a tie, -1 if this hand is lesser.
     */
    @Override
    public int compareTo(Hand o) {
        if (handValue < o.handValue) {
            return 1;
        }
        if (handValue > o.handValue) {
            return -1;
        }

        return cardCounter.backValues.get(2).compareTo(o.cardCounter.backValues.get(2));
    }

    /**
     * Returns true if the hand's hand code is valid for the hand type.
     *
     * @return True if the hand is valid.
     */
    @Override
    public boolean validate() {
        return cardCounter.backValues.containsKey(2);
    }
}
