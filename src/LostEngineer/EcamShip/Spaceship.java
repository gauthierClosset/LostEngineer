package LostEngineer.EcamShip;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import LostEngineer.Ennemies.Ennemies;
import LostEngineer.Start.StartingGame;
import LostEngineer.Start.StartingGame.GameState;
import LostEngineer.Weapons.Projectile;

public class Spaceship {

		// x, y : Coordinates of the spaceship's center.
		private int centerX = 50;
		private static int centerY = 240;
		
		// speedX, speedY : Rate at which x and y positions change.
		private int speedX = 0;
		private int speedY = 0;
		
		public static int health = 2;
		
		// gameWidth : Width of the game screen
		private int gameScreenWidth = 0;
		
		// projectiles : Array of 
		private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
		
		public static Rectangle rect = new Rectangle(0, 0, 0, 0);
		
		// jumped : Fire at false state by default.
		private boolean jumped = false;
		
		public void update(Dimension dimension) {
			
			gameScreenWidth = dimension.width;
					
			// Move spaceship and update position.
			if (speedX < 0 || speedX > 0) {
				centerX += speedX;
			} else if (speedY < 0 || speedY > 0) {
				centerY += speedY;
			} else {
				//DO NOTHING
			}

			// Prevents spaceship going out of the screen
			if (centerX + speedX <= 50) {
				centerX = 50;
			} else if (centerX + speedX >= gameScreenWidth - 10) {
				centerX = gameScreenWidth - 10;
			}
			
			// 76 - 54
			rect.setRect(centerX-38, centerY-27, 70, 50);
		}

		public void moveRight() {
			speedX = 2;
		}

		public void moveLeft() {
			speedX = -2;
		}

		public void stop() {
			speedX = 0;
			speedY = 0;
		}
		
		public void moveUp() {
			speedY = -4;
		}

		public void moveDown() {
			speedY = 4;
		}
		
		public void shoot() {
				Projectile p = new Projectile(centerX + 10, centerY - 10);
				projectiles.add(p);
		}
		
		public static ArrayList getProjectiles() {
			return projectiles;
		}

		public int getCenterX() {
			return centerX;
		}

		public void setCenterX(int centerX) {
			this.centerX = centerX;
		}

		public static int getCenterY() {
			return centerY;
		}

		public void setCenterY(int centerY) {
			this.centerY = centerY;
		}

		public int getSpeedX() {
			return speedX;
		}

		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}

		public int getSpeedY() {
			return speedY;
		}

		public void setSpeedY(int speedY) {
			this.speedY = speedY;
		}
}
