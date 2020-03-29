package Unities;

import java.awt.Color;


/**
*	Découle de la classe abstraite <code>Unites</code> et définie les caractéristiques propres au <code>Zerb</code>
*	@version 1.0
*	@author	Clément RUER, Romain MIGNAC
*/


public class Zerb extends Unites{

	/**
	*	Constructeur des objets Zerb 
	*	@param belonging correspond à la couleur propre à chaque joueur 
	*/

	public Zerb(Color belonging){
		super(1,belonging);
	}

	public Zerb(){
		super(1);
	}
	
}