package inf101.v20.lab4.grid.trippTrappTreSkoTest;

import inf101.v20.games.Rute;
import inf101.v20.games.plastRamme;
import inf101.v20.lab4.grid.IGrid;
import inf101.v20.games.RuteValg;
import inf101.v20.players.AIPlayer;
import inf101.v20.players.Player;
import inf101.v20.players.personPlayer;
import inf101.v20.trippTrappSpill.trippTrappTreSkoGame;
import inf101.v20.games.IGame;
import inf101.v20.games.RuteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tre på rad oppfyller kravene til spillet
 * @author Sandra Solberg
 */

public class trippTrappTreskoTest {


    private IGame brett;

    /**
     * Sjekker om en spiller kan markere en rute på brettet
     */

    /**
     * Tester konstruktøren
     * Setter opp Tripp Trapp Tresko griden
     * sjekket at antallKolonner() er riktig,
     */

    @BeforeEach
    void setUp() {
        brett = new trippTrappTreSkoGame();



    }


    @Test
    void konstruktørTest() {
        plastRamme game = new trippTrappTreSkoGame();

        assertEquals(3, game.numberOfColumns());
        assertEquals(3, game.numberOfRows());

    }

    /**
     * Når spillet Begynner skal current player være player 1
     */

    @Test
    void getPlayerTest1() {
        brett.initPlayers(2);

        assertTrue(brett.getCurrentPlayer().getPlayerName() == "Player 1");

        //assertEquals(Rute.Player1, g.getCurrentPlayer());
    }

    /**
     * Denne bør testes fordi jeg ofte hadde problemer med
     * denne bruker
     */

    @Test
    void switchPlayerAI(){
        brett.initPlayers(1);

        Player p = brett.getCurrentPlayer();

        brett.switchPlayer(p);

        assertTrue(brett.getCurrentPlayer().getPlayerId() == 3, "Should be AI");


    }

    /**
     * Gridet begynner med tomme (ledige) ruter
     */

    @Test
    void startWithEmpty() {
        brett.initPlayers(2);

        for (int x = 0; x < brett.numberOfRows(); x++)
            for (int y = 0; y < brett.numberOfColumns(); y++) {
                assertTrue(brett.getRute(x, y).isEmpty());
            }

    }

    /**
     * Sjekker om brettet blir fylt
     */
    @Test
    void fultBrettTest() {
        brett.initPlayers(2);

        //markerer alle rutene
        for (int x = 0; x < brett.numberOfRows(); x++)
            for (int y = 0; y < brett.numberOfColumns(); y++) {
                brett.addPlayerMark(x, y);
            }

        //sjekker om rutene er fylt.
        for (int col = 0; col < brett.numberOfColumns(); col++) {
            for (int row = 0; row < brett.numberOfRows(); row++) {
                assertTrue(!brett.getRute(row, col).equals(RuteValg.OPEN), " ingen ruter er åpen");
            }
        }

    }

    //fyller litt av brettet og sjekker om brettet ikke er fult
    @Test
    void fultBrettTest2() {
        brett.initPlayers(2);
        //markerer alle rutene
        for (int x = 0; x < 2; x++)
            for (int y = 0; y < 2; y++) {
                brett.addPlayerMark(x, y);
            }
        assertTrue(!brett.fultBrett(), "Brettet er enda ikke fult");
    }


    /**
     * Sjekker om det er mulig å markere en tom/ledig celle
     */
    @Test
    void addPlayerMarkIRute() {
        brett.initPlayers(2);

        brett.addPlayerMark(0, 1);

        assertTrue(!brett.getRute(0, 1).isEmpty(), "Posisjonen er fylt");


    }

    /**
     * Passer på at det ikke er mulig å markere et allerede merket felt
     */
    @Test
    void canNotAddMarkToAMarkedCell() throws RuteException {
        brett.initPlayers(2);
        Player curr = brett.getCurrentPlayer();


        brett.addPlayerMark(0, 0);
        brett.switchPlayer(curr);
        brett.addPlayerMark(0, 0);
        assertEquals(false, brett.getRute(0, 0).equals(RuteValg.PLAYER1));



    }

