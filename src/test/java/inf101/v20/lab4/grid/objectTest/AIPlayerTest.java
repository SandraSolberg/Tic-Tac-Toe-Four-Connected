package inf101.v20.lab4.grid.objectTest;

import inf101.v20.games.IGame;
import inf101.v20.games.Rute;
import inf101.v20.games.RuteValg;
import inf101.v20.players.AIPlayer;
import inf101.v20.players.Player;
import inf101.v20.trippTrappSpill.trippTrappTreSkoGame;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AI player tester
 */
public class AIPlayerTest {

    IGame game;

    /**
     * Tester om AIen kan legge til en rute.
     * Jeg bruker iterator over ledige ruter og legger til neste ledige
     *
     */
    @Test
    public void AIvelgerRuteTest(){
        //setter opp
        game = new trippTrappTreSkoGame();
        game.initPlayers(1);

        AIPlayer ai = new AIPlayer(3);

        game.addPlayerMark(0, 0);

        Rute r = ai.aiMove(game);

        assertTrue(r.getRow() == 1, " AI valgte rad 1");
        assertTrue(r.getCol() == 0, " AI valgte rad 0");

    }
    @Test
    public void AIvelgerRuteTest2(){
        //setter opp
        game = new trippTrappTreSkoGame();
        game.initPlayers(1);

        AIPlayer ai = new AIPlayer(3);

        game.addPlayerMark(0, 0);
        game.addPlayerMark(1, 0);
        game.addPlayerMark(1, 1);

        Rute r = ai.aiMove(game);

        assertTrue(r.getRow() == 2, " AI valgte rad 1");
        assertTrue(r.getCol() == 0, " AI valgte rad 0");

    }
    @Test
    public void emptyBrettGivesNull() {
        game.initPlayers(1);

        AIPlayer ai = new AIPlayer(3);

        for (int i = 0; i < game.numberOfColumns(); i++) {
            for (int j = 0; j < game.numberOfRows(); j++) {
                game.addPlayerMark(i, j);
            }
        }

        try{
            ai.aiMove(game);
        } catch(NullPointerException e){
            System.out.println("Brettet er fult");
        }
    }



    @Test
    public void aICanAccesAbstractClassValues(){
        AIPlayer ai = new AIPlayer(3);

        assertTrue(ai.getPlayerId() == 3, "AI ble opprettet med id 3");

    }
}
