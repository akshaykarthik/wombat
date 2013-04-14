package edu.mhs.wombat.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.States;
import edu.mhs.wombat.utils.ResourceManager;
import edu.mhs.wombat.utils.StateUtils;
import edu.mhs.wombat.utils.data.Options;
import edu.mhs.wombat.utils.effects.Starfield;

public class OptionsState extends BasicGameState {
	private StateBasedGame gm;
	private Starfield bg;

	public OptionsState() {
		Options.load();
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		gm = game;

	}

	public void enter(GameContainer container, StateBasedGame game) {
		bg = new Starfield(0, 10);
	}

	public void leave(GameContainer container, StateBasedGame game) {

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		bg.render(g);
		// Options Data
		Object[] opts = Options.getOptions().keySet().toArray();
		// **********************
		g.setFont(ResourceManager.getFont("font60"));
		g.drawString("Options", 160, 160);
		g.setFont(ResourceManager.getFont("font40"));
		for (int i = 0; i < opts.length; i++) {
			g.drawString(opts[i].toString(), 160, 220 + i * 40);
			g.drawString(Options.get(opts[i].toString()), 460, 220 + i * 40);
		}
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
		return States.OPTIONS.ordinal();
	}
}