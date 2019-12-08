package Game;

import java.util.ArrayList;

public class WinBlock extends EnemyStatic{
	
	public static ArrayList<WinBlock> wins = new ArrayList<WinBlock>();

	public WinBlock(int centerX, int centerY) {
		super(centerX, centerY);
	}

	// Behavioral Methods
	public static void update() {
		for (WinBlock i : wins) {
			i.centerX += i.speedX;
			i.speedX = i.bg.getSpeedX() * 5 + i.movementSpeed;
			i.r.setBounds(i.centerX - 30, i.centerY - 10, 85, 60);
			if (i.r.intersects(Robot.yellowRed))
				i.checkCollision();
		}
	}

	protected void checkCollision() {
		if (r.intersects(Robot.rect) || r.intersects(Robot.rect2)) {
			StartingClass.State = "win";
		}
	}

}