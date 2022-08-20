/**
 * 2022-08-09
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards_game;

import ca.sheridancollege.chieur.standard_playing_cards.Card;
import java.util.*;

public interface SynchronousUi {
	void announceInvalidInputMessage(Throwable throwable);

	void announcePlayerAmountPrompt(int min, int max);

	int requestPlayerAmount();

	void announceRoundIteration(int iteration);

	void announceRevealedCentralCard(Card card);

	void announceCardPrompt(Player player);

	int requestCardEnumeration();

	void announceChosenCard(Card card);

	void announceDominantCardPlayerPair(CardPlayerPair cardPlayerPair, Card centralCard);

	void announceTiedDominantCardPlayerPairs(Map<Card, Player> cardPlayerMap, Card centralCard);

	void announceEliminatedPlayers(Set<Player> players);

	void announceWinnerPlayer(Player player);
}