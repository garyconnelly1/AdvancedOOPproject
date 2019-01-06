package ie.gmit.sw;

/**
* Represents the different directions that an object can be facing.
*
* @author Gary Connlly
*/
public enum Direction {
	UP (0), 
	DOWN (1), 
	LEFT (2), 
	RIGHT (3);

	private final int orientation;
	
	/**
	 * Sets the direction based on the integer passed as a parameter.
	 * @param int orientation.
	 */

    private Direction(int orientation) {
        this.orientation = orientation;
    }
    
    /**
     * Returns the orientation int.
     * @return int orientation.
     */
    
    public int getOrientation() {
        return this.orientation;
    }
}