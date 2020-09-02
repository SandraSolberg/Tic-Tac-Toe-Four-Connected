package inf101.v20.firePaaRad;

import inf101.v20.games.*;
import inf101.v20.lab4.grid.GridRetninger;
import inf101.v20.lab4.grid.IGrid;
import inf101.v20.players.AIPlayer;
import inf101.v20.players.Player;
import inf101.v20.players.personPlayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class firePaaRad implements IGame {


    /**
     * max rows og max cols
     */
    private final int rows = 6;
    private final int cols = 7;

    /**
     * Players
     * burde bli laget in en abstract player class
     */
    private Player currentPlayer;
    private personPlayer player1, player2;
    private AIPlayer AI;

    Rute grid[][];

    //sjekker 4 på rad
    int checkWin[];


    public firePaaRad(){
        grid = new Rute[6][7];

        initializeRuter();


        checkWin = new int[4];
    }

    /**
     * Denne kommer ikke til å bli direkte brukt av user
     * @param row
     * @param col
     * @throws RuteException
     */

    @Override
    public void addPlayerMark(int row,int col) throws RuteException {

        /*her skiller fire på rad seg fra tripp trapp tresko. Vi vil bare få disse brikkene til å lande  bunnen
         altså player må velge kolonne den skal droppe brikken sin i

         begynner brikke plassering på nederste rad

          */

        RuteValg mark = currentPlayer.getPlayerMark();

        for(int r = rows-1; r >= 0; r--){
            if(getRute(r, col).getValue() == 0){
                grid[r][col] = new Rute(mark);
                break;
            }
        }

    }

    public void addPlayerBrikke(int col) throws RuteException{


         /*her skiller fire på rad seg fra tripp trapp tresko. Vi vil bare få disse brikkene til å lande  bunnen
         altså player må velge kolonne den skal droppe brikken sin i

         begynner brikke plassering på nederste rad

          */

        RuteValg mark = currentPlayer.getPlayerMark();

        for(int r = rows-1; r >= 0; r--){
            if(getRute(r, col).getValue() == 0){
                grid[r][col] = new Rute(mark);
                break;
            }
        }

    }

    @Override
    public boolean validValg(int row, int column) {
        return column >= 0 && column < cols //
                && row >= 0 && row < rows;

    }
    @Override
    public int numberOfRows() {
        return rows;
    }

    @Override
    public int numberOfColumns() {
        return cols;
    }
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public Player getPlayerOther(Player currentPlayer) {
            if(currentPlayer.getPlayerMark().equals(RuteValg.PLAYER2)){
                return player1;
            }
            if(player1.isPlaying()){
                return AI;
            }

            return player2;

    }

    @Override
    public void switchPlayer(Player currentPlayer) {
        this.currentPlayer = getPlayerOther(currentPlayer);

    }

    @Override
    public void playTwoPlayers() {
        System.out.println("Velkommen til fire på rad");

        printBoard();
        while(!sjekkSeier() && !fultBrett()){


            System.out.println(getCurrentPlayer().playTurDisp());

            player1.makeMoveFireRad(this);
            printBoard();
            System.out.println(player2.playTurDisp());

            if(!sjekkSeier() && !fultBrett()){
                switchPlayer(player1);
                player2.makeMoveFireRad(this);
                switchPlayer(player2);
            }
            printBoard();


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

        System.out.println("Velkommen til fire på rad");


        while(!sjekkSeier() && !fultBrett()){

                 printBoard();
                System.out.println(player1.playTurDisp());

                player1.makeMoveFireRad(this);


                System.out.println(AI.playTurDisp());

                this.currentPlayer = AI;

                Rute m = AI.aiMove(this);

                addPlayerMark(0, m.getCol());

                switchPlayer(AI);


        }
        printBoard();

    }

    @Override
    public boolean fultBrett() {

        if(emptyRuter().size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean seierDiagonalt() {
        for(int row = 0; row < numberOfRows()-3; row++){
            for(int col = 0; col < numberOfColumns()-3; col++){

                if(getRute(row, col).getValue() > 0){



                    for(int dx = 0; dx <= 3; dx++) {
                        int next = getRute(row+dx, col+dx).getValue();
                        checkWin[dx] = next;

                        //0, 0 //1.1 //2.2 //3.3

                    }
                    if(checkWin[0] == checkWin[1] && checkWin[1] == checkWin[2] && checkWin[0] == checkWin[3]){
                        System.out.println("seier diagonalt");
                        return true;
                    }
                }

            }
        }
        return false;
    }

    @Override
    public boolean seierDiagonal2() {
        for(int row = 0; row < numberOfRows()-3; row++){
            for(int col = 3; col < numberOfColumns(); col++){

                if(getRute(row, col).getValue() > 0){


                            //r.c , r+1.c-1, r+2.c-2
                            if(!validValg(row, col)) continue;


                                int next = getRute(row, col).getValue();
                                int second = getRute(row+1, col-1).getValue();
                                int third = getRute(row+2, col-2).getValue();
                                int last = getRute(row+3, col-3).getValue();

                                if(next == second && second == third && third == last){
                                    System.out.println("seier diagonalt 2");
                                    return true;
                                }
                            }

                        }


            }
        return false;
    }

    @Override
    public boolean seierVertikalt() {
        for(int col = 0; col <numberOfColumns(); col++){
            for(int row = 0; row < numberOfRows()-3; row++){

                if(getRute(row, col).getValue() > 0){


                    for(int dy = 0; dy <= 3; dy++) {
                        int next = getRute(row+dy, col).getValue();
                        checkWin[dy] = next;

                    }
                    if(checkWin[0] == checkWin[1] && checkWin[1] == checkWin[2] && checkWin[0] == checkWin[3]){
                        System.out.println("seier vertikalt");
                        return true;
                    }
                }

            }
        }
        return false;
    }

    @Override
    public boolean seierHorisontalt() {
        int checkWin[] = new int[4];

        for(int row = 0; row < numberOfRows(); row++){
            for(int col = 0; col < numberOfColumns()-3; col++){


                if(getRute(row, col).getValue() > 0){

                    for(int dx = 0; dx <= 3; dx++) {
                        int next = getRute(row, col + dx).getValue();
                        checkWin[dx] = next;

                       }
                        if(checkWin[0] == checkWin[1] && checkWin[1] == checkWin[2] && checkWin[0] == checkWin[3]){
                            System.out.println("seier horisontalt");
                        return true;
                    }
                }
            }
        }
        return false;
    }



    @Override
    public void initPlayers(int playersInGame) {
        player1 = new personPlayer(1);
        this.currentPlayer = player1;


        if (playersInGame == 2) {
            player2 = new personPlayer(2);
        }
        player1.setPlaying();
        AI = new AIPlayer(3);

    }

    @Override
    public IRute getRute(int row, int column) {
        if(!validValg(row, column))
            throw new RuteException("Rute row, column finnes ikke");

        return grid[row][column];
    }

    @Override
    public void initializeRuter() {
        for(int row = 0; row < rows; row++) {
           for(int col = 0; col < cols; col++){
               grid[row][col] = new Rute(row, col, RuteValg.OPEN);
           }
        }

    }

    public void printBoard(){
        System.out.println("___________________________");
        for(int row = 0; row < rows; row++){
            System.out.print("|");
            for(int col = 0; col < cols; col++){
                System.out.print(" " + grid[row][col] + "|");
            }
            System.out.println();

        }
        System.out.println("___________________________");

    }

    @Override
    public void reset() {
        initializeRuter();

    }
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
    public List<Rute> emptyRuter() {
            List<Rute> emptySpots = new ArrayList<>();

            for (int col = 0; col < numberOfColumns(); col++) {
                for (int row = 0; row < numberOfRows(); row++) {
                    if(getRute(row, col).getValue() == 0){
                        emptySpots.add(new Rute(row, col, RuteValg.OPEN));
                    }

                }
            }
            return emptySpots;
    }

    @Override
    public IGrid<Rute> brettCopy() {
        return null;
    }
}
