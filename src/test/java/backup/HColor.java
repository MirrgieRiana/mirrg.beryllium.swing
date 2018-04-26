package backup;

import java.awt.Color;

public class HColor
{

	/**
	 * 2色a, bの中間色を計算します。 Aerが0以下の場合はaを返し、Aerが1以上の場合はbを返します。 Aerが小数の場合は2色a,
	 * bを適切な比率で混色した色を計算して返します。
	 *
	 * @param Aer
	 *            0以上1未満の小数
	 */
	public static Color createLinearRatioColor(double Aer, Color a, Color b)
	{
		if (Aer <= 0)
			return b;
		if (Aer >= 1)
			return a;

		return createColor(Aer * a.getRed() + (1 - Aer) * b.getRed(), Aer * a.getGreen() + (1 - Aer) * b.getGreen(),
			Aer * a.getBlue() + (1 - Aer) * b.getBlue(), Aer * a.getAlpha() + (1 - Aer) * b.getAlpha());
	}

}
