package ie.gmit.sw;

import ie.gmit.sw.models.*;

public class CollisionDetection {

	public CollisionDetection() {
	}

	public void detectCollision(Sprite player, Sprite knight) {
		if (player.getPointAsString().equals(knight.getPointAsString())) {
			System.out.println("HIT!!");

		}

	}

}
