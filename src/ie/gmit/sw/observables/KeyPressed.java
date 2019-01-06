package ie.gmit.sw.observables;

import java.awt.event.KeyEvent;

/**
* Provides an implementation of KeyListener and KeyObservable.
* Is used to notify any observers whenever a key is pressed during the game.
*
* @author Gary Connlly
*/

import ie.gmit.sw.observers.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyPressed implements KeyListener, KeyObservable {

	private static KeyPressed instance = null;

	private ArrayList<KeyObserver> objList;
	
	/**
	 * Initializes a list of observers.
	 */

	private KeyPressed() {
		objList = new ArrayList<KeyObserver>();
	}
	
	/**
	 * Notifies any observers whenever a key is pressed by looping through the 
	 * observer list.
	 * @param keyEvent The key event that occurred.
	 */

	@Override
	public void NotifyObservers(KeyEvent keyEvent) {

		for (KeyObserver obs : objList) {
			obs.update(keyEvent);
		}

	}
	
	/**
	 * Adds objects to the list of observers.
	 * @param obs The KeyObserver object to be added.
	 */

	public void AddObserver(KeyObserver obs) {
		if (obs != null)
			objList.add(obs);
	}

	/**
	 * Deletes an observer from the observer list.
	 * @param obs The KeyObserver object to be deleted.
	 */
	
	public void DelObserver(KeyObserver obs) {
		if (obs != null)
			objList.remove(obs);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		NotifyObservers(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	/**
	 * Checks if an instance of this object already exists, if it
	 * does, return it. If not create a new instance of this object and return that.
	 * @return
	 */

	public static KeyPressed getInstance() {
		if (instance == null) {
			instance = new KeyPressed();
		}

		return instance;

	}

}
