package backup;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;

public class HSwing
{

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

	public static <T extends JComponent> T setToolTipText(T component, String string)
	{
		component.setToolTipText(string);
		return component;
	}

}
