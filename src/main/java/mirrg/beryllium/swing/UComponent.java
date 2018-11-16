package mirrg.beryllium.swing;

import static mirrg.beryllium.swing.UEvent.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public interface UComponent
{

	// Button

	public static JButton createButton(String text)
	{
		return new JButton(text);
	}

	public static JButton createButton(Action action)
	{
		return new JButton(action);
	}

	public static JButton createButton(String text, ActionListener listener)
	{
		return addActionListener(new JButton(text), listener);
	}

	public static JButton createButton(String text, Action action)
	{
		JButton button = new JButton(action);
		button.setText(text);
		return button;
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

	/**
	 * @param components
	 *            nullの場合、セパレータを追加します。
	 */
	public static JMenu createMenu(String text, Component... components)
	{
		JMenu menu = new JMenu(text);
		for (Component component : components) {
			if (component == null) {
				menu.addSeparator();
			} else {
				menu.add(component);
			}
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

	public static <T extends Component> T setPreferredSize(T component, int width, int height)
	{
		component.setPreferredSize(new Dimension(width, height));
		return component;
	}

	public static <T extends Component> T setPreferredSizeFromRows(T component, int width, int rows)
	{
		return setPreferredSize(component, width, component.getFont().getSize() * rows + 6);
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
