package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import states.*;

public class Game extends StateBasedGame {
		
	public Game() {
		super("Pokemon");
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Game());
			app.setDisplayMode(1080, 720, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu());
		addState(new NewGame());
		
	}
	
	
	

}
