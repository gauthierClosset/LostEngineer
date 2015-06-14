package LostEngineer.Ennemies;

import java.awt.Rectangle;
import java.util.ArrayList;

import LostEngineer.EcamShip.Spaceship;
import LostEngineer.Start.StartingGame;
import LostEngineer.Weapons.Projectile;

public class IsipEngineer {
	
	public int health = 2;
	private int speedX = -1;
	private int centerX; 
	private int centerY;
	private boolean visible;
	private int movementSpeed;
	public static Rectangle r = new Rectangle(0, 0, 0, 0);
	
	public IsipEngineer(int X, int Y) {
		centerX = X;
		centerY = Y;
		health = 2;
		visible = true;
	}
	
	public void update(int i) {
		//follow();
		//centerY += movementSpeed;
		centerX += speedX;
		checkCollision(i);
		r.setBounds(centerX, centerY, 68, 45);
		
	}
	
	public static void checkCollision(int i){
		IsipEngineer isipship = (IsipEngineer) Ennemies.getIsipShips().get(i);
		Rectangle rect = isipship.r;
    	if (rect.intersects(Spaceship.rect)){
    		System.out.println("Collision Ennemy!");
    		Spaceship.health = 0;
    	} /*else if((Projectile.r.intersects(rect))) {
    		Projectile.setVisible(false);
			StartingGame.score += 1;
			
			if (isipship.health > 0) {
				isipship.health += -1;
			
			} else if (isipship.health == 0) {
				isipship.setCenterX(-100);
				StartingGame.score += 5;
				isipship.setVisible(false);
			}
    	}*/ else {
    		// DO NOTHING
    		//for(Projectile projectile : );
    		ArrayList<Projectile> projectiles = Spaceship.getProjectiles();
    		for(Projectile projectile : projectiles) {
    			if(projectile.r.intersects(rect)) {
    				Projectile.setVisible(false);
    				StartingGame.score += 1;
    				if (isipship.health > 0) {
    					isipship.health += -1;
    				} else if (isipship.health == 0) {
    					isipship.setCenterX(-100);
    					StartingGame.score += 5;
    					isipship.setVisible(false);
    				}
    			}
    		}
    	}
    }
	
	public void follow() {
		if (Spaceship.getCenterY() > centerY) {
			movementSpeed = 1;
		} else if (Spaceship.getCenterY() < centerY){
			movementSpeed = -1;
		} else {
			movementSpeed = 0;
		}
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean bVisible) {
		this.visible = bVisible;
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
	
}
