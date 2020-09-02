package inf101.v20.lab4.grid;

import java.util.Arrays;
import java.util.List;

/**
 * GridRetninger - enum for å holde styr retningene.
 * Enum for ulike retninger på brettet
 * jeg skal sjekke (Diagonal, Vertikal, Horisontalt)
 * Jeg tok inspirasjon fra Semesteroppgave 1 GridDirection
 *
 * @author Sandra Solberg - {sit006@uib.no}
 */

public enum GridRetninger {
    CENTER(0, 0 ), LEFT(0, -1), RIGHT(0, 1),
    UP(-1, 0), DOWN(1, 0), UPLEFT(-1, -1),
    UPRIGHT(-1, 1), DOWNLEFT(1, -1), DOWNRIGHT(1, 1);


    /**
     * Diagonaler for Tripp Trapp Tresko som ArrayLister
     *
     */
    public static final List<GridRetninger> DIAGONAL1 = Arrays.asList(UPLEFT, CENTER, DOWNRIGHT);
    public static final List<GridRetninger> DIAGONAL2 = Arrays.asList(DOWNLEFT, CENTER, UPRIGHT);

    /**
     * Vertikal for Tripp Trapp TreSko som ArrayLister
     */
    public static final List<GridRetninger> three_Vertical = Arrays.asList(UP, CENTER, DOWN);
    /**
     * Horisontal for Tripp Trapp TreSko som ArrayLister
     */
    public static final List<GridRetninger> three_Horizontal = Arrays.asList(LEFT, CENTER, RIGHT);
    /**
     * Alle retningene på brettet (alle cellene) som ArrayList
     */
    public static final List<GridRetninger> three_Board = Arrays.asList(CENTER, LEFT, RIGHT, UP, DOWN,
            UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT);

    int row;
    int col;

    private GridRetninger(int row, int col) {
        this.row = row;
        this.col = col;
       // this.mask = mask;
    }

    /**
     * @return The change to your X-coordinate if you were to move one step in this
     *         direction
     */
    public int getRow() {
        return row;
    }

    /**
     * @return The change to your Y-coordinate if you were to move one step in this
     *         direction
     */
    public int getColumn() {
        return col;
    }


}
