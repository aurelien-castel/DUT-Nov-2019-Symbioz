package Interface;

import java.awt.*;
import javax.swing.*;

/**
 * Classe pour la fenetre de jeu
 * @author	Clément RUER, Romain MIGNAC
 */
public class Fenetre extends JFrame { // La classe qui observe

	public Fenetre() {

		setSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}