package com.jyurkiw.highhand;

/**
 * Represents a single Card in a standard deck (not counting the Joker).
 */
public class Card implements Comparable<Card> {
    public static final String[] CARD_SUIT = {
            "H",
            "S",
            "C",
            "D",
            "JOKER"
    };

    public static final String[] CARD_VALUE = {
            "JOKER",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "J",
            "Q",
            "K",
            "A"
    };

    /**
     * Return value from the passed card code.
     *
     * @param cardCode A valid card code (ex: 10H = Ten of Hearts)
     * @return The numerical value of the code (ex: 10H = 10, AS = A)
     */
    public static String getCardValue(String cardCode) {
        if (cardCode.equalsIgnoreCase("JOKER")) {
            return cardCode;
        }
        return cardCode.substring(0, cardCode.length() - 1);
    }

    /**
     * Return the CARD_VALUE index for the passed card code's value.
     *
     * @param cardCode A valid card code (ex: 10H = Ten of Hearts)
     * @return The index of the card code's value or -1 if not found.
     */
    public static int getCardValueIndex(String cardCode) {
        String cardValue = Card.getCardValue(cardCode);
        for (int i = 0; i < Card.CARD_VALUE.length; i++) {
            if (Card.CARD_VALUE[i].equalsIgnoreCase(cardValue)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Return the suit from the passed card code.
     *
     * @param cardCode A valid card code (ex: 10H = Ten of Hearts)
     * @return The suit of the code (ex: 10H = H, AS = S)
     */
    public static String getCardSuit(String cardCode) {
        if (cardCode.equalsIgnoreCase("JOKER")) {
            return cardCode;
        }
        return "" + cardCode.charAt(cardCode.length() - 1);
    }

    /**
     * Return the CARD_SUIT index for the passed card code's value.
     *
     * @param cardCode A valid card code (ex: 10H = Ten of Hearts)
     * @return The index of the card code's suit or -1 if not found.
     */
    public static int getCardSuitIndex(String cardCode) {
        String suitValue = Card.getCardSuit(cardCode);
        for (int i = 0; i < Card.CARD_SUIT.length; i++) {
            if (Card.CARD_SUIT[i].equalsIgnoreCase(suitValue)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * The CARD_VAlUE index of this card.
     */
    public int ValueIndex;

    /**
     * The CARD_SUIT index of this card.
     */
    public int SuitIndex;

    /**
     * Construct a Card with the passed value and suit indexes.
     *
     * @param valueIndex The value index to set.
     * @param suitIndex The suit index to set.
     */
    public Card(int valueIndex, int suitIndex) {
        ValueIndex = valueIndex;
        SuitIndex = suitIndex;
    }

    /**
     * Construct a Card with the passed card code.
     *
     * @param cardCode A valid card code (ex: 10H = Ten of Hearts)
     */
    public Card(String cardCode) {
        ValueIndex = Card.getCardValueIndex(cardCode);
        SuitIndex = Card.getCardSuitIndex(cardCode);
    }

    public boolean isJoker() {
        return ValueIndex == 0 && SuitIndex == 4;
    }

    @Override
    public int compareTo(Card o) {
        return ValueIndex - o.ValueIndex;
    }

    @Override
    public String toString() {
        return Card.CARD_VALUE[ValueIndex] + Card.CARD_SUIT[SuitIndex];
    }
}
