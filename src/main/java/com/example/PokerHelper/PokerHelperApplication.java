package com.example.PokerHelper;
import java.util.ArrayList;
import java.util.List;

public class PokerHelperApplication {

	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card("Hearts", "Ace"));
		cards.add(new Card("Diamonds", "Ace"));
		cards.add(new Card("Clubs", "King"));
		cards.add(new Card("Spades", "Queen"));
		cards.add(new Card("Hearts", "Jack"));

		HandEvaluator evaluatorChain = new PairHandler(new ThreeOfKindHandler(null));

		PokerHand pairHand = new PokerHand(cards);
		System.out.println("First hand:");
		evaluatorChain.evaluate(pairHand);

		cards.set(2, new Card("Clubs", "Ace"));

		PokerHand threeOfKindHand = new PokerHand(cards);
		System.out.println("\nSecond Hand");
		evaluatorChain.evaluate(threeOfKindHand);
	}
}


