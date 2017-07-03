import java.awt.BorderLayout;
import java.awt.Dimension;
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

		JPanel panel1 = new JPanel();      //上部存放表格
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2 = new JPanel();     //下底部panel
		frame.getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(1,2,0,0));
		
		
		JPanel panel3 = new Table();    //下左
		panel2.add(panel3);
		JPanel panel4 = new BarChartGradientFrame("demo").createDemoPanel();    //下右用来存放条形图
		panel4.setPreferredSize(new Dimension(100,100));
		panel2.add(panel4);
		
		

		String[][] cellData = {                                                          //table1数据
				{"M00001", "P001", "红色", "1000", "2月5日", "还原工段", "1000", "0",
						           "1#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00001", "P001", "红色", "1000", "2月5日", "还原工段", "1000", "0",
							       "2#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00001", "P001", "红色", "1000", "2月5日", "还原工段", "1000", "0",
								   "3#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00002", "P002", "黄色", "1000", "2月6日", "还原工段", "2000", "2",
						           "1#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00002", "P002", "黄色", "1000", "2月6日", "还原工段", "2000", "2",
							       "2#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00002", "P002", "黄色", "1000", "2月6日", "还原工段", "2000", "2",
								   "3#", "10", "24", "240", "8", "8","8","7","8","9" },
				{"M00003", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
						           "1#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00003", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
							       "2#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00003", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
								   "3#", "10", "24", "240", "8", "8","8","7","8","9" },
				{"M00004", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
									"1#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00004", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
									"2#", "10", "24", "240", "8", "8","8","7","8","9"},
				{"M00004", "P003", "蓝色", "1000", "2月6日", "还原工段", "3000", "3",
									"3#", "10", "24", "240", "8", "8","8","7","8","9"}
		        };
		String[] columnNames = { "生产订单", "产品", "规格", "计划数量", "完工日期", "工段",
				"已排程数量", "未排程数量", "可用机台", "产品生产能力", "排程时间", "排程数量", "2月4号",
				"2月5号" };
		
		String[] columnNames2 = { "生产订单", "产品", "规格", "计划数量", "完工日期", "工段",
				"已排程数量", "未排程数量", "可用机台", "产品生产能力", "排程时间", "排程数量","6月5号","6月6号","6月7号"};
		String[] columnNames22 = {"","","","","","","","","","","","","","","","","",""};
		

		JTable table1 = this.getTable(cellData,columnNames22);                  //下表
		
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        GroupableTableHeader tableHeader = new GroupableTableHeader();
        table1.setTableHeader(tableHeader);
        
        
        for(int i = 0 ;i < 12 ; i++){
        	DefaultGroup group = new DefaultGroup();
            group.setRow(0);
            group.setRowSpan(2);      //设定占用两行
            group.setColumn(i);
            group.setHeaderValue(columnNames2[i]);
            tableHeader.addGroup(group);
        }
      
        	DefaultGroup group = new DefaultGroup();
            group.setRow(0);
            group.setColumn(12);
            group.setColumnSpan(3);
            group.setHeaderValue(columnNames2[12]);
            tableHeader.addGroup(group);
            
            group = new DefaultGroup();
            group.setRow(1);
            group.setColumn(12);
            group.setHeaderValue("早");
            tableHeader.addGroup(group);

            group = new DefaultGroup();
            group.setRow(1);
            group.setColumn(13);
            group.setHeaderValue("中");
            tableHeader.addGroup(group);
            
            group = new DefaultGroup();
            group.setRow(1);
            group.setColumn(14);
            group.setHeaderValue("晚");
            tableHeader.addGroup(group);
            
            group = new DefaultGroup();
            group.setColumn(15);                                     //6月6号
            group.setColumnSpan(3);
            group.setHeaderValue(columnNames2[13]);
            tableHeader.addGroup(group);
            
            group = new DefaultGroup();
            group.setRow(1);
            group.setColumn(15);
            group.setHeaderValue("早");
            tableHeader.addGroup(group);

            group = new DefaultGroup();
            group.setRow(1);
            group.setColumn(16);
            group.setHeaderValue("中");
            tableHeader.addGroup(group);
            
            group = new DefaultGroup();
            group.setRow(1);
            group.setColumn(17);
            group.setHeaderValue("晚");
            tableHeader.addGroup(group);
        
	
		panel1.add(new JScrollPane(table1), BorderLayout.CENTER);
		table1.getTableHeader().setPreferredSize(new Dimension(1,42)); //设定表头高度

        
	}
	String[][] table2Datas = {
			{"1#","","","","","",""},
			{"1#","","","","","",""},
			{"2#","","","","","",""},
			{"2#","","","","","",""},
			{"3#","","","","","",""},
			{"3#","","","","","",""}
	};
//	JTable table2 = getTable();
	
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
//		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
////		firsetColumn.setPreferredWidth(30);
////		firsetColumn.setMaxWidth(120);
////		firsetColumn.setMinWidth(120);
////		table.setRowHeight(20);
    }

}
