import java.awt.*;

public class Enemy extends GameObject
{
	int counter = 0;
	int katasa;
	int type;
	boolean ishit = false;
	Player player;
	boolean startshoot;
	int shootnum;

	Enemy(Player iplayer)
	{
		player = iplayer;
		active = false;
	}

	public void activate(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = (int)(Math.random()+0.5);
		active = true;
		katasa = 10;
		counter = 0;
		shootnum = Level.getLevel();
		startshoot = false;
	}

	public void hit()
	{
		katasa--;
		ishit = true;
		if (katasa < 0)
		{
			switch(type)
			{
				case 0:
					Score.addScore(10);
					break;
				case 1:
					Score.addScore(20);
					break;
				default:
			}

			ObjectPool.newParticle(x, y, 45, 2);
			ObjectPool.newParticle(x, y, 135, 2);
			ObjectPool.newParticle(x, y, 225, 2);
			ObjectPool.newParticle(x, y, 315, 2);
			active = false;
		}
	}

	public void move()
	{
		switch(type)
		{
			case 0:
				move_enemy0();
				break;
			case 1:
				move_enemy1();
				break;
			default:
		}
	}

	void move_enemy0()
	{
		counter++;
		y++;
		x += Math.sin(y / 20);
		if ( (500 < y) )
		{
			active = false;
		}

		if ((counter%80)==0)
		{
			Bullet.FireRound(x, y);
		}
	}

	void move_enemy1()
	{
		counter++;
		double p = 60;
		double q = 200;	
		y = (-q / Math.pow(p,2) * Math.pow((counter - p), 2) + q);

		if ( (-30 > y) )
		{
			active = false;
		}

		if ((counter%60)==0)
		{
			startshoot = true;
		}

		if (startshoot)
		{
			if (((counter%5)==0)&&(shootnum>0))
			{
				Bullet.FireAim(x, y, player);
				shootnum--;
			}
		}
	}

	public void draw(Graphics g)
	{
		if (ishit)
		{
			g.setColor(Color.orange);
		}else{
			switch(type)
			{
				case 0:
					g.setColor(Color.black);
					break;
				case 1:
					g.setColor(Color.blue);
					break;
				default:
			}
		}
		ishit = false;
		g.drawRect((int)x-16, (int)y-16, (int)32, (int)32);
	}
}