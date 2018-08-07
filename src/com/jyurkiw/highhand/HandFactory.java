package com.jyurkiw.highhand;

import com.jyurkiw.highhand.hands.*;

/**
 * A simple factory class that parses hand codes into hand objects.
 * Nothing fancy here. Just test hands in order from most valuable to least valuable and
 * return the first successful validate call.
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
        CardCounter counter;

        hand = new FiveOfAKind(handCode);
        if (hand != null && hand.validate()) return hand;

        hand = new StraightFlush(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new FourOfAKind(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new FullHouse(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new Flush(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new Straight(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new ThreeOfAKind(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new TwoPair(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new Pair(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        hand = new HighCard(handCode, hand.cardCounter);
        if (hand.validate()) return hand;

        return null;
    }
}
