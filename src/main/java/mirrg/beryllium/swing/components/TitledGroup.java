package mirrg.beryllium.swing.components;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class TitledGroup extends JComponent
{

	private TitledBorder titledBorder;

	public TitledGroup(String title)
	{
		setBorder(titledBorder = new TitledBorder(title));
	}

	public TitledGroup(String title, Component component)
	{
		this(title);
		setLayout(new CardLayout());
		add(component);
	}

	public TitledBorder getTitledBorder()
	{
		return titledBorder;
	}

}
