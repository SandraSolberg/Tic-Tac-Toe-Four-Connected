package inf101.v20.sem2.example.GUI;

import inf101.v20.games.IGame;
import inf101.v20.games.plastRamme;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 *
 * trippTrappGUI.java -> En klasse som definerer GUI av spillet trippTrappGame.java
 *
 * @author Sandra Solberg
 */

public class trippTrappGUI extends JPanel implements ActionListener {


    private int gridRow;
    /**
     * The width of each cell in pixels.
     */
    private int gridCol;

    /**
     * Vi trenger 9 knapper for spillet
     */
    private JButton spilleKnapper[][];

    /**
     * HashMap for å bevare verdiene og Stringen lagt ved
     */
    private HashMap<Integer, String> gridButtons;

    /**
     *
     */
    private IGame game;
    /**
     *
     */
    private plastRammeComponent komponent;
    private plastRamme ramme;

    private JButton reset;
    private JButton newGame;

    private JPanel knappPanel;
    private JPanel optionPanel;
    private JPanel panel;
    private PlayerPanel playerPanel;

    private JLabel status;

    private static final String PLAYER1_MARK = "X";
    private static final String PLAYER2_MARK = "O";
    private static final String OPEN_MARK = "-";



    public trippTrappGUI(int gridRow, int gridCol) {
        this.gridRow = gridRow;
        this.gridCol = gridCol;

        komponent = new plastRammeComponent(10, 10 );
        //initTopButtons();
        //initButtonPanel();
        //knappene i gridet.


    }

    /**
     * inneholder knappene reset og new game
     */
    JPanel initOptionButtons(){
        optionPanel = new JPanel();
        this.add(optionPanel);

        reset = new JButton(" Reset");
        reset.addActionListener(this);
        optionPanel.add(reset);

        newGame = new JButton("New Game");
        optionPanel.add(newGame);

        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new GridLayout(1, 2));
        add(borderPanel);
        Border linje = BorderFactory.createTitledBorder("Options");
        borderPanel.setBorder(linje);

        borderPanel.add(reset, BorderLayout.LINE_START);
        borderPanel.add(newGame, BorderLayout.LINE_END);

        return borderPanel;
    }
    JPanel initMessagePanel(String INIT_START){
        JPanel message = new JPanel();
        this.add(message);

        status = new JLabel(INIT_START);

        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        message.add(status);

        return message;
    }
    /**
     * @return clikable knapper for spillet
     */
    void initButtonPanel() {
        knappPanel = new JPanel(); //rutene vi skal klikke på
        knappPanel.setLayout(new GridLayout(gridRow, gridCol, 10, 10));
        this.add(knappPanel);

        status = new JLabel();
        status.setText("Welcome to this game!, choose a game ");

        //alle 9 knappene i gridet
        spilleKnapper = new JButton[gridRow][gridCol];

        //Action-listner for alle knappene
        KnappLytter lytter = new KnappLytter();


        for (int row = 0; row < gridRow; row++) {
            for (int col = 0; col < gridCol; col++) {
                spilleKnapper[row][col] = new JButton(OPEN_MARK);
                spilleKnapper[row][col].setPreferredSize(new Dimension(90, 90));
                spilleKnapper[row][col].setBackground(Color.CYAN);

                spilleKnapper[row][col].addActionListener(this);
                knappPanel.add(spilleKnapper[row][col]);


            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button =(JButton) e.getSource();
        if(button == reset){
            resetBoard("Tykket på " + reset.getText());
            //perform reset on game
        }
        if(button == newGame){
            newGameBoard("Trykket på " + newGame.getText());
        }
        ((JButton)e.getSource()).setBackground(Color.red);
        ((JButton)e.getSource()).setText("X");
    }

    //bruker reset metoden i game
    private void resetBoard(String exampleParam) {
        updateMessage(exampleParam);
        ramme.initializeRuter();

        this.updateUI();

    }
    private void newGameBoard(String exmpleParam){
        game.reset();
        this.updateUI();
        //TODO sette players til nytt valg
    }

    /**
     *
     * @param exampleParam tar inn et scenario og gir ut riktig oppdaterings beskjed.
     */
    private void updateMessage(String exampleParam){
        status.setText(exampleParam);

    }

    /**
     * En privat klasse som lytter etter knapper
     */
    private class KnappLytter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel clickedPanel =(JPanel)e.getSource(); // get the reference to the button that was clicked


        }
    }
}
