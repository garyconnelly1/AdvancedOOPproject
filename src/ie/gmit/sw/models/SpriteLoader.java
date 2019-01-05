package ie.gmit.sw.models;

import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.SpriteFactory;

public class SpriteLoader {

	private Sprite player;
	private ImageLoader loader;
	private List<Sprite> knights = new ArrayList<Sprite>();

	public SpriteLoader() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws Exception {
		this.loader = new ImageLoader();
		this.player = SpriteFactory.getSprite("PLAYER", "Player 1", new Point(0, 0),
				loader.loadImages("./resources/images/sprites/default", null));
	}

	public Sprite loadPlayer() {
		return this.player;
	}

	public List<Sprite> loadKnights(int number) throws Exception {
		for (int i = 0; i <= number; i++) {
			knights.add(SpriteFactory.getSprite("KNIGHT", "Knight " + i,
					new Point((int) (Math.random() * 10), (int) (Math.random() * 10)),
					loader.loadImages("./resources/images/sprites/knight", null)));
		}
		return knights;
	}

}
