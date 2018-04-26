package mirrg.beryllium.swing;

import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public interface EventUtil
{

	public static <T extends AbstractButton> T addActionListener(T component, ActionListener listener)
	{
		component.addActionListener(listener);
		return component;
	}

}
