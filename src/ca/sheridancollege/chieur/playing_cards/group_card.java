/**
	SYST 17796 Project Base code.
	Students can modify and extend to implement their game.
	Add your name as an author and the date!
*/
package ca.sheridancollege.chieur.playing_cards;

import java.util.Collections;
import java.util.ArrayList;

/**
	A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than once. The group of cards has a maximum size attribute which is flexible for reuse.

	@author dancye
	@author Paul Bonenfant Jan 2020
*/
public class group_card{
	private ArrayList<Card>list_card;

	public group_card(ArrayList<Card>list_card){
		this.list_card=list_card;
	}

	/**
		A method that will get the group of cards as an ArrayList

		@return the group of cards.
	*/
	public ArrayList<Card>get_list_card(){
		return list_card;
	}

	public void shuffle(){
		Collections.shuffle(list_card);
	}

	/**
		@return the number of cards in this deck
	*/
	public int get_amount_card(){
		return list_card.size();
	}
}