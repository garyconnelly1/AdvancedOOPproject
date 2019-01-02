package ie.gmit.sw;

public class IsoConverter implements IsoConvertable{
	
	
	@Override
	public int getIsoX(int x, int y) {
		int rshift = (DefaultProperties.getDefaultViewSize()/2) - (DefaultProperties.getTileWidth()/2) + (x - y); //Pan camera to the right
		return (x - y) * (DefaultProperties.getTileWidth()/2) + rshift;
	}

	@Override
	public int getIsoY(int x, int y) {
		return (x + y) * (DefaultProperties.getTileHeight()/2);
	}

	@Override
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
	}

}