    /**
     * Passer på at tre like diagonalt markerte på brettet fører til seier
     */
    @Test
    void threeDiagonalMarksMeansWin() {
        brett.initPlayers(2);
        brett.addPlayerMark(0, 0);
        brett.addPlayerMark(1, 1);
        brett.addPlayerMark(2, 2);

        assertTrue(brett.seierDiagonalt(), "Diagonalt");
        assertEquals(true, brett.seierDiagonalt());


    }

    /**
     * Passer på at tre like vertikalt markerte på brettet fører til seier
     */
    @Test
    void threeVerticalMarksMeansWin() {
        brett.initPlayers(2);
        brett.addPlayerMark(0, 1);
        brett.addPlayerMark(1, 1);
        brett.addPlayerMark(2, 1);

        assertTrue(brett.seierVertikalt(), " Vertikal seier");

    }

    @Test
    void threeVerticalMarksDoesNotWin() {
        brett.initPlayers(2);
        brett.addPlayerMark(0, 0);
        brett.addPlayerMark(2, 1);
        brett.addPlayerMark(2, 2);

        assertEquals(false, brett.seierVertikalt());

    }

    /**
     * Passer på at tre like horisontalt markerte på brettet fører til seier
     */
    @Test
    void threeHortizontalMarksDoesWin() {
        brett.initPlayers(2);
        brett.addPlayerMark(0, 0);
        brett.addPlayerMark(0, 1);
        brett.addPlayerMark(0, 2);

        assertEquals(true, brett.seierHorisontalt());

    }

    @Test
    void threeHorizontalMarksDoesNotWin() {
        brett.initPlayers(2);
        brett.addPlayerMark(0, 0);
        brett.addPlayerMark(0, 1);
        brett.addPlayerMark(1, 2);

        assertEquals(false, brett.seierHorisontalt());

    }

    /**
     * Passer på dersom brettet er fult at det blir uavgjort mellom spillerene
     */
    @Test
    void fullGridEndswithATie() {
        brett.initPlayers(2);
        //sett up
        for (int row = 0; row < brett.numberOfRows(); row++) {
            for (int col = 0; col < brett.numberOfColumns(); col++) {
                brett.addPlayerMark(row, col);
            }
        }
        assertEquals(true, brett.fultBrett());

    }

    @Test
    void AIwinningAgainstPlayerTest() {

        brett.initPlayers(1);
        //sett up

        AIPlayer ai = new AIPlayer(3);
        Player curr = brett.getCurrentPlayer();

        brett.addPlayerMark(1, 1);
        ai.aiMove(brett);
        brett.addPlayerMark(1, 2);
        ai.aiMove(brett);
        brett.addPlayerMark(2, 2);
        ai.aiMove(brett);

        assertTrue(!curr.isPlaying(), "Player cant be playing after game");


    }


    /**
     * Sjekker om dersom to spillere spiller mot hverandre om
     * dersom de vinner spillet avsluttes
     */
    @Test
    void winnigEndGame() {




    }


    @Test
    void switchingPlayersWorkTest() {
        brett.addPlayerMark(1, 1);
        brett.switchPlayer(brett.getCurrentPlayer());
        brett.addPlayerMark(2, 2);

        assertTrue(brett.getRute(2, 2).getValue() == 2, "Player 2 plasserte sitt merke på brettet");

    }

    @Test
    /**
     * Sjekker om empty rute listen blir mindre ettersom ruter blir fylt
     */
    void emptyRuterSizeGetsSmaller() {
        for (int row = 0; row < brett.numberOfRows()-1; row++) {
            for (int col = 0; col < brett.numberOfColumns()-1; col++) {
                brett.addPlayerMark(row, col);
            }
        }
        assertTrue(brett.emptyRuter().size() == 5, " Det er 5 ledige ruter igjen");

    }
}
