package inf101.v20.games;

/**
 *  dette er en klasse for rutene i spillet (celle i et grid)
 */

import inf101.v20.lab4.grid.IGrid;

import java.awt.*;

/**
 * Rute , en klasse som definerer en celle i gridet.
 *
 * Et rute-objekt inneholder row og col som er (x,y) i Gridet
 * Et enum (RuteValg.java) som fyller dette med enten (Player1, Player2, OPEN)
 * disse har en verdi altså (data) etter va som blir fylt inn i ruten som også er definert i RuteValg.
 */
public class Rute implements IRute {

    /**
     * Rute representerer (row, col) i et grid
     * Den må også inneholde informasjon om data enum
     */
    private int row;
    private int col;
    private RuteValg data;



    /**
     * Konstruktør en Rute kan inneholde enten en Player eller en åpen rute
     * @param data
     */
    public Rute(RuteValg data) {
        this.data = data;

    }

    /**
     * En konstruktør for posisjonen av ruten
     * @param row
     * @param col
     * @param data
     */

    public Rute(int row, int col, RuteValg data){
        this.row = row;
        this.col = col;
        this.data = data;
    }

    @Override
    public int getValue() {
        return data.getValue();

    }

    @Override
    public Color toColor() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(this.getValue() == 0){
            return true;
        }
        return false;
    }


    @Override
    public void setEmpty() {
        int val = this.getValue();
        if(val != 0){
            new Rute(RuteValg.OPEN);
        }

    }
    /**
     *
     * @return Retunerer karakterer assosiert med enumet
     */
    public String toString(){
        if (this.getValue() == 1) {
            return "X";
        } else if (this.getValue() == 2) {
            return "O";
        } else if (this.getValue() == 0) {
            return "-";
        }
        return null;
    }

    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }

    public void paintRute(Graphics2D g2d){



    }



}
