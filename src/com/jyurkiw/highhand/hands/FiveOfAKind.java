package com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.CardCounter;
import com.jyurkiw.highhand.Hand;

/**
 * Five of a kind hand requires four of a kind plus a joker.
 */
public class FiveOfAKind extends Hand {
    /**
     * Construct a five of a kind hand from the passed hand code.
     * Hand must be checked by validate to detect if it is actually
     * a five of a kind.
     *
     * @param handCode
     */
    public FiveOfAKind(String handCode) {
        super(handCode, 0);
    }

    public FiveOfAKind(String handCode, CardCounter cardCounter) {
        super(handCode, 0, cardCounter);
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
     * Five of a kind requires a joker.
     *
     * @return true if valid Five of a Kind.
     */
    @Override
    public boolean validate() {
        if (cardCounter == null) {
            cardCounter = CardCounter.count(cards);
        }

        if (cardCounter.values.containsValue(4) && _hasJoker) {
            _joker.setJoker(getHighCard().ValueIndex, getHighCard().SuitIndex);
            return true;
        } else {
            return false;
        }
    }
}
