package ie.gmit.sw.models;

import java.awt.image.BufferedImage;

/**
* Represents a Knight object which inherits the functionality of Sprite.
*
* @author Gary Connlly
*/

public class Knight extends Sprite{
	
	/**
	 * Creates a Knight object using a name and a Point object passed
	 * as parameters.
	 * @param name The name of the knight.
	 * @param p The Point object for that knight.
	 * @return Knight object.
	 */
	public Knight(String name, Point p) {
		super(name, p);
	}
	
	/**
	 * Creates a Knight object using a name, a Point, and an image array object passed
	 * as parameters.
	 * @param name The name of the knight.
	 * @param p The Point object for that knight.
	 * @param img The image array for that knight.
	 * @return Knight object.
	 */
	
	public Knight(String name, Point p, BufferedImage[] img) {
		super(name, p, img);

	}

}
