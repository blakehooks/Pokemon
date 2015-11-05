package player;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	private static Player player;

	private String name;
	private Image sprite;
	private float x,y;
	
	private Player(float startX, float startY) {
		this.x = startX;
		this.y = startY;
		
		try {
			sprite = new Image("assets/img/pikachu.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Player getPlayer() {
		if (player == null) {
			player = new Player(1000, 650);
		}
		return player;
	}
	public void draw() {
		sprite.draw(x, y);
	}
	
	public void move(double dX, double dY) {
		x += dX;
		y += dY;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
