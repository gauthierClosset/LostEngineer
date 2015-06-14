package LostEngineer.Weapons;

import java.awt.Rectangle;

import LostEngineer.Ennemies.Ennemies;
import LostEngineer.Start.StartingGame;

public class Projectile {
	
	private int x, y, speedX;
	private static boolean visible;
	public static Rectangle r;
	
	public Projectile(int startX, int startY) {
		x = startX;
		y = startY;
		speedX = 3;
		visible = true;
		
		r = new Rectangle(0, 0, 0, 0);
	}
	

	public void update(){
		x += speedX;
		if (x > 800) {
		   visible = false;
		}
		
		r.setBounds(x, y, 10, 5);
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getSpeedX() {
		return speedX;
	}


	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}


	public boolean isVisible() {
		return visible;
	}


	public static void setVisible(boolean bVisible) {
		visible = bVisible;
	}
}
