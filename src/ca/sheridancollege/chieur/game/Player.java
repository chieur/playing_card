package ca.sheridancollege.chieur.game;

/**
 *
 * @author Ricky Chieur
 */
abstract public class Player implements Comparable<Player> {
	public final int ID;

	public Player(int id) {
		ID = id;
	}

	@Override
	public int compareTo(Player player) {
		if (ID>player.ID)
			return 1;
		else if (ID<player.ID)
			return -1;
		else
			return 0;
	}

	@Override
	abstract public String toString();
}