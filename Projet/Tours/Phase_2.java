package Tours;

import Joueur.*;
import Unities.*;
import Plateau.*;

/**
 * Classe de phase
 * @author	Aurélien Castel
 */
public class Phase_2 {
	
    /**
     * Contructeur en privé
     */
    private Phase_2() {

    }

    /** Instance unique non préinitialisée */
    private static Phase_2 INSTANCE = null;

    private Plateau plat;

    /**
     * Point d'accès pour l'instance unique du singleton
     * Contructeur, le paramètre permet à seulement créer une phase_x avec la classe
     * phase
     * 
     * @param p
     * @return INSTANCE
     */
    public static synchronized Phase_2 getInstance(Phase p) {
        if (INSTANCE == null) {
            INSTANCE = new Phase_2();
        }
        return INSTANCE;
    }

    public void play(JoueurInterface currentJoueur) {

        plat = Phase.getPlateau();

        plat.getZone(1).itereCase(currentJoueur);
        plat.getZone(2).itereCase(currentJoueur);
        plat.getZone(3).itereCase(currentJoueur);
        
        Phase.setPlateau(this.plat);
        Phase.getTour().update();
    }
}