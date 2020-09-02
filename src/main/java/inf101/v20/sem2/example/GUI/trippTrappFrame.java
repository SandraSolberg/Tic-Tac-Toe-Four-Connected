package inf101.v20.sem2.example.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * trippTrappFrame.java klasse som bygger på JFrame (window)
 */

public class trippTrappFrame extends JFrame {

    private trippTrappGUI knapperCanvas;
    private PlayerPanel playerPanel;
    private JPanel panel;


    public trippTrappFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tripp Trapp TreSko");
        setSize(500, 500);


        knapperCanvas = new trippTrappGUI(3, 3);
        playerPanel = new PlayerPanel();

        setLayout(new BorderLayout());

        trippTrappGUI g = new trippTrappGUI(3, 3);
        g.initButtonPanel();

        JPanel option = g.initOptionButtons();
        JPanel message = g.initMessagePanel("Velkommen til Tripp Trapp Tresko");

        add(option, BorderLayout.SOUTH);
        add(g, BorderLayout.WEST);
        add(playerPanel, BorderLayout.EAST);
        add(message, BorderLayout.NORTH);


        setVisible(true);


        /*JButton reset = new JButton("Reset");
        trippCanvas.add(reset);

        JButton newGame = new JButton("New Game");
        trippCanvas.add(newGame, BorderLayout.NORTH); */



    }



}
