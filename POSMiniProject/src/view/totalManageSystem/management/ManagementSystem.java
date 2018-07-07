package view.totalManageSystem.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ComponentSettings;
import view.totalManageSystem.popUp.MainFrame;

public class ManagementSystem {
	public static boolean mainPopCheck = true;

	public ManagementSystem() {
		JFrame mf = new JFrame("Total Management System"); // 메인 프레임
		mf.setSize(978, 600);

		JPanel panel = new JPanel(); // 메인 패널

		panel.setLayout(null);

		Color color = new Color(27, 36, 36); // 메인 백그라운드 컬러
		panel.setBackground(color);

		// 로고 부분
		Image mainlogo = new ImageIcon("images/totalManageSystem/Main/mainlogo.jpg").getImage().getScaledInstance(356,
				177, 0);
		JLabel jl_logo = new JLabel(new ImageIcon(mainlogo));

		jl_logo.setBounds(47, 59, 356, 177);

		// branchOffice버튼
		Image bo = new ImageIcon("images/totalManageSystem/Main/branchOffice.jpg").getImage().getScaledInstance(184,
				189, 0);
		JButton branchOffice = new JButton(new ImageIcon(bo));
		branchOffice.setSize(184, 189);

		branchOffice.setBounds(440, 59, 184, 189);

		branchOffice.setBackground(Color.white);
		branchOffice.setOpaque(false);

		branchOffice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (mainPopCheck) {
					new MainFrame("office");
					mainPopCheck = false;
				}
			}
		});

		branchOffice.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				branchOffice.setIcon(new ImageIcon("images/totalManageSystem/Main/branchOffice.jpg"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				branchOffice.setIcon(new ImageIcon("images/totalManageSystem/Main/branchOfficeOnMouse.jpg"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// ProductManage버튼

		Image pm = new ImageIcon("images/totalManageSystem/Main/ProductManage.jpg").getImage().getScaledInstance(287,
				429, 0);
		JButton ProductManage = new JButton(new ImageIcon(pm));
		ProductManage.setSize(287, 429);

		ProductManage.setBounds(650, 70, 287, 429);

		ProductManage.setBackground(Color.white);
		ProductManage.setOpaque(false);
		ProductManage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (mainPopCheck) {
					new MainFrame("product");
					mainPopCheck = false;
				}
			}
		});

		ProductManage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				ProductManage.setIcon(new ImageIcon("images/totalManageSystem/Main/ProductManage.jpg"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ProductManage.setIcon(new ImageIcon("images/totalManageSystem/Main/ProductManageOnMouse.jpg"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// EventManage버튼

		Image em = new ImageIcon("images/totalManageSystem/Main/EventManage.jpg").getImage().getScaledInstance(560, 233,
				0);
		JButton EventManage = new JButton(new ImageIcon(em));
		EventManage.setSize(560, 233);

		EventManage.setBounds(61, 270, 560, 233);

		EventManage.setBackground(Color.white);
		EventManage.setOpaque(false);

		EventManage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (mainPopCheck) {
					new MainFrame("event");
					mainPopCheck = false;
				}
			}
		});

		EventManage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				EventManage.setIcon(new ImageIcon("images/totalManageSystem/Main/EventManage.jpg"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				EventManage.setIcon(new ImageIcon("images/totalManageSystem/Main/EventManageOnMouse.jpg"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JButton[] btns = { branchOffice, ProductManage, EventManage };
		ComponentSettings.imageButtonSetting(btns);
		// 출력
		panel.add(jl_logo);
		panel.add(branchOffice);
		panel.add(ProductManage);
		panel.add(EventManage);

		mf.add(panel);
		mf.setResizable(false);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
