package LostEngineer.Ennemies;

import java.awt.Rectangle;

import LostEngineer.EcamShip.Spaceship;
import LostEngineer.Start.StartingGame;

public class Ennemy {
	
	public int health;
	private int power;
	private int speedX = -1;
	private int centerX; 
	private int centerY;
	
	//71-45
	public static Rectangle rect = new Rectangle(0, 0, 0, 0);
	
	public void update() {
		rect.setRect(centerX+3, centerY, 68, 45);
		centerX += speedX;
		if (rect.intersects(Spaceship.rect)){
			checkCollision();
		}
	}

	public void die() {
		
	}
		
	public void attack() {
		
	}
	
	public void checkCollision(){
    	if (rect.intersects(Spaceship.rect)){
    		System.out.println("Collision Ennemy!");
    	}
    }

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	public int getHealth() {
		return centerY;
	}

	public void setHealth(int healthpoints) {
		this.health = healthpoints;
	}

}
