/**
 * 2022-08-08
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards_game;

import ca.sheridancollege.chieur.standard_playing_cards.Card;

public class CardPlayerPair {
	final Card card;
	final Player player;

	CardPlayerPair(Card card, Player player) {
		this.card = card;
		this.player = player;
	}
}