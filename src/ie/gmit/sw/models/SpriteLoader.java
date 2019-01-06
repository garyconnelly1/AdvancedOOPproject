package ie.gmit.sw.models;

import java.util.ArrayList;

/**
* Represents a Sprite loader in that other classes can use this to get Sprite objects.
*
* @author Gary Connlly
*/
import java.util.List;

import ie.gmit.sw.SpriteFactory;

public class SpriteLoader {

	private Sprite player;
	private ImageLoader loader;
	private List<Sprite> knights = new ArrayList<Sprite>();
	
	/**
	* Creates a new </code>Sprite Loader</code> object
	*
	*/
	
	public SpriteLoader() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes a Loader object to load the images.
	 * Initializes the player object by using the <code>getSprite()</code>
	 * method of the SpriteFactory.
	 * @throws Exception
	 */

	public void init() throws Exception {
		this.loader = new ImageLoader();
		this.player = SpriteFactory.getSprite("PLAYER", "Player 1", new Point(0, 0),
				loader.loadImages("./resources/images/sprites/default", null));
	}
	
	/**
	 * Method that returns the Sprite object that was loaded into the player variable.
	 * @return The Sprite that was loaded into the player variable.
	 */

	public Sprite loadPlayer() {
		return this.player;
	}
	
	/**
	 * Uses the SpriteFactory to add a specified number of Knight objects 
	 * into list and returns them.
	 * @param number of Knight objects to be added to the list.
	 * @return List of knight Sprites.
	 * @throws Exception
	 */

	public List<Sprite> loadKnights(int number) throws Exception {
		for (int i = 0; i <= number; i++) {
			knights.add(SpriteFactory.getSprite("KNIGHT", "Knight " + i,
					new Point((int) (Math.random() * 10), (int) (Math.random() * 10)),
					loader.loadImages("./resources/images/sprites/knight", null)));
		}
		return knights;
	}

}
