package mirrg.beryllium.swing;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JSplitPane;

public interface PanelUtil
{

	// SplitPane

	public static Component createSplitPaneHorizontal(Component... components)
	{
		return createSplitPaneHorizontal(Arrays.asList(components));
	}

	public static Component createSplitPaneHorizontal(List<Component> components)
	{
		if (components.size() == 1) return components.get(0);
		return new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
			components.get(0),
			createSplitPaneHorizontal(components.subList(1, components.size())));
	}

	public static JSplitPane createSplitPaneHorizontal(Component c1, Component c2)
	{
		return new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, c1, c2);
	}

	public static JSplitPane createSplitPaneHorizontal(double resizeWeight, Component c1, Component c2)
	{
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, c1, c2);
		splitPane.setResizeWeight(resizeWeight);
		return splitPane;
	}

	public static Component createSplitPaneVertical(Component... components)
	{
		return createSplitPaneVertical(Arrays.asList(components));
	}

	public static Component createSplitPaneVertical(List<Component> components)
	{
		if (components.size() == 1) return components.get(0);
		return new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,
			components.get(0),
			createSplitPaneVertical(components.subList(1, components.size())));
	}

	public static JSplitPane createSplitPaneVertical(Component c1, Component c2)
	{
		return new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, c1, c2);
	}

	public static JSplitPane createSplitPaneVertical(double resizeWeight, Component c1, Component c2)
	{
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, c1, c2);
		splitPane.setResizeWeight(resizeWeight);
		return splitPane;
	}

}
