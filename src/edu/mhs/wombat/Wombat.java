package edu.mhs.wombat;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.endgame.DefeatState;
import edu.mhs.wombat.endgame.VictoryState;
import edu.mhs.wombat.game.GameState;
import edu.mhs.wombat.menu.CreditsState;
import edu.mhs.wombat.menu.HighState;
import edu.mhs.wombat.menu.MenuState;
import edu.mhs.wombat.menu.OptionsState;
import edu.mhs.wombat.preloader.PreloaderState;
import edu.mhs.wombat.utils.Globals;

public class Wombat extends StateBasedGame {

	/**
	 * Create a new test
	 */
	public Wombat() {
		super("Bacterium");
	}

	/**
	 * @see org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.GameContainer)
	 */
	@Override
	public void initStatesList(GameContainer container) {
		this.addState(new PreloaderState());
		this.addState(new MenuState());
		this.addState(new CreditsState());
		this.addState(new OptionsState());
		this.addState(new GameState());
		this.addState(new DefeatState());
		this.addState(new VictoryState());
		this.addState(new HighState());
	}

	/**
	 * Entry point to our Game
	 * 
	 * @param argv
	 *            The arguments to pass into the Game
	 */
	public static void main(String[] argv) {
		try {
			AppGameContainer container = new AppGameContainer(new Wombat());
			container.setResizable(false);
			
			container.setDisplayMode(Globals.WIDTH, Globals.HEIGHT, false);
			container.setTargetFrameRate(Globals.TARGET_FPS);
			container.setShowFPS(Globals.DEBUG);
			container.setVerbose(Globals.DEBUG);
			container.setTitle("Bacterium");
			container.setVSync(true);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}