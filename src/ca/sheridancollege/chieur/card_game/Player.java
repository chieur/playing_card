
package ca.sheridancollege.chieur.card_game;

import java.util.*;
import ca.sheridancollege.chieur.cards.Card;

public class Player extends ca.sheridancollege.chieur.game.Player{
	public Set<? extends Card> deck = new HashSet();

	public Player(int id) {
		super(id);
	}

	@Override
	public String toString() {
		return "player # "+ID;
	}
}