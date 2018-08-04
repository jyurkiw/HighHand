package com.jyurkiw.highhand.com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Hand;

/**
 * Five of a kind hand requires four of a kind plus a joker.
 */
public class FiveOfAKind extends Hand {
    /**
     * Construct a five of a kind hand from the passed hand code.
     * Hand must be checked by isValid to detect if it is actually
     * a five of a kind.
     *
     * @param handCode
     */
    public FiveOfAKind(String handCode) {
        super(handCode);
        handValue = 0;
    }

    @Override
    public int compareTo(Hand o) {
        if (handValue < o.handValue) {
            return 1;
        }
        if (handValue > o.handValue) {
            return -1;
        }
        return cards.get(0).compareTo(o.cards.get(0));
    }

    /**
     * Returns true if this hand is a valid five of a kind hand and false if it is not.
     *
     * @return true if valid Five of a Kind.
     */
    @Override
    public boolean isValid() {
        for (int i = 1; i < 4; i++) {
            if (cards.get(i).compareTo(cards.get(0)) != 0) {
                return false;
            }
        }
        return cards.get(4).isJoker();
    }
}
