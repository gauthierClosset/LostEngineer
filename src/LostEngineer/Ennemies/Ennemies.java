package LostEngineer.Ennemies;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import LostEngineer.EcamShip.Spaceship;
import LostEngineer.Start.StartingGame;
import LostEngineer.Weapons.Projectile;

public class Ennemies {
	
	private static ArrayList<IsipEngineer> isipShips = new ArrayList<IsipEngineer>();
	
	//private static ArrayList<Rectangle> rectangles = new ArrayList<Rectangle> ();
	
	public void createIsipship() {
		Random randomGenerator = new Random();
		int posX = 840;
		int randomPosY = randomGenerator.nextInt(480); 
		IsipEngineer isipEngineer = new IsipEngineer(posX, randomPosY);
		isipShips.add(isipEngineer);
		//rectangles.add(isipEngineer.r);
	}
	
	public static ArrayList getIsipShips() {
		return isipShips;
	}
	
	/*public static ArrayList getRectangles() {
		return rectangles;
	}*/
}
