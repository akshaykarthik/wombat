package edu.mhs.wombat.game.data.player;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import edu.mhs.wombat.game.Camera;
import edu.mhs.wombat.game.GameStatus;
import edu.mhs.wombat.utils.Globals;

public abstract class Weapon {
	public boolean canFire = true;
	protected float attackTimer = 0;
	private static Input input = new Input(Globals.HEIGHT);

	public abstract String getName();

	public abstract float getAttackCD();

	public void update(int delta, float fireMod) {
		this.attackTimer += delta * fireMod;
		this.canFire = false;
		if (this.attackTimer >= this.getAttackCD()) {
			this.canFire = true;
		}
	}

	public void fire(GameStatus gs) {
		if (this.canFire)
			this.attackTimer = 0;
	}

	public Vector2f getMousePos() {
		float x2 = input.getAbsoluteMouseX();
		float y2 = input.getAbsoluteMouseY();
		Vector2f mousepos = Camera.worldToScreen(new Vector2f(x2, y2));
		return mousepos;
	}

}
