package Tours;

import Joueur.*;
import Unities.*;
import Plateau.*;

/**
 * Classe de phase
 * 
 * @author Aurélien Castel, Nathan Caba
 */
public class Phase_1 {

    /**
     * Contructeur en privé
     */
    private Phase_1() {

    }

    /** Instance unique non préinitialisée */
    private static Phase_1 INSTANCE = null;

    /** Instance du plateau de jeu */
    private Plateau plat;

    /**
     * Point d'accès pour l'instance unique du singleton Contructeur, le paramètre
     * permet à seulement créer une Phase_x avec la classe Phase
     * 
     * @param p
     * @return INSTANCE
     */
    public static synchronized Phase_1 getInstance(Phase p) {
        if (INSTANCE == null) {
            INSTANCE = new Phase_1();
        }
        return INSTANCE;
    }

    /**
     * Lancez la phase ici
     * 
     * @param currentJoueur
     */
    public void play(JoueurInterface currentJoueur) {

        /**
         * Création d'objets pour récupérer leurs informations générales (par exemple:
         * coût)
         */

        Zerb zerb = new Zerb();
        Crapit crapit = new Crapit();
        Krogul krogul = new Krogul();

        /**
         * Lancement du jeu:
         */

        plat = Phase.getPlateau();

        System.out.println("Joueur a vous de jouer " + currentJoueur.getIdJoueur() + "\n");

        int choiceZone = -1;
        int choiceUnit = -1;
        int choiceCase = -1;
        int line = 1;

        int manaTmp = currentJoueur.getMana();

        loop: for (; manaTmp > 0;) {
            switch (line++) { // permet de faire un semblant de goto en java

            case 1: /* ligne 1 */
                choiceCase = -1;
                System.out.println("0.Terminer la phase "); // à enlever
                System.out.println("1.Choisir zone interne");
                System.out.println("2.Choisir zone au milieu");
                System.out.println("3.Choisir zone externe");
                System.out.println("  ( Mana restant: " + manaTmp + " )");
                System.out.println(" Faites votre choix: \n");

                choiceZone = currentJoueur.getChoice(0, 3);
                if (choiceZone == 0) {
                    break loop; // quit
                }
                break;

            case 2: /* ligne 2 */
                if (choiceZone == 1) {
                    choiceCase = 1;
                }
                if (choiceZone != 1) {
                    System.out.println("0.Retour ");
                }
                if (choiceZone == 3) {
                    System.out.println("Choisir une case entre 1 - 3 ");
                    choiceCase = currentJoueur.getChoice(0, 3);
                }
                if (choiceZone == 2) {
                    System.out.println("Choisir une case entre 1 - 2");
                    choiceCase = currentJoueur.getChoice(0, 2);
                }
                if (choiceCase == 0) {
                    line = 1;
                    break;
                }
                /* Pour 2 joueur, multiplier "choiceZone" par 2 */
                choiceCase += (currentJoueur.getIdJoueur() - 1) * choiceZone;
                break;

            case 3: /* ligne 3 */
                System.out.println("0.Retour ");
                System.out.println("1.Mettre un Zerb (" + zerb.getCost() + ")");
                System.out.println("2.Mettre un Crapit (" + crapit.getCost() + ")");
                System.out.println("3.Mettre un Krogul (" + krogul.getCost() + ")");
                System.out.println("  ( Mana restant: " + manaTmp + " )");
                System.out.println(" Faites votre choix: \n");

                choiceUnit = currentJoueur.getChoice(0, 3);
                if (choiceUnit == 0) {
                    line = 1; // goto 1
                }
                if (choiceUnit == 1) {
                    if ((manaTmp - zerb.getCost()) < 0) {
                        System.out.println("(!) Pas assez de mana (!)\n");
                    } else {
                        if (plat.getZone(choiceZone).getCase(choiceCase - 1)
                                .addZerbEnd(new Zerb(currentJoueur.getColor()))) {
                            manaTmp = manaTmp - 1;
                        } else {
                            System.out.println("(!) Plus d'emplacement libre pour les Zerbs (!)\n");
                        }
                    }
                    line = 3;
                }
                if (choiceUnit == 2) {
                    if ((manaTmp - crapit.getCost()) < 0) {
                        System.out.println("(!) Pas assez de mana (!)");
                    } else {
                        plat.getZone(choiceZone).getCase(choiceCase - 1)
                                .addCrapit(new Crapit(currentJoueur.getColor()));
                        manaTmp = manaTmp - 3;
                    }
                    line = 3;
                }
                if (choiceUnit == 3) {
                    if ((manaTmp - krogul.getCost()) < 0) {
                        System.out.println("(!) Pas assez de mana (!)");
                    } else {
                        plat.getZone(choiceZone).getCase(choiceCase - 1)
                                .addKrogul(new Krogul(currentJoueur.getColor()));
                        manaTmp = manaTmp - 5;
                    }
                    line = 3;
                }
                Phase.getTour().update();
                break;

            }
        }
        Phase.setPlateau(this.plat);
        currentJoueur.setManaBuffer(manaTmp / 2);

        // int choice = j.getChoice(0, 10);

        // System.out.println("Choice: "+choice);

    }

}