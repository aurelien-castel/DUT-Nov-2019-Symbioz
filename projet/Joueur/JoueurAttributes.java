package Joueur;

import java.util.Scanner;

import java.util.Random;
import java.awt.Color;

/**
 * Classe qui sert à stocker et partager des variables
 * @author	Aurélien Castel
 */
public class JoueurAttributes {

	private static int sharedId = 0;

	/**
	 * Cette classe ne sert qu'à sauver les variables static
	 * donc le constructeur est en private
	 */
	private JoueurAttributes(){

	}

	/**
	 * @return the sharedId
	 */
	protected static int getSharedId() {
		sharedId++;
		return sharedId;
	}

}