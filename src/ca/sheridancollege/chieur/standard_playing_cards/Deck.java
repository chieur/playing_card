/**
 * 2022-07-27
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.standard_playing_cards;

import java.util.*;

public class Deck extends ca.sheridancollege.chieur.cards.Deck{
	static public Set<Card> getAllCards() {
		if (allCards == null) {
			Set<Card> cards = new HashSet();

			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					cards.add(new Card(suit, rank));
				}
			}

			allCards = cards;
		}

		return (Set<Card>) allCards;
	}
}