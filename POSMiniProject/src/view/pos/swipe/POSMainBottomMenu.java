package view.pos.swipe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class POSMainBottomMenu extends JPanel {

	public POSMainBottomMenu () { } 
	
	public POSMainBottomMenu(JPanel contentPanel) {
		this.setBounds(0, 0, 1200, 100);
		setLayout(null);
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 1200, 100);
		jp.setBackground(Color.BLACK);
		this.add(jp);
		jp.setLayout(null);
		
		// fake menu button
		
		// 발주 버튼
		JButton orderBtn = new JButton("");
		orderBtn.setBounds(40, 10, 120, 80);
		orderBtn.setBorderPainted(false);
		orderBtn.setBackground(Color.BLACK);
		orderBtn.setOpaque(true);
	    orderBtn.setVerticalTextPosition(SwingConstants.CENTER);
	    orderBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		orderBtn.setIcon(new ImageIcon("images/buttonsImages/order.png"));
		jp.add(orderBtn);
		
		// 저널 조회 버튼
		JButton journalBtn = new JButton("");
		journalBtn.setBounds(200, 10, 120, 80);
		journalBtn.setBorderPainted(false);
		journalBtn.setBackground(Color.BLACK);
		journalBtn.setOpaque(true);
	    journalBtn.setVerticalTextPosition(SwingConstants.CENTER);
	    journalBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		journalBtn.setIcon(new ImageIcon("images/buttonsImages/print.png"));
		jp.add(journalBtn);
		
		// 직전 영수증 버튼
		JButton recBtn = new JButton("");
		recBtn.setBounds(360, 10, 120, 80);
		recBtn.setBorderPainted(false);
		recBtn.setBackground(Color.BLACK);
		recBtn.setOpaque(true);
	    recBtn.setVerticalTextPosition(SwingConstants.CENTER);
	    recBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		recBtn.setIcon(new ImageIcon("images/buttonsImages/beforprint.png"));
		jp.add(recBtn);
		
		// 폐기 버튼
		JButton scrapBtn = new JButton("");
		scrapBtn.setBounds(520, 10, 120, 80);
		scrapBtn.setBorderPainted(false);
		scrapBtn.setBackground(Color.BLACK);
		scrapBtn.setOpaque(true);
	    scrapBtn.setVerticalTextPosition(SwingConstants.CENTER);
	    scrapBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		scrapBtn.setIcon(new ImageIcon("images/buttonsImages/trash.png"));
		jp.add(scrapBtn);
		
		// 시재 버튼
		JButton readyBtn = new JButton("");
		readyBtn.setBounds(680, 10, 120, 80);
		readyBtn.setBorderPainted(false);
		readyBtn.setBackground(Color.BLACK);
		readyBtn.setOpaque(true);
	    readyBtn.setVerticalTextPosition(SwingConstants.CENTER);
	    readyBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		readyBtn.setIcon(new ImageIcon("images/buttonsImages/count.png"));
		jp.add(readyBtn);
		
		//마우스 이벤트
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == journalBtn) {
					contentPanel.removeAll();
					contentPanel.add(new SearchJournel());
					contentPanel.repaint();
					POSMainFrame.eventSwipe.suspend();
					
				}
				if (e.getSource() == orderBtn) {

					contentPanel.removeAll();
					contentPanel.add(new ProductOrder());
					contentPanel.repaint();
					POSMainFrame.eventSwipe.suspend();

					
				}
				if (e.getSource() == readyBtn) {

					contentPanel.removeAll();
					contentPanel.add(new ReadyMoney());
					contentPanel.repaint();
					POSMainFrame.eventSwipe.suspend();

					
				}
				if (e.getSource() == scrapBtn) {

					contentPanel.removeAll();
					contentPanel.add(new ProductScrap());
					contentPanel.repaint();
					POSMainFrame.eventSwipe.suspend();
				}

			}
		};
		orderBtn.addActionListener(action);
		journalBtn.addActionListener(action);
		recBtn.addActionListener(action);
		readyBtn.addActionListener(action);
		scrapBtn.addActionListener(action);
	}

}
