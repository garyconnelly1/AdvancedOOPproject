package ie.gmit.sw.models;

import java.awt.image.BufferedImage;

/**
* Class that loads the required images from the resources folder and adds them to an array of Buffered images.
*
* @author Gary Connlly
*/
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageLoader {

	public ImageLoader() {}
	
	/**
	 * Uses the directory that was passed as a parameter to locate the images file, 
	 * and then proceeds to add each image in that file to the buffered image array.
	 * @param directory The location of the images file.
	 * @param img An array of buffered images to be added to.
	 * @return BufferedImage[] array.
	 * @throws Exception
	 */

	public BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {
		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}

}
