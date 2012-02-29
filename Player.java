import java.awt.*;

public class Player extends GameObject
{
    double speed;
    Player(double ix, double iy, double ispeed)
    {
        x = ix;
		y = iy;
		speed = ispeed;
		active = false;
	}
    public void move()
    {
    }
	public void move(int mx, int my)
	{
		double postX = x + mx * speed;
		double postY = y + my * speed;
		
		if ((0 < postX)&&(postX < 500))
		{
			x = postX;
		}
		if ((0 < postY)&&(postY < 480))
		{
			y = postY;
		}
	}
	public void draw(Graphics g)
	{
		if (active)
		{
			g.setColor(Color.red);
			//ŽOŠpŒ`‚Ì•`‰æ
			g.drawLine((int)(x), (int)(y-14), (int)(x-10), (int)(y+7));
			g.drawLine((int)(x), (int)(y-14), (int)(x+10), (int)(y+7));
			g.drawLine((int)(x-10), (int)(y+7), (int)(x+10), (int)(y+7));
		}
	}
}