package ie.gmit.sw;

import ie.gmit.sw.models.*;

/**
* Interface that allows any class to add an their own 
* implementation of isometric conversions.  
*
* @author Gary Connlly
*/



public interface IsoConvertable {
	
	
	
	public int getIsoX(int x, int y);
	
	public int getIsoY(int x, int y);
	
	@SuppressWarnings("exports")
	public Point getIso(int x, int y);

}
