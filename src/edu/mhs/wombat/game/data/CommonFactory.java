package edu.mhs.wombat.game.data;

import org.newdawn.slick.geom.Vector2f;

import edu.mhs.wombat.game.core.Entity;
import edu.mhs.wombat.game.data.common.LinearBullet;

public class CommonFactory {
	public static Entity newLinearBullet(Vector2f src, Vector2f target, float velocity){
		return new LinearBullet(src, target, velocity);
	}
}