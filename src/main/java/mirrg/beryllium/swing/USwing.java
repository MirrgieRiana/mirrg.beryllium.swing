package mirrg.beryllium.swing;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public interface USwing
{

	public static void setSystemLookAndFeel() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}

}
