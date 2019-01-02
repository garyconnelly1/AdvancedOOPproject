package ie.gmit.sw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyPressed implements KeyListener, KeyObservable {

	private ArrayList<KeyObserver> objList;

	public KeyPressed() {
		objList = new ArrayList();
	}

	@Override
	public void NotifyObservers(KeyEvent keyEvent) {

		for (KeyObserver obs : objList) {
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

		NotifyObservers(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
