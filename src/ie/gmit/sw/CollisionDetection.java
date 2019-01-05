package ie.gmit.sw;

import ie.gmit.sw.models.*;

public class CollisionDetection {
	
	private String potHole = "25";

	public CollisionDetection() {
	}

	public boolean detectCollision(Sprite player, Sprite knight) {
		if (player.getPointAsString().equals(knight.getPointAsString()) || player.getPointAsString().equals(potHole)) {
			return true;
		}
		else {
			return false;
		}

	}

}
