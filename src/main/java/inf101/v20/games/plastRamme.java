package inf101.v20.games;

import inf101.v20.lab4.grid.GridRetninger;
import inf101.v20.lab4.grid.IGrid;
import inf101.v20.players.Player;

import java.util.Collection;
import java.util.List;

/**
 * Lager plastrammen for et fire på rad spill/tre på rad.
 * Her må alle rutenes nåværende tilstand representeres
 * via {@Link Rute.java}
 *
 * @author Sandra Solberg
 */

public interface plastRamme {

    /**
     *
     * Får rutens row and column
     *
     * @param row  raden av ruten, 0-indexed
     * @param column colunm av, 0-indexed
     * @return The state of the cell in the given row and column.
     * @throws RuteException med gitt beskjed til spilleren
     */
    IRute getRute(int row, int column) throws RuteException;

    /**
     * Setter opp start innholdet i rutene
     */
    void initializeRuter();


    /**
     * Ved å kalle på denne metoden skal spillet resetes
     * Rutene settes til initial state. (Done)
     * Players må velges velges på nytt.
     */
    void reset();



    /**
     * @return The number of rows in this automaton
     */
    int numberOfRows();

    /**
     * @return The number of columns in this automaton
     */
    int numberOfColumns();

    /**
     * Iterate over alle rutene på brettet
     * @return Liste over Rute med RuteValg empty
     */
    List<Rute> emptyRuter();

    /**
     *
     * @return copy av brettet
     */
    IGrid<Rute> brettCopy();
}
