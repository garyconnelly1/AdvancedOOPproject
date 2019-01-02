package ie.gmit.sw;

public class IsoConverter implements IsoConvertable{
	
	public static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;

	@Override
	public int getIsoX(int x, int y) {
		int rshift = (DEFAULT_VIEW_SIZE/2) - (TILE_WIDTH/2) + (x - y); //Pan camera to the right
		return (x - y) * (TILE_WIDTH/2) + rshift;
	}

	@Override
	public int getIsoY(int x, int y) {
		return (x + y) * (TILE_HEIGHT/2);
	}

	@Override
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
	}

}
