package com.example.PokerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThreeOfKindHandler implements HandEvaluator {
    private HandEvaluator nextEvaluator;

    public ThreeOfKindHandler(HandEvaluator nextEvaluator) {
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

        if (valueCount.containsValue(3)) {
            System.out.println("This hand contains three of a kind.");
        } else if (nextEvaluator != null) {
            nextEvaluator.evaluate(hand);
        } else {
            System.out.println("This hand does not contain three of a kind.");
        }
    }
}