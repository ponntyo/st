import java.awt.*;

public class Title
{
	int count;
	Font titleFont;
	Font infoFont;
	Title()
	{
		count = 0;
		titleFont = new Font("sansserif", Font.BOLD, 30);
		infoFont = new Font("sansserif", Font.BOLD, 11);
	}
	public void drawTitle(Graphics g)
	{
		g.setColor(Color.black);
		count++;
		g.setFont(titleFont);
		g.drawString("しゅーてぃんぐ",120,150);
			g.setFont(infoFont);
			g.drawString("スペースではじめるよ、スペースでリトライよ",100,350);
		
	}
	public void drawGameover(Graphics g)
	{
		g.setColor(Color.black);
		count++;
		g.setFont(titleFont);
		g.drawString("GAMEOVER",150,150);
	}
}