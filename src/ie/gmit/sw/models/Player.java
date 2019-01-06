package ie.gmit.sw.models;

import java.awt.image.BufferedImage;

/**
* Represents a Player object which inherits the functionality of Sprite.
* This object is a Singleton, meaning only one instance of Player can exist at a time.
*
* @author Gary Connlly
*/

public class Player extends Sprite {

	private static Player instance = null;

	public Player(String name, Point p) {
		super(name, p);
	}

	/**
	 * Creates a Player object using the name, Point and image array passed as 
	 * parameters.
	 * @param name
	 * @param p
	 * @param img
	 */
	
	private Player(String name, Point p, BufferedImage[] img) {
		super(name, p, img);

	}
	
	/**
	 * Checks if there is already an instance of this object, if there
	 * is, return it. If an instance does not exist create one using the given parameters.
	 * @param name
	 * @param p
	 * @return Player.
	 */
	public static Player getInstance(String name, Point p) {

		if (instance == null) {
			instance = new Player(name, p);
		}

		return instance;

	}
	
	/**
	 * Checks if there is already an instance of this object, if there
	 * is, return it. If an instance does not exist create one using the given parameters.
	 * @param name
	 * @param p
	 * @param img
	 * @return Player.
	 */
	public static Player getInstance(String name, Point p, BufferedImage[] img) {

		
		if (instance == null) {
			instance = new Player(name, p, img);
		}

		return instance;

	}
	
	/**
	 * Checks if there is already an instance of this object, if there
	 * is, return it. If an instance does not exist create one using the given parameters
	 * @return Player.
	 */

	public static Player getInstance() {
		
		if (instance != null) {
			return instance;
		} else {
			return null;
		}
	}

}
