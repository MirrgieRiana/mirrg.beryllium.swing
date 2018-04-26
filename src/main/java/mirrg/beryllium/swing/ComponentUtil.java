package mirrg.beryllium.swing;

import static mirrg.beryllium.swing.EventUtil.*;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

	// MenuBar

	public static JMenuBar createMenuBar(Component... components)
	{
		JMenuBar menuBar = new JMenuBar();
		for (Component component : components) {
			menuBar.add(component);
		}
		return menuBar;
	}

	public static JMenu createMenu(String text, Component... components)
	{
		JMenu menu = new JMenu(text);
		for (Component component : components) {
			menu.add(component);
		}
		return menu;
	}

	public static JMenuItem createMenuItem(String text, ActionListener actionListener)
	{
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.addActionListener(actionListener);
		return menuItem;
	}

}
