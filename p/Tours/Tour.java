package Tours;

import java.util.ArrayList;
import java.util.Scanner;

import Joueur.*;
import Interface.*;
import Plateau.Plateau;

/**
 * Classe tour permet d'orchestrer le jeu C'est un singleton
 * 
 * @author Aurélien Castel, Nathan Caba
 */
public class Tour {

	/** Le nombre de tours */
	private int nbeTour;
	/** Pour la victoire */
	private Boolean gagne = false;

	/**
	 * Phases
	 */
	/** Permet de récupérer toutes les phases */
	private Phase phaseObj;
	/** Phase 1 */
	private static Phase_1 phase1;
	/** Phase 2 */
	private static Phase_2 phase2;

	/**
	 * Joueur
	 */
	/** Nbe total (joueurs réels et bots) */
	private int nbeJoueur;
	/** Nombre de bots */
	private int nbeBot;

	/** Nombre minimal de joueurs pour jouer */
	private final int nbeMinJoueur;
	/** Où sont stockés les joueurs et bots */
	private ArrayList<JoueurInterface> listJoueur;

	/** Partie graphique */
	/** Le plateau de jeu */
	private Plateau p;
	/** La fenetre de jeu */
	private Fenetre f;
	/** Le dessin: la partie graphique du jeu */
	private Dessin d;
	/**
	 * Observeur qui permet de mettre à jour l'interface s'il y a eu des changements
	 * sur le plateau
	 */
	private final MessageObservable observable;

	/**
	 * Contructeur en privé
	 */
	private Tour() {

		nbeTour = 0;
		nbeMinJoueur = JoueurInterface.getNbeMinJoueur();
		nbeJoueur = nbeMinJoueur;

		listJoueur = new ArrayList<>();

		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);

		System.out.println("______NOMBRE_DE_JOUEURS______\n");

		/**
		 * Demande du nbe d'utilisateurs
		 */
		System.out.print("Entrez le nombre le joueurs (2 ou 4): ");
		for (Boolean choose = false; choose == false;) {

			int value;
			try {
				value = Integer.parseInt(scanner.nextLine());
				if ((value == 2) || (value == 4)) {

					choose = true;

					nbeJoueur = value;

				}
				// not positive.
			} catch (NumberFormatException e) {
				// not an integer
			}

		}

		/**
		 * Demande du nbe de bots
		 */
		System.out.print("Parmis ces joueurs combien il y a de bot ? (il doit y avoir au moins 1 joueur reel): ");
		for (Boolean choose = false; choose == false;) {

			int value;
			try {
				value = Integer.parseInt(scanner.nextLine());
				if (value < nbeJoueur) {

					choose = true;

					nbeBot = value;

				}
				// not positive.
			} catch (NumberFormatException e) {
				// not an integer
			}

		}
		System.out.println(
				"Il y a donc en tout " + nbeJoueur + " joueurs et " + nbeBot + " bots parmis tous les joueurs.");

		System.out.println("_____________________________\n");

		/**
		 * On set le nbe de joueurs réels
		 */
		Joueur.setNbeJoueur(nbeJoueur - nbeBot);
		/**
		 * On set le nbe de bots
		 */
		Bot.setNbeJoueur(nbeBot);

		System.out.println("______CREATION_DES_JOUEURS______\n");

		for (int i = 0; i < nbeJoueur - nbeBot; i++) {

			listJoueur.add(Joueur.createNewJoueur());

		}

		for (int i = 0; i < nbeBot; i++) {

			listJoueur.add(Bot.createNewJoueur());

		}

		System.out.println("________________________________\n");

		/**
		 * On créé le plateau puis l'interface
		 */
		p = new Plateau(listJoueur);
		f = new Fenetre();
		d = new Dessin(p); // interface graphique ici
		f.add(d);

		/**
		 * Création des phases
		 */
		phaseObj = Phase.getInstance(this, p);
		phase1 = phaseObj.getPhase1();
		phase2 = phaseObj.getPhase2();

		// Create Observable and add Observer
		observable = new MessageObservable();
		observable.addObserver(d);

		observable.changeData(p);

		/**
		 * Les tours et différentes phases ici :
		 */

		System.out.println("______QUE_LA_PARTIE_COMMENCE______\n");

		while ((nbeTour < 12) && (gagne == false)) {

			// on parcourt les phases
			for (enumPhase phase : enumPhase.values()) {

				// on parcourt les joueurs
				for (JoueurInterface currentJoueur : listJoueur) {

					System.out.println("___<" + phase + ">\n");

					if (phase == enumPhase.PHASE1) {
						phase1.play(currentJoueur);// pour une phase on prend le joueur
					}

					else if (phase == enumPhase.PHASE2) {
						phase2.play(currentJoueur);
					}

					else if (phase == enumPhase.PHASE3) {

					}

					else if (phase == enumPhase.PHASE4) {

					}
					if(currentJoueur.getSymbioz() == 3){
						System.out.println("Joueur" + currentJoueur.getIdJoueur() + " a gagné !");
						gagne = true;
						break;
					}
				}
				if(gagne == true)break;

			}
			// gagne=true;
			nbeTour++;
		}

		System.out.println("____________FIN_DU_JEU____________\n");
		scanner.close();
		System.exit(1);

	}

	/** Instance unique non préinitialisée */
	private static Tour INSTANCE = null;

	/**
	 * Point d'accès pour l'instance unique du singleton On lance le jeu d'ici
	 * 
	 * @return Tour
	 */
	public static synchronized Tour getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Tour();
		}
		return INSTANCE;
	}

	/**
	 * Pour mettre à jour l'observeur (mise à jour de la partie graphique)
	 */
	public void update() {

		observable.changeData(p);

	}
}