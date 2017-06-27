import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.CombineData;
import com.CombineTable;
import com.cherish.header.DefaultGroup;
import com.cherish.header.GroupableTableHeader;

public class TableTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableTest window = new TableTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TableTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		frame.setBounds(100, 100, 1244, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2);

		String[][] cellData = {
				{"M00001", "P001", "红色", "1000", "2月5日", "还原工段", "1000", "0",
						"1#", "10", "24", "240", "24", "" ,""},
				{"M00001", "P001", "红色", "1000", "2月5日", "还原工段", "1000", "0",
							"1#", "10", "24", "240", "24", "" ,""},
				{"M00001", "P001", "红色", "1000", "2月5日", "还原工段", "1000", "0",
								"1#", "10", "24", "240", "24", "",""  },
				{"M00002", "P002", "黄色", "1000", "2月6日", "还原工段", "2000", "2",
						"1#", "10", "24", "240", "24", "" ,""},
				{"M00002", "P002", "黄色", "1000", "2月6日", "还原工段", "2000", "2",
							"1#", "10", "24", "240", "24", "",""},
				{"M00002", "P002", "黄色", "1000", "2月6日", "还原工段", "2000", "2",
								"1#", "10", "24", "240", "24", "","" },
				{"M00003", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
						"1#", "10", "24", "240", "24", "" ,""},
				{"M00003", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
							"1#", "10", "24", "240", "24", "","" },
				{"M00003", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
								"1#", "10", "24", "240", "24", "" } };
		String[] columnNames = { "生产订单", "产品", "规格", "计划数量", "完工日期", "工段",
				"已排程数量", "未排程数量", "可用机台", "产品生产能力", "排程时间", "排程数量", "2月4号",
				"2月5号" };
		
		String[] columnNames2 = { "生产订单", "产品", "规格", "计划数量", "完工日期", "工段",
				"已排程数量", "未排程数量", "可用机台", "产品生产能力", "排程时间", "排程数量","拆分表头","拆分表头","拆分表头"};
		panel.setLayout(new BorderLayout(0, 0));
		
		JTable table = new JTable(cellData, columnNames);
		panel.add(new JScrollPane(table));


		JTable table2 = this.getTable(cellData,columnNames2);                  //下表
		
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        GroupableTableHeader tableHeader = new GroupableTableHeader();
        table2.setTableHeader(tableHeader);
        
        DefaultGroup group = new DefaultGroup();
        group.setRow(0);
        group.setRowSpan(2);      //设定占用两行
        group.setColumn(0);
        group.setHeaderValue("生产订单");
        tableHeader.addGroup(group);
        
        for(int i = 1 ;i < 15 ; i++){
        	group = new DefaultGroup();
        	group.setRow(0);
        	group.setColumn(i);
        	group.setColumnSpan(1);
        	group.setHeaderValue(i+"");
        	tableHeader.addGroup(group);
        }
        
        initHeader(table2);
        
        
		panel2.setLayout(new BorderLayout(0, 0));
		panel2.add(new JScrollPane(table2), BorderLayout.CENTER);
//		table2.getTableHeader().setPreferredSize(new Dimension(1,65)); //设定表头高度

        
	}
	
	private static JTable getTable(String[][] datas,String[] columnNames) {                
		ArrayList<Integer> combineColumns = new ArrayList<Integer>();   //用来保存需要合并的列数
		for(int i = 0 ; i < 7 ; i++){
			combineColumns.add(i);
		}
		CombineData m = new CombineData(datas, combineColumns);                                                     //AAAAAAA
//		String[] columnNames = {"生产订单","产品", "可用机台", "产品能力", "排程时间"};       //表头名
		DefaultTableModel tm = new DefaultTableModel(datas,columnNames);                                            //BBBBBBBB
		JTable cTable = new CombineTable(m, tm);                                                              //CCCCCCC

		TableColumn column = cTable.getColumnModel().getColumn(0);
//		column.setCellRenderer(new CombineColumnRender());
//		column.setWidth(50);                                             //去掉第一列宽度设定
//		column.setMaxWidth(50);
//		column.setMinWidth(50);
		cTable.setCellSelectionEnabled(true);
		return cTable;
	}
	private void initHeader(JTable table){
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(30);
		firsetColumn.setMaxWidth(120);
		firsetColumn.setMinWidth(120);
		table.setRowHeight(20);
    }

}
