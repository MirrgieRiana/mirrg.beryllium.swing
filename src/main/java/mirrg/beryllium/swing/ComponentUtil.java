package mirrg.beryllium.swing;

import static mirrg.beryllium.swing.EventUtil.*;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public interface ComponentUtil
{

	// Button

	public static JButton createButton(String caption)
	{
		return new JButton(caption);
	}

	public static JButton createButton(String caption, ActionListener listener)
	{
		return addActionListener(new JButton(caption), listener);
	}

}
