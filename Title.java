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
		g.drawString("����[�Ă���",120,150);
			g.setFont(infoFont);
			g.drawString("�X�y�[�X�ł͂��߂��A�X�y�[�X�Ń��g���C��",100,350);
			//����Ƀe�L�X�g�ǉ�������I�I
		
	}
	public void drawGameover(Graphics g)
	{
		g.setColor(Color.black);
		count++;
		g.setFont(titleFont);
		g.drawString("GAMEOVER",150,150);
	}
}