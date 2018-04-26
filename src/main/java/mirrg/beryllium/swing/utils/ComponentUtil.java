package mirrg.beryllium.swing.utils;

import static mirrg.beryllium.swing.utils.EventUtil.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
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

	// properties

	public static <T extends Component> T setPreferredSize(T component, int width, int rows)
	{
		component.setPreferredSize(new Dimension(width, component.getFont().getSize() * rows + 6));
		return component;
	}

	public static <T extends JComponent> T setToolTipText(T component, String string)
	{
		component.setToolTipText(string);
		return component;
	}

	public static <T extends AbstractButton> T addIntoButtonGroup(T component, ButtonGroup buttonGroup)
	{
		buttonGroup.add(component);
		return component;
	}

}
