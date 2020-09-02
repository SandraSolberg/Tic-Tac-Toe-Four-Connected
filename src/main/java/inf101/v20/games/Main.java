package inf101.v20.games;

import inf101.v20.firePaaRad.firePaaRad;
import inf101.v20.games.RuteValg;
import inf101.v20.trippTrappSpill.trippTrappTreSkoGame;

import java.util.List;
import java.util.Scanner;

/**
 * Main for å teste funksjonalitet før jeg bruker GUImain
 */
public class Main {
    public static void main(String[] args) {


        Scanner inn = new Scanner(System.in);

        System.out.println("Velkommen!, hvilket spill vil du spille? \n for fire på rad skriv: 1 \n og for tripp trapp tresko skriv: 2");

        System.out.println("Ditt valg: ");
        int valg = inn.nextInt();

        while(valg < 1 && valg > 2){
            System.out.println("Du må velge 1 eller 2");
            valg = inn.nextInt();
        }


        if(valg == 1){
            firePaaRad g = new firePaaRad();
            g.setUPGame();

        } else{
            trippTrappTreSkoGame game = new trippTrappTreSkoGame();
        game.setUPGame();
        }










    }
}
