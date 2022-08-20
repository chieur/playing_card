/**
 * 2022-07-28
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.my_card_game;

import ca.sheridancollege.chieur.standard_playing_cards.Card;
import java.util.*;

interface UiController {
	int promptPlayerAmount(int min, int max);

	void announceRoundIteration(int iteration);

	void announceRevealedCentralCard(Card card);

	Map<Card, Player> promptCardPlayerMap(Set<Player> players);

	void announceDominantCardPlayerPair(CardPlayerPair cardPlayerPair, Card centralCard);

	void announceTiedDominantCardPlayerPairs(Map<Card, Player> cardPlayerMap, Card centralCard);

	void announceEliminatedPlayers(Set<Player> players);

	void announceWinnerPlayer(Player player);
}