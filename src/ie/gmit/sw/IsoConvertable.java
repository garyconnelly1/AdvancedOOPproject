package ie.gmit.sw;

/*
 * Interface that allows any class to add an their own 
 * implementation of isometric conversions.  
 */

public interface IsoConvertable {
	
	public int getIsoX(int x, int y);
	
	public int getIsoY(int x, int y);
	
	public Point getIso(int x, int y);

}
