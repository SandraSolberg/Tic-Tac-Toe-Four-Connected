package inf101.v20.trippTrappSpill;

import inf101.v20.games.*;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.lab4.grid.GridRetninger;
import inf101.v20.lab4.grid.IGrid;
import inf101.v20.players.AIPlayer;
import inf101.v20.players.Player;
import inf101.v20.players.personPlayer;

import java.util.*;

/**
 *  Et trippTrappTreSko.java - implementation for Tripp Trapp TreSko spill
 * trippTrappTreSko.java - en klasse for spillet Tripp Trapp Tresko og brettet dens
 * @author Sandra Solberg
 */
public class trippTrappTreSkoGame implements IGame {

    /**
     * Max antall rader og kolonner i tripp trapp treSko 3X3 format
     */
    public static final int rows = 3;
    public static final int columns = 3;


    /**
     * Grid av rute-elementer
     */
    IGrid<Rute> grid;


    /**
     * Players i spillet
     */
    private personPlayer player1, player2;
    private AIPlayer AI;
    private Player currentP;




    /**
     * Konstruerer tripp trapp spill med åpne ruter lagret i et Grid.
     * setter størrelsen til max for rows og columns og rutene ti open ('Empty')
     */
    public trippTrappTreSkoGame() {
        this.grid = new Grid(rows, columns, RuteValg.OPEN);

        //setter opp tomt brett
        initializeRuter();

        //player1 begynner alltid


    }

    @Override
    public IRute getRute(int row, int columns) {
        if (!validValg(row, columns))
            throw new RuteException("Rute row, column finnes ikke");


        return grid.get(row, columns);
    }


    @Override
    public void initializeRuter() {
        for (int col = 0; col < grid.getWidth(); col++) {
            for (int row = 0; row < grid.getHeight(); row++) {
                grid.set(col, row, new Rute(RuteValg.OPEN));

            }
        }

    }

    /**
     * Reseter brettet
     */
    public void reset() {
        initializeRuter();

    }

    @Override
    public void addPlayerMark(int row, int column) {
        RuteValg mark = currentP.getPlayerMark();

        if (getRute(row, column).getValue() != 0) {

            System.out.println("This position is taken");
            return;

        }
        grid.set(row, column, new Rute(mark));

    }

    @Override
    public boolean validValg(int row, int column) {
        return column >= 0 && column < grid.getWidth() //
                && row >= 0 && row < grid.getHeight();

    }

    @Override
    public void initPlayers(int playersInGame) {

        player1 = new personPlayer(1);
        this.currentP = player1;


        if (playersInGame == 2) {
            player2 = new personPlayer(2);
        }
        player1.setPlaying();
        AI = new AIPlayer(3);
    }

    @Override
    public void printBoard() {
        System.out.println(" ____________");

        for (int row = 0; row < grid.getHeight(); row++) {
            System.out.print(" | ");
            for (int col = 0; col < grid.getWidth(); col++) {
                System.out.print(grid.get(row, col) + " | ");


            }
            System.out.println("\n");
            System.out.println(" ____________");
        }

    }

    //kan bli slettet
    @Override
    public Player getCurrentPlayer() {
        return this.currentP;

    }

    /**
     *
     * @param current den nåverende playeren
     * @return det andre player Objectet som er med i spillet, om det er player1, player 2 eller AI
     */
    @Override
    public Player getPlayerOther(Player current) {
        if (current.getPlayerMark().equals(RuteValg.PLAYER2)) {
            return player1;
        }
        if(player1.isPlaying()){
            return AI;
        }
        return player2;
    }

    @Override
    public int numberOfRows() {
        return this.grid.getHeight();
    }

    @Override
    public int numberOfColumns() {
        return this.grid.getWidth();
    }

    @Override
    public List<Rute> emptyRuter() {
        List<Rute> emptySpots = new ArrayList<>();

        for (int col = 0; col < numberOfColumns(); col++) {
            for (int row = 0; row < numberOfRows(); row++) {
                if(grid.get(row, col).getValue() == 0){
                    emptySpots.add(new Rute(row, col, RuteValg.OPEN));
                }

            }
        }
        return emptySpots;
    }



    @Override

    public void switchPlayer(Player currentPlayer) {
        this.currentP = getPlayerOther(currentPlayer);
    }


    /**
     * Går gjennom brettet, om jeg finner en ledig rute så er ikke brettet fult
     */
    @Override
    public boolean fultBrett() {
        boolean full = false;

        if(emptyRuter().size() == 0){
            full = true;
        }


        return full;
    }



    /**
     * @param list
     * @return true/false om alle elementene i listen er like
     */

    public boolean playerCheckWin(List<Integer> list) {

        int v = list.get(0);
        if(list.get(1).equals(v) && list.get(2).equals(list.get(1))){
            System.out.println( this.currentP + " Won");
            System.out.println("in " + v + list.get(1) + list.get(2));
            printBoard();
            return true;
        }
        return false;
    }

