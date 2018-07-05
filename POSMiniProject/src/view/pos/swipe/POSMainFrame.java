package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class POSMainFrame extends JFrame {

	private JPanel contentPane;
	POSMainCenterMenu centerMenu = new POSMainCenterMenu();

	public POSMainFrame() {
		getContentPane().setLayout(null);
		this.setBounds(400, 400, 1200, 640);
		this.setResizable(false); // â ũ�� ���� �Ұ�

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 1200, 600);
		setContentPane(contentPane);

		POSMainCenterMenu centerMenu = new POSMainCenterMenu();
		centerMenu.setBounds(0, 100, 1200, 400);
		contentPane.add(centerMenu);

		POSMainUpperMenu upMenu = new POSMainUpperMenu(centerMenu); // ��ܸ޴� �������
		contentPane.add(upMenu);
		upMenu.setBounds(0, 0, 1200, 100);
		upMenu.setLayout(null);

		POSMainBottomMenu bottomMenu = new POSMainBottomMenu(centerMenu);
		bottomMenu.setBounds(0, 500, 1200, 100);
		contentPane.add(bottomMenu);
		bottomMenu.setLayout(null);

		// �߾�����
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, // X��
				(screenSize.height - frameSize.height) / 2);// Y��

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}