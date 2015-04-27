package LostEngineer.Ennemies;

public class Boss {

	private int maxHealth;
	private int currentHealth; 
	private int power;
	private int speedY = -1;
	private int centerX; 
	private int centerY;
	
	public void update() {
		centerY += speedY;
	}
}
