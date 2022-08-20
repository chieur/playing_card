/**
 * 2022-07-28
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards_game;

import java.util.*;

public class Player implements Comparable<Player> {
	final int id;
	Set<ca.sheridancollege.chieur.standard_playing_cards.Card> deck = new HashSet();

	Player(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "player # " + id;
	}

	@Override
	public int compareTo(Player player) {
		if (id < player.id) {
			return -1;
		} else if (id > player.id) {
			return 1;
		} else {
			return 0;
		}
	}
}