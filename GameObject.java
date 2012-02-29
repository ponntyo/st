import java.awt.*;

public abstract class GameObject
{
    public boolean active;
	public double x;
	public double y;
    abstract void move();
    abstract void draw(Graphics g);
}