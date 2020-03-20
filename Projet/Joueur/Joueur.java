package Joueur;

import java.util.Random;
import java.util.Scanner;

import java.awt.Color;

/**
 * Classe qui caractérise un joueur réel
 * @author	Aurélien Castel
 */
public class Joueur implements JoueurInterface {

	/**
	 * Couleurs
	 */
	/**Rouge */
	private int couleurRJoueur;
	/**Vert */
	private int couleurGJoueur;
	/**Bleu */
	private int couleurBJoueur;

	/**
	 * Le nombre de joueurs
	 * Par défaut on prend le nombre minimal dans l'interface Joueur
	 */
	private static int nbeJoueur = JoueurInterface.getNbeMinJoueur();
	/**Compte les joueurs à partir de 1 */
	private static int numJoueur = 1;
	/**L'identifiant du joueur, se qui le caractérise */
	private int idJoueur;

	/**
	 * Nombre de symbioz du joueur
	 */
	private int symbioz = 0;

	/**
	 * Le mana maximum - final static
	 * C'est le mana de départ lorsqu'on commence le jeu
	 * Au début on le récupère dans l'interface Joueur
	 */
	private final static int manaMax = JoueurInterface.getNbeMana();
	/**
	 * Le mana courant
	 * différent à chaque joueur
	 */
	private int mana = JoueurInterface.getNbeMana();
	/**Attribut utilisé pour la cagnotte de mana */
	private int manaBuffer = 0;

	/**On ne peut pas faire de new Object */
	private Joueur() {
	}

	/**
	 * @param nbeJoueur the nbeJoueur to set
	 */
	public static void setNbeJoueur(int nbe) {
		if (Joueur.nbeJoueur < nbe) {
			Joueur.nbeJoueur = nbe;
		}
	}

	/**
	 * @return the nbeJoueur
	 */
	public static int getNbeJoueur() {
		return Joueur.nbeJoueur;
	}

	/**
	 * Permet de créer
	 * @return type de Joueur
	 */
	public static Joueur createNewJoueur() {

		if (numJoueur <= nbeJoueur) {
			Joueur j = new Joueur();
			j.idJoueur = JoueurAttributes.getSharedId();

			j.couleurRJoueur = randInt(0, 255);
			j.couleurBJoueur = randInt(0, 255);
			j.couleurGJoueur = randInt(0, 255);

			numJoueur++;
			System.out.println("Je suis un joueur et mon numero est: " + j.idJoueur);
			return j;
		}

		return null;

	}

	/**
	 * Récuperer la couleur du joueur
	 * @return Color
	 */
	public Color getColor() {

		Color c = new Color(couleurRJoueur, couleurGJoueur, couleurBJoueur);

		return c;
	}

	/**
	 * @return the idJoueur
	 */
	public int getIdJoueur() {
		return idJoueur;
	}

	/**
	 * Le joueur choisis selon un range
	 */
	public int getChoice(int rangeMin, int rangeMax) {

		int choice = 0;

		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);

		/**
		 * Demande
		 */
		for (Boolean choose = false; choose == false;) {

			System.out.print("> joueur " + idJoueur + ": ");

			int value;
			try {
				value = Integer.parseInt(scanner.nextLine());
				if ((value >= rangeMin) && (value <= rangeMax)) {

					choose = true;

					choice = value;

				}
				// not positive.
			} catch (NumberFormatException e) {
				// not an integer
			}

			System.out.println("");

		}

		return choice;

	}

	/**
	 * set buffered mana
	 */

	public void setManaBuffer(int buf) {
		manaBuffer = buf;
	}

	/**
	 * @return the mana
	 */
	public int getMana() {
		return (mana + manaBuffer);
	}

	/**
	 * Retourne un int au hasard entre un invervalle
	 * @param min Minimum value
	 * @param max Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public void incrementeSymbioz(){
		this.symbioz= this.symbioz + 1;
	}

	public int getSymbioz(){
		return this.symbioz;
	}

}