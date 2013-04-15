package edu.mhs.wombat.game.data.player;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.game.GameStatus;
import edu.mhs.wombat.game.core.Entity;
import edu.mhs.wombat.game.core.EntityState;
import edu.mhs.wombat.game.core.Hitbox;
import edu.mhs.wombat.utils.Globals;
import edu.mhs.wombat.utils.MathUtils;

public class Player implements Entity{
	public Vector2f pos;
	public Vector2f vel;
	public float health, energy;
	public Hitbox hitbox;
	public PlayerState state;
	private Input input = new Input(Globals.HEIGHT);

	private Circle shape = new Circle(0, 0, 15, 15);

	public Player() {
		pos = new Vector2f(250, 250);
		vel = new Vector2f(0, 0);
		hitbox = new Hitbox(85, 85);
	}

	public void init(GameStatus gs) {
		state = PlayerState.ALIVE;

	}

	public void update(StateBasedGame game, GameStatus gs, int delta) {
		switch (state) {
		case ALIVE:
			boolean right = (input.isKeyDown(Input.KEY_RIGHT));
			boolean left = (input.isKeyDown(Input.KEY_LEFT));
			boolean up = (input.isKeyDown(Input.KEY_UP));
			boolean down = (input.isKeyDown(Input.KEY_DOWN));

			if (left && !right)
				vel.x = -10;
			else if (right && !left)
				vel.x = 10;
			else
				vel.x = 0;

			if (up && !down)
				vel.y = -10;
			else if (down && !up)
				vel.y = 10;
			else
				vel.y = 0;

			if (input.isKeyDown(Input.KEY_SPACE)) {
				vel.x = 0;
				vel.y = 0;
			}

			break;
		case DEAD:
			vel.x = 0;
			vel.y = 0;
			break;
		case DYING:
			vel.x = 0;
			vel.y = 0;
			break;
		case SPAWNING:
			vel.x = 0;
			vel.y = 0;
			break;
		case STUNNED:
			vel.x = 0;
			vel.y = 0;
			break;
		}
		
		pos = pos.add(vel);
		
		pos.x = (float) MathUtils.loop(pos.x, 0, Globals.WIDTH);
		pos.y = (float) MathUtils.loop(pos.y, 0, Globals.HEIGHT);
	}

	public void render(StateBasedGame game, Graphics g) {
		g.setColor(Color.magenta);
		shape.setCenterX(pos.x);
		shape.setCenterY(pos.y);
		g.fill(shape);
		g.setColor(Color.cyan);
		float x2 = input.getAbsoluteMouseX();
		float y2 = input.getAbsoluteMouseY();
		g.drawLine(pos.x, pos.y, x2, y2);
		g.setColor(Color.white);

	}

	public void collideWith(Entity b) {

	}

	@Override
	public EntityState getState() {
		return null; // uses playerstate instead
	}

	@Override
	public void setState(EntityState es) {
		// uses playerstate instead
	}

	@Override
	public Hitbox getHitBox() {
		return hitbox;
	}

	@Override
	public void playerCollide(Player a) {
		// ignore, can't collide with self
		
	}

	@Override
	public Vector2f getPos() {
		return pos;
	}

}
