package inf101.v20.games;

import inf101.v20.players.Player;

/**
 * "kontrakt" for hva spillene burde inneholde
 *
 * @author Sandra Solberg {email: sit006@uib.no}
 */
public interface IGame extends plastRamme  {

    /**
     * Player ska få kunne legge sitt merke i denne ruten om den oppfyller
     * kravene IGame#validValg() og om ruten er åpen.
     * @param col
     * @param row
     * @throws RuteException om man ikke kan legge PlayerMark altså sin brikke her
     */
    void addPlayerMark(int row, int col) throws RuteException;

    /**
     *
     * @param column
     * @param row
     * @return true om det er lov å la passere player mark her
     */
    boolean validValg(int row, int column);

    /**
     * Om det er player 1 sin tur retuner player 1
      * @return den playeren som spiller nå
     */


    Player getCurrentPlayer();
    /**
     * @return gir tilbake  nåværende spillerens merke
     */
    Player getPlayerOther(Player currentPlayer);

    /**
     * Bestemmer hvem sin tur det er
     * @return
     */
    void switchPlayer(Player currentPlayer);


    /**
     * Spill runde hvor spillerene gjør et move.
     * også bytter de på .
     *
     */
    void playTwoPlayers();

    /**
     * Spill runde mot en AI
     */
    void playAgainstAI();

    /**
     * Sjekker om brettet er fult eller ikke
     * @return true om brettet er fult ellers false
     */
    boolean fultBrett();

    /**
     *
     * @return true ved seier diagonal (0.0 , 1.1, 2.0)
     */
    boolean seierDiagonalt();

    /**
     *
     * @return true ved seier diagonal (0.2 , 1.1, 2.0)
     */
    boolean seierDiagonal2();

    /**
     *
     * @return true ved vertikal seier
     */
    boolean seierVertikalt();

    /**
     *
     * @return true ved horisontal seier
     */
    boolean seierHorisontalt();



    /**
     *
     * Man velger om man spille two players eller multiplayers 1 = singel (mot AI) og 2 = multiplayer
     * Velg hvilke players som skal være med player1 = id(1), player2 = id(2)
     * også player AI = (3)
     * @param playersInGame
     */

    void initPlayers(int playersInGame);

    /**
     * Printer en terminal ut hva som er i terminalen
     */
    void printBoard();




}
