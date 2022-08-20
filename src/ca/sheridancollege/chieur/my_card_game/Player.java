/**
 * 2022-07-28
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.my_card_game;

import java.util.*;

public class Player extends ca.sheridancollege.chieur.card_game.Player {
	Set<ca.sheridancollege.chieur.standard_playing_cards.Card> deck = new HashSet();

	Player(int id) {
		super(id);
	}
}