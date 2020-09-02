package inf101.v20.games;

/**
 * Rute valgene som kan komme på knappene
 *
 * @author Sandra Solberg
 */

public enum RuteValg {
    OPEN(0), PLAYER1(1), PLAYER2(2);
    private int value;

    private RuteValg(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }



}
