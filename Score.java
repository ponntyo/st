import java.awt.*;

public class Score
{
	static int myscore;
	static int hiscore;
	Font scoreFont;

	Score()
	{
		scoreFont = new Font("sansserif", Font.BOLD, 10);
		myscore = 0;
	}
	public void drawScore(Graphics g)
	{
		g.setColor(Color.black);
		g.setFont(scoreFont);
		g.drawString("score:"+myscore, 30, 30);
	}
	public void drawHiScore(Graphics g)
	{
		g.setColor(Color.black);
		g.setFont(scoreFont);
		g.drawString("hiscore:"+hiscore, 420, 30);
	}
	public static void addScore(int gain)
	{
		myscore += gain;
	}
	public static void compareScore()
	{
		if (myscore > hiscore)
		{
			hiscore = myscore;
			saveScore();
		}
	}
	static void saveScore()
	{
	}

	static void loadScore()
	{
	}

	public static void initScore()
	{
		myscore = 0;
	}
}