/**
 * @author	Ricky Chieu 2022
*/
package ca.sheridancollege.chieur.my_card_game;

import ca.sheridancollege.chieur.cards.DeckManager;
import ca.sheridancollege.chieur.standard_playing_cards.Card;
import ca.sheridancollege.chieur.standard_playing_cards.Deck;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Game extends ca.sheridancollege.chieur.card_game.Game {
	private final UiController UI_CONTROLLER;
	private final Set<Card> CENTRAL_DECK = Deck.getAllCards();
	private Set<Player> activePlayers;
	private Card revealedCentralCard = null;

	Game(UiController uiController, Set<Player> players) {
		this.UI_CONTROLLER = uiController;
		activePlayers = players;
	}

	void play() {
		for (Player currentPlayer : activePlayers) {
			DeckManager.transferRandomCards(CENTRAL_DECK, 8, currentPlayer.deck);// deals cards to the player
		}

		for (int iteration = 1; activePlayers.size() > 1; iteration++) {
			UI_CONTROLLER.announceRoundIteration(iteration);
			revealedCentralCard = DeckManager.takeRandomCard(CENTRAL_DECK);// reveals 1 random card from the pile
			UI_CONTROLLER.announceRevealedCentralCard(revealedCentralCard);

			Map<Card, Player> cardPlayerMap = UI_CONTROLLER.promptCardPlayerMap(activePlayers);// get the attacking cards from players

			Set<Card> attackngCards = cardPlayerMap.keySet();// attacking cards

			Set<Card> greatestRankCards = Card.getGreatestRankCard(attackngCards);// gets the cards which have the greatest rank

			DeckManager.transferAllCards(attackngCards, CENTRAL_DECK);// adds the used cards to the pile

			CardPlayerPair winnerCardPlayerPair = null;

			if (greatestRankCards.size() == 1) {// only 1 card has the greatest rank
				Card card = greatestRankCards.iterator().next();
				winnerCardPlayerPair = new CardPlayerPair(card, cardPlayerMap.get(card));
			} else// multiple cards have the greatest rank
			{
				for (Card card : greatestRankCards) {
					if (card.SUIT == revealedCentralCard.SUIT) {
						winnerCardPlayerPair = new CardPlayerPair(card, cardPlayerMap.get(card));
					}
				}
			}
			// determines the winner of this round

			if (winnerCardPlayerPair != null) {// there is a winner
				winnerCardPlayerPair.PLAYER.deck.add(revealedCentralCard);// gives the central card to the winner

				UI_CONTROLLER.announceDominantCardPlayerPair(winnerCardPlayerPair, revealedCentralCard);// annouces the winner card and player
			} else {// there is no winner
				CENTRAL_DECK.add(revealedCentralCard);// returns the central card to the pile

				Map<Card, Player> tiedCardPlayerMap = new HashMap();
				for (Card card : greatestRankCards) {
					tiedCardPlayerMap.put(card, cardPlayerMap.get(card));
				}
				UI_CONTROLLER.announceTiedDominantCardPlayerPairs(tiedCardPlayerMap, revealedCentralCard);// annouces the the tied cards
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
				UI_CONTROLLER.announceEliminatedPlayers(eliminatedPlayers);
			}
		}

		UI_CONTROLLER.announceWinnerPlayer(activePlayers.isEmpty()
			? null
			: activePlayers.iterator().next()
		);
	}
}