package com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.CardCounter;
import com.jyurkiw.highhand.Hand;

public class Flush extends Hand {
    public Flush(String handCode) {
        super(handCode);

        handValue = 4;
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

        for (int i = 0; i < cards.size(); i++) {
            int cardComp = cards.get(i).compareTo(o.cards.get(i));
            if (cardComp != 0) {
                return cardComp;
            }
        }

        return 0;
    }

    /**
     * Returns true if the hand's hand code is valid for the hand type.
     *
     * @return True if the hand is valid.
     */
    @Override
    public boolean validate() {
        if (cardCounter == null) {
            cardCounter = CardCounter.count(cards);
        }

        if (_hasJoker) {
            for (int i = Card.ACE_IDX; i >= 0; i--) {
                if (!cardCounter.backValues.containsKey(i)) {
                    _joker.setJoker(i, getHighCard().SuitIndex);
                }
            }
        }

        return cardCounter.backSuits.containsKey(5) || cardCounter.backSuits.containsKey(4) && _hasJoker;
    }
}
