package ie.gmit.sw.controllers;

import ie.gmit.sw.models.*;

/**
* Class used to detect if the player collides with a Knight or other game objects..
*
* @author Gary Connlly
*/

public class CollisionDetection {

	private String potHole = "25";
	private String fountain1 = "44";
	private String fountain2 = "45";

	public CollisionDetection() {
	}
	/**
	 * Uses the <code>getPointAsString()</code> method of the Sprites to get the String representation
	 * of the Sprites position. The using those values compares them to see if they equal each other or
	 * the position of other game objects. 
	 * @param player
	 * @param knight
	 * @return <code>true</code> or <code>false</code> value depending on whether the player has hit something.
	 */

	public boolean detectCollision(Sprite player, Sprite knight) {
		/**
		 * If the player hits a Knight or the pot hole.
		 */
		if (player.getPointAsString().equals(knight.getPointAsString()) || player.getPointAsString().equals(potHole)) {

			/**
			 * If the player is not located in one of the fountains.
			 */
			if (player.getPointAsString().equals(fountain1) || player.getPointAsString().equals(fountain2)) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}

	}

}
