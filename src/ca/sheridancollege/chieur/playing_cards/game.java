/**
	@date 2022-07-23
	@author Ricky Chieu
*/

package ca.sheridancollege.chieur.playing_cards;

import java.util.ArrayList;

/**
	The class that models your game. You should create a more specific child of this class and instantiate the methods given.
*/
public abstract class game{
	private final String name;
	private ArrayList<player>list_player;

	public game(String name){
		this.name=name;
		list_player=new ArrayList();
	}

	/**
		@return the name
	*/
	public String get_name(){
		return name;
	}

	/**
		@return the players of this game
	*/
	public ArrayList<player> get_list_player(){
		return list_player;
	}

	/**
		@param list_player the players of this game
	*/
	public void set_list_player(ArrayList<player>list_player){
		this.list_player=list_player;
	}

	/**
		Play the game. This might be one method or many method calls depending on your game.
	*/
	public abstract void play();

	/**
		When the game is over, use this method to declare and display a winning player.
	*/
	public abstract void declare_winner();
}