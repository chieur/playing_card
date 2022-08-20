/**
 * 2022-07-27
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.standard_playing_cards;

import java.util.*;

public class Card extends ca.sheridancollege.chieur.cards.Card {

	public final Suit SUIT;
	public final Rank RANK;

	Card(Suit suit, Rank rank) {
		this.SUIT = suit;
		this.RANK = rank;
	}

	@Override
	public String toString() {
		return "" + SUIT.getCharacter(true) + RANK.getAlphanumeric();
	}

	static public Set<Card> getGreatestRankCard(Set<Card> cards) {
		Set<Rank> ranks = new HashSet();

		for (Card currentCard : cards) {
			ranks.add(currentCard.RANK);
		}

		Rank greatestRank = Rank.getGreatestRank(ranks);

		Set<Card> greatestRankCards = new HashSet();

		for (Card currentCard : cards) {
			if (currentCard.RANK == greatestRank) {
				greatestRankCards.add(currentCard);
			}
		}

		return greatestRankCards;
	}
}