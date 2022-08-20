/**
	@author Ricky Chieu 2022
*/
package ca.sheridancollege.chieur.cards;

import java.util.Set;

public abstract class Deck {
	static protected Set<? extends Card> allCards;

	/**
		@return the number of cards in this deck
	*/
	static public int getSize(){
		return allCards.size();
	}
}