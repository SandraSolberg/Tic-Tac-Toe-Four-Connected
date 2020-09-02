package inf101.v20.lab4.grid.objectTest;

import inf101.v20.players.Player;
import inf101.v20.players.personPlayer;
import inf101.v20.games.RuteValg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    //player id
    int id;




    /**
     * Test om Player får tildelt riktig navn
     */
    @Test

    void testGetShortName() {
        id = 2;
        Player player2 = new personPlayer(id);
        assertEquals("Player2", player2.getPlayerName());
    }

    /**
     * Test om player får korrekt playermark fra klassen Player.java og  enum RuteValg.java
     */

    @Test

    void testgetPlayerMark(){
        id = 1;
        Player player1 = new personPlayer(id);
        assertTrue(player1.getPlayerMark().equals(RuteValg.PLAYER1));
    }



}
