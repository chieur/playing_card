/**
 * 2022-08-08
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.my_card_game;

import ca.sheridancollege.chieur.standard_playing_cards.Card;

public class CardPlayerPair {
	final Card CARD;
	final Player PLAYER;

	CardPlayerPair(Card card, Player player) {
		this.CARD = card;
		this.PLAYER = player;
	}
}