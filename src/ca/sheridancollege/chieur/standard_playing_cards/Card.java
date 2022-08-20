/**
 * 2022-07-27
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.standard_playing_cards;

import java.util.*;

public class Card extends ca.sheridancollege.chieur.playing_cards.Card {
	static public Set<Card> getGreatestRankCard(Set<Card> cards) {
		Set<Rank> ranks = new HashSet();

		for (Card currentCard : cards) {
			ranks.add(currentCard.rank);
		}

		Rank greatestRank = Rank.getGreatestRank(ranks);

		Set<Card> greatestRankCards = new HashSet();

		for (Card currentCard : cards) {
			if (currentCard.rank == greatestRank) {
				greatestRankCards.add(currentCard);
			}
		}

		return greatestRankCards;
	}

	public final Suit suit;
	public final Rank rank;

	Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "" + suit.getCharacter(true) + rank.getAlphanumeric();
	}
}