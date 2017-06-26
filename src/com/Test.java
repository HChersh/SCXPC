package com;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Test {

	public static void main(String args[]) {
		JFrame jf = new JFrame("Cell Combine Table");
		jf.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		JTable cTable = getTable1();

		jf.getContentPane().add(new JScrollPane(cTable));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 500);
		jf.setVisible(true);
		
		JTable cTable2 = getTable1();

		jf.getContentPane().add(new JScrollPane(cTable2));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1000, 300);
		jf.setVisible(true);
	}

	private static CombineTable getTable1() {
		String[][] datas = new String[10][6];
		for (int i = 0; i < datas.length; i++) {             //i表示某一行
			String[] data = datas[i];
			for (int j = 0; j < data.length; j++) {
				data[j] = "";
			}
			data[0] = String.valueOf((int) (i / 3));         //之后通过data[0]的值对这一列进行合并了
			data[1] = String.valueOf((int) (i / 3));
			data[2] = String.valueOf((int) (i / 3));
		}

		ArrayList<Integer> combineColumns = new ArrayList<Integer>();   //用来保存需要合并的列数
		combineColumns.add(0);                                          //表示需要合并0列
		combineColumns.add(1);
		combineColumns.add(2);
		CombineData m = new CombineData(datas, combineColumns);
		String[] columnNames = {"a","b", "c", "d", "e"};       //表头名
		DefaultTableModel tm = new DefaultTableModel(datas,columnNames);
		CombineTable cTable = new CombineTable(m, tm);

		TableColumn column = cTable.getColumnModel().getColumn(0);
		column.setCellRenderer(new CombineColumnRender());
		column.setWidth(50);
		column.setMaxWidth(50);
		column.setMinWidth(50);
		cTable.setCellSelectionEnabled(true);
		return cTable;
	}

	private static CombineTable getTable2() {
		String[][] datas = new String[10][6];
		for (int i = 0; i < datas.length; i++) {
			String[] data = datas[i];
			for (int j = 0; j < data.length; j++) {
				data[j] = "";
			}
			data[0] = String.valueOf((int) (i / 4));
			data[1] = String.valueOf((int) (i / 2));
		}

		CombineData m = new CombineData(datas, 0, 1);
		DefaultTableModel tm = new DefaultTableModel(datas, new String[] { "1",
				"2", "3", "4", "5" });
		CombineTable cTable = new CombineTable(m, tm);

		TableColumnModel columnModel = cTable.getColumnModel();
		for (Integer integer : m.combineColumns) {
			TableColumn column = columnModel.getColumn(integer);
			column.setCellRenderer(new CombineColumnRender());
			column.setWidth(50);
			column.setMaxWidth(50);
			column.setMinWidth(50);
		}

		cTable.setCellSelectionEnabled(true);
		return cTable;
	}
}