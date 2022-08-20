/**
	@date 2022-07-23
	@author Ricky Chieu
*/

package ca.sheridancollege.chieur.playing_cards;

/**
	A class that models each Player in the game. Players have an identifier, which should be unique.

	@author dancye
	@author Paul Bonenfant Jan 2020
*/
public abstract class player{
	private String name;

	/**
		A constructor that allows you to set the player's unique ID
		@param name the unique ID to assign to this player.
	*/
	public player(String name){
		this.name=name;
	}

	/**
		@return the name of the player
	*/
	public String get_name(){
		return name;
	}

	/**
		sets the name of the player
		@param name name of the player to set
	*/
	public void set_name(String name){
		this.name=name;
	}

	/**
		The method to be overridden when you subclass the Player class with your specific type of Player and filled in with logic to play your game.
	*/
	public abstract void play();
}