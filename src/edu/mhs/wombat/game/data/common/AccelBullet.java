package edu.mhs.wombat.game.data.common;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.game.GameStatus;
import edu.mhs.wombat.game.core.Entity;
import edu.mhs.wombat.game.core.EntityState;
import edu.mhs.wombat.game.data.player.Player;
import edu.mhs.wombat.utils.Globals;
import edu.mhs.wombat.utils.VectorU;

public class AccelBullet extends Bullet {
	private Vector2f pos;
	private Vector2f vel;
	private Vector2f accel;
	private EntityState state;
	private Circle shape = new Circle(0, 0, 6);

	private static final Vector2f bufferLBounds = new Vector2f(-100, -100);
	private static final Vector2f bufferUBounds = new Vector2f(
			Globals.WIDTH + 100, Globals.HEIGHT + 100);

	public AccelBullet(Vector2f source, Vector2f target, float ivel,
			float iaccel) {
		pos = source.copy();
		Vector2f target_vel = target.copy().sub(pos.copy()).normalise();
		vel = target_vel.copy().normalise().scale(ivel);
		accel = target_vel.scale(iaccel);
	}

	@Override
	public EntityState getState() {
		return state;
	}

	@Override
	public void setState(EntityState es) {
		state = es;

	}

	@Override
	public void init(GameStatus gs) {

	}

	@Override
	public void update(StateBasedGame game, GameStatus gs, int delta) {
		pos = pos.add(vel);
		vel = vel.add(accel);
		shape.setCenterX(pos.x);
		shape.setCenterY(pos.y);
		if (!VectorU.inBounds(pos, bufferLBounds, bufferUBounds))
			state = EntityState.DEAD;

	}

	@Override
	public void render(StateBasedGame game, Graphics g) {
		if (Globals.isInField(pos))
			g.draw(shape);

	}

	@Override
	public Shape getHitBox() {
		return shape;
	}

	@Override
	public void collideWith(Entity b) {
		if (!(b instanceof Bullet))
			state = EntityState.DEAD;
	}

	@Override
	public void playerCollide(Player a) {

	}

	@Override
	public Vector2f getPos() {
		return pos;
	}

	@Override
	public float getDamage() {
		return 10;
	}

	@Override
	public void close(GameStatus gs) {

	}


}
