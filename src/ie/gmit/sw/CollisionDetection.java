package ie.gmit.sw;

import ie.gmit.sw.models.*;

public class CollisionDetection {

	public CollisionDetection() {
	}

	public boolean detectCollision(Sprite player, Sprite knight) {
		if (player.getPointAsString().equals(knight.getPointAsString())) {
			return true;
		}
		else {
			return false;
		}

	}

}
