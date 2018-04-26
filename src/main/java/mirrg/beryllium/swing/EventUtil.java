package mirrg.beryllium.swing;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.AbstractButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public interface EventUtil
{

	// listener adder

	public static <T extends AbstractButton> T addActionListener(T component, ActionListener listener)
	{
		component.addActionListener(listener);
		return component;
	}

	// specialized event method hooker

	public static <T extends Component> T hookRightClick(T component, Consumer<MouseEvent> listener)
	{
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON3) listener.accept(e);
			}
		});
		return component;
	}

	public static <T extends Component> T hookPopup(T component, Consumer<MouseEvent> listener)
	{
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger()) listener.accept(e);
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger()) listener.accept(e);
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
				if (e.getClickCount() == 2) listener.accept(e);
			}
		});
		return component;
	}

}
