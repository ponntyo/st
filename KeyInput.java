import java.awt.event.*;

public class KeyInput extends KeyAdapter
{
	boolean keyup;
	boolean keydown;
	boolean keyleft;
	boolean keyright;
	int keyshot;

	KeyInput() {
		keyup = false;
		keydown = false;
		keyleft = false;
		keyright = false;
		keyshot = 0;
	}
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT)
		{
			keyleft = true;
		}
		if (keycode == KeyEvent.VK_RIGHT)
		{
			keyright = true;
		}
		if (keycode == KeyEvent.VK_UP)
		{
			keyup = true;
		}
		if (keycode == KeyEvent.VK_DOWN)
		{
			keydown = true;
		}
		if (keycode == KeyEvent.VK_SPACE)
		{

			if (keyshot == 0)
			{
				keyshot = 2;
			}
			else
			{
				keyshot = 1;
			}
		}
		
		if (keycode == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT)
		{
			keyleft = false;
		}
		if (keycode == KeyEvent.VK_RIGHT)
		{
			keyright = false;
		}
		if (keycode == KeyEvent.VK_UP)
		{
			keyup = false;
		}
		if (keycode == KeyEvent.VK_DOWN)
		{
			keydown = false;
		}
		if (keycode == KeyEvent.VK_SPACE)
		{
			keyshot = 0;
		}
	}
	public int getXDirection()
	{
		int ret = 0;
		if (keyright)
		{
			ret = 1;
		}
		if (keyleft)
		{
			ret = -1;
		}
		return ret;
	}
	public int getYDirection()
	{
		int ret = 0;
		if (keydown)
		{
			ret = 1;
		}
		if (keyup)
		{
			ret = -1;
		}
		return ret;
	}
	public int checkShotKey()
	{
		int ret = keyshot;
		if (keyshot==2)
		{
			keyshot = 1;
		}
		return ret;
	}
}