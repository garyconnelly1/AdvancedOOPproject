package ie.gmit.sw;

import javax.swing.JOptionPane;

/**
* The Runner class and access point for this application.
*
* @author Gary Connlly
*/

import ie.gmit.sw.views.GameWindow;

public class Runner {
	
	/**
	 * The main method and entry point for the application.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		/**
		 * Launches a thread that creates a GameWindow object to paint the graphical user interface.
		 * @throws Exception.
		 */
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { // Template method....
				try {
					/*
					 * ---------------------------------------- Control Keys
					 * ---------------------------------------- Use the arrow keys to move the
					 * player. Move Player: 'X' Toggle View: 'Z'
					 * ----------------------------------------
					 */

					new GameWindow();

				} catch (Exception e) {
					/**
					 * Launches an error window whenever the GUI fails to load.
					 */
					JOptionPane.showMessageDialog(null, "There was an Error launching the Game Window", "Error",
							JOptionPane.ERROR_MESSAGE); // Add error box.
					e.printStackTrace();
				}

			}
		});

	}
}