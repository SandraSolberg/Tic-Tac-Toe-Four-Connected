package inf101.v20.players;

import inf101.v20.games.IGame;
import inf101.v20.games.Rute;
import inf101.v20.games.RuteValg;

import java.util.Scanner;

public class personPlayer extends Player {

    /**
     *
     * @param playerId
     *
     */


    public personPlayer(int playerId) {
        super(playerId);
    }

    /**
     *
     * @param game, statusen for hva som skjer for spilleren
     * //Todo
     */

    public void showStatus(IGame game, String hendelse) {

        switch (hendelse){
            case "seier":
                System.out.println("Player: " +  this.getPlayerName() +  " Won");
            case "lose":
                System.out.println("GAME OVER!");
            case "tie":
                System.out.println("Brettet er ferdig");
        }




    }


    /**
     * Alle person players kan velge et trekk basert på terminal input
     * Spillerene velger et trekk.
     * Ved defualt skal den kalle på seg selv recrusivt om en ulovlig posisjon er valgt.
     * @param game
     * @return
     */
    public void makeMove(IGame game) {

        Scanner inn = new Scanner(System.in);

        System.out.println("Velg rad:");
        int r = inn.nextInt();
        System.out.println("Velg kolonne:");
        int c = inn.nextInt();


        if (game.validValg(r, c) && game.getRute(r, c).getValue() == 0) {
            game.addPlayerMark(r, c);

            System.out.println("Player: " + getPlayerName() + " valgte rute: " + r + "," + c);
        } else {
            System.out.println("Stopp der, denne ruten er enten opptatt eller utenfor gridet \n Prøv igjen");
            makeMove(game);
        }
    }

        public void makeMoveFireRad(IGame game){

            Scanner inn = new Scanner(System.in);

            System.out.println("Velg kolonne:");
            int c = inn.nextInt();


            if (game.validValg(0, c) && game.getRute(0, c).getValue() == 0) {
                game.addPlayerMark(0, c);


                System.out.println("Player: " + getPlayerName() + " valgte kolonne: " + c);
            } else {
                System.out.println("Stopp der, denne ruten er enten opptatt eller utenfor gridet \n Prøv igjen");
                makeMove(game);
            }
        }



}
