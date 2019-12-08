package Game;

import java.util.ArrayList;

public class EnemyDynamic extends EnemyStatic{

	public static ArrayList<EnemyDynamic> enemies = new ArrayList<EnemyDynamic>();

	public EnemyDynamic(int centerX, int centerY) {
		super (centerX, centerY);
	}

	// Behavioral Methods
	public static void update() {
		for (EnemyDynamic i : enemies) {
			i.follow();
			i.centerX += i.speedX;
			i.speedX = i.bg.getSpeedX() * 5 + i.movementSpeed;
			i.r.setBounds(i.centerX - 30, i.centerY - 10, 85, 60);
			if (i.r.intersects(Robot.yellowRed))
				i.checkCollision();
		}
	}

	public void follow() {
		if (centerX - StartingClass.getRobot().getCenterX() > 650) {
			this.movementSpeed = 0;
		} else if (StartingClass.getRobot().getCenterX() - centerX > 650) {
			this.movementSpeed = 0;
		} else if (Math.abs(StartingClass.getRobot().getCenterX() - centerX) < 5) {
			this.movementSpeed = 0;
		} else {
			if (StartingClass.getRobot().getCenterX() >= centerX) {
				this.direction = "right";
				this.movementSpeed = 2;
			} else {
				this.direction = "left";
				this.movementSpeed = -2;
			}
		}
	}
}