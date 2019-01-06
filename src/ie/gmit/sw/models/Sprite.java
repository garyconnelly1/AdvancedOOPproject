package ie.gmit.sw.models;

/*
 *   
 *   BufferedImage[][]
 *   --------------------------
 *   {U0, U1, U2, U3}, =>Up
 *   {D0, D1, D2, D3}, =>Down
 *   {L0, L1, L2, L3}, =>Left
 *   {R0, R1, R2, R3}, =>Right
 * 
 */

/**
* Represents a Sprite object and is a superclass for Player and Knight.
*
* @author Gary Connlly
*/

import java.awt.image.*;
import ie.gmit.sw.*;

public class Sprite {
	private String name; 
	private BufferedImage[][] images = new BufferedImage[4][3]; 
	private Direction direction = Direction.DOWN; 
	private int index = 0; 
	private Point position; 
	private String coordinate;
	
	/**
	 * Creates a Sprite object using the parameterized values.
	 * @param name The name for the Sprite.
	 * @param p The Point for the Sprite.
	 */
	
	public Sprite(String name, Point p) {
		super();
		this.name = name;
		this.position = p;
	}
	
	/**
	 * Creates a Sprite object using the parameterized values.
	 * @param name The name for the Sprite.
	 * @param p The Point for the Sprite.
	 * @param img The image array for the Sprite.
	 */
	
	public Sprite(String name, Point p, BufferedImage[] img) {
		this(name, p);
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++) {
			images[row][col] = img[i];
			if (col == images[row].length - 1) {
				row++;
				col = 0;
			}else {
				col++;
			}
		}
	}
	
	/**
	 * Returns the name of the Sprite.
	 * @return name String name for the Sprite.
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Returns the Point the Sprite is on.
	 * @return position Point.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Returns the buffered image for the Sprite.
	 * @return Buffered image.
	 */
	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}
	
	
	/**
	 * Returns the image for the Sprite taking a step in the specified direction
	 * by looping through the array of Sprite images to find the one corresponding with the
	 * given direction. 
	 * @param d The direction the Sprite is facing.
	 * @return Buffered image of the Sprite.
	 */
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		}else {
			index = 0;
		}
		
		return images[d.getOrientation()][index];
	}
	
	/**
	 * Sets the direction for the Sprite.
	 * @param d The enumeration direction for the Sprite.
	 */
	public void setDirection(Direction d) {
		direction = d;
	}
	
	/**
	 * Returns the Sprite direction.
	 * @return Direction enumeration.
	 */
	
    public Direction getDirection() {
        return this.direction;
    }
    
    /**
     * Method for controlling how the Sprite moves.
     * Uses the direction of the Sprite to change the point that the Sprite is standing on,
     * giving the illusion of movement.
     */
	
	public void move() { 
		step(direction);
		switch(direction.getOrientation()) {
		case 1:
			if(position.getY() + 1 < 10)
				position.setY(position.getY() + 1); //UP
			break;
		case 2:
			if(position.getX() - 1 > -1)
				position.setX(position.getX() - 1); //DOWN
			break;
		case 3:
			if(position.getX() + 1 < 10)
				position.setX(position.getX() + 1); //LEFT
			break;
		default:
			if(position.getY() - 1 > -1)
				position.setY(position.getY() - 1); //RIGHT
			break;
		}
	}
	
	/**
	 * Returns a String representation of the Sprite Point.
	 * This makes it easier to compare Sprite positions to check for collisions.
	 * @return Players point as a String.
	 */
	public String getPointAsString() {
		
		coordinate = Integer.toString(position.getX()) + Integer.toString(position.getY());
		
		return coordinate;
	}
}