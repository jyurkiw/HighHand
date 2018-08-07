package com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.CardCounter;
import com.jyurkiw.highhand.CardSorter;
import com.jyurkiw.highhand.Hand;

/**
 * Straight requires five cards of sequential rank of the same suit.
 */
public class Straight extends Hand {

    /**
     * Construct a Straight with the given handCode.
     * Hand must be checked by validate to detect if it is actually
     * a Straight.
     *
     * @param handCode
     */
    public Straight(String handCode) {
        super(handCode, 1);
    }

    public Straight(String handCode, CardCounter cardCounter) {
        super(handCode, 1, cardCounter);
    }

    @Override
    public int compareTo(Hand o) {
        if (handValue < o.handValue) {
            return 1;
        }
        if (handValue > o.handValue) {
            return -1;
        }
        return cards.get(0).compareTo(o.getHighCard());
    }

    /**
     * Return true if the hand is a valid Straight.
     * Straight can be completed with a Joker.
     *
     * @return True if the hand is a valid Straight and false otherwise.
     */
    @Override
    public boolean validate() {
        int highCardValue = getHighCard().ValueIndex;
        int cardSuit = getHighCard().SuitIndex;

        if (_hasJoker) {
            cards.remove(_joker);
        }

        int highLowDiff = highCardValue - getLowCard().ValueIndex - cards.size() + 1;

        if (_hasJoker) {
            if (highLowDiff == 0) {
                if (highCardValue != Card.ACE_IDX) {
                    _joker.setJoker(highCardValue + 1, cardSuit);
                } else {
                    _joker.setJoker(getLowCard().ValueIndex - 1, cardSuit);
                }

            } else if (highLowDiff == 1) {
                for (int i = 1; i < cards.size(); i++) {
                    if (highCardValue - cards.get(i).ValueIndex - i > 0) {
                        _joker.setJoker(cards.get(i).ValueIndex + 1, cardSuit);
                        break;
                    }
                }
            } else {
                cards.add(_joker);
                cards.sort(new CardSorter());

                return false;
            }

            cards.add(_joker);
            cards.sort(new CardSorter());
            highCardValue = getHighCard().ValueIndex;
        }

        return highCardValue - getLowCard().ValueIndex - cards.size() == -1;
    }
}
