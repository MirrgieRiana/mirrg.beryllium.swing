package mirrg.beryllium.swing;

import static mirrg.beryllium.swing.UColor.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class TestColor
{

	@Test
	public void test()
	{
		assertEquals(new Color(0, 255, 0, 255), createColor(-1, 256, -10000, 10000));
		assertEquals(new Color(3, 6, 11, 66), createRandomColor(3, 3, 6, 6, 11, 11, 66, 66));
		assertEquals(new Color(35, 63, 135, 221), new Color(getARGB(getFromARGB(new Color(35, 63, 135, 221).getRGB())), true));

		assertEquals(new Color(0, 255, 0), createColor(-1, 256, -10000));
		assertEquals(new Color(3, 6, 11), createRandomColor(3, 3, 6, 6, 11, 11));
		assertEquals(new Color(35, 63, 135), new Color(getRGB(getFromRGB(new Color(35, 63, 135).getRGB()))));

		assertEquals(new Color(40, 60, 80, 100).getRGB(), getRatioARGB(0.25, new Color(20, 40, 60, 80).getRGB(), new Color(100, 120, 140, 160).getRGB()));
	}

}
