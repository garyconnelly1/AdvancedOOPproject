package ie.gmit.sw.observers;

import java.awt.event.KeyEvent;
import java.util.List;

import ie.gmit.sw.Direction;
import ie.gmit.sw.KeyPressed;
import ie.gmit.sw.models.*;
import ie.gmit.sw.views.GameWindow;

public class KnightObserver implements KeyObserver {

	// private Sprite knight;
	private List<Sprite> knights;

	public KnightObserver() {
		// knight = GameWindow.getKnight();
		knights = GameWindow.getKnights();
		KeyPressed keyPressed = KeyPressed.getInstance(); // Because we want to get a handle on the same KeyPressed
															// listener from multiple classes.
		keyPressed.AddObserver(this);
	}

	@Override
	public void update(KeyEvent e) {
		int i = 0;
		for (Sprite knight : knights) {
			if (i >= 5) {
				i = 0;
			}
			i++;

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
			} else if (e.getKeyCode() == KeyEvent.VK_X) {
				knight.move();
			} else {
				return;
			}

		}

	}

}
