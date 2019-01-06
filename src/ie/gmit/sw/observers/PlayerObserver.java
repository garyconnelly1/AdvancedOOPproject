package ie.gmit.sw.observers;

import java.awt.event.KeyEvent;

/**
* Provides the implementation of the KeyObserver interface and updates Player objects based on 
* key events..
*
* @author Gary Connlly
*/
import ie.gmit.sw.*;
import ie.gmit.sw.views.GameWindow;
import ie.gmit.sw.views.GameView;
import ie.gmit.sw.models.Sprite;
import ie.gmit.sw.observables.KeyPressed;

public class PlayerObserver implements KeyObserver {

	private Sprite player;
	private GameView view;
	
	/**
	 * Gets a handle on all the player singleton object that exists in the game.
	 * Gets a handle on the KeyPressed singleton object.
	 * Adds itself as an observer to the KeyPressed list of observers.
	 */

	public PlayerObserver() {

		player = SpriteFactory.getSprite("PLAYER");
		KeyPressed keyPressed = KeyPressed.getInstance(); // Because we want to get a handle on the same KeyPressed listener from multiple classes.
		keyPressed.AddObserver(this);

	}

	@Override
	public void update(KeyEvent e) {
		/**
		 * If the right arrow key is pressed, set the direction for the player accordingly.
		 */
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection(Direction.RIGHT);
			/**
			 * If the left arrow key is pressed, set the direction for the player accordingly.
			 */
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection(Direction.LEFT);
			/**
			 * If the up arrow key is pressed, set the direction for the player accordingly.
			 */
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection(Direction.UP);
			/**
			 * If the down arrow key is pressed, set the direction for the player accordingly.
			 */
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection(Direction.DOWN);
			/**
			 * If the z key is pressed, toggle the view of the game window.
			 */
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			view = GameWindow.getView(); // Get a handle on the current view.
			view.toggleView();
			/**
			 * If the x key is pressed, move the player in it's corresponding direction.
			 */
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else {
			return;
		}

	}

}
