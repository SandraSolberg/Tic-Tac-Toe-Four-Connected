package inf101.v20.games;

import inf101.v20.players.AIPlayer;
import inf101.v20.players.Player;
import inf101.v20.players.personPlayer;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * En abstraskjon av spill funksjoner som er viktig å ha med
 *
 * Behandling av players er likt for begge. Kom ikke langt nok til å utvikle denne videre
 */
public abstract class abstractGame implements plastRamme {

    protected Player currentPlayer;
    protected  personPlayer player1, player2;
    protected AIPlayer AI;


    /**
     * bestemme hvilke spillere som er med
     * @param playersInGame
     */
    public void initPlayers(int playersInGame) {
        player1 = new personPlayer(1);
        this.currentPlayer = player1;

        if (playersInGame == 2) {

            player2 = new personPlayer(2);
        }
        player1.setPlaying();
        AI = new AIPlayer(3);

    }

    public void switchPlayer(Player currentPlayer) {
        this.currentPlayer = getPlayerOther(currentPlayer);

    }
    public Player getPlayerOther(Player currentPlayer){
        if(currentPlayer.equals(RuteValg.PLAYER2)){
            return player1;
        }
        if(player1.isPlaying()){
            return AI;
        }

        return player2;

    }
    public void setUPGame() {
        Scanner inn = new Scanner(System.in);
        System.out.println("Dersom du vil spille alene mot AI trykk 1 \n Dersom du vil spille two-players trykk 2?: ");
        int choice;


        try {
            choice = inn.nextInt();

            while (choice <= 0 || choice > 2) {
                System.out.println("Error. Du må velge 1 eller 2 players");
                choice = inn.nextInt();
            }
        } catch (InputMismatchException ex) {

            System.out.println("Ugyldig ! du må velge 1 eller 2");
            choice = inn.nextInt();
        }
    }
        public abstract boolean seierVertikalt();


        public abstract boolean seierDiagonalt();

        public abstract boolean seierDiagonal2();

        public abstract boolean seierHorisontalt();

        //på printen må jeg bruke getPlayerOther(currentP) fordi player switchet før while slutter i playTwoPlayer()
        public boolean sjekkSeier() {
            boolean win = false;
            if ((seierVertikalt()) || (seierHorisontalt())  || (seierDiagonalt()) || (seierDiagonal2())) {

                win = true;
            }
            return win;
        }



    }
