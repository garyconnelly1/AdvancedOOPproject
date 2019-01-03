package ie.gmit.sw.views;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import ie.gmit.sw.*;
import ie.gmit.sw.models.*;
import ie.gmit.sw.models.Point;
import ie.gmit.sw.properties.DefaultProperties;


/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 777L;

	// Composites.
	private ImageLoader loader;
	private IsoConverter converter;
	private Sprite player;

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

	public GameView(int[][] matrix, int[][] things) throws Exception {
		init();
		this.matrix = matrix;
		this.things = things;

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter
		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	private void init() throws Exception {
		converter = new IsoConverter();
		loader = new ImageLoader();
		tiles = loader.loadImages("./resources/images/ground", tiles);
		objects = loader.loadImages("./resources/images/objects", objects);
		//player = Player.getInstance("Player 1", new Point(0, 0), loader.loadImages("./resources/images/sprites/default", null));
		player = SpriteFactory.getSprite("PLAYER","Player 1", new Point(0, 0), loader.loadImages("./resources/images/sprites/default", null));
	}

	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) { // This is called each time the timer reaches zero
		this.repaint();
	}

	public void paintComponent(Graphics g) { // This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;

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

					// Paint the object or things on the ground
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}

		// Paint the player on the ground
		point = converter.getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}

}