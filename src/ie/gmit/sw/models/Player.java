package ie.gmit.sw.models;

import java.awt.image.BufferedImage;

public class Player extends Sprite {

	private static Player instance = null;

	public Player(String name, Point p) {
		super(name, p);
	}

	public Player(String name, Point p, BufferedImage[] img) {
		super(name, p, img);

	}

	public static Player getInstance(String name, Point p) {

		if (instance == null) {
			instance = new Player(name, p);
		}

		return instance;

	}

	public static Player getInstance(String name, Point p, BufferedImage[] img) {

		
		if (instance == null) {
			instance = new Player(name, p, img);
		}

		return instance;

	}

	public static Player getInstance() {
		
		if (instance != null) {
			return instance;
		} else {
			return null;
		}
	}

}
