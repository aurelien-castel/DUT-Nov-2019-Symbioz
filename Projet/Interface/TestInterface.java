package Interface;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;

import Plateau.*;
import Joueur.*;
import Interface.*;
import Unities.*;

public class TestInterface {
    
    // Où sont stockés les joueurs et bots
    private ArrayList<JoueurInterface> listJoueur;

    public TestInterface() {

        JFrame f = new JFrame();
        f.setSize(new Dimension(500, 500));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listJoueur = new ArrayList<>();

        listJoueur.add(Bot.createNewJoueur());
        listJoueur.add(Bot.createNewJoueur());

        Plateau p = new Plateau(listJoueur);
        p.getZone(1).getCase(2).addZerb(new Zerb(Color.BLUE), 5);
        p.getZone(2).getCase(5).addZerb(new Zerb(Color.BLUE), 3);
        p.getZone(3).getCase(1).addZerb(new Zerb(Color.BLUE), 8);
        p.getZone(1).getCase(0).addZerb(new Zerb(Color.BLUE), 13);

        f.add(new Dessin(p));
        f.setVisible(true);

    }

}