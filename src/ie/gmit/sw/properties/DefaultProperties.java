package ie.gmit.sw.properties;

/**
* Sets any default values that are to be used throughout the game.
*
* @author Gary Connlly
*/



public class DefaultProperties {

	private static int DEFAULT_IMAGE_INDEX = 0;
	private static int DEFAULT_VIEW_SIZE = 1280;
	private static int TILE_WIDTH = 128;
	private static int TILE_HEIGHT = 64; 
	
	public DefaultProperties() {}
	
	/**
	 * Returns the integer for the default image index.
	 * @return int DEFAULT_IMAGE_INDEX.
	 */
	public static int getDefaultImageIndex() {
		return DEFAULT_IMAGE_INDEX;
	}
	
	/**
	 * Returns the integer for the default view size.
	 * @return int DEFAULT_VIEW_SIZE.
	 */

	public static int getDefaultViewSize() {
		return DEFAULT_VIEW_SIZE;
	}

	/**
	 * Returns the integer for the tile width.
	 * @return int TILE_WIDTH.
	 */
			
	public static int getTileWidth() {
		return TILE_WIDTH;
	}
	
	/**
	 * Returns the integer for the tile height.
	 * @return int TILE_HEIGHT.
	 */

	public static int getTileHeight() {
		return TILE_HEIGHT;
	}
}

/*
public static void loadProperties() {
	//String rootPath = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
	//String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	//String appConfigPath = rootPath + "app.properties";
	
	Properties appProps = new Properties();
	
	try {
		//appProps.load(new FileInputStream(rootPath));
		appProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	tempProperty =  appProps.getProperty("DEFAULT_IMAGE_INDEX");
	DEFAULT_IMAGE_INDEX = Integer.parseInt(tempProperty);
	
	tempProperty =  appProps.getProperty("DEFAULT_VIEW_SIZE");
	DEFAULT_VIEW_SIZE =  Integer.parseInt(tempProperty);
	
	tempProperty =  appProps.getProperty("TILE_WIDTH");
	TILE_WIDTH =  Integer.parseInt(tempProperty);
	
	tempProperty =  appProps.getProperty("TILE_HEIGHT");
	TILE_HEIGHT =  Integer.parseInt(tempProperty);
	
	
}
*/
