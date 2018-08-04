package com.jyurkiw.highhand;

/**
 * Represents a single Card in a standard deck (not counting the Joker).
 */
public class Card implements Comparable<Card> {
    private static final String[] CARD_SUIT = {
            "H",
            "S",
            "C",
            "D",
            "JOKER"
    };

    private static final String[] CARD_VALUE = {
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

    public static final int ACE_IDX = 13;
    public static final int JOKER_IDX = 0;
    public static final int JOKER_SUIT = 4;

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

    private boolean _isJoker = false;
    private boolean _isAssignedJoker = false;

    /**
     * Construct a Card with the passed value and suit indexes.
     *
     * @param valueIndex The value index to set.
     * @param suitIndex The suit index to set.
     */
    public Card(int valueIndex, int suitIndex) {
        ValueIndex = valueIndex;
        SuitIndex = suitIndex;

        _isJoker = ValueIndex == JOKER_IDX && SuitIndex == JOKER_SUIT;
    }

    /**
     * Construct a Card with the passed card code.
     *
     * @param cardCode A valid card code (ex: 10H = Ten of Hearts)
     */
    public Card(String cardCode) {
        ValueIndex = Card.getCardValueIndex(cardCode);
        SuitIndex = Card.getCardSuitIndex(cardCode);

        _isJoker = cardCode.equalsIgnoreCase("JOKER");
    }

    /**
     * Return true if this card is a joker.
     *
     * @return true if this card is a joker.
     */
    public boolean isJoker() {
        return _isJoker;
    }

    /**
     * Set the value of this joker to another card value.
     * @param cardCode The card to set this joker to.
     */
    public void setJoker(String cardCode) {
        if (isJoker()) {
            ValueIndex = Card.getCardValueIndex(cardCode);
            SuitIndex = Card.getCardSuitIndex(cardCode);

            _isAssignedJoker = true;
        }
    }

    /**
     * Set the value of this joker to another card value.
     *
     * @param valueIndex The card value index.
     * @param suitIndex The card suit index.
     */
    public void setJoker(int valueIndex, int suitIndex) {
        if (isJoker()) {
            ValueIndex = valueIndex;
            SuitIndex = suitIndex;

            _isAssignedJoker = true;
        }
    }

    /**
     * Returns true if this card is an assigned joker.
     *
     * @return true if this card is an assigned joker.
     */
    public boolean isAssignedJoker() {
        return _isAssignedJoker;
    }

    /**
     * Reset this joker to a joker's value.
     */
    public void resetJoker() {
        if (_isJoker) {
            ValueIndex = 0;
            SuitIndex = 4;

            _isAssignedJoker = false;
        }
    }

    @Override
    public int compareTo(Card o) {
        int compValue =  ValueIndex - o.ValueIndex;
        if (compValue > 0) {
            return 1;
        } else if (compValue < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (isJoker()) {
            return "JOKER(" + Card.CARD_VALUE[ValueIndex] + Card.CARD_SUIT[SuitIndex] + ")";
        } else {
            return Card.CARD_VALUE[ValueIndex] + Card.CARD_SUIT[SuitIndex];
        }
    }
}
