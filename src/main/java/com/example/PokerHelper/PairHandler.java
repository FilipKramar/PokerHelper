package com.example.PokerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PairHandler
        implements HandEvaluator {
    private HandEvaluator nextEvaluator;

    public PairHandler(HandEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
    }

    @Override
    public void evaluate(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            String value = card.getValue();
            valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
        }

        long pairs = valueCount.values().stream().filter(count -> count == 2).count();

        if (pairs == 1) {
            System.out.println("This hand contains a pair.");
        } else if (nextEvaluator != null) {
            nextEvaluator.evaluate(hand);
        } else {
            System.out.println("This hand does not contain a pair.");
        }
    }
}