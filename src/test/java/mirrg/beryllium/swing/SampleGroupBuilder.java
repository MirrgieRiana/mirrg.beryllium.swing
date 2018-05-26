package mirrg.beryllium.swing;

import static mirrg.beryllium.swing.GroupBuilder.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SampleGroupBuilder
{

	public static void main(String[] args)
	{

		JFrame frame = new JFrame();

		{
			GroupLayout layout = new GroupLayout(frame.getContentPane());

			layout.setAutoCreateGaps(true);

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

			frame.setLayout(layout);
		}

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

}
