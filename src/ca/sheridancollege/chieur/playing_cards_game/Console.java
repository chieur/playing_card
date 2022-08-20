/**
 * 2022-08-09
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards_game;

import ca.sheridancollege.chieur.standard_playing_cards.Card;
import java.util.*;

public class Console implements SynchronousUi {
	Scanner scanner = new Scanner(System.in);

	@Override
	public void announceInvalidInputMessage(Throwable throwable) {
		System.out.println(throwable);
	}

	@Override
	public void announcePlayerAmountPrompt(int min, int max) {
		System.out.println("the amount of players must be inclusively between 2 and 4");
	}

	@Override
	public int requestPlayerAmount() {
		System.out.println("input the amount of players");
		return scanner.nextInt();
	}

	@Override
	public void announceRoundIteration(int iteration) {
		System.out.println("\nround # " + iteration);
	}

	@Override
	public void announceRevealedCentralCard(Card card) {
		System.out.println("\nrevealed central card : " + card);
	}

	@Override
	public void announceCardPrompt(Player player) {
		System.out.println("\n" + player + "'s deck");
		Set<Card> deck = player.deck;

		System.out.print("enum :");
		for (int index = 0, deckSize = deck.size(); index < deckSize; index++) {
			System.out.printf(" %02d", index);
		}

		System.out.print("\ncard :");
		for (Card card : deck) {
			System.out.print(" " + card);
		}

		System.out.println();
	}

	@Override
	public int requestCardEnumeration() {
		System.out.println("input the enumeration of the card to use");
		return scanner.nextInt();
	}

	@Override
	public void announceChosenCard(Card card) {
		System.out.println("card chosen : " + card);
	}

	@Override
	public void announceDominantCardPlayerPair(CardPlayerPair cardPlayerPair, Card centralCard) {
		System.out.println("\ndominant card : " + cardPlayerPair.card + "\ncentral card " + centralCard + " awarded to " + cardPlayerPair.player);
	}

	@Override
	public void announceTiedDominantCardPlayerPairs(Map<Card, Player> cardPlayerMap, Card centralCard) {
		System.out.println("\ntie");
		for (Card card : cardPlayerMap.keySet()) {
			System.out.println(card + " of " + cardPlayerMap.get(card));
		}
		System.out.println(centralCard + " not awarded to anyone");
	}

	@Override
	public void announceEliminatedPlayers(Set<Player> players) {
		System.out.println("\nplayer(s) eliminated :");
		for (Player player : players) {
			System.out.println(player);
		}
	}

	@Override
	public void announceWinnerPlayer(Player player) {
		System.out.println(player == null
			? "ther is no winner"
			: "\nwinner : " + player
		);
	}
}