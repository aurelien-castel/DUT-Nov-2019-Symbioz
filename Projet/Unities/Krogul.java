package Unities;

import java.awt.Color;

/**
*	Découle de la classe abstraite <code>Unites</code> et définie les caractéristiques propres au <code>Krogul</code>
*	@version 1.0
*	@author	Clément RUER, Romain MIGNAC
*/


public class Krogul extends Unites{

	/**
	*	Constructeur des objets Krogul
	*	@param belonging correspond à la couleur propre à chaque joueur 
	*/

	public Krogul(Color belonging){
		super(5,belonging);
	}

	public Krogul(){
		super(5);
	}
	
}