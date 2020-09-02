package inf101.v20.lab4.grid.firePaaRadTest;

import inf101.v20.firePaaRad.firePaaRad;
import inf101.v20.games.IGame;
import inf101.v20.games.Rute;
import inf101.v20.players.Player;
import inf101.v20.players.personPlayer;
import inf101.v20.trippTrappSpill.trippTrappTreSkoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class firePaaRadTest {

    //spill instans
    IGame game;

    //gridet med rute objekter
    Rute[][] grid;

    personPlayer player1, player2;
    Player curr;


   @BeforeEach
    void setUp() {
        game = new firePaaRad();
        grid = new Rute[6][7];

        game.initializeRuter();


    }

    //sjekker horisontalt for brettet
    @Test
    public void horisontalBrettTest(){
       game.initPlayers(1);

       for(int col = 1; col <= 5; col++){
           game.addPlayerMark(0, col);
       }
       assertTrue(game.seierHorisontalt(), "horisontal seier");
    }
    @Test
    public void vertikalBrettTest(){
        game.initPlayers(1);

        for(int i = 0; i <= 4; i++){
            game.addPlayerMark(0, 2);
        }

        assertTrue(game.seierVertikalt(), "horisontal seier");

    }
    @Test
    public void diagonal1BrettTest(){
       player1 = new personPlayer(1);
       player2 = new personPlayer(2);

       this.curr = player1;

        for(int i=3; i>= 0; i--) {
            game.addPlayerMark(0, i); //4, 2, 3, 1
            game.switchPlayer(player1);
            game.addPlayerMark(0, i+1); //2, 1, 1, 0, 0, 0,
            game.switchPlayer(player2);

        }
        assertTrue(game.seierDiagonalt(), "seier diagonalt");
       }

       //0,1 .. 1.2..

    @Test
    public void diagonal2BrettTest(){
        game.initPlayers(2);

        Player curr = game.getCurrentPlayer();

        //sjekker fra kolonne 0 til 3

        game.addPlayerMark(0, 0);

        game.switchPlayer(curr);

        //kolonne 1 legger til en "O"
        game.addPlayerMark(0, 1);

        //kolonne 2 legger til to  "O"
        for(int i = 0; i< 3; i++){
            game.addPlayerMark(0, 2);
        }
        //kolonne 3 legger til 3 av "O"
        for(int i = 0; i < 4; i++){
            game.addPlayerMark(0, 3);
        }
        game.switchPlayer(curr);
        for(int i = 0; i < 3; i++){
            game.addPlayerMark(0, i);
        }
        assertTrue(game.seierDiagonal2(), "X vant");





    }



}
