/**
 * 2022-07-28
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards_game;

import ca.sheridancollege.chieur.standard_playing_cards.*;
import ca.sheridancollege.chieur.playing_cards.Manager;
import java.util.*;

public class GameSystem {
	static private final UiController uiController = new ConsoleController();
	static private final Set<Card> centralDeck = Deck.getCards();
	static private Set<Player> activePlayers = createPlayers(2, 4);
	static private Card revealedCentralCard = null;

	static private Set<Player> createPlayers(int min, int max) {
		Set<Player> players = new TreeSet();
		for (int i = 0, playersSize = uiController.promptPlayerAmount(min, max); i < playersSize; i++) {
			players.add(new Player(i));
		}
		return players;
	}

	static public void main(String[] args) {
		for (Player currentPlayer : activePlayers) {
			Manager.transferRandomCards(centralDeck, 8, currentPlayer.deck);// deals cards to the player
		}

		for (int iteration = 1; activePlayers.size() > 1; iteration++) {
			uiController.announceRoundIteration(iteration);
			revealedCentralCard = Manager.takeRandomCard(centralDeck);// reveals 1 random card from the pile
			uiController.announceRevealedCentralCard(revealedCentralCard);

			Map<Card, Player> cardPlayerMap = uiController.promptCardPlayerMap(activePlayers);// get the attacking cards from players

			Set<Card> attackngCards = cardPlayerMap.keySet();// attacking cards

			Set<Card> greatestRankCards = Card.getGreatestRankCard(attackngCards);// gets the cards which have the greatest rank

			Manager.transferAllCards(attackngCards, centralDeck);// adds the used cards to the pile

			CardPlayerPair winnerCardPlayerPair = null;

			if (greatestRankCards.size() == 1) {// only 1 card has the greatest rank
				Card card = greatestRankCards.iterator().next();
				winnerCardPlayerPair = new CardPlayerPair(card, cardPlayerMap.get(card));
			} else// multiple cards have the greatest rank
			{
				for (Card card : greatestRankCards) {
					if (card.suit == revealedCentralCard.suit) {
						winnerCardPlayerPair = new CardPlayerPair(card, cardPlayerMap.get(card));
					}
				}
			}
			// determines the winner of this round

			if (winnerCardPlayerPair != null) {// there is a winner
				winnerCardPlayerPair.player.deck.add(revealedCentralCard);// gives the central card to the winner

				uiController.announceDominantCardPlayerPair(winnerCardPlayerPair, revealedCentralCard);// annouces the winner card and player
			} else {// there is no winner
				centralDeck.add(revealedCentralCard);// returns the central card to the pile

				Map<Card, Player> tiedCardPlayerMap = new HashMap();
				for (Card card : greatestRankCards) {
					tiedCardPlayerMap.put(card, cardPlayerMap.get(card));
				}
				uiController.announceTiedDominantCardPlayerPairs(tiedCardPlayerMap, revealedCentralCard);// annouces the the tied cards
			}

			Set<Player> eliminatedPlayers = new TreeSet();
			for (Iterator<Player> activePlayerIterator = activePlayers.iterator(); activePlayerIterator.hasNext();) {
				Player player = activePlayerIterator.next();
				if (player.deck.isEmpty()) {
					eliminatedPlayers.add(player);
					activePlayerIterator.remove();// eliminates this player
				}
			}
			if (!eliminatedPlayers.isEmpty()) {
				uiController.announceEliminatedPlayers(eliminatedPlayers);
			}
		}

		uiController.announceWinnerPlayer(activePlayers.isEmpty()
			? null
			: activePlayers.iterator().next()
		);
	}
}