package Plateau;

import java.util.ArrayList;

import Joueur.*;

/**
 * Classe qui caractérise le plateau
 * @author	Pierre, Nathan Caba
 */
public class Plateau {

	private Zone outer;
	private Zone middle;
	private Zone inner;

	public Plateau(ArrayList<JoueurInterface> listJoueur){
		outer = new Zone(false, 12);
		middle = new Zone(false, 8);
		inner = new Zone(true, 4);

		this.voisinage();
		// this.test();
	}

	public void voisinage() {

		int j = 0;
		for (int i = 0; i <= 11;i++) {
			if(i%3 == 2) {
				outer.getCase(i).setVoisin(outer.getCase(i+1));
				outer.getCase(i).setVoisin(outer.getCase(i-1));
				outer.getCase(i).setVoisin(middle.getCase(j));
				j++;
				outer.getCase(i).setVoisin(middle.getCase(j));
			} else {
				outer.getCase(i).setVoisin(outer.getCase(i+1));
				outer.getCase(i).setVoisin(outer.getCase(i-1));
				outer.getCase(i).setVoisin(middle.getCase(j));
			}
			if (i%3 == 0) {
				j++;
			}
		}

		//System.out.println("------------------");

		j = 0;
		for (int i = 0; i <= 7;i++) {
			middle.getCase(i).setVoisin(middle.getCase(i+1));
			middle.getCase(i).setVoisin(middle.getCase(i-1));
			middle.getCase(i).setVoisin(outer.getCase(j));
			j++;
			middle.getCase(i).setVoisin(outer.getCase(j));
			middle.getCase(i).setVoisin(inner.getCase(i/2));
		}

		//System.out.println("------------------");

		j = 0;
		for (int i = 0; i <= 3;i++) {
			inner.getCase(i).setVoisin(inner.getCase(i+1));
			inner.getCase(i).setVoisin(inner.getCase(i-1));
			inner.getCase(i).setVoisin(middle.getCase(j));
			inner.getCase(i).setVoisin(middle.getCase(j+1));
			j+=2;
		}
	}

	public Zone getZone(int choice){
		switch(choice){
			case 1:
				return this.inner;
			case 2:
				return this.middle;
			case 3:
				return this.outer;
			default:
				return null;
		}
	}
}