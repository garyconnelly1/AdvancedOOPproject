package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import ie.gmit.sw.models.*;

public class SpriteFactory {
	
	private static String key;
	
	@SuppressWarnings("rawtypes")
	private static final HashMap knightMap = new HashMap();

	public static Sprite getSprite(String type, String name, Point p, BufferedImage[] img) {

		if (type.equals("PLAYER")) {
			return Player.getInstance(name, p, img);
		} else if (type.equals("KNIGHT")) {
			return new Knight(name, p, img);
		} else {
			return null;
		}

	}

	public static Sprite getSprite(String type, String name, Point p) {
		if (type.equals("PLAYER")) {
			return Player.getInstance(name, p);
		} else if (type.equals("KNIGHT")) {
			return new Knight(name, p);
		} else {
			return null;
		}

	}

	public static Sprite getSprite(String type) {
		if (type.equals("PLAYER")) {
			return Player.getInstance();
		} else {
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	public static Sprite flyweightKnight(String name, Point p, BufferedImage[] img) {
		key = Integer.toString(p.getX()) + Integer.toString(p.getY());
		Knight knight = (Knight)knightMap.get(key);
		System.out.println(key);
		
		if(knight == null) {
			System.out.println("DEBUG: knight was null.");
			knight = new Knight(name, p, img); 
			knightMap.put(key,knight);
		}
		System.out.println(knightMap.size());
		
		return knight;
	}

}
