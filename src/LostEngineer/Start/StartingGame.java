package LostEngineer.Start;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import LostEngineer.EcamShip.Spaceship;
import LostEngineer.Ennemies.IsipEngineer;
import LostEngineer.Weapons.Projectile;

public class StartingGame extends Applet implements Runnable, KeyListener {
	
	private Spaceship spaceship;
	private IsipEngineer isipship;
	private Graphics second;
	private URL spaceshipUrl, isipshipUrl;
	private Dimension windowSize;
	private Image image;
	
	public Image spaceshipImg;
	public Image isipShipImg;

	@Override
	public void init() {
		setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Space Lost Engineer");
        
        try {
        	spaceshipUrl = new URL(getDocumentBase(), "LostEngineer/Data/spaceship.png");
        	isipshipUrl = new URL(getDocumentBase(), "LostEngineer/Data/isip.png");
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        spaceshipImg = getImage(spaceshipUrl);
        isipShipImg = getImage(isipshipUrl);
	}
	
	@Override
	public void start() {
		spaceship = new Spaceship();
		isipship = new IsipEngineer(840, 240);
		
		Thread thread = new Thread(this);
        thread.start(); 
	}
	
	@Override
	public void stop() {
		
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void run() {
		while (true) {
			windowSize = this.getSize();
			spaceship.update(windowSize);
			
			ArrayList projectiles = spaceship.getProjectiles();
			for (int i = 0; i < projectiles.size(); i++) {
				Projectile p = (Projectile) projectiles.get(i);
				if (p.isVisible() == true) {
					p.update();
				} else {
					projectiles.remove(i);
				}
			}
				
			isipship.update();
			repaint();
	        try {
	            Thread.sleep(17);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		int spaceshipImgWidth = 0;
		int spaceshipImgHeight = 0;
		
		try {
			spaceshipImgWidth = ImageIO.read(spaceshipUrl).getWidth();
			spaceshipImgHeight = ImageIO.read(spaceshipUrl).getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList projectiles = spaceship.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = (Projectile) projectiles.get(i);
			g.setColor(Color.YELLOW);
			g.fillRect(p.getX(), p.getY(), 10, 5);
		}
		
		g.drawImage(spaceshipImg, spaceship.getCenterX() - spaceshipImgWidth/2, spaceship.getCenterY() - spaceshipImgHeight/2, this);
		
		g.drawImage(isipShipImg, isipship.getCenterX(), isipship.getCenterY(), this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
	   	case KeyEvent.VK_UP:
	   		spaceship.moveUp();
	   		break;

	   	case KeyEvent.VK_DOWN:
	   		spaceship.moveDown();
	   		break;

	   	case KeyEvent.VK_LEFT:
	   		spaceship.moveLeft();
	   		break;

	   	case KeyEvent.VK_RIGHT:
	   		spaceship.moveRight();
	   		break;

	   	case KeyEvent.VK_SPACE:
	   		spaceship.shoot();
	   		break;
	   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
        	spaceship.stop();
            break;

        case KeyEvent.VK_DOWN:
        	spaceship.stop();
            break;

        case KeyEvent.VK_LEFT:
        	spaceship.stop();
            break;

        case KeyEvent.VK_RIGHT:
        	spaceship.stop();
            break;

        case KeyEvent.VK_SPACE:
            break;

        }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
