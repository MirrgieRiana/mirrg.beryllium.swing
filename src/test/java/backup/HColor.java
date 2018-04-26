package backup;

import java.awt.Color;

public class HColor
{

	/**
	 * ランダムなrgb値と255のa値を持つ色を生成して返します。
	 */
	public static Color createRandomColor()
	{
		return createRandomRangedColor(0, 255);
	}

	/**
	 * 0から127の範囲でランダムなrgb値と255のa値を持つ色を生成して返します。
	 */
	public static Color createRandomDarkColor()
	{
		return createRandomRangedColor(0, 127);
	}

	/**
	 * 128から255の範囲でランダムなrgb値と255のa値を持つ色を生成して返します。
	 */
	public static Color createRandomLightColor()
	{
		return createRandomRangedColor(128, 255);
	}

	/**
	 * minからmaxの範囲でランダムなrgb値と255のa値を持つ色を生成して返します。
	 */
	public static Color createRandomRangedColor(int min, int max)
	{
		//return createColor(HMath.randomBetween(min, max), HMath.randomBetween(min, max), HMath.randomBetween(min, max));
		// TODO
		throw new UnsupportedOperationException();
	}

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

	public static int getColorInt(int r, int g, int b)
	{
		return (r << 16) | (g << 8) | b;
	}

}
