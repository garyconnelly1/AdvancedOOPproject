package ie.gmit.sw.views;

/**
* Responsible for painting the view for the game..
*
* @author Gary Connlly
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.Timer;
import ie.gmit.sw.*;
import ie.gmit.sw.controllers.CollisionDetection;
import ie.gmit.sw.controllers.GameController;
import ie.gmit.sw.models.*;
import ie.gmit.sw.models.Point;
import ie.gmit.sw.properties.DefaultProperties;



 
public class GameView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 777L;

	// Composites.
	private ImageLoader loader;
	private IsoConverter converter;
	private Sprite player;
	private List<Sprite> knights = new ArrayList<Sprite>();
	private CollisionDetection collider;
	private boolean isCollided = false;
	private boolean gameOver = false;
	

	// Do we really need two models like this?
	private int[][] matrix;
	private int[][] things;

	private BufferedImage[] tiles; // Note that all images, including sprites, have dimensions of 128 x 64. This
									// make painting much simpler.
	private BufferedImage[] objects; // Taller sprites can be created, by using two tiles (head torso, lower body and
										// legs) and improve animations
	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK }; // This is a 2D representation

	private Timer timer; // Controls the repaint interval.
	private boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	/**
	 * Creates a GameView using the variables passed as parameters.
	 * @param matrix Array used to paint the ground.
	 * @param things Array used to paint the objects onto the ground.
	 * @param player The Player object.
	 * @param knights The Knight objects.
	 * @throws Exception
	 */
	public GameView(int[][] matrix, int[][] things, Sprite player, List<Sprite> knights) throws Exception {
		init();
		this.matrix = matrix;
		this.things = things;
		this.player = (Player)player;
		this.knights = knights;

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter
		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
		
		
	}
	
	/**
	 * Initializes the values that will be painted onto the scene.
	 * @throws Exception
	 */

	private void init() throws Exception {
		converter = new IsoConverter();
		loader = new ImageLoader();
		tiles = loader.loadImages("./resources/images/ground", tiles);
		objects = loader.loadImages("./resources/images/objects", objects);
		collider = new CollisionDetection();
	}

	/**
	 * Toggles the view between isometric and 2D.
	 */
	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	/**
	 * This is called each time the timer reaches zero.
	 */
	public void actionPerformed(ActionEvent e) { 
		/**
		 * If the game is over, stop the timer, meaning the view will stop getting painted,
		 * and inform he user accordingly.
		 */
		if(gameOver == true) {
			timer.stop();
			JOptionPane.showMessageDialog(null, "Congradulations, you win!", "Victory!!", JOptionPane.PLAIN_MESSAGE); // Add error box.
		} else if(!this.isCollided ) {
			/**
			 * If the player had not collided with anything, continue to repaint the scene.
			 */
			this.repaint();
		} else { 
			/**
			 * Meaning the player has lost the game, so stop the timer and inform the user accordingly.
			 */
			timer.stop();
			JOptionPane.showMessageDialog(null, "You lose. Please close the game and try again", "Ooops", JOptionPane.PLAIN_MESSAGE); // Add error box.
		}
		
	}

	/**
	 * Paint the view.
	 */
	public void paintComponent(Graphics g) { // This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		Point point2;
		
		/**
		 * Check if the player collides with any of the knights. If he does, set isCollided to true.
		 */
		for(Sprite knight: knights) {
			if(collider.detectCollision(player, knight) == true) {
				this.isCollided = true;
			}
		}
		
		/**
		 * If the win conditions are met, set the gameOver variable to true.
		 */
		if(GameController.winCondition(player) == true) {
			this.gameOver = true;
		}

		/**
		 * Draw the ground and objects.
		 */
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];

				if (imageIndex >= 0 && imageIndex < tiles.length) {
					// Paint the ground tiles
					if (isIsometric) {
						x1 = converter.getIsoX(col, row);
						y1 = converter.getIsoY(col, row);

						g2.drawImage(tiles[DefaultProperties.getDefaultImageIndex()], x1, y1, null);
						if (imageIndex > DefaultProperties.getDefaultImageIndex()) {
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					} else {
						x1 = col * DefaultProperties.getTileWidth();
						y1 = row * DefaultProperties.getTileHeight();
						if (imageIndex < cartesian.length) {
							g2.setColor(cartesian[imageIndex]);
						} else {
							g2.setColor(Color.WHITE);
						}

						g2.fillRect(x1, y1, DefaultProperties.getTileWidth(), DefaultProperties.getTileWidth());
					}

					/**
					 * Paint the object or things on the ground
					 */
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}

		/**
		 * Paint the player on the ground
		 */
		point = converter.getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
		
		/**
		 * Paint knights on the ground.
		 */
		for(Sprite knight: knights) {
			point2 = converter.getIso(knight.getPosition().getX(), knight.getPosition().getY());
			g2.drawImage(knight.getImage(), point2.getX(), point2.getY(), null);
		}
		
		
	}

}