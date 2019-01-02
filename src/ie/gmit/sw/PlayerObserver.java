package ie.gmit.sw;

import java.awt.event.KeyEvent;

public class PlayerObserver implements KeyObserver{
	
	private Sprite player;
	//private boolean isIsometric = true; //Toggle between 2D and Isometric (Z key)
	private GameView view;
	
	public PlayerObserver() {
		
		player = Player.getInstance();
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
			view = GameWindow.getView();
			view.toggleView();
			System.out.println("Toggle View");
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else {
			return;
		}
		
		
	}
	

}
