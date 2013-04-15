package edu.mhs.wombat.game.data.monsters;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.game.GameStatus;
import edu.mhs.wombat.game.core.Entity;
import edu.mhs.wombat.game.core.EntityInstance;
import edu.mhs.wombat.game.core.EntityState;

public class EmptyMonster implements Entity {

	@Override
	public void init(GameStatus gs) {

	}

	@Override
	public void update(StateBasedGame game, EntityInstance ei, int delta) {
		switch (ei.getState()) {
		case ALIVE:
			break;
		case DEAD:
			break;
		case DYING:
			break;
		case SPAWNING:
			break;
		case STUNNED:
			break;
		default:
			break;
		}

	}

	@Override
	public void render(StateBasedGame game, EntityInstance ei, Graphics g) {

	}

	@Override
	public void collideWith(EntityInstance a, Entity ba, EntityInstance bb) {
		a.setState(EntityState.DEAD);
	}

}
