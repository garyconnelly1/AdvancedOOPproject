package ie.gmit.sw;

import ie.gmit.sw.models.*;

public class CollisionDetection {

	private String potHole = "25";
	private String fountain1 = "44";
	private String fountain2 = "45";

	public CollisionDetection() {
	}

	public boolean detectCollision(Sprite player, Sprite knight) {
		if (player.getPointAsString().equals(knight.getPointAsString()) || player.getPointAsString().equals(potHole)) {

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
