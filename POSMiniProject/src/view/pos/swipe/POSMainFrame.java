package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import thread.EventViewSwipe;

public class POSMainFrame extends JFrame {

	private JPanel contentPane;
	private POSMainCenterMenu centerMenu = new POSMainCenterMenu();
	public static Thread eventSwipe ;
	public static Object[][] staticData;
	public static int[] counterMoneys = {5,10,20,40,100,500,1000,1000};
	
	public POSMainFrame() {
		getContentPane().setLayout(null);
		this.setBounds(400, 400, 1200, 640);
		this.setResizable(false); // 창 크기 변경 불가
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 1200, 600);
		setContentPane(contentPane);

		
		
		POSMainCenterMenu centerMenu = new POSMainCenterMenu();
		centerMenu.setBounds(0, 100, 1200, 400);
		contentPane.add(centerMenu);

		POSMainUpperMenu upMenu = new POSMainUpperMenu(centerMenu); // 상단메뉴 여기수정
		contentPane.add(upMenu);
		upMenu.setBounds(0, 0, 1200, 100);
		upMenu.setLayout(null);
		

		POSMainBottomMenu bottomMenu = new POSMainBottomMenu(centerMenu);
		bottomMenu.setBounds(0, 500, 1200, 100);
		contentPane.add(bottomMenu);
		bottomMenu.setLayout(null);

		eventSwipe = new EventViewSwipe(centerMenu,this);
		eventSwipe.start();
		// 중앙정렬
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, // X축
				(screenSize.height - frameSize.height) / 2);// Y축

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
