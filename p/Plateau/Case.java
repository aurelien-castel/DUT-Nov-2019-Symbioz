package Plateau;

import Joueur.*;
import Unities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.awt.*;

/**
 * Classe qui caractérise une case
 * 
 * @author Pierre, Nathan Caba
 */

public class Case {

	private int idCase;

	private boolean isSymbioz = false;

	/**
	 * Arraylist des objets Zerbs
	 *
	 * @see Zerb
	 */
	private ArrayList<Zerb> emplacementZerb = new ArrayList<Zerb>(); // Emplacement pour les Zerb

	/**
	 * Arraylist des objets Kroguls
	 *
	 * @see Krogul
	 */
	private ArrayList<Krogul> emplacementKrogul = new ArrayList<Krogul>();

	/**
	 * Arraylist des objets Crapits
	 *
	 * @see Crapit
	 */
	private ArrayList<Crapit> emplacementCrapit = new ArrayList<Crapit>();

	/**
	 * Arraylist des cases voisines
	 */
	private ArrayList<Case> listeVoisin = new ArrayList<Case>();

	/**
	 * Contructeur en privé
	 *
	 * @param idCase
	 */
	public Case(int idCase) {
		this.idCase = idCase;
	}

	/**
	 * Vérification de la réalisation d'une Symbioz
	 *
	 * @param j
	 */
	public boolean realisationSymbioz(Color color) {
		boolean realSymbioz = false;
		if (this.emplacementZerb.size() == 12 && countColor(color) == 12 && this.isSymbioz == false) {
			this.isSymbioz = true;
			realSymbioz = true;
		}
		return realSymbioz;
	}

	/**
	 * ajoute un Krogul a l'element emplacementKrogul
	 *
	 * @param krogul
	 * @see Krogul
	 * @see emplacementKrogul
	 */
	public void addKrogul(Krogul krogul) {
		this.emplacementKrogul.add(krogul);
	}

	/**
	 * ajoute un Crapit a l'element emplacementCrapit
	 *
	 * @param crapit
	 * @see Crapit
	 * @see emplacementCrapit
	 */
	public void addCrapit(Crapit crapit) {
		this.emplacementCrapit.add(crapit);
	}

	/**
	 * Retire un Krogul a l'element emplacementKrogul
	 *
	 * @param krogul
	 * @see Krogul
	 * @see emplacementKrogul
	 */
	public void deleteKrogul(Krogul krogul) {
		this.emplacementCrapit.remove(krogul);
	}

	/**
	 * Retire un Crapit a l'element emplacementCrapit
	 *
	 * @param crapit
	 * @see Crapit
	 * @see emplacementCrapit
	 */
	public void deleteCrapit(Crapit crapit) {
		this.emplacementCrapit.remove(crapit);
	}

	/**
	 * définis un Zerb a l'element emplacementZerb d'index i
	 *
	 * @param i
	 * @param zerb
	 * @see Zerb
	 * @see emplacementZerb
	 */
	public boolean addZerb(Zerb zerb, int index) {
		if (index < 12) {
			this.emplacementZerb.set(index, zerb);
			return true;
		} else {
			System.out.println("Plus d'emplacement libre pour les Zerbs");
		}
		return false;
	}

	/**
	 * ajoute un Zerb a l'element emplacementZerb
	 *
	 * @param zerb
	 * @see Zerb
	 * @see emplacementZerb
	 */
	public boolean addZerbEnd(Zerb zerb) {
	/*	int countColor = 0;
		Color col1 = null;
		Color col2 = null;
		Color tmp = null;
		for (int i = 0; i < emplacementZerb.size(); i++) {
			tmp = emplacementZerb.get(i).getBelonging();
			if (col2 != null && col2 != tmp) {
				return false;
			}
			if (col1 == null) {
				col1 = tmp;
			} else if (col2 == null) {
				col2 = tmp;
			}
		}
		if (emplacementZerb.size() < 12) {
			this.emplacementZerb.add(zerb);
			return true;
		}
		return false;*/

		int countColor = 0;
		Color col1 = null;
		Color col2 = null;
		for (int i = 0;i < emplacementZerb.size();i++) {
			emplacementZerb.get(i).getBelonging();
		}
		if(emplacementZerb.size() < 12){
			this.emplacementZerb.add(zerb);
			return true;
		}
		return false;
	}
	/* ---------------------------------------- */

	/**
	 * renvoie l'id de la case
	 *
	 * @see idCase
	 */
	public int getIdCase() { //
		return this.idCase;
	}

	/**
	 * renvoie l'arrayList de Kroguls
	 *
	 * @see emplacementKrogul
	 */
	public ArrayList<Krogul> getKrogul() {
		return this.emplacementKrogul;
	}

	/**
	 * renvoie l'arrayList de Zerb
	 *
	 * @see emplacementZerb
	 */
	public ArrayList<Zerb> getZerb() {
		return this.emplacementZerb;
	}

	/**
	 * renvoie l'arrayList de Crapit
	 *
	 * @see emplacementCrapit
	 */
	public ArrayList<Crapit> getCrapit() {
		return this.emplacementCrapit;
	}

	public int countColor(Color color) {
		int sameColor = 0;
		for (int step = 0; step < emplacementZerb.size(); step++) {
			if (this.emplacementZerb.get(step).getBelonging().getRGB() == color.getRGB())
				sameColor = sameColor + 1;
		}
		return sameColor;
	}

	public void setVoisin(Case voisin) {
		this.listeVoisin.add(voisin);
	}

/**
 * Permet de récupérer tout les voisins de cette case sous forme d'une liste
 * @return [listeVoisin]
 */
	public ArrayList<Case> getVoisin(){
		return this.listeVoisin;
	}

/**
 * Permet de récupérer un voisin de cette case en fonction d'un index
 * @param  index [int]
 * @return       [Case]
 */
	public Case getCaseVoisin(int index){
		return this.listeVoisin.get(index);
	}
}