package com.jyurkiw.highhand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Counts cards and suits in a hand.
 */
public class CardCounter {
    public HashMap<Integer, Integer> values;
    public HashMap<Integer, Integer> suits;

    public HashMap<Integer, Integer> backValues;
    public HashMap<Integer, Integer> backSuits;

    public CardCounter() {
        values = new HashMap<>();
        suits = new HashMap<>();

        backValues = new HashMap<>();
        backSuits = new HashMap<>();
    }

    /**
     * Returns a CardCounter object mapping card value and suit indexes to count.
     *
     * @param cards The cards arraylist from any hands object.
     * @return A hashmap that maps card value index to count.
     */
    public static CardCounter count(ArrayList<Card> cards) {
        CardCounter counter = new CardCounter();

        for (Card card : cards) {
            int count = counter.values.getOrDefault(card.ValueIndex, 0);
            counter.values.put(card.ValueIndex, count + 1);

            count = counter.suits.getOrDefault(card.SuitIndex, 0);
            counter.suits.put(card.SuitIndex, count + 1);
        }

        for (Map.Entry<Integer, Integer> e : counter.values.entrySet()) {
            counter.backValues.put(e.getValue(), e.getKey());
        }

        for (Map.Entry<Integer, Integer> e : counter.suits.entrySet()) {
            counter.backSuits.put(e.getValue(), e.getKey());
        }

        return counter;
    }

    public HashSet<Integer> getSingleValues() {
        HashSet<Integer> data = new HashSet<>();
        values.entrySet().stream()
                .filter(e->e.getValue() == 1)
                .mapToInt(e -> e.getKey())
                .forEach(i->data.add(i));
        return data;
    }
}
