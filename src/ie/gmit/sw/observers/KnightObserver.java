package ie.gmit.sw.observers;

import java.awt.event.KeyEvent;

import ie.gmit.sw.Direction;
import ie.gmit.sw.KeyPressed;
import ie.gmit.sw.models.*;
import ie.gmit.sw.views.GameWindow;

public class KnightObserver implements KeyObserver{
	
	private Sprite knight;
	
	public KnightObserver() {
		knight = GameWindow.getKnight();
		KeyPressed keyPressed = KeyPressed.getInstance(); // Because we want to get a handle on the same KeyPressed listener from multiple classes.
		keyPressed.AddObserver(this);
	}

	@Override
	public void update(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			knight.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			knight.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			knight.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			knight.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			knight.move();
		} else {
			return;
		}
		
	}

}
