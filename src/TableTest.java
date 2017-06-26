import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


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
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setBounds(100, 100, 1244, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel);
		
		Object[][] cellData = {{"M00001","P001","红色","1000","2月5日","还原工段","1000","0","1#","10","24","240","24",""},
				               {"","","","","","","","","2#","10","24","240","24",""},
				               {"","","","","","","","","3#","10","24","240","15",""},
				               {"M00001","P001","红色","1000","2月5日","还原工段","1000","0","1#","10","24","240","24",""},
				               {"","","","","","","","","2#","10","24","240","24",""},
				               {"","","","","","","","","3#","10","24","240","15",""},
				               {"M00001","P001","红色","1000","2月5日","还原工段","1000","0","1#","10","24","240","24",""},
				               {"","","","","","","","","2#","10","24","240","24",""},
				               {"","","","","","","","","3#","10","24","240","15",""}
		};
		String[] columnNames = {"生产订单", "产品","规格","计划数量","完工日期","工段","已排程数量","未排程数量","可用机台","产品生产能力","排程时间","排程数量","2月4号","2月5号"};
		JTable table = new JTable(cellData, columnNames);
		panel.add(new JScrollPane(table),BorderLayout.CENTER);
//        table.addColumn(new TableColumn());		
//		panel.add(table, BorderLayout.CENTER);
		
	}

}
