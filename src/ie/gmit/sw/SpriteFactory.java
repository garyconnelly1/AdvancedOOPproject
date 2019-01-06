package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
* Factory class which is used to generate Sprite objects.
*
* @author Gary Connlly
*/


import java.util.HashMap;

import ie.gmit.sw.models.*;

public class SpriteFactory {

	private static String key;

	@SuppressWarnings("rawtypes")
	private static final HashMap knightMap = new HashMap();
	
	/**
	 * Creates a Sprite object when given a type, a name, a Point, and an image.
	 * @param type The String name type of the Sprite.
	 * @param name The name of the Sprite.
	 * @param p The Point object for the Sprite.
	 * @param img The image to be used for the Sprite.
	 * @return A Sprite Object.
	 */

	@SuppressWarnings("exports")
	public static Sprite getSprite(String type, String name, Point p, BufferedImage[] img) {

		if (type.equals("PLAYER")) {
			return Player.getInstance(name, p, img);
		} else if (type.equals("KNIGHT")) {
			return flyweightKnight(name, p, img);
		} else {
			return null;
		}

	}
	
	/**
	 * Creates a Sprite object when given a type, a name, a Point.
	 * @param type The String name type of the Sprite.
	 * @param name The name of the Sprite.
	 * @param p The Point object for the Sprite.
	 * @return A Sprite object.
	 */

	public static Sprite getSprite(String type, String name, Point p) {
		if (type.equals("PLAYER")) {
			return Player.getInstance(name, p);
		} else if (type.equals("KNIGHT")) {
			return new Knight(name, p);
		} else {
			return null;
		}

	}
	
	/**
	 * Creates a Sprite object when given a type.
	 * @param type The String name type of the Sprite.
	 * @return A Sprite object.
	 */

	public static Sprite getSprite(String type) {
		if (type.equals("PLAYER")) {
			return Player.getInstance();
		} else {
			return null;
		}

	}
	
	/**
	 * Utilizes a Flyweight design pattern to create Knight objects.
	 * If a Knight object already exists on the same point that was passed in as the parameter,
	 * a new one will not be created, saving memory and confusion for the player.
	 * @param name The name of the Sprite.
	 * @param p The Point object for the Sprite.
	 * @param img The image to be used for the Sprite.
	 * @return
	 */

	@SuppressWarnings("unchecked")
	private static Sprite flyweightKnight(String name, Point p, BufferedImage[] img) {
		key = Integer.toString(p.getX()) + Integer.toString(p.getY());
		Knight knight = (Knight) knightMap.get(key);

		if (knight == null) {
			knight = new Knight(name, p, img);
			knightMap.put(key, knight);
		}

		return knight;
	}

}
