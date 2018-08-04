package com.jyurkiw.highhand.com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.CardSorter;
import com.jyurkiw.highhand.Hand;

/**
 * Straight Flush requires five cards of sequential rank of the same suit.
 */
public class StraightFlush extends Hand {

    /**
     *
     *
     * @param handCode
     */
    public StraightFlush(String handCode) {
        super(handCode);
        handValue = 1;
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

    @Override
    public boolean isValid() {
        int highCardValue = getHighCard().ValueIndex;
        int cardSuit = getHighCard().SuitIndex;

        boolean jokerAssigned = false;
        if (_hasJoker) {
            cards.remove(_joker);
        }

        if (!cards.stream().allMatch(crd -> crd.SuitIndex == cardSuit)) {
            return false;
        }

        int highLowDiff = highCardValue - getLowCard().ValueIndex - cards.size() - 1;

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
                    }
                }
            } else {
                return false;
            }

            cards.add(_joker);
            cards.sort(new CardSorter());
        }

        return highCardValue - getLowCard().ValueIndex - cards.size() == 1;
    }
}
