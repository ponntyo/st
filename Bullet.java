import java.awt.*;

public class Bullet extends GameObject
{
	double direction;
	double speed;
	double speedX;
	double speedY;
	
	Bullet()
	{
		active = false;
	}

	public void move()
	{
		x += speedX;
		y += speedY;
		
		if ( (x < 0)||(500 < x)||(y < 0)||(500 < y) )
		{
			active = false;
		}
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawRect((int)(x-3), (int)(y-3), (int)6, (int)6);
	}

	public void activate(double ix, double iy, double idirection, double ispeed)
	{
		x = ix;
		y = iy;
		direction = idirection;
		speed = ispeed;
		active = true;

		double radian;
		radian = Math.toRadians(direction);
		speedX = speed * Math.cos(radian);
		speedY = speed * Math.sin(radian);
	}

	public static void FireRound(double x, double y)
	{
		for (int i = 0; i < 360; i += 60 )
		{
			ObjectPool.newBullet(x, y, i, 3);
		}
	}

	public static void FireAim(double x, double y, Player player)
	{
		double degree = Math.toDegrees(Math.atan2(player.y - y, player.x - x));
		ObjectPool.newBullet(x, y, degree, 4);
		ObjectPool.newBullet(x, y, degree+20, 4);
		ObjectPool.newBullet(x, y, degree-20, 4);
	}
}