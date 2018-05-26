package mirrg.beryllium.swing;

import java.awt.CardLayout;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;

import mirrg.beryllium.swing.utils.ContainerUtil;

public class SampleTitledGroup
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setLayout(new CardLayout());
		frame.add(ContainerUtil.createTitledGroup("Title", ContainerUtil.createScrollPane(new JList<String>(IntStream.range(0, 20)
			.mapToObj(i -> "" + i)
			.collect(Collectors.toCollection(Vector::new))), 200, 200)));

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

}
