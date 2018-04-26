package mirrg.beryllium.swing;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public interface ComponentUtil
{

	// Button

	public static JButton createButton(String caption, ActionListener listener)
	{
		JButton button = new JButton(caption);
		button.addActionListener(listener);
		return button;
	}

}
