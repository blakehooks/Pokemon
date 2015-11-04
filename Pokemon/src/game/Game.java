package game;

import org.newdawn.slick.*;

import player.Player;

public class Game extends BasicGame {
	private Player player;
		
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
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Hello World", 200, 200);
		player.draw();

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		player = new Player(0, 0);

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		processInput(gc, delta);
	}
	
	public void processInput(GameContainer gc, int delta) {
		if (gc.getInput().isKeyDown(Input.KEY_W)) {
			player.move(50f, 0);
			System.out.println("W Pressed!");
		} 
	}
	
	
	

}
