/**
 * 2022-07-28
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards_game;

import ca.sheridancollege.chieur.standard_playing_cards.Card;
import ca.sheridancollege.chieur.playing_cards.Manager;
import java.util.*;

public class ConsoleController implements UiController {
	Scanner scanner = new Scanner(System.in);
	SynchronousUi synchronousUi = new Console();// make singleton

	@Override
	public int promptPlayerAmount(int min, int max) {
		synchronousUi.announcePlayerAmountPrompt(min, max);
		int playerAmount;
		for (;;) {
			playerAmount = synchronousUi.requestPlayerAmount();
			if (playerAmount < min || playerAmount > max) {
				synchronousUi.announceInvalidInputMessage(new Exception("invalid input: the number of players must be but isn't inclusively between 2 and 4"));
			} else {
				return playerAmount;
			}
		}
	}

	@Override
	public void announceRoundIteration(int iteration) {
		synchronousUi.announceRoundIteration(iteration);
	}

	@Override
	public void announceRevealedCentralCard(Card card) {
		synchronousUi.announceRevealedCentralCard(card);
	}

	private Card promptCard(Player player) {
		synchronousUi.announceCardPrompt(player);
		Card card;
		for (;;) {
			try {
				card = Manager.takeCard(player.deck, synchronousUi.requestCardEnumeration());
				break;
			} catch (IndexOutOfBoundsException exception) {
				synchronousUi.announceInvalidInputMessage(new Exception("invalid input: the enumeration of the card must be but isn't existant"));
			}
		}
		synchronousUi.announceChosenCard(card);
		return card;
	}

	@Override
	public Map<Card, Player> promptCardPlayerMap(Set<Player> players) {
		HashMap<Card, Player> CardPlayerMap = new HashMap();
		for (Player player : players) {
			CardPlayerMap.put(promptCard(player), player);// link the player with its card
		}
		return CardPlayerMap;
	}

	@Override
	public void announceDominantCardPlayerPair(CardPlayerPair CardPlayerPair, Card centralCard) {
		synchronousUi.announceDominantCardPlayerPair(CardPlayerPair, centralCard);
	}

	@Override
	public void announceTiedDominantCardPlayerPairs(Map<Card, Player> cardPlayerMap, Card centralCard) {
		synchronousUi.announceTiedDominantCardPlayerPairs(cardPlayerMap, centralCard);
	}

	@Override
	public void announceEliminatedPlayers(Set<Player> players) {
		synchronousUi.announceEliminatedPlayers(players);
	}

	@Override
	public void announceWinnerPlayer(Player player) {
		synchronousUi.announceWinnerPlayer(player);
	}
}