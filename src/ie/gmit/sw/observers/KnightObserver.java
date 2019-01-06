package ie.gmit.sw.observers;

import java.awt.event.KeyEvent;


import java.util.List;

import ie.gmit.sw.Direction;
import ie.gmit.sw.models.*;
import ie.gmit.sw.observables.KeyPressed;
import ie.gmit.sw.views.GameWindow;

/**
* Provides the implementation of the KeyObserver interface and updates Knight objects based on 
* key events..
*
* @author Gary Connlly
*/

public class KnightObserver implements KeyObserver {

	private List<Sprite> knights;

	/**
	 * Gets a handle on all the Knight objects that exist in the game.
	 * Gets a handle on the KeyPressed singleton object.
	 * Adds itself as an observer to the KeyPressed list of observers.
	 */
	public KnightObserver() {
		knights = GameWindow.getKnights();
		KeyPressed keyPressed = KeyPressed.getInstance(); // Because we want to get a handle on the same KeyPressed
															// listener from multiple classes.
		keyPressed.AddObserver(this);
	}
	
	/**
	 * Updates the view depending on what key was pressed.
	 */

	@Override
	public void update(KeyEvent e) {
		int i = 0;
		for (Sprite knight : knights) {
			/**
			 * There are only 5 possible configurations for how knight objects can move,
			 * any more than that would be too difficult to play.
			 */
			if (i >= 5) { 
				i = 0;
			}
			i++;

			/**
			 * If the right arrow key is pressed, set the direction for all of the knights accordingly.
			 */
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (i == 1)
					knight.setDirection(Direction.LEFT);
				else if (i == 2)
					knight.setDirection(Direction.RIGHT);
				else if (i == 3)
					knight.setDirection(Direction.UP);
				else if (i == 4)
					knight.setDirection(Direction.UP);
				else
					knight.setDirection(Direction.DOWN);
				/**
				 * If the left arrow key is pressed, set the direction for all of the knights accordingly.
				 */
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (i == 1)
					knight.setDirection(Direction.RIGHT);
				else if (i == 2)
					knight.setDirection(Direction.LEFT);
				else if (i == 3)
					knight.setDirection(Direction.DOWN);
				else if (i == 4)
					knight.setDirection(Direction.LEFT);
				else
					knight.setDirection(Direction.UP);
				/**
				 * If the up arrow key is pressed, set the direction for all of the knights accordingly.
				 */
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (i == 1)
					knight.setDirection(Direction.UP);
				else if (i == 2)
					knight.setDirection(Direction.DOWN);
				else if (i == 3)
					knight.setDirection(Direction.LEFT);
				else if (i == 4)
					knight.setDirection(Direction.RIGHT);
				else
					knight.setDirection(Direction.RIGHT);
				/**
				 * If the down arrow key is pressed, set the direction for all of the knights accordingly.
				 */
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (i == 1)
					knight.setDirection(Direction.DOWN);
				else if (i == 2)
					knight.setDirection(Direction.UP);
				else if (i == 3)
					knight.setDirection(Direction.RIGHT);
				else if (i == 4)
					knight.setDirection(Direction.DOWN);
				else
					knight.setDirection(Direction.LEFT);
				/**
				 * If the x key is pressed, move the knights in their corresponding directions.
				 */
			} else if (e.getKeyCode() == KeyEvent.VK_X) {
				knight.move();
			} else {
				return;
			}

		}

	}

}
