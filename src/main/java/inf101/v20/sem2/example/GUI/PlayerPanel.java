package inf101.v20.sem2.example.GUI;

import inf101.v20.games.IGame;
import inf101.v20.players.AIPlayer;
import inf101.v20.players.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * PlayerPanel - En klasse for å holde styr på spillerenes valg
 */
public class PlayerPanel extends JPanel implements ActionListener {

    private static final String Players_Status = "Din tur Player: ";
    private static final String INIT_MESSAGE = "Ingen rute er valgt";
    private static final String UPDATE_MESSAGE = "rute er valgt ";

    private static final String INITIAL_Score = "Player Score: ";

    //ILocation choice
    private int score = 0;

    private IGame game;

    private AIPlayer aiPlayer;
    private Player player1, player2, current;

    private JLabel playerTurn, choice, status, displayMessage;

    private JPanel panel;
    private JPanel scorePanel;


    //INIT Buttons
    JCheckBox twoPlayers;
    JCheckBox ai;

    /**
     * Her vil jeg ha en mouseListner, mouseEvent
     */
    public PlayerPanel(){



        initPanel();

    }
    public void initPanel(){
        panel = new JPanel();
        add(panel);

        displayMessage = new JLabel(" Velg spillere ");
        panel.add(displayMessage);

        ai = new JCheckBox("Spill alene mot AI");

        panel.add(ai);

        twoPlayers = new JCheckBox("Multiplayer");
        panel.add(twoPlayers);

        //legger dem til itemListner for å legge til funksjon for dem.
        checkBoxHandler handle = new checkBoxHandler();
        ai.addItemListener(handle);
        twoPlayers.addItemListener(handle);


        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new GridLayout(4, 2, 5, 5));
        add(borderPanel);
        Border linje = BorderFactory.createTitledBorder("Spill display");
        borderPanel.setBorder(linje);

        borderPanel.add(displayMessage);
        borderPanel.add(twoPlayers);
        borderPanel.add(ai);





    }

    /**
     * Trenger en display for staus oppdateringer til spilleren
     *
     */
    public void gameMessages(){
        scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(4, 1, 5, 5));
        add(scorePanel);

        playerTurn = new JLabel(Players_Status + " ");
        scorePanel.add(playerTurn);

        choice = new JLabel(INIT_MESSAGE);
        scorePanel.add(choice);

        status = new JLabel(INITIAL_Score + score);
        scorePanel.add(status);

        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new GridLayout(4, 1));
        add(borderPanel);
        Border linje = BorderFactory.createTitledBorder("Spill handling");
        borderPanel.setBorder(linje);

        borderPanel.add(playerTurn);
        borderPanel.add(choice);
        borderPanel.add(status);
    }

    /**
     * Metode for å høre på hvilke knapper som blir trykket.
     */
    public void controlCheckBox(){


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class checkBoxHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {


        }
    }
}
