package LostEngineer.Weapons;

import java.awt.Rectangle;

import LostEngineer.Start.StartingGame;



public class Projectile {
	
	private int x, y, speedX;
	private boolean visible;
	private Rectangle r;
	
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
		   //r=null;
		}
		
		r.setBounds(x, y, 10, 5);
		
		if(x <= 800){
			checkCollision();
		}
	}
	
	public void checkCollision() {
		if(r.intersects(StartingGame.isipship.rect)){
			visible = false;
			StartingGame.score += 1;
			
			if (StartingGame.isipship.health > 0) {
				StartingGame.isipship.health -= 1;
			}
			if (StartingGame.isipship.health == 0) {
				//StartingGame.isipship.die();
				StartingGame.isipship.setCenterX(-100);
				StartingGame.score += 5;
			}
		}
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


	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
