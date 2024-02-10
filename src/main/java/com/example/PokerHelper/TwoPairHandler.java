package com.example.PokerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairHandler implements  HandEvaluator {

    private HandEvaluator nextEvaluator;

    public TwoPairHandler(HandEvaluator nextEvaluator) {
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


        long pairs = 0;
        for (int count : valueCount.values()) {
            if (count == 2) {
                pairs++;
            }
        }

        if (pairs == 2) {
            System.out.println("This hand contains  two pairs.");
        } else if (nextEvaluator != null) {
            nextEvaluator.evaluate(hand);
        }
    }
}
