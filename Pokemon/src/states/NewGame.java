package states;


import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class NewGame extends BasicGameState {
	TextField nameInput;
	Font font = new Font("Verdana", Font.BOLD, 32);
	TrueTypeFont ttf = new TrueTypeFont(font, false);
	boolean nameSet = false;
	public NewGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {		
		nameInput = new TextField(gc, ttf, 100, 100, 200, 200);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		nameInput.render(gc, g);
		nameInput.setFocus(true);
		if (nameSet) {
			String name = nameInput.getText();
			nameInput.deactivate();
			g.drawString("Your name is: " + name + "\nIs this the name you want?", 600, 500);
			if (gc.getInput().isKeyPressed(Input.KEY_Y)) {
				System.out.println("Name set to " + nameInput.getText());
			} else if (gc.getInput().isKeyPressed(Input.KEY_N)){
				nameSet = false;
				nameInput.setText("");
				nameInput.setFocus(true);
				g.clear();
				
			}
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			nameSet = true;
					
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}
