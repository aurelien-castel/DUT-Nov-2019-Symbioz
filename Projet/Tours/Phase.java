package Tours;

import Plateau.*;

/**
 * Classe qui caratérise les phases Singleton qui créé des phases qui sont aussi
 * des singletons
 * 
 * @author Aurélien Castel
 */
public class Phase {

    /** Permet de récupérer les méthodes du tour */
    private static Tour tour;
    /** Sauvegarde du plateau du jeu */
    private static Plateau plateau;

    /** Création de la phase 1 */
    private static Phase_1 phase1;
    /** Création de la phase 2 */
    private static Phase_2 phase2;

    /**
     * Constructeur en privé
     */
    private Phase() {

    }

    /** Instance unique non préinitialisée */
    private static Phase INSTANCE = null;

    /**
     * Point d'accès pour l'instance unique du singleton
     * 
     * @param tour
     * @param plateau
     * @return
     */
    public static synchronized Phase getInstance(Tour tour, Plateau plateau) {
        if (INSTANCE == null) {
            INSTANCE = new Phase();

            Phase.tour = tour;
            Phase.plateau = plateau;
            phase1 = Phase_1.getInstance(INSTANCE);
            phase2 = Phase_2.getInstance(INSTANCE);

        }
        return INSTANCE;
    }

    /**
     * @return the plateau
     */
    public static Plateau getPlateau() {
        return plateau;
    }

    /**
     * @return the tour
     */
    public static Tour getTour() {
        return tour;
    }

    /**
     * @return the phase1
     */
    public static Phase_1 getPhase1() {
        return phase1;
    }

    /**
     * @return the phase2
     */
    public static Phase_2 getPhase2() {
        return phase2;
    }

    /**
     * argument de type plateau
     * 
     * @param plat
     */
    public static void setPlateau(Plateau plat) {
        Phase.plateau = plat;
    }

}