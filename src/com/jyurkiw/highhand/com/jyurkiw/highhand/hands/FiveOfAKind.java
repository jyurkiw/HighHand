package com.jyurkiw.highhand.com.jyurkiw.highhand.hands;

import com.jyurkiw.highhand.Hand;

public class FiveOfAKind extends Hand {
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
