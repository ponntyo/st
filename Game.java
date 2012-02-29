import java.awt.*;
import java.awt.event.*;

public class Game extends Frame
{
	public static void main(String args[])
	{
		new Game();
	}

	Game()
	{
		super("Shooting Game");
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
		setSize(500, 500);

		MyCanvas mc = new MyCanvas();
		add(mc);
		setVisible(true);
		mc.init();
		mc.initThread();
	}
}