package Unities;

import java.awt.Color;

/**
*	Découle de la classe abstraite <code>Unites</code> et définie les caractéristiques propres au <code>Crapit</code>
*	@version 1.0
*	@author	Clément RUER, Romain MIGNAC
*/

public class Crapit extends Unites{

	/**
	*	Constructeur des objets Crapit
	*	@param belonging correspond à la couleur propre à chaque joueur 
	*/

	public Crapit(Color belonging){
		super(3,belonging);
	}

	public Crapit(){
		super(3);
	}

	public void printCrapit(){
		System.out.println("test");
	}
	
}