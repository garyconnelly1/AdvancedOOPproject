package ie.gmit.sw;

import java.awt.event.KeyEvent;

public class PlayerObserver implements KeyObserver{
	
	public PlayerObserver() {
		
		//Sprite player = new Sprite();
		KeyPressed keyPressed = new KeyPressed();
		keyPressed.AddObserver(this);
		
	}

	@Override
	public void update(KeyEvent e) {
		
		
	}
	

}
