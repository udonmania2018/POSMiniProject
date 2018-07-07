package view.totalManageSystem.popUp;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.totalManageSystem.management.ManagementSystem;

public class MainFrame extends JFrame {

	private ControllPanel sideButtons;
	private String category;
	public static boolean popUpMainFrameCheck = true;
	public MainFrame(){}
	
	public MainFrame(String caegory) {
		this.setSize(600, 600);
		this.setTitle("KH 편의점 종합 관리 시스템");
		this.getContentPane().setBackground(new Color(27, 36, 36));
		this.setLayout(null);
		this.category = caegory;
		
		sideButtons = new ControllPanel(this.category,this);
		this.add(sideButtons);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				ManagementSystem.mainPopCheck= true;
			}
		});
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
