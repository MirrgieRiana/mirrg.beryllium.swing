package mirrg.beryllium.swing;

import static mirrg.beryllium.swing.GroupBuilder.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SampleGroupBuilder
{

	public static void main(String[] args)
	{
		new FrameTest() {

			@Override
			protected void init()
			{
				GroupLayout layout = new GroupLayout(getContentPane());

				group(
					group(
						new JLabel("Label"),
						new JTextField("Text")),
					group(
						new JLabel("Label"),
						new JTextField("Text")),
					group(
						new JLabel("Label"),
						new JTextField("Text")),
					group(
						new JLabel("Label"),
						new JTextField("Text")),
					group(
						new JLabel("Label"),
						new JTextField("Text")),
					group(
						new JLabel("Label"),
						new JTextField("Text")),
					new JScrollPane(new JButton("Button"))).apply(layout);

				setLayout(layout);
			}

		}.setVisible(true);
	}

}
