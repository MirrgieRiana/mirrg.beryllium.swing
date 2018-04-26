package mirrg.beryllium.swing;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class TitledGroup extends JComponent
{

	private static final long serialVersionUID = -2129682085019459410L;

	private TitledBorder titledBorder;

	public TitledGroup(String title)
	{
		setBorder(titledBorder = new TitledBorder(title));
	}

	public TitledBorder getTitledBorder()
	{
		return titledBorder;
	}

}
