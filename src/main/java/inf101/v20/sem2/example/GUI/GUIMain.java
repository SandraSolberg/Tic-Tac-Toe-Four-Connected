package inf101.v20.sem2.example.GUI;

import inf101.v20.games.IGame;
import inf101.v20.trippTrappSpill.trippTrappTreSkoGame;

public class GUIMain {


	public static void main(String[] args) {



		//Supplier iterable siden de skal bruke forskjellige grid??

		//Supplier TrippTrappTresko = new trippTrappTreSkoGame();
		//Supplier firePaaRad = new firePaaRadGame();

		//Supplier menu = new GameGUI
		/* 
		 * If you want to use graphics, you can base your implementation on this skeleton GUI setup. 
		 * 
		 *  You may need to make your own Supplier-type that you can pass on to .run(). 
		 *  
		 *  The supplier should provide some kind of game-instances.
		 *  
		 *  If you don't want to use this code, you are free to delete it. 
		 *  
		 *  Good luck! 
		 *  
		 *  -Anna
		 */



		//trippTrappTreSkoGUI.run( () -> new trippTrappTreSkoGame(trippTrappBygger.loadGrid(brett)));
		new trippTrappFrame();
		//new firePaaRadFrame();


		//new trippTrappGUI().run();

	}
}
