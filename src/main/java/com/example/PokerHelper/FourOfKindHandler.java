package com.example.PokerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourOfKindHandler implements HandEvaluator {
    private HandEvaluator nextEvaluator;

    public FourOfKindHandler(HandEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
    }

    @Override
    public void evaluate(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            String value = card.getValue();
            int count = valueCount.getOrDefault(value, 0);
            valueCount.put(value, count + 1);
        }

        if (valueCount.containsValue(4)) {
            System.out.println("This hand contains four of a kind.");
        } else if (nextEvaluator != null) {
            nextEvaluator.evaluate(hand);
        }
    }
}
