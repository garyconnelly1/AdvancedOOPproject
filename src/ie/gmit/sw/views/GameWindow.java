package ie.gmit.sw.views;

import java.awt.*;

import java.util.*;
import java.util.List;

import javax.swing.*;

import ie.gmit.sw.*;
import ie.gmit.sw.models.*;
import ie.gmit.sw.observers.*;
import ie.gmit.sw.properties.DefaultProperties;

public class GameWindow {
	 /*
	 * This matrix represents the isometric game model, with each number mapping to an
	 * image in the images/ground/ directory.
	 */
	
	
	private static GameView view;
	private static Sprite player;
	private KeyPressed keyListener;
	private static List<Sprite> knights = new ArrayList<Sprite>();
	private int[][] model = { 
			{ 1, 0, 0, 0, 0, 0 , 0, 0, 0, 2},
			{ 0, 1, 0, 0, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 2, 0, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 0, 1, 0, 0 , 0, 0, 0, 2},
			{ 2, 2, 2, 2, 1, 0 , 0, 0, 0, 2},
			{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1},
			{ 3, 3, 3, 3, 3, 3 , 1, 0, 0, 1},
			{ 3, 3, 3, 3, 3, 3 , 1, 0, 0, 0},
			{ 3, 3, 3, 3, 3, 3 , 1, 6, 6, 6},
			{ 3, 3, 3, 3, 3, 3 , 1, 7, 7, 7}
	};
	
	//This matrix is a representation of where objects (things) in the game are placed
	private int[][] objects = { 
			{ 0, 0, 0, 5, 5, 5 , 3, 5, 5, 0},
			{ 5, 0, 0, 0, 5, 5 , 5, 5, 5, 0},
			{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9},
			{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
			{ 0, 0, 0, 0, 1, 0 , 0, 5, 5, 0},
			{ 0, 0, 8, 0, 1, 0 , 0, 0, 5, 0},
			{ 0, 0, 3, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 3, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0}
	};
	
	public GameWindow() throws Exception {
		/*
		for(int i = 0; i < objects.length; i++) {
			for(int j = 0; j < objects[i].length; j++) {
				if(objects[i][j] == 8) {
					System.out.println(i + "  " + j);
				}
			}
			
		}*/
		initResources();
		
		view = new GameView(model, objects, player, knights);
		Dimension d = new Dimension(DefaultProperties.getDefaultViewSize(), DefaultProperties.getDefaultViewSize()/2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);
		
		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);
		f.addKeyListener(keyListener);
		f.setSize(1000, 1000);
		f.setLocation(100, 100);
		f.pack();
		f.setVisible(true);
	}
	
	// Simple Accessor method to access the game view.(Abstract this out later)
	public static GameView getView() {
		return view;
	}
	
	
	public static List<Sprite> getKnights(){
		return knights;
	}
	
	public void initResources() throws Exception {
		//objects[(int) (Math.random() * 10)][(int) (Math.random() * 10)] = 3;
		//objects[(int) (Math.random() * 10)][(int) (Math.random() * 10)] = 3;
		//objects[(int) (Math.random() * 10)][(int) (Math.random() * 10)] = 3;
		
		SpriteLoader spriteLoader = new SpriteLoader();
		player = spriteLoader.loadPlayer();
		System.out.println(player.getPointAsString());
		knights = spriteLoader.loadKnights(4);
		keyListener = KeyPressed.getInstance();
		
		new PlayerObserver();
		new KnightObserver();
	}
}