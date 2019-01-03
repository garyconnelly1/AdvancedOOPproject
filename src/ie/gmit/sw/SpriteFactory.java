package ie.gmit.sw;

import java.awt.image.BufferedImage;

public class SpriteFactory {

	public static Sprite getSprite(String type, String name, Point p, BufferedImage[] img) {

		if (type.equals("PLAYER")) {
			return Player.getInstance(name, p, img);
		} else {
			return null;
		}

	}
	
	public static Sprite getSprite(String type, String name, Point p) {
		if(type.equals("PLAYER")) {
			return Player.getInstance(name, p);
		}
		else {
			return null;
		}
		
	}

	public static Sprite getSprite(String type) {
		if (type.equals("PLAYER")) {
			return Player.getInstance();
		} else {
			return null;
		}

	}

}
