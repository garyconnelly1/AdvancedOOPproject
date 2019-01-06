package ie.gmit.sw;

import ie.gmit.sw.models.*;

/**
* Is an implementation of the IsoConvertable interface.
*
* @author Gary Connlly
*/
import ie.gmit.sw.properties.DefaultProperties;

public class IsoConverter implements IsoConvertable{
	
	/**
	 * Returns an integer representation of of the X value based on
	 * the x and why values passed as parameters.
	 * @param int x.
	 * @param int y.
	 * @return 
	 */
	
	@Override
	public int getIsoX(int x, int y) {
		int rshift = (DefaultProperties.getDefaultViewSize()/2) - (DefaultProperties.getTileWidth()/2) + (x - y); 
		return (x - y) * (DefaultProperties.getTileWidth()/2) + rshift;
	}
	
	/**
	 * Returns an integer representation of of the Y value based on
	 * the x and why values passed as parameters.
	 * @param int x.
	 * @param int y.
	 * @return 
	 */

	@Override
	public int getIsoY(int x, int y) {
		return (x + y) * (DefaultProperties.getTileHeight()/2);
	}
	
	/**
	 * Returns a Point object using the x and y integers passed as parameters
	 * to construct the Point.
	 * @param int x value.
	 * @param int y value.
	 * @return a Point object.
	 */

	@SuppressWarnings("exports")
	@Override
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); 
	}

}
