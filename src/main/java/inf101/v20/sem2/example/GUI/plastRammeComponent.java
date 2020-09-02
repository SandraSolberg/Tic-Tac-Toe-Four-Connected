package inf101.v20.sem2.example.GUI;

import inf101.v20.games.IGame;
import inf101.v20.games.plastRamme;

import java.awt.*;

/**
 * Et Component som tegner IRuteComponenter.
 *
 * @author Sandra Solberg
 */

public class plastRammeComponent extends Component {

    /**
     * Holder dimension av gridet med rutene.
     */
    private Dimension gridDim;

    /**
     * The automaton to paint the cells of.
     */
    private plastRamme brett;

    /**
     * The height of each cell in pixels.
     */
    private int gridRow;
    /**
     * The width of each cell in pixels.
     */
    private int gridCol;
    /**
     * The size of the space between each cell and between the cell and the edge
     * of the window.
     */
    private final int padding = 2;


    public plastRammeComponent(int gridRow, int gridCol){
        this.gridRow = gridRow;
        this.gridCol = gridCol;

    }
    public Dimension getGridDim(){
        return gridDim;
    }
    public int getGridRow(){
        return this.gridRow;
    }
    public int getGridCol(){
        return this.gridCol;
    }


    /**
     * paint komponentene
     * @param g
     */
    public void paint(Graphics g){
        for (int col = 0; col < brett.numberOfColumns(); col++) {
            for (int row = 0; row < brett.numberOfRows(); row++) {
                g.setColor(brett.getRute(col, row).toColor());
                g.fillRect(col * (gridRow + padding) + padding, row
                                * (gridRow + padding) + padding, gridRow,
                        gridCol);
            }

        }



    }
}
