package ie.gmit.sw;

import ie.gmit.sw.models.*;

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
