package com.jyurkiw.highhand;

import com.jyurkiw.highhand.com.jyurkiw.highhand.hands.FiveOfAKind;
import com.jyurkiw.highhand.com.jyurkiw.highhand.hands.StraightFlush;

/**
 * A simple factory class that parses hand codes into hand objects.
 * Nothing fancy here. Just test hands in order from most valuable to least valuable and
 * return the first successful isValid call.
 */
public class HandFactory {

    /**
     * Parse the passed hand code's hand type. Start at the top and work our way down to high-card.
     * If a hand is nothing else, it is automatically a high-card.
     *
     * @param handCode A valid handCode is a colon delimited collection of five cardCodes (ex: AS:4D:3C:4H:3S)
     * @return The highest viable hand object for the passed hand code.
     */
    public static Hand parseHand(String handCode) {
        Hand hand;

        hand = new FiveOfAKind(handCode);
        if (!hand.isValid()) {
            hand = new StraightFlush(handCode);
        }

        return hand;
    }
}
