package edu.mhs.wombat.endgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.States;
import edu.mhs.wombat.utils.Globals;
import edu.mhs.wombat.utils.ResourceManager;
import edu.mhs.wombat.utils.StateUtils;
import edu.mhs.wombat.utils.effects.Starfield;

public class VictoryState extends BasicGameState {

	private StateBasedGame gm;
	private Image background;
	private Starfield bg;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		gm = game;

	}

	public void enter(GameContainer container, StateBasedGame game) {
		bg = new Starfield(-10, -10);
	}

	public void leave(GameContainer container, StateBasedGame game) {

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		bg.render(g);
		g.setFont(ResourceManager.getFont("font100"));
		g.drawString("Victory!", Globals.WIDTH / 2 - 20, Globals.HEIGHT / 2);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

	}

	public void keyReleased(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			StateUtils.switchTo(gm, States.MENU);
		}
	}

	@Override
	public int getID() {
		return States.VICTORY.ordinal();
	}

}
