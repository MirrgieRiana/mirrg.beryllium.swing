package backup;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public class HSwing
{

	public static JButton createButton(String caption, ActionListener listener)
	{
		JButton button = new JButton(caption);
		button.addActionListener(listener);
		return button;
	}

	public static JScrollPane createScrollPane(Component component)
	{
		JScrollPane scrollPane = new JScrollPane(component);
		return scrollPane;
	}

	public static JScrollPane createScrollPane(Component component, int width, int height)
	{
		JScrollPane scrollPane = new JScrollPane(component);
		scrollPane.setPreferredSize(new Dimension(width, height));
		return scrollPane;
	}

	public static JMenuBar createJMenuBar(Component... components)
	{
		JMenuBar menuBar = new JMenuBar();
		for (Component component : components) {
			menuBar.add(component);
		}
		return menuBar;
	}

	public static JMenu createJMenu(String text, Component... components)
	{
		JMenu menu = new JMenu(text);
		for (Component component : components) {
			menu.add(component);
		}
		return menu;
	}

	public static JMenuItem createJMenuItem(String text, ActionListener actionListener)
	{
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.addActionListener(actionListener);
		return menuItem;
	}

	public static <T> T process(T object, Consumer<T> consumer)
	{
		consumer.accept(object);
		return object;
	}

	public static <T> T get(Supplier<T> supplier)
	{
		return supplier.get();
	}

	public static <T extends Component> T setPreferredSize(T component, int width, int rows)
	{
		component.setPreferredSize(new Dimension(width, component.getFont().getSize() * rows + 6));
		return component;
	}

	public static <T extends AbstractButton> T addIntoButtonGroup(T component, ButtonGroup buttonGroup)
	{
		buttonGroup.add(component);
		return component;
	}

	public static <T extends AbstractButton> T addActionListener(T component, ActionListener listener)
	{
		component.addActionListener(listener);
		return component;
	}

	public static <T extends JComponent> T setToolTipText(T component, String string)
	{
		component.setToolTipText(string);
		return component;
	}

	public static <T extends Component> T hookRightClick(T component, Predicate<MouseEvent> listener)
	{
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON3) {
					if (listener.test(e)) e.consume();
				}
			}
		});
		return component;
	}

	public static <T extends Component> T hookPopup(T component, Predicate<MouseEvent> listener)
	{
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger()) {
					if (listener.test(e)) e.consume();
				}
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger()) {
					if (listener.test(e)) e.consume();
				}
			}
		});
		return component;
	}

	public static <T extends JTextComponent> T hookChange(T textComponent, Consumer<DocumentEvent> listener)
	{
		textComponent.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e)
			{
				listener.accept(e);
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				listener.accept(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				listener.accept(e);
			}

		});
		return textComponent;
	}

	public static <T extends Component> T hookDoubleClick(T component, Consumer<MouseEvent> listener)
	{
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() == 2) {
					listener.accept(e);
				}
			}
		});
		return component;
	}

}
