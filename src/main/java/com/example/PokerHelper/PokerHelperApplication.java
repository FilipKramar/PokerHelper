package com.example.PokerHelper;
import java.util.ArrayList;
import java.util.List;

public class PokerHelperApplication {

	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card("Hearts", "Ace"));
		cards.add(new Card("Hearts", "Two"));
		cards.add(new Card("Hearts", "One"));
		cards.add(new Card("Hearts", "Jack"));
		cards.add(new Card("Hearts", "Jack"));

		HandEvaluator evaluatorChain = new FourOfKindHandler((new FullHouseHandler( new FlushHandler(new ThreeOfKindHandler(new TwoPairHandler(new PairHandler(null)))))));

		PokerHand pairHand = new PokerHand(cards);
		System.out.println("First hand:");
		evaluatorChain.evaluate(pairHand);

		cards.set(2, new Card("Clubs", "Ace"));

		PokerHand threeOfKindHand = new PokerHand(cards);
		System.out.println("Second Hand:");
		evaluatorChain.evaluate(threeOfKindHand);

		cards.set(2, new Card("Clubs", "Queen"));

		PokerHand twoPairHand = new PokerHand(cards);
		System.out.println("Third hand:");
		evaluatorChain.evaluate(twoPairHand);

		cards.set(2, new Card("Clubs", "Ace"));
	}
}


