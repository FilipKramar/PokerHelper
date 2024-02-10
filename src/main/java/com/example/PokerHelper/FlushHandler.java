package com.example.PokerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlushHandler implements  HandEvaluator{
    private HandEvaluator nextEvaluator;

    public FlushHandler(HandEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
    }

    @Override
    public void evaluate(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Map<String, Integer> suitCount = new HashMap<>();

        for (Card card : cards) {
            String value = card.getSuit();
            int count = suitCount.getOrDefault(value, 0);
            suitCount.put(value, count + 1);
        }

        if (suitCount.containsValue(5)) {
            System.out.println("This hand contains a flush.");
        } else if (nextEvaluator != null) {
            nextEvaluator.evaluate(hand);
        }
    }
}
