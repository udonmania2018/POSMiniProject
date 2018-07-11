package view.pos.swipe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.pos.popup.safe.SafeMoney;

public class POSMainUpperMenu extends JPanel implements ActionListener {
	private JFrame safeMoneyframe = new JFrame();

	public POSMainUpperMenu(JPanel contentPanel) {
		this.setBounds(0, 0, 1200, 100);
		setLayout(null);
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 1200, 100);
		jp.setBackground(Color.BLACK);
		this.add(jp);
		jp.setLayout(null);

		// SOS버튼
		JButton sosBtn = new JButton("");
		sosBtn.setBounds(40, 10, 120, 80);
		sosBtn.setBorderPainted(false);
		sosBtn.setOpaque(true);
		sosBtn.setVerticalTextPosition(SwingConstants.CENTER);
		sosBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		sosBtn.setIcon(new ImageIcon("images/buttonsImages/sos.png"));
		jp.add(sosBtn);

		// 상품 버튼
		JButton productBtn = new JButton("");
		productBtn.setBounds(200, 10, 120, 80);
		productBtn.setBorderPainted(false);
		productBtn.setBackground(Color.BLACK);
		productBtn.setOpaque(true);
		productBtn.setVerticalTextPosition(SwingConstants.CENTER);
		productBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		productBtn.setIcon(new ImageIcon("images/buttonsImages/product.png"));
		jp.add(productBtn);

		// 금고 버튼
		JButton safeBtn = new JButton("");
		safeBtn.setBounds(360, 10, 120, 80);
		safeBtn.setBorderPainted(false);
		safeBtn.setBackground(Color.BLACK);
		safeBtn.setOpaque(true);
		safeBtn.setVerticalTextPosition(SwingConstants.CENTER);
		safeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		safeBtn.setIcon(new ImageIcon("images/buttonsImages/money.png"));
		jp.add(safeBtn);

		// 보류 버튼
		JButton pauseBtn = new JButton("");
		pauseBtn.setBounds(520, 10, 120, 80);
		pauseBtn.setBorderPainted(false);
		pauseBtn.setBackground(Color.BLACK);
		pauseBtn.setOpaque(true);
		pauseBtn.setVerticalTextPosition(SwingConstants.CENTER);
		pauseBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		pauseBtn.setIcon(new ImageIcon("images/buttonsImages/boryu.png"));
		jp.add(pauseBtn);

		// 메인 버튼
		JButton callMainBtn = new JButton("");
		callMainBtn.setBounds(680, 10, 120, 80);
		callMainBtn.setBorderPainted(false);
		callMainBtn.setBackground(Color.BLACK);
		callMainBtn.setOpaque(true);
		callMainBtn.setVerticalTextPosition(SwingConstants.CENTER);
		callMainBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		callMainBtn.setIcon(new ImageIcon("images/buttonsImages/main.png"));
		jp.add(callMainBtn);

		// 결제 버튼
		JButton paymentBtn = new JButton("");
		paymentBtn.setBounds(900, 10, 240, 80);
		paymentBtn.setBorderPainted(false);
		paymentBtn.setBackground(Color.BLACK);
		paymentBtn.setOpaque(true);
		paymentBtn.setVerticalTextPosition(SwingConstants.CENTER);
		paymentBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		paymentBtn.setIcon(new ImageIcon("images/buttonsImages/cash.png"));
		jp.add(paymentBtn);

		ActionListener action = new ActionListener() {

			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				if (e.getSource() == productBtn) {
					contentPanel.removeAll();
					contentPanel.add(new ProductSelect());
					contentPanel.repaint();
					synchronized (POSMainFrame.eventSwipe) {
						POSMainFrame.eventSwipe.suspend();
					}

				} else if (e.getSource() == callMainBtn) {
					contentPanel.removeAll();
					contentPanel.add(new POSMainCenterMenu());
					contentPanel.repaint();
					synchronized (POSMainFrame.eventSwipe) {
						POSMainFrame.eventSwipe.resume();
					}

				} else if (e.getSource() == paymentBtn) {
					if (contentPanel instanceof POSMainCenterMenu) {
						// contentPanel.remove(((POSMainCenterMenu)
						// contentPanel).getScrollPane2());
						contentPanel.removeAll();
						contentPanel.remove(((POSMainCenterMenu) contentPanel).getScrollPane3());
						Payment temp = new Payment();
						temp.setLocation(800, 200);
						temp.setOpaque(false);
						contentPanel.add(temp);
						synchronized (POSMainFrame.eventSwipe) {
							POSMainFrame.eventSwipe.suspend();

						}
						contentPanel.setVisible(true);
					}
					// System.out.println("결제 버튼 처리 OK");
				} else if (e.getSource() == sosBtn) {
					JOptionPane.showMessageDialog(null, "경찰서로 통보되었습니다", "SOS", JOptionPane.ERROR_MESSAGE);
				} else if (e.getSource() == pauseBtn) {
					JOptionPane.showMessageDialog(null, "현재 내용이 보류되었습니다.", "보류", JOptionPane.WARNING_MESSAGE);
				} else if (e.getSource() == safeBtn) {
					SafeMoney sm = new SafeMoney(safeMoneyframe);
					safeMoneyframe.add(sm);
					safeMoneyframe.setVisible(true);
					safeMoneyframe.setSize(621, 400);

					// 새 창 띄울때 가운데 정렬
					Dimension frameSize = sm.getSize();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					sm.setLocation((screenSize.width - frameSize.width) / 2, // X축
							(screenSize.height - frameSize.height) / 2);// Y축
				}
			}
		};

		safeBtn.addActionListener(action);
		callMainBtn.addActionListener(action);
		productBtn.addActionListener(action);
		paymentBtn.addActionListener(action);
		sosBtn.addActionListener(action);
		pauseBtn.addActionListener(action);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
