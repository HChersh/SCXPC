import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridLayout;


public class SCXPC {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCXPC window = new SCXPC();
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
	public SCXPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1245, 781);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 0, 0));   //4通过读取生产订单获取，17是已知的
		
		frame.getContentPane().add(new JButton("1"));
		frame.getContentPane().add(new JButton("2"));
		frame.getContentPane().add(new JButton("3"));
		frame.getContentPane().add(new JButton("4"));
		frame.getContentPane().add(new JButton("5"));	
		frame.getContentPane().add(new JButton("6"));
		frame.getContentPane().add(new JButton("7"));
		frame.getContentPane().add(new JButton("8"));	
		frame.getContentPane().add(new JButton("9"));
		frame.getContentPane().add(new JButton("10"));
		frame.getContentPane().add(new JButton("11"));	
		frame.getContentPane().add(new JButton("12"));
		frame.getContentPane().add(new JButton("13"));
		frame.getContentPane().add(new JButton("14"));	
		frame.getContentPane().add(new JButton("15"));
		frame.getContentPane().add(new JButton("16"));
		frame.getContentPane().add(new JButton("17"));	
		
		
//		JButton button = new JButton("啊啊啊啊");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("addd");
//			}
//		});
//		frame.getContentPane().add(button, BorderLayout.NORTH);
		
		
		
		
	}

}
