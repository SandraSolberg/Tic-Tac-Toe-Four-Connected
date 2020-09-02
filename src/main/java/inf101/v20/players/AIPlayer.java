package inf101.v20.players;

import inf101.v20.games.*;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.lab4.grid.GridRetninger;
import inf101.v20.lab4.grid.IGrid;
import inf101.v20.trippTrappSpill.trippTrappTreSkoGame;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * AIPlayer - En klasse som implementerer en spiller drevet av denne koden
 */
public class AIPlayer extends Player {


    //level til AI (level 1 er random, level 2 er advanced)
    private int level;


    //for the game
    IGrid<Rute> grid;

    //refererer til spill objektet.
    IGame game;




    public AIPlayer(int playerId) {
        super(playerId);

    }

    /**
     * AI må velge en plassering
     * Denne må retunere en (row, col);
     */
    public Rute aiMove(IGame game){


        //AI sin tur

        //er posisjonen ledig?

        //copi av spillets brett
        this.game = game;
        //grid = game.brettCopy();

        Iterator cells = game.emptyRuter().iterator();

       if(game.emptyRuter().isEmpty()){
           return null;
       }
       //når AIen starter velger den neste ledige evt nå det er mindre enn 2 posisjoner igjen
       if((game.emptyRuter().size() <= 2)){

           if(cells.hasNext()){
               Rute chosen = (Rute) cells.next();
               return chosen;
           }
       } else{
           int size = game.emptyRuter().size();
           Random rand = new Random();
           Rute element1 = game.emptyRuter().get(rand.nextInt(size));

           return element1;
           }



       return null;
    }



    //miniMax

    //holde oversikt på brettet (Gridet)

    //holde oversikt på player 1 valg

    //velge beste løsningen for seg selv


}
