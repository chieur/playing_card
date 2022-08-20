/**
 * 2022-08-03
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.cards;

import java.util.*;
import java.util.Random;

public class DeckManager {
	static private final Random RANDOM = new Random();

	static public <C extends ca.sheridancollege.chieur.cards.Card> C takeCard(Set<C> deck, int index) {
		C card = (C) deck.toArray()[index];
		deck.remove(card);
		return card;
	}

	static public <C extends ca.sheridancollege.chieur.cards.Card> C takeRandomCard(Set<C> deck) {
		C card = (C) deck.toArray()[RANDOM.nextInt(deck.size())];
		deck.remove(card);
		return card;
	}

	static public <C extends ca.sheridancollege.chieur.cards.Card> Set<C> takeRandomCards(Set<C> deck, int amount) {
		Set<C> cards = new HashSet();
		for (int i = 0; i < amount; i++) {
			cards.add(takeRandomCard(deck));
		}
		return cards;
	}

	static public <C extends ca.sheridancollege.chieur.cards.Card> void transferAllCards(Set<C> sourceDeck, Set<C> destinationDeck) {
		destinationDeck.addAll(sourceDeck);
	}

	static public <C extends ca.sheridancollege.chieur.cards.Card> void transferRandomCard(Set<C> sourceDeck, Set<C> destinationDeck) {
		destinationDeck.add(takeRandomCard(sourceDeck));
	}

	static public <C extends ca.sheridancollege.chieur.cards.Card> void transferRandomCards(Set<C> sourceDeck, int amount, Set<C> destinationDeck) {
		destinationDeck.addAll(takeRandomCards(sourceDeck, amount));
	}
}