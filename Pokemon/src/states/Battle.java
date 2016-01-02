package states;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
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
		g.drawRect(0, (float) (gc.getHeight() * .79) - 1, (float) (gc.getWidth() * 0.75), (float) (gc.getHeight() * .21));
		g.drawRect((float) (gc.getWidth() * 0.75), (float) (gc.getHeight() * .79) - 1, (float) (gc.getWidth() * .25) - 1, (float) (gc.getHeight() * .21));
		
		//Draw Wild pokemon
		g.drawImage(wild.getSprite(), 900, 100);
		g.drawString(wild.getName(), 900 + trainerPokemon.getSprite().getWidth(), 100);
		
		//Mouse coordinates for positioning
		g.drawString("Mouse X: " + Mouse.getX(), 0, 100);
		g.drawString("Mouse Y: " + Mouse.getY(), 0, 150);
		
		
		
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
