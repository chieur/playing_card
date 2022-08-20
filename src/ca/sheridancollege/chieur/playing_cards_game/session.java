/**
	2022-07-28
	@author Ricky Chieu
*/

package ca.sheridancollege.chieur.playing_cards_game;

public class session{
	static private session singleton=null;

	private session(){}

	static session get_instance(){
		return singleton==null?new session():singleton;
	}

	public void create_list_player(){
		
	}
}