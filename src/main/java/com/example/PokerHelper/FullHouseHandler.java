package com.example.PokerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouseHandler implements HandEvaluator {

    private HandEvaluator nextEvaluator;

    public FullHouseHandler(HandEvaluator nextEvaluator) {
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

        if (valueCount.containsValue(3) && valueCount.containsValue(2)) {
            System.out.println("This hand contains a full house.");
        } else if (nextEvaluator != null) {
            nextEvaluator.evaluate(hand);
        }
    }
}
