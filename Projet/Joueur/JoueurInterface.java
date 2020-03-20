package Joueur;

import java.util.Scanner;

import java.util.Random;
import java.awt.Color;

/**
 * Classe qui permet caractériser un joueur ou bot en ayant des méthodes communes
 * @author	Aurélien Castel
 */
public interface JoueurInterface {

	/**
	 * @param nbeJoueur the nbeJoueur to set
	 */
	public static void setNbeJoueur(int nbe) {

	}

	/**
	 * @return the nbeJoueur
	 */
	public static int getNbeJoueur() {
		return 0;

	}

	/**
	 * @return the nbeMinJoueur
	 */
	public static int getNbeMinJoueur() {
		return 2;
	}

	/**
	 * @return the nbe de mana (point action/crédits)
	 */
	public static int getNbeMana() {
		return 10;
	}

	/**
	 * 
	 * @return New joueur
	 */
	public static JoueurInterface createNewJoueur() {
		return null;

	}

	/**
	 * @return Color
	 */
	public default Color getColor() {
		return null;

	}

	/**
	 * @return the idJoueur
	 */
	public default int getIdJoueur() {
		return 0;

	}

	/**
	 * @return the choice
	 */
	public default int getChoice(int rangeMin, int rangeMax) {
		return 0;

	}

	/**
	 * set buffered mana
	 */
	public void setManaBuffer(int buf);

	/**
	 * @return the mana
	 */
	public int getMana();

	/**
 	* Incrémente symbioz
 	*/
	public void incrementeSymbioz();

	/**
	 * @return symbioz
	 */
	public int getSymbioz();

}