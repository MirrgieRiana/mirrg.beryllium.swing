package mirrg.beryllium.swing.utils;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import mirrg.beryllium.swing.TitledGroup;

public interface ContainerUtil
{

	// Panel

	public static JPanel createPanel(Consumer<JPanel> initializer)
	{
		JPanel panel = new JPanel();
		initializer.accept(panel);
		return panel;
	}

	public static JPanel createPanel(Component... components)
	{
		JPanel panel = new JPanel();
		Stream.of(components)
			.forEach(panel::add);
		return panel;
	}

	public static JPanel createPanel(List<Component> components)
	{
		JPanel panel = new JPanel();
		components.forEach(panel::add);
		return panel;
	}

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

	// BorderPanel

	public static Component createBorderPanelUp(Component... components)
	{
		return createBorderPanelUp(Arrays.asList(components));
	}

	public static Component createBorderPanelUp(List<Component> components)
	{
		if (components.size() == 1) return components.get(0);
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(4, 4));
		panel.add(components.get(0), BorderLayout.NORTH);
		{
			Component component = createBorderPanelUp(components.subList(1, components.size()));
			if (component != null) panel.add(component, BorderLayout.CENTER);
		}

		return panel;
	}

	public static Component createBorderPanelDown(Component... components)
	{
		return createBorderPanelDown(Arrays.asList(components));
	}

	public static Component createBorderPanelDown(List<Component> components)
	{
		if (components.size() == 1) return components.get(0);
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(4, 4));
		{
			Component component = createBorderPanelDown(components.subList(0, components.size() - 1));
			if (component != null) panel.add(component, BorderLayout.CENTER);
		}
		panel.add(components.get(components.size() - 1), BorderLayout.SOUTH);

		return panel;
	}

	public static Component createBorderPanelLeft(Component... components)
	{
		return createBorderPanelLeft(Arrays.asList(components));
	}

	public static Component createBorderPanelLeft(List<Component> components)
	{
		if (components.size() == 1) return components.get(0);
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(4, 4));
		panel.add(components.get(0), BorderLayout.WEST);
		{
			Component component = createBorderPanelLeft(components.subList(1, components.size()));
			if (component != null) panel.add(component, BorderLayout.CENTER);
		}

		return panel;
	}

	public static Component createBorderPanelRight(Component... components)
	{
		return createBorderPanelRight(Arrays.asList(components));
	}

	public static Component createBorderPanelRight(List<Component> components)
	{
		if (components.size() == 1) return components.get(0);
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(4, 4));
		{
			Component component = createBorderPanelRight(components.subList(0, components.size() - 1));
			if (component != null) panel.add(component, BorderLayout.CENTER);
		}
		panel.add(components.get(components.size() - 1), BorderLayout.EAST);

		return panel;
	}

	public static JPanel createBorderPanelVertical(Component top, Component middle, Component bottom)
	{
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(4, 4));
		if (top != null) panel.add(top, BorderLayout.NORTH);
		if (middle != null) panel.add(middle, BorderLayout.CENTER);
		if (bottom != null) panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}

	public static JPanel createBorderPanelHorizontal(Component left, Component center, Component right)
	{
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(4, 4));
		if (left != null) panel.add(left, BorderLayout.WEST);
		if (center != null) panel.add(center, BorderLayout.CENTER);
		if (right != null) panel.add(right, BorderLayout.EAST);

		return panel;
	}

	// Margin

	public static JPanel createMargin(int margin, Component component)
	{
		JPanel panel = createPanel(component);
		panel.setLayout(new CardLayout());
		panel.setBorder(new EmptyBorder(margin, margin, margin, margin));
		return panel;
	}

	public static TitledGroup createTitledGroup(String title, Component component)
	{
		return new TitledGroup(title, component);
	}

	// ScrollPane

	public static JScrollPane createScrollPane(Component component)
	{
		return new JScrollPane(component);
	}

	public static JScrollPane createScrollPane(Component component, int width, int height)
	{
		JScrollPane scrollPane = new JScrollPane(component);
		scrollPane.setPreferredSize(new Dimension(width, height));
		return scrollPane;
	}

}
