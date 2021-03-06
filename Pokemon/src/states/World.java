package states;

import java.util.Random;

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
import pokemon.Pokemon;

public class World extends BasicGameState {
	Player player = Player.getPlayer();
	Image wild;
	boolean startBattle;
	
	public static final float SPEED_MODIFIER = .5f; 
	
	public World() {
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		try {
			player.setSprite(new Image("assets/img/pikachu.png"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		player.addToParty(new Pokemon());
		Random rand = new Random();
		SpriteSheet ss = new SpriteSheet(new Image("assets/img/sprites2.png"), 41, 41);
		int random = rand.nextInt(11) + 1;
		wild = ss.getSprite(random, random);
		
		

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		player.draw();
		g.drawString("Player Name: " + player.getName(), 500, 700);
		g.drawImage(wild, 50, 50);
		Rectangle playerBox = new Rectangle(player.getX(), player.getY(), player.getSprite().getWidth(), player.getSprite().getHeight());
		g.drawRect(player.getX(), player.getY(), player.getSprite().getWidth(), player.getSprite().getHeight());
		if (playerBox.intersects(new Rectangle(50, 50, 41, 41))) {
			System.out.println("YOYOYOYO");
		}
		//g.fill(playerBox);
		g.drawString(player.getBag().toString(), 300, 300);
		
		//Set false each time the room is created to prevet infinite loop
		startBattle = false;
		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		processInput(gc, delta);
		if (startBattle) {
			sbg.enterState(3);
		}

	}

	@Override
	public int getID() {
		return 2;
	}
	
	public void processInput(GameContainer gc, int delta) {
		if (gc.getInput().isKeyDown(Input.KEY_W)) {
			player.move(0, -delta * SPEED_MODIFIER);
			if (player.getY() < 0) {
				player.move(0, delta * SPEED_MODIFIER);
			}
		} else if (gc.getInput().isKeyDown(Input.KEY_S)) {
			player.move(0, delta * SPEED_MODIFIER);
			if (player.getY() > gc.getHeight() - player.getSprite().getHeight()) {
				player.move(0, -delta * SPEED_MODIFIER);
			}
		} else if (gc.getInput().isKeyDown(Input.KEY_A)) {
			player.move(-delta * SPEED_MODIFIER, 0);
			if (player.getX() < 0) {
				player.move(delta * SPEED_MODIFIER, 0);
			}
		} else if (gc.getInput().isKeyDown(Input.KEY_D)) {
			player.move(delta * SPEED_MODIFIER, 0);
			if (player.getX() > gc.getWidth() - player.getSprite().getWidth()) {
				player.move(-delta * SPEED_MODIFIER, 0);
			}
		}
		
		
		if (gc.getInput().isKeyDown(Input.KEY_B)) {
			startBattle = true;
		}
	}

}
