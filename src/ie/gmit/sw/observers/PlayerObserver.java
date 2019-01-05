package ie.gmit.sw.observers;

import java.awt.event.KeyEvent;
import ie.gmit.sw.*;
import ie.gmit.sw.views.GameWindow;
import ie.gmit.sw.views.GameView;
import ie.gmit.sw.models.Sprite;
import ie.gmit.sw.observables.KeyPressed;

public class PlayerObserver implements KeyObserver {

	private Sprite player;
	private GameView view;

	public PlayerObserver() {

		player = SpriteFactory.getSprite("PLAYER");
		KeyPressed keyPressed = KeyPressed.getInstance(); // Because we want to get a handle on the same KeyPressed listener from multiple classes.
		keyPressed.AddObserver(this);

	}

	@Override
	public void update(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			view = GameWindow.getView(); // Get a handle on the current view.
			view.toggleView();
			System.out.println("Toggle View");
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else {
			return;
		}

	}

}
