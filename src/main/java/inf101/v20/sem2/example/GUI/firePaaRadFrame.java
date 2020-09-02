package inf101.v20.sem2.example.GUI;

import javax.swing.*;


public class firePaaRadFrame extends JFrame {


    private trippTrappGUI knapperCanvas;
    private PlayerPanel playerPanel;
    private JPanel panel;

    /**
     *
     */
    private final int maxRow = 6;
    private final int maxCol = 7;

    public firePaaRadFrame(){
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setTitle("Fire på rad");
       setSize(1000, 1000);

       /*
       trippCanvas = new testCanvas();
       knapperCanvas = new trippTrappGUI(maxRow, maxCol);
       playerPanel = new PlayerPanel();

       setLayout(new BorderLayout());

       trippTrappGUI g = new trippTrappGUI(maxRow, maxCol);
       g.initButtonPanel();

       JPanel option = g.initOptionButtons();
       JPanel message = g.initMessagePanel("Velkommen til Fire På Rad");

       add(option, BorderLayout.SOUTH);
       add(g, BorderLayout.WEST);
       add(playerPanel, BorderLayout.EAST);
       add(message, BorderLayout.NORTH);
    */

       setVisible(true);


   }


}
