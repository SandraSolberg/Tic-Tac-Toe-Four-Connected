package inf101.v20.sem2.example.GUI;

import inf101.v20.games.plastRamme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

/**
 * @author Sandra Solberg
 */
public class firePaaRadGUI extends JPanel implements ActionListener {


    private Supplier<plastRamme> ramme;
    plastRamme firePaaRad;

    public static void run(Supplier<plastRamme> ramme){
        JFrame f = new JFrame("Fire på rad");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firePaaRadGUI ap = new firePaaRadGUI(ramme);
        ap.initialize();
        f.add("Center", ap);
        f.pack();
        f.setVisible(true);

    }
    public firePaaRadGUI(Supplier<plastRamme> ramme) {
        this.ramme = ramme;
        this.firePaaRad = ramme.get();
    }

    public void initialize(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
