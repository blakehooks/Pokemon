package states;


import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

import player.Player;
import pokemon.Move;
import pokemon.Pokedex;
import pokemon.Pokemon;

public class Battle extends BasicGameState {
	Player p = Player.getPlayer();
	Pokemon trainerPokemon;
	Pokemon wild;
	boolean exitBattle;
	boolean battleWon;
	Pokedex pokedex;
	Random rand;
	
	Rectangle box1, box2, box3, box4;
	Move move1, move2, move3, move4;
	
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
		
		//Set false each time the room is created to prevent infinite loop
		exitBattle = false;
		battleWon = false;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		
		
		//Draw my pokemon
		g.drawImage(trainerPokemon.getSprite(), 300, 400);
		g.drawString(trainerPokemon.getName() + "\nHP: " + trainerPokemon.getHp(), 300 + trainerPokemon.getSprite().getWidth(), 400);
		
		//Draw Wild pokemon
		g.drawImage(wild.getSprite(), 900, 100);
		g.drawString(wild.getName() + "\nHP: " + wild.getHp(), 900 + trainerPokemon.getSprite().getWidth(), 100);
		
		//Draw battle boxes
		g.drawRect(0, (float) (gc.getHeight() * .79) - 1, (float) (gc.getWidth() * 0.75), (float) (gc.getHeight() * .20));
		g.drawRect((float) (gc.getWidth() * 0.75), (float) (gc.getHeight() * .79) - 1, (float) (gc.getWidth() * .25) - 1, (float) (gc.getHeight() * .20));
		
		//Draw Pokemon Moves
		//g.drawString(trainerPokemon.getMoves()[0].getName(), 50, ((float) (gc.getHeight() * .79) + 10));
		
		
		
		//Move hitboxes
		box1 = new Rectangle(0, (float) ((gc.getHeight() * .79)),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));
		box2 = new Rectangle((float) (gc.getWidth() * 0.375), (float) ((gc.getHeight() * .79)),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));
		box3 = new Rectangle(0, (float) ((gc.getHeight() * .79)) + (float) (gc.getHeight() * .10),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));
		box4 = new Rectangle((float) (gc.getWidth() * 0.375), (float) ((gc.getHeight() * .79)) + (float) (gc.getHeight() * .10),(float) (gc.getWidth() * 0.375), (float) (gc.getHeight() * .10));

		move1 = trainerPokemon.getMoves()[0];
		move2 = trainerPokemon.getMoves()[1];
		move3 = trainerPokemon.getMoves()[2];
		move4 = trainerPokemon.getMoves()[3];
		
		g.drawString(move1.getName(), box1.getCenterX() - g.getFont().getWidth(move1.getName())/2, box1.getCenterY() - g.getFont().getHeight(move1.getName())/2);
		g.drawString(move2.getName(), box2.getCenterX() - g.getFont().getWidth(move2.getName())/2, box2.getCenterY() - g.getFont().getHeight(move2.getName())/2);
		g.drawString(move3.getName(), box3.getCenterX() - g.getFont().getWidth(move3.getName())/2, box3.getCenterY() - g.getFont().getHeight(move3.getName())/2);
		g.drawString(move4.getName(), box4.getCenterX() - g.getFont().getWidth(move4.getName())/2, box4.getCenterY() - g.getFont().getHeight(move4.getName())/2);
		
		
		
		
		//Mouse coordinates for positioning
		g.drawString("Mouse X: " + gc.getInput().getMouseX(), 0, 100);
		g.drawString("Mouse Y: " + gc.getInput().getMouseY(), 0, 150);
		
		if (battleWon) {
			g.drawString("YOU WIN!", 500, 500);
			if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
				exitBattle = true;
			}
		}
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		processInput(gc, delta);
		if (wild.getHp() <= 0) {
			battleWon = true;
		}
		if (exitBattle) {
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
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
		
		if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !battleWon) {
			if (box1.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
				wild.takeDamange(move1.getStrength());
			}
			if (box2.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
				wild.takeDamange(move2.getStrength());
			}
			if (box3.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
				wild.takeDamange(move3.getStrength());
			}
			if (box4.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
				wild.takeDamange(move4.getStrength());
			}
		}
	}

}
