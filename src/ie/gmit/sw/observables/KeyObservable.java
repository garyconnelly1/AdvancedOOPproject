package ie.gmit.sw.observables;

/**
* An interface that provides a method signature for notifying observers based on a KeyEvent.
*
* @author Gary Connlly
*/

import java.awt.event.KeyEvent;

public interface KeyObservable {
	
	 public void NotifyObservers(KeyEvent keyEvent);

}
