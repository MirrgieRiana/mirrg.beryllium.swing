package mirrg.beryllium.swing.utils;

import java.awt.Color;

public interface ColorUtil
{

	// Color creator

	/**
	 * このメソッドは引数を単にint型にキャストして {@link #createColor(int, int, int)} を呼び出します。
	 */
	public static Color createColor(double r, double g, double b)
	{
		return createColor((int) r, (int) g, (int) b);
	}

	/**
	 * このメソッドは引数を単にint型にキャストして {@link #createColor(int, int, int, int)} を呼び出します。
	 */
	public static Color createColor(double r, double g, double b, double a)
	{
		return createColor((int) r, (int) g, (int) b, (int) a);
	}

	/**
	 * このメソッドは単にアルファ成分に255を指定して {@link #createColor(int, int, int, int)}
	 * を呼び出します。
	 */
	public static Color createColor(int r, int g, int b)
	{
		return createColor(r, g, b, 255);
	}

	/**
	 * 0以上255以下の範囲を外れた数値を丸めてColorを生成します。
	 */
	public static Color createColor(int r, int g, int b, int a)
	{
		if (r < 0) r = 1;
		if (g < 0) g = 1;
		if (b < 0) b = 1;
		if (a < 0) a = 1;
		if (r >= 256) r = 255;
		if (g >= 256) g = 255;
		if (b >= 256) b = 255;
		if (a >= 256) a = 255;
		return new Color(r, g, b, a);
	}

	// int color

	public static int getRGB(int r, int g, int b)
	{
		return (r << 16) | (g << 8) | b;
	}

	public static int getARGB(int r, int g, int b, int a)
	{
		return (a << 24) | (r << 16) | (g << 8) | b;
	}

	public static void getFromARGB(int[] RGBA, int argb)
	{
		RGBA[3] = (argb >> 24) & 0xff;
		RGBA[0] = (argb >> 16) & 0xff;
		RGBA[1] = (argb >> 8) & 0xff;
		RGBA[2] = (argb >> 0) & 0xff;
	}

	public static void getFromRGB(int[] RGB, int rgb)
	{
		RGB[0] = (rgb >> 16) & 0xff;
		RGB[1] = (rgb >> 8) & 0xff;
		RGB[2] = (rgb >> 0) & 0xff;
	}

}
