package inf101.v20.players;

import inf101.v20.games.IGame;
import inf101.v20.games.Rute;
import inf101.v20.games.RuteValg;

/**
 * En klasse som definerer spillerne
 *
 */

public abstract class Player{

    //ser om den er player1 eller player2
    int playerId;

    private String name;

    //om det er player sin tur
    protected boolean playerTurn;


    //spillerens merke
    private RuteValg myMark;

    public Player(int playerId){
        this.playerId = playerId;
        myMark = getPlayerMark();
        this.name = getPlayerName();
        playerTurn = false;

    }
    //hent player id
    public int getPlayerId(){
        return this.playerId;
    }

    public String getPlayerName(){
        if(this.playerId == 2){
            return this.name = "Player 2";
        }
        if(this.playerId == 1){
            return  this.name = "Player 1";
        }
          return this.name =  "AI";
    }

    /**
     * sjekker om man spiller mot ai, returnerer true om ja
     * Lettere å skille player 2 og AI i game
     *
     * @return
     */
    public void setPlaying(){
        if(playerTurn = false){
            this.playerTurn = true;
        }
        this.playerTurn = false;
    }

    /**
     * sjekker hvilke tilstand av øvrige metoden playturn er i
     */
    public boolean isPlaying(){
        return playerTurn;
    }



    /**
     *
     * @return Rutevalg.Player1 eller RuteValg.Player2 ("X" eller "O");
     */
    public RuteValg getPlayerMark() {
        if(this.playerId == 1){
            return RuteValg.PLAYER1;
        }
        return RuteValg.PLAYER2;
    }

    /**
     * Viser hvilke spiller det er til å ta et trekk
     *
     * @return disp
     */
    public String playTurDisp(){
        String disp =  " ";

        disp += "Player: " + getPlayerName() + " din tur";

        return disp;
    }





}
