package states;


import java.awt.Color;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import player.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;

public class Battle extends BasicGameState {
	Player p = Player.getPlayer();
	Pokemon trainerPokemon;
	Pokemon wild;
	boolean exitBattle;
	Pokedex pokedex;
	Random rand;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		pokedex = new Pokedex();
		
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rand = new Random();
		int pokeID = rand.nextInt(pokedex.getPokedex().size());
		wild = pokedex.getPokedex().get(pokeID);
		
		trainerPokemon = p.getFirstInParty();
		
		//Set false each time the room is created to prevet infinite loop
		exitBattle = false;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		
		
		//Draw my pokemon
		g.drawImage(trainerPokemon.getSprite(), 300, 400);
		g.drawString(trainerPokemon.getName(), 300 + trainerPokemon.getSprite().getWidth(), 400);
		
		//Draw battle boxes
		g.drawRect(0, (float) (gc.getHeight() * .79) - 1, (float) (gc.getWidth() * 0.75), (float) (gc.getHeight() * .20));
		g.drawRect((float) (gc.getWidth() * 0.75), (float) (gc.getHeight() * .79) - 1, (float) (gc.getWidth() * .25) - 1, (float) (gc.getHeight() * .20));
		
		//Draw Pokemon Moves
		//g.drawString(trainerPokemon.getMoves()[0].getName(), 50, ((float) (gc.getHeight() * .79) + 10));
		
		
		
		//Move hitboxes
		Rectangle box1 = new Rectangle(0, (float) ((gc.getHeight() * .79)),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));
		Rectangle box2 = new Rectangle((float) (gc.getWidth() * 0.375), (float) ((gc.getHeight() * .79)),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));
		Rectangle box3 = new Rectangle(0, (float) ((gc.getHeight() * .79)) + (float) (gc.getHeight() * .10),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));
		Rectangle box4 = new Rectangle((float) (gc.getWidth() * 0.375), (float) ((gc.getHeight() * .79)) + (float) (gc.getHeight() * .10),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));

		String move1 = trainerPokemon.getMoves()[0].getName();
		String move2 = trainerPokemon.getMoves()[1].getName();
		String move3 = trainerPokemon.getMoves()[2].getName();
		String move4 = trainerPokemon.getMoves()[3].getName();
		
		g.drawString(move1, box1.getCenterX() - g.getFont().getWidth(move1)/2, box1.getCenterY() - g.getFont().getHeight(move1)/2);
		g.drawString(move2, box2.getCenterX() - g.getFont().getWidth(move2)/2, box2.getCenterY() - g.getFont().getHeight(move2)/2);
		g.drawString(move3, box3.getCenterX() - g.getFont().getWidth(move3)/2, box3.getCenterY() - g.getFont().getHeight(move3)/2);
		g.drawString(move4, box4.getCenterX() - g.getFont().getWidth(move4)/2, box4.getCenterY() - g.getFont().getHeight(move4)/2);
		
		if (box1.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
			g.drawString("HIT 111", 125, 125);
		}
		if (box2.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
			g.drawString("HIT 222", 125, 125);
		}
		if (box3.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
			g.drawString("HIT 333", 125, 125);
		}
		if (box4.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
			g.drawString("HIT 444", 125, 125);
		}
		//Draw Wild pokemon
		g.drawImage(wild.getSprite(), 900, 100);
		g.drawString(wild.getName(), 900 + trainerPokemon.getSprite().getWidth(), 100);
		
		//Mouse coordinates for positioning
		g.drawString("Mouse X: " + gc.getInput().getMouseX(), 0, 100);
		g.drawString("Mouse Y: " + gc.getInput().getMouseY(), 0, 150);
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		processInput(gc, delta);
		if (exitBattle) {
			sbg.enterState(2);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	public void processInput(GameContainer gc, int delta) {		
		if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {
			exitBattle = true;
		}
	}

}
