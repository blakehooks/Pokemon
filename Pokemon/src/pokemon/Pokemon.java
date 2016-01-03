package pokemon;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Pokemon {
	private String name;
	private Image sprite;
	private int hp;
	private Move[] moves;
	
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
		moves = new Move[4];
		moves[0] = new Move("Tackle", 20, 20, new Type("Normal"));
		moves[1] = new Move("Quick Attack", 20, 5, new Type("Normal"));
		moves[2] = new Move("Punch", 0, 10, new Type("Normal"));
		moves[3] = new Move("Double Kick", 0, 30, new Type("Fighting"));
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
		moves = new Move[4];
		moves[0] = new Move("Tackle", 20, 20, new Type("Normal"));
		moves[1] = new Move("Quick Attack", 20, 5, new Type("Normal"));
		moves[2] = new Move("Punch", 0, 10, new Type("Normal"));
		moves[3] = new Move("Double Kick", 0, 30, new Type("Fighting"));
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
	
	/**
	 * Take damage from a move or other affliction
	 * @param hp hp to remove
	 */
	public void takeDamange(int hp) {
		if (this.hp - hp < 0) {
			this.hp = 0;
		} else {
			this.hp -= hp;
		}
	}
	
	/**
	 * Heal up
	 * @param hp hp to add
	 */
	public void heal(int hp) {
		this.hp += hp;
	}
	
	/**
	 * Get moveset
	 */
	public Move[] getMoves() {
		return moves;
	}
	
	
	
	

}
