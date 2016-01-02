package pokemon;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Pokemon {
	private String name;
	private Image sprite;
	private int hp;
	
	public Pokemon() {
		name = "Bulbasaur";
		SpriteSheet ss = null;
		try {
			ss = new SpriteSheet(new Image("assets/img/sprites2.png"), 41, 41);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		sprite = ss.getSprite(0, 0);
		hp = 100;
	}
	
	public Pokemon(String n, int x, int y, int hp) {
		this.name = n;
		SpriteSheet ss = null;
		try {
			ss = new SpriteSheet(new Image("assets/img/sprites2.png"), 41, 41);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.sprite = ss.getSprite(x, y);
		this.hp = hp;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sprite
	 */
	public Image getSprite() {
		return sprite;
	}
	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	

}
