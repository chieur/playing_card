/**
 * @date 2022-07-23
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.playing_cards;

public abstract class Card {
	//default modifier for child classes

	/**
	 * Students should implement this method for their specific children classes
	 *
	 * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
	 */
	@Override
	public abstract String toString();
}