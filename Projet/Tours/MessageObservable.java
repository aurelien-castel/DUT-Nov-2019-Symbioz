package Tours;

import java.util.*;

import Joueur.*;
import Interface.*;
import Plateau.Plateau;

/**
 * Classe qui sert à observer
 * @author	Aurélien Castel
 */
public class MessageObservable extends Observable {

    MessageObservable() {
	
		super();
		
	}
	
    void changeData(Object data) {
	
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
	}

}