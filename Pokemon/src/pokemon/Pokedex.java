package pokemon;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Pokedex {
	ArrayList<Pokemon> pokedex;

	public Pokedex() {
		pokedex = new ArrayList<Pokemon>();
		loadPokedex();
	}
	
	public ArrayList<Pokemon> getPokedex() {
		return pokedex;
	}
	
	private void loadPokedex() {
		Scanner input = null;
		try {
			input = new Scanner(new File("assets/txt/pokedex.txt")) ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		while (input.hasNextLine()) {
			pokedex.add(processLine(input.nextLine()));
		}
		input.close();
	}
	
	private Pokemon processLine(String s) {
		SpriteSheet ss = null;
		try {
			ss = new SpriteSheet(new Image("assets/img/sprites2.png"), 41, 41);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		Scanner input = new Scanner(s);
		String name = input.next();
		int x = input.nextInt();
		int y = input.nextInt();
		int hp = input.nextInt();
		
		Pokemon p = new Pokemon(name, x, y, hp);
		
		input.close();
		
		return p;
	}

}
