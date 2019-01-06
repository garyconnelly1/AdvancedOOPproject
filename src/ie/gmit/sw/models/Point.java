package ie.gmit.sw.models;

/**
* Represents a Point that a Sprite can exist on.
*
* @author Gary Connlly
*/

public class Point {
	private int x;
	private int y;

	/**
	 * Creates a Point object using the x and y integer values passed as
	 * parameters.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return Point.
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the x coordinate.
	 * @return integer x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate of the Point.
	 * @param x The integer value for the coordinate.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Returns the y coordinate of the Point.
	 * @return y The integer value for the coordinate.
	 */

	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate for the Point.
	 * @param y The integer value for the coordinate.
	 */

	public void setY(int y) {
		this.y = y;
	}

}