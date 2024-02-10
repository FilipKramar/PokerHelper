package com.example.PokerHelper;

import java.util.List;

class PokerHand {
    private List<Card> cards;

    public PokerHand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
