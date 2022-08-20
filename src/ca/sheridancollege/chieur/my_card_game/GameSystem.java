/**
 * 2022-07-28
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.my_card_game;

import java.util.*;

public class GameSystem{
	static private final UiController UI_CONTROLLER = ConsoleController.getSingleton();

	static private Set<Player> createPlayers(int min, int max) {
		Set<Player> players = new TreeSet();
		for (int i = 0, playersAmount = UI_CONTROLLER.promptPlayerAmount(min, max); i < playersAmount; i++) {
			players.add(new Player(i));
		}
		return players;
	}

	static public void main(String[] args) {
		Game game=new Game(UI_CONTROLLER,createPlayers(2,4));
		game.play();
	}
}