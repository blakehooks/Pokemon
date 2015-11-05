package player;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	private Image sprite;
	private float x,y;
	
	public Player(float startX, float startY) {
		this.x = startX;
		this.y = startY;
		
		try {
			sprite = new Image("assets/img/pikachu.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw() {
		sprite.draw(x, y);
	}
	
	public void move(double dX, double dY) {
		x += dX;
		y += dY;
	}

}
