package mirrg.beryllium.swing;

import javax.swing.UIManager;

public class SwingUtil
{

	public static void setWindowsLookAndFeel() throws Exception
	{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	}

}
