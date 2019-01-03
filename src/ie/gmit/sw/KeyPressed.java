package ie.gmit.sw;

import java.awt.event.KeyEvent;
import ie.gmit.sw.observers.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyPressed implements KeyListener, KeyObservable {
	
	private static KeyPressed instance = null;

	private ArrayList<KeyObserver> objList;

	private KeyPressed() {
		System.out.println("DEBUG: KeyPressed constructor");
		objList = new ArrayList<KeyObserver>();
	}

	@Override
	public void NotifyObservers(KeyEvent keyEvent) {

		for (KeyObserver obs : objList) {
			System.out.println("DEBUG: NotifyObservers");
			obs.update(keyEvent);
		}

	}

	public void AddObserver(KeyObserver obs) {
		if (obs != null)
			objList.add(obs);
	}
	
	 public void DelObserver(KeyObserver obs)
	   {
	       if (obs != null)
	          objList.remove(obs);
	   }

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("DEBUG: Key pressed");
		NotifyObservers(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	public static KeyPressed getInstance() {
		System.out.println("DEBUG: KeyPressed getInstance");
		if (instance == null) {
			instance = new KeyPressed();
		}

		return instance;

	}
	
	

}
