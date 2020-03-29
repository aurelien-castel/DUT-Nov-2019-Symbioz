package Joueur;

import java.util.Random;
import java.awt.Color;

/**
 * Classe qui caractérise un bot C'est un joueur spécifique qui n'est pas
 * controlé mais qui a des choix aléatoires Il remplace un joueur physique
 * 
 * @author Aurélien Castel
 */
public class Bot implements JoueurInterface {

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
	private Bot() {
	}

	/**
	 * @param nbeJoueur the nbeJoueur to set
	 */
	public static void setNbeJoueur(int nbe) {
		if (Bot.nbeJoueur < nbe) {
			Bot.nbeJoueur = nbe;
		}
	}

	/**
	 * @return the nbeJoueur
	 */
	public static int getNbeJoueur() {
		return Bot.nbeJoueur;
	}

	/**
	 * Permet de créer
	 * @return type de Joueur
	 */
	public static Bot createNewJoueur() {

		if (numJoueur <= nbeJoueur) {
			Bot b = new Bot();
			b.idJoueur = JoueurAttributes.getSharedId();

			b.couleurRJoueur = randInt(0, 255);
			b.couleurBJoueur = randInt(0, 255);
			b.couleurGJoueur = randInt(0, 255);

			numJoueur++;
			System.out.println("Je suis un bot et mon numero est: " + b.idJoueur);
			return b;
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
	 * Le bot choisis au hasards un choix selon un range donné
	 * @param rangeMin
	 * @param rangeMax
	 * @return int
	 */
	public int getChoice(int rangeMin, int rangeMax) {

		int choice = 2;

		choice = randInt(rangeMin, rangeMax);

		System.out.println("bot> " + idJoueur + ": " + choice + "\n");

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
		return mana;
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