package Plateau;

import Unities.*;
import Joueur.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
// import sun.net.www.content.text.plain;

/**
 * Classe qui caractérise une zone du plateau
 * @author	Pierre, Nathan
 */

public class Zone{

	private int idZone;
	private boolean fertile;
	private Case[] zoneCase;

	private int nbCase;

	private Random rand = new Random();

/**
 *  Constructeur d'une zone
 * @param Si la zone est fertile true, sinon false
 * @param  Le nombre de case de la zone
 */

	public Zone(boolean fertile, int nbCase){
		this.fertile = fertile;
		this.zoneCase = new Case[nbCase];
		this.nbCase = nbCase;
		for(int i = 0; i < nbCase; i++) {
			this.zoneCase[i] = new Case(i);
		}
	}

	public boolean isFertile(){
		return fertile;
	}

/** Récupére une case en fonction de l'index
 * @param [int]
 * @return [Case]
 */
	public Case getCase(int indexCase){
		if(indexCase == -1) {
			indexCase = zoneCase.length;
			indexCase--;
		}
		if(indexCase == zoneCase.length) {
			indexCase = 0;
		}
		return this.zoneCase[indexCase];
	}


/** Itere chaque case de chaque zone pour la reproduction aléatoire
 * @param Joueur
 */
	public void itereCase(JoueurInterface j){
		int step, rdm = 0, flag = 0;

		for(step = 0; step < nbCase; step++){
			flag = 0;
			ArrayList<Case> listeVoisin = new ArrayList<Case>();
			listeVoisin = zoneCase[step].getVoisin();

			if(3 < zoneCase[step].countColor(j.getColor())){
				if(8 > zoneCase[step].countColor(j.getColor())){
					rdm = rand.nextInt((listeVoisin.size()-1 - 0) + 1) + 0;
					do{
						if(zoneCase[step].getCaseVoisin(rdm).addZerbEnd(new Zerb(j.getColor()))){
							flag = 1;
						}else{
							rdm = rand.nextInt((listeVoisin.size()-1 - 0) + 1) + 0;
						}
					}while(flag == 0);
				}
			}

			if(8 <= zoneCase[step].countColor(j.getColor())){  
				if(12 > zoneCase[step].countColor(j.getColor())){
					rdm = rand.nextInt((listeVoisin.size()-1 - 0) + 1) + 0;
					do{
						if(zoneCase[step].getCaseVoisin(rdm).addZerbEnd(new Zerb(j.getColor())) && zoneCase[step].getCaseVoisin(rdm).addZerbEnd(new Zerb(j.getColor()))){
							flag=1;
						}else{
							rdm = rand.nextInt((listeVoisin.size()-1 - 0) + 1) + 0;
						}
					}while(flag == 0);
				}	
			}

			if(zoneCase[step].realisationSymbioz(j.getColor())){	
				j.incrementeSymbioz();
			}

		listeVoisin = null;
		rdm = 0;
		}
	}
}

