package edu.mhs.wombat.game.data.monsters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import edu.mhs.wombat.game.GameStatus;
import edu.mhs.wombat.game.core.Entity;
import edu.mhs.wombat.game.core.EntityState;
import edu.mhs.wombat.game.data.bullets.Bullet;
import edu.mhs.wombat.game.data.player.Player;
import edu.mhs.wombat.utils.Globals;
import edu.mhs.wombat.utils.MathU;
import edu.mhs.wombat.utils.ResourceManager;

public class BumperMonster extends Monster {
	private static Image image;
	private final Shape hitbox;

	public Vector2f pos;
	public Vector2f vel;
	public EntityState state;
	public float maxvel = 8;

	public BumperMonster(float ix, float iy) {

		this.collideDoDamage = 2f;
		this.collideTakeDamage = this.health;

		this.state = EntityState.ALIVE;
		this.pos = new Vector2f(ix, iy);
		this.vel = new Vector2f((float) Math.random() * Globals.ARENA_WIDTH,
				(float) Math.random() * Globals.ARENA_HEIGHT)
				.sub(this.pos.copy()).normalise().scale(maxvel);

		if (image == null) {
			image = ResourceManager.getSpriteSheet("monsters_square") // CHANGE
																		// THIS
					.getSubImage(0, 0).getScaledCopy(1f);
			image.setCenterOfRotation(image.getWidth() / 2f,
					image.getHeight() / 2f);
		}
		this.hitbox = new Circle(this.pos.x, this.pos.y, image.getWidth() / 2f);

		this.maxHealth = _MonsterData.Bumper_Health;
		this.health = this.maxHealth;
	}

	public BumperMonster(Vector2f pos2) {
		this(pos2.x, pos2.y);
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
		float vr = 1.0f; // was 0.5f
		this.vel.x = (float) (this.vel.x + (Math.random() < 0.5 ? -vr : vr));
		this.vel.y = (float) (this.vel.y + (Math.random() < 0.5 ? -vr : vr));
		this.pos = this.pos.add(this.vel);
		
		if (this.vel.length() > this.maxvel)
			this.vel.normalise().scale(this.maxvel);
		
		this.hitbox.setCenterX(this.pos.x);
		this.hitbox.setCenterY(this.pos.y);
		



		if (!MathU.inBounds(this.pos.x, maxvel, Globals.ARENA_WIDTH - maxvel))
			this.vel.x *= -1;

		if (!MathU.inBounds(this.pos.y, maxvel, Globals.ARENA_HEIGHT - maxvel))
			this.vel.y *= -1;

		if (!Globals.isInField(this.pos))
			this.state = EntityState.DEAD;
	}

	@Override
	public Shape getHitBox() {
		return this.hitbox;
	}

	@Override
	public void render(StateBasedGame game, Graphics g) {
		image.drawCentered(this.pos.x, this.pos.y);
	}

	@Override
	public void collideWith(Entity b) {
		if (b instanceof Bullet) {
			this.takeDamage(((Bullet) b).getDamage());
		}
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
		gs.scores.addPoints(_MonsterData.Bumper_Points, gs);
	}

}
