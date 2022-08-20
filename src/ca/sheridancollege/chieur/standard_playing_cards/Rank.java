/**
 * 2022-07-27
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.standard_playing_cards;

import java.util.*;

public enum Rank {
	ACE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING;

	static Rank getGreatestRank(Set<Rank> ranks) {
		Rank currentGreatestRank = ACE;
		for (Rank currentRank : ranks) {
			if (currentRank.getMagnitude() > currentGreatestRank.getMagnitude()) {
				currentGreatestRank = currentRank;
			}
		}
		return currentGreatestRank;
	}

	private int getMagnitude() {
		return ordinal() + 1;
	}

	char getAlphanumeric() {
		return ordinal() > 0 && ordinal() < 9
			? String.valueOf(getMagnitude()).charAt(0)
			: ordinal() == 9
				? 'X'
				: Character.toUpperCase(name().charAt(0));
	}
}