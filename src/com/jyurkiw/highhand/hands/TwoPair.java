package com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Card;
import com.jyurkiw.highhand.CardCounter;
import com.jyurkiw.highhand.Hand;

import java.util.*;

public class TwoPair extends Hand {
    public HashSet<Integer> pairValues = new HashSet<>();

    public TwoPair(String handCode) {
        super(handCode, 7);

        initPairValues();
    }

    public TwoPair(String handCode, CardCounter cardCounter) {
        super(handCode, 7, cardCounter);

        initPairValues();
    }

    private void initPairValues(){
        HashSet<Integer> valueSet = new HashSet<>();
        for (Card card : cards) {
            if (valueSet.contains(card.ValueIndex)) {
                pairValues.add(card.ValueIndex);
            } else {
                valueSet.add(card.ValueIndex);
            }
        }
    }

    /**
     * Used to compare two hands to check for getPair winner.
     *
     * @param o The other hand to compare to.
     * @return 1 if this hand is greater, 0 if getPair tie, -1 if this hand is lesser.
     */
    @Override
    public int compareTo(Hand o) {
        if (handValue < o.handValue) {
            return 1;
        }
        if (handValue > o.handValue) {
            return -1;
        }

        TwoPair other;
        if (o instanceof TwoPair) {
            other = (TwoPair) o;
        } else {
            return -1;
        }

        int maxComp = pairValues.stream().max(Comparator.comparing(Integer::valueOf)).get()
                .compareTo(other.pairValues.stream().max(Comparator.comparing(Integer::valueOf)).get()
        );

        if (maxComp == 0) {
            maxComp = pairValues.stream().min(Comparator.comparing(Integer::valueOf)).get()
                    .compareTo(other.pairValues.stream().min(Comparator.comparing(Integer::valueOf)).get()
            );
        }

        if (maxComp == 0) {
            HashSet<Integer> singles = cardCounter.getSingleValues();
            HashSet<Integer> oSingles = o.cardCounter.getSingleValues();

            return singles.stream().max(Comparator.comparing(Integer::intValue)).get().compareTo(
                    oSingles.stream().max(Comparator.comparing(Integer::intValue)).get()
            );
        } else {
            return maxComp;
        }
    }

    /**
     * Returns true if the hand's hand code is valid for the hand type.
     *
     * @return True if the hand is valid.
     */
    @Override
    public boolean validate() {
        return pairValues.size() == 2;
    }
}
