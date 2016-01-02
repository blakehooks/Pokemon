package player;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import items.Item;
import items.ItemList;
import pokemon.Pokemon;

public class Player {
	private static Player player;

	private ArrayList<Pokemon> party = new ArrayList<Pokemon>();
	private String name;
	private Image sprite;
	private float x,y;
	private ItemList bag;
	
	private Player(float startX, float startY) {
		this.x = startX;
		this.y = startY;
		Pokemon bulb = new Pokemon();
		party.add(bulb);
		
		try {
			sprite = new Image("assets/img/pikachu.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		bag = new ItemList();
		bag.getItems().add(new Item("Potion", 5));
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
	
	public Pokemon getFirstInParty() {
		return party.get(0);
	}
	
	public ItemList getBag() {
		return bag;
	}

}
