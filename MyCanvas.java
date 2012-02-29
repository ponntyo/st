import java.awt.*;
import java.util.Random;

public class MyCanvas extends Canvas implements Runnable{
	ObjectPool objectpool;
	KeyInput keyinput;
	Image imgBuf;
	Graphics gBuf;
	Random random;
	Title title;
	Score score;

	public int scene;
	static final int SCENE_TITLE = 0;
	static final int SCENE_GAMEMAIN = 1;
	public boolean gameover;
	int counter;

	static final int SHOT_PRESSED = 1;
	static final int SHOT_DOWN = 2;
	int shotkey_state;
	MyCanvas()
	{
		keyinput = new KeyInput();
		addKeyListener(keyinput);
		setFocusable(true);
		random = new Random();
		title = new Title();
		score = new Score();
	}
	public void init()
	{
		objectpool = new ObjectPool();
		Score.loadScore();
		scene = SCENE_TITLE;
		gameover = false;
		Level.initLevel();
		Score.initScore();
	}
	public void initThread()
	{
		Thread thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g)
	{
		g.drawImage(imgBuf, 0, 0, this);
	}
	public void run()
	{
		imgBuf = createImage(500, 500);
		gBuf = imgBuf.getGraphics();
		for(counter = 0; ; counter++)
		{
			shotkey_state = keyinput.checkShotKey();
			gBuf.setColor(Color.white);
			gBuf.fillRect(0, 0, 500, 500);
			switch (scene)
			{
				case 0:
					title.drawTitle(gBuf);
					score.drawScore(gBuf);
					score.drawHiScore(gBuf);
					if (shotkey_state == SHOT_DOWN)
					{
						scene = SCENE_GAMEMAIN;
					}
					break;
				case 1:
					gameMain();
					break;
			}
			repaint();
			
			try{
				Thread.sleep(20);
			}
			catch(InterruptedException e)
			{}
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	void gameMain()
	{
		if (objectpool.isGameover())
		{
			title.drawGameover(gBuf);
			if (shotkey_state == SHOT_DOWN)
			{
				Score.compareScore();
				init();
			}
		}		
		objectpool.getColision();
		objectpool.movePlayer(keyinput);
		if (counter % (100 - Level.getLevel() * 10) == 0)
		{
			ObjectPool.newEnemy(100 + random.nextInt(300), 0);
		}
		if ((counter % 500) == 0)
		{
			Level.addLevel();
		}
		if ((shotkey_state == SHOT_PRESSED)&&(counter % 3 == 0))
		{
			objectpool.shotPlayer();
		}
		objectpool.drawAll(gBuf);
		score.drawScore(gBuf);
		score.drawHiScore(gBuf);
		
	}
}