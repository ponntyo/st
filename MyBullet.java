import java.awt.*;
public class MyBullet extends GameObject
{
	MyBullet()
	{
		active = false;
	}
	public void move()
	{
        y -= 15;
		if ( (y < 0) )
		{
			active = false;
		}
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.gray);
		g.drawRect((int)x-3, (int)y-10, (int)6, (int)20);
	}
	public void activate(double ix, double iy)
	{
		x = ix;
		y = iy;
		active = true;
	}
}