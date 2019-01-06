package ie.gmit.sw.controllers;

import ie.gmit.sw.models.*;

/**
* Class that checks if the win coditions for the game have been met.
*
* @author Gary Connlly
*/

public class GameController {

	private static String chest1 = "60";
	private static boolean hitChest1 = false;
	private static String chest2 = "26";
	private static boolean hitChest2 = false;
	private static String chest3 = "78";
	private static boolean hitChest3 = false;
	private static String compare;
	private static int chestCount = 0;
	private static boolean isWon = false;
	private static String endPoint = "92";

	public GameController() {
	}
	
	/**
	 * If the player has hit a chest, a boolean is set indicating that that chest has been hit.
	 * If it has already been hit, it does not add to the players count.
	 * Once the player has a count of greater than or equal to 2, and the player
	 * hits the end point, the isWon variable will be set to <code>true</code> meaning that
	 * the game is over.
	 * @param player
	 * @return
	 */

	public static boolean winCondition(Sprite player) {
		compare = player.getPointAsString();
		if (compare.equals(chest1) && hitChest1 == false) {
			hitChest1 = true;
			chestCount++;
		} else if (compare.equals(chest2) && hitChest2 == false) {
			hitChest2 = true;
			chestCount++;
		} else if (compare.equals(chest3) && hitChest3 == false) {
			hitChest2 = true;
			chestCount++;
		} else if (compare.equals(endPoint) && chestCount >= 2) {
			isWon = true;
		}

		if (isWon == true) {
			return true;
		} else {
			return false;
		}
	}

}
