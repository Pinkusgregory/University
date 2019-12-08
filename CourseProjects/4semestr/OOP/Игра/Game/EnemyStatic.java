package Game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class EnemyStatic extends Person{
	
	protected int maxHealth, currentHealth, power;
	protected Background bg = StartingClass.getBg1();
	public Rectangle r = new Rectangle(0, 0, 0, 0);
	public int health = 5;
	protected boolean isdead;
	public static ArrayList<EnemyStatic> enemies = new ArrayList<EnemyStatic>();
	protected int movementSpeed;
	public String direction = "left";
	
	public EnemyStatic(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
	}

	public static void update() {
		for (EnemyStatic i : enemies) {
			i.centerX += i.speedX;
			i.speedX = i.bg.getSpeedX() * 5 + i.movementSpeed;
			i.r.setBounds(i.centerX - 30, i.centerY - 10, 85, 60);
			if (i.r.intersects(Robot.yellowRed))
				i.checkCollision();
		}
	}
	
	protected void checkCollision() {
		if (r.intersects(Robot.rect) || r.intersects(Robot.rect2)) {
			StartingClass.State = "dead";
		}
	}
	
	public void attack() {

	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getPower() {
		return power;
	}

	public Background getBg() {
		return bg;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public boolean getIsDead() {
		return isdead;
	}

	public void setIsDead(boolean s) {
		isdead = s;
	}
}