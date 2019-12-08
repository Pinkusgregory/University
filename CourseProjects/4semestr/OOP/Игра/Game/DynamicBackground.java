package Game;

abstract class DynamicBackground {
	public double orbitX; // x-coordinate in orbit's center */
	public double orbitY; // y-coordinate in orbit's center */
	public double orbitRadius = 20;
	public double orbitSpeed = 0.03;
	public double sphereRadius = 5;
	public double t;
	public double drawX;
	public double drawY;
	public double radian;
	boolean mousePress;

	public abstract void update();
}