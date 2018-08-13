package mirrg.beryllium.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public interface ULayout
{

	/**
	 * 表形式の {@link GroupLayout} を生成します。
	 * セルの結合には対応していません。
	 *
	 * @param gapSize
	 *            0以下の場合、ギャップは作成されません。
	 */
	public static LayoutManager createGroupLayout(Container host, Component[][] components, int gapSize)
	{
		GroupLayout groupLayout = new GroupLayout(host);

		int rows = components.length;
		int columns = components[0].length;

		{
			SequentialGroup sequentialGroup = groupLayout.createSequentialGroup();

			boolean isFirst = true;
			for (int rowIndex = 0; rowIndex < rows; rowIndex++) {

				if (isFirst) {
					isFirst = false;
				} else {
					if (gapSize > 0) sequentialGroup.addGap(gapSize);
				}

				ParallelGroup parallelGroup = groupLayout.createParallelGroup();
				for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
					parallelGroup.addComponent(components[rowIndex][columnIndex]);
				}
				sequentialGroup.addGroup(parallelGroup);

			}

			groupLayout.setVerticalGroup(sequentialGroup);
		}

		{
			SequentialGroup sequentialGroup = groupLayout.createSequentialGroup();

			boolean isFirst = true;
			for (int columnIndex = 0; columnIndex < columns; columnIndex++) {

				if (isFirst) {
					isFirst = false;
				} else {
					if (gapSize > 0) sequentialGroup.addGap(gapSize);
				}

				ParallelGroup parallelGroup = groupLayout.createParallelGroup();
				for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
					parallelGroup.addComponent(components[rowIndex][columnIndex]);
				}
				sequentialGroup.addGroup(parallelGroup);

			}

			groupLayout.setHorizontalGroup(sequentialGroup);
		}

		return groupLayout;
	}

}
