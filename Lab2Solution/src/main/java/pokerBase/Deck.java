package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				// TODO Lab3 - Fix this
				if ((eSuit != eSuit.JOKER) && (eRank != eRank.JOKER)) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}

		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers) {
		// TODO Lab3 - Implement joker constructor
		this();
		for (int i = 0; i < NbrOfJokers; i++) {
			deckCards.add(new Card(eSuit.JOKER, eRank.JOKER, 99));
		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);
		// TODO Lab3 - Implement joker and wild constructor
		for (Card DeckCard : deckCards) {
			for (Card WildCard : Wilds) {
				if (DeckCard == WildCard) {
					DeckCard.setbWild(true);
				}
			}
		}

	}

	public Card Draw() {
		// TODO Lab 3 - Implement exception handling for overdraw
		return deckCards.remove(0);
	}

	public ArrayList<Card> getCardsinDeck() {
		return deckCards;
	}
	class DeckException extends Exception {

		public Card Draw() throws DeckException {
			if (deckCards.size() < 1)
				throw new DeckException();
			return deckCards.remove(0);
		}
	}
}
