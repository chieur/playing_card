/**
 * 2022-07-27
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.standard_playing_cards;

import ca.sheridancollege.chieur.playing_cards.group_card;
import java.util.*;

public class Deck {
	static public Set<Card> getCards() {
		Set<Card> cards = new HashSet();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}

		return cards;
	}
}