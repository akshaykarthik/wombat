package edu.mhs.wombat.game.data.monsters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.game.GameStatus;
import edu.mhs.wombat.game.core.Entity;
import edu.mhs.wombat.game.core.EntityState;
import edu.mhs.wombat.game.data.player.Player;

public class EmptyMonster extends Monster {
	public Vector2f pos;
	public Vector2f vel;
	public EntityState state;
	public Shape shape;

	public EmptyMonster(float ix, float iy) {
		this.state = EntityState.ALIVE;
		this.pos = new Vector2f(ix, iy);
		this.vel = new Vector2f(0, 0);
		this.shape = new Circle(0, 0, 0);
	}

	@Override
	public EntityState getState() {
		return this.state;
	}

	@Override
	public void setState(EntityState es) {
		this.state = es;
	}

	@Override
	public void init(GameStatus gs) {

	}

	@Override
	public void update(StateBasedGame game, GameStatus gs, int delta) {
		switch (this.state) {
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
	public Shape getHitBox() {
		return this.shape;
	}

	@Override
	public void render(StateBasedGame game, Graphics g) {

	}

	@Override
	public void collideWith(Entity b) {
		this.setState(EntityState.DEAD);
	}

	@Override
	public Vector2f getPos() {
		return this.pos;
	}

	@Override
	public void playerCollide(Player a) {
		this.takeDamage(this.collideTakeDamage);
	}

	@Override
	public void close(GameStatus gs) {

	}
}