    @Override
    public boolean seierDiagonalt() {
        List<GridRetninger> diagonal1 = GridRetninger.DIAGONAL1;

        //senteret i tre på rad er 1,1
        int row = 1;
        int col = 1;

        List<Integer> dig1 = new ArrayList<>();
        for(GridRetninger dir: diagonal1){
            int val = grid.get(row+dir.getRow(), col+dir.getColumn()).getValue();

           //om diagonalen (0.0, 1.1, 2.2) har tomme verdier sjekk den andre
            if(val == 0)continue;

            else if(val > 0) dig1.add(val);

        }
        if(dig1.size() >= 3 && playerCheckWin(dig1)){
          return true;
        }
        return false;
    }

    public boolean seierDiagonal2() {
        List<GridRetninger> diagonal2 = GridRetninger.DIAGONAL2;

        int row = 1;
        int col = 1;

        List<Integer> dig2 = new ArrayList<>();
        for (GridRetninger dir2 : diagonal2) {
            int val2 = grid.get(row + dir2.getRow(), col + dir2.getColumn()).getValue();
            if (val2 == 0) continue;

            else if (val2 > 0) dig2.add(val2);

            if (dig2.size() >= 3 && playerCheckWin(dig2)) {
                    return true;
                }

        } return false;
    }

    @Override
    public boolean seierVertikalt() {
        List<GridRetninger> vertical = GridRetninger.three_Vertical;


        //row 1
        for(int col = 0; col< numberOfColumns(); col++){

            List<Integer> values = new ArrayList<>();
            for(GridRetninger dir: vertical){
                int val = grid.get(1+dir.getRow(), col).getValue();

                if(val == 0) continue;

                else if(grid.get(1+dir.getRow(), col).getValue() > 0){
                    values.add(val);
                }
            }
            if(values.size() >= 3 && playerCheckWin(values)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean seierHorisontalt() {
        List<GridRetninger> horisontalt = GridRetninger.three_Horizontal;

        //col 1 er sentrum (center, så er left og right justert etter row)
        for(int row = 0; row < numberOfRows(); row++){

            List<Integer> h = new ArrayList<>();
            for(GridRetninger dir: horisontalt){
                int val = grid.get(row, 1+dir.getColumn()).getValue();

                if(val == 0)continue;

                else if(val > 0){
                    h.add(val);
                }

                }
                if(h.size() >= 3 && playerCheckWin(h)){
                        return true;
                    }
            }

        return false;
    }


    //på printen må jeg bruke getPlayerOther(currentP) fordi player switchet før while slutter i playTwoPlayer()
    public boolean sjekkSeier() {
        boolean win = false;
        if ((seierVertikalt()) || (seierHorisontalt())  || (seierDiagonalt()) || (seierDiagonal2())) {

            win = true;
        }
        return win;
    }

    public void setUPGame(){
        Scanner inn = new Scanner(System.in);
        System.out.println("Dersom du vil spille alene mot AI trykk 1 \n Dersom du vil spille two-players trykk 2?: ");
        int choice;


        try {
            choice = inn.nextInt();

            while (choice<=0 || choice>2) {
                System.out.println("Error. Du må velge 1 eller 2 players");
                choice = inn.nextInt();
            } }

        catch (InputMismatchException ex) {

            System.out.println("Ugyldig ! du må velge 1 eller 2");
            choice = inn.nextInt();
        }

        initPlayers(choice);

        if(choice == 2){
            System.out.println("Spillerene er: " + player1.getPlayerName() + " og " + getPlayerOther(player1).getPlayerName());
            playTwoPlayers();
        } else{
            System.out.println("Spillerene er: " + player1.getPlayerName() + " og " + AI.getPlayerName());
            playAgainstAI();
        }

    }
    @Override
    public IGrid<Rute> brettCopy() {
        return grid.copy();
    }

    @Override
    public void playTwoPlayers() {

        System.out.println("Hei velkommen til Tre på rad");




        while(!fultBrett() && !sjekkSeier()){

            printBoard();


            System.out.println(getCurrentPlayer().playTurDisp());

            player1.makeMove(this);
            printBoard();
            System.out.println(player2.playTurDisp());
            switchPlayer(player1);
            player2.makeMove(this);
            switchPlayer(player2);

        }
        if(sjekkSeier()){
            if(getCurrentPlayer().getPlayerId() == 1){
                player1.showStatus(this, "seier");

                if(getCurrentPlayer().getPlayerId() == 2){
                player2.showStatus(this, "seier");
                }

            }
        }
        else if(fultBrett()){
            player1.showStatus(this, "tie");
        }
        player1.showStatus(this, "lose");

    }

    @Override
    public void playAgainstAI() {

        while (emptyRuter().size()>0 && !sjekkSeier()) {

            printBoard();

            System.out.println(currentP.playTurDisp());


           player1.makeMove(this);


            System.out.println(AI.playTurDisp());

            Rute rute  = AI.aiMove(this);
            this.currentP = AI;


            if(emptyRuter().size() > 0 && !sjekkSeier()) {
                addPlayerMark(rute.getRow(), rute.getCol());

                System.out.println("Player: " + AI.getPlayerName() + " valgte rute " + rute.getRow() + "," + rute.getCol());
            }

            switchPlayer(AI);

        }
        if(sjekkSeier()){
            if (getCurrentPlayer().getPlayerId() == 1) {
                player1.showStatus(this, "seier");
            }
            player1.showStatus(this, "lose");
        }
        else if(emptyRuter().size() == 0){
            player1.showStatus(this, "tie");
        }


    }


}
