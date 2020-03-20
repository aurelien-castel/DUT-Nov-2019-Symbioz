package Unities;

import java.awt.Color;


/**
*	La classe abstraite <code>Unites</code> sert à définir les caractéristiques d'une unité 
*	@version 1.0
*	@author	Clément RUER, Romain MIGNAC
*/


public abstract class Unites{

	private int cost;
	private Color belonging;
	/**
	* Constructeur de la classe abstraite unite
	* @param cost represente le coût de l'unité
	* @param belonging represente l'appartenance de l'unité (a quel joueur elle appartient)
	*/
	public Unites(int cost, Color belonging){
		this.cost = cost;
		this.belonging =belonging;
	}

	/**
	 * Constructeur pour une unitée orpheline
	 * @param cost
	 */
	public Unites(int cost){
		this.cost = cost;
	}

	/**
	* @return le coût de l'unité
	*/
	public int getCost(){
		return this.cost;
	}
	/**
	* @return l'appartenance de l'unité
	*/
	public Color getBelonging(){
		return this.belonging;
	}
}