package view.totalManageSystem.popUp.product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import dao.tmsDao.Product;
import model.vo.ProductGroup;
import view.ComponentSettings;
import view.totalManageSystem.management.ManagementSystem;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.GroupManage;
import view.totalManageSystem.popUp.MainFrame;

public class ProductMain extends JPanel {
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Product dao = new Product();

	public ProductMain(MainFrame frame, ControllPanel mainPanel) {

		this.setBounds(0, 0, 580, 600);
		this.setBackground(Color.white);
		this.setLayout(null);
		JLabel lblNewLabel = new JLabel("제 품 추 가");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 20, 206, 82);
		add(lblNewLabel);

		JButton btnNewButton_1 = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		btnNewButton_1.setBounds(150, 470, 100, 40);
		btnNewButton_1.setBorderPainted(false);
		add(btnNewButton_1);

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
		btnNewButton.setBounds(423, 40, 100, 40);
		btnNewButton.setBorderPainted(false);
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new ProductModifyMain(frame, mainPanel));
				mainPanel.repaint();
			}
		});
		btnNewButton.setBackground(new Color(52, 152, 219));

		JButton btnNewButton_2 = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		btnNewButton_2.setBounds(350, 470, 100, 40);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ManagementSystem.mainPopCheck = true;
			}
		});
		add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488\uBD84\uB958");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 130, 170, 40);
		add(lblNewLabel_1);

		JLabel label = new JLabel("\uBC1C\uC8FC\uAC00\uACA9");
		label.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(70, 232, 170, 40);
		add(label);

		JLabel lblNewLabel_2 = new JLabel("\uC81C\uC870\uD68C\uC0AC");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_2.setBounds(70, 182, 170, 40);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC0C1\uD488\uAC00\uACA9");
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(70, 282, 170, 40);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC0C1\uD488\uBA85");
		lblNewLabel_4.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(70, 330, 170, 40);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uC720\uD1B5\uAE30\uD55C");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_5.setBounds(70, 380, 170, 40);
		add(lblNewLabel_5);

		textField_1 = new JTextField();
		textField_1.setBounds(300, 232, 200, 40);
		add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(300, 285, 200, 40);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(300, 335, 200, 40);
		add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(400, 385, 100, 40);
		add(textField_5);
		textField_5.setColumns(10);

		ArrayList<ProductGroup> glist = dao.selectProductGroup();

		JComboBox comboBox2 = new JComboBox();

		if (glist != null) {
			for (int i = 0; i < glist.size(); i++) {
				comboBox2.addItem(glist.get(i).getProductGroupName());
			}
		} else {
			comboBox2.addItem("제품 분류를 추가해주세요...");
		}
		comboBox2.setBounds(300, 134, 200, 40);
		comboBox2.setBackground(UIManager.getColor("Table.sortIconLight"));
		add(comboBox2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("Table.sortIconLight"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\uB86F\uB370", "\uB18D\uC2EC", "\uC0BC\uC591" }));
		comboBox.setBounds(300, 184, 200, 40);
		add(comboBox);

		JButton plusButton = new JButton(new ImageIcon("images/buttonsImages/PLUS.png"));
		plusButton.setFont(new Font("굴림", Font.PLAIN, 10));
		plusButton.setBounds(506, 137, 27, 27);
		plusButton.setBorderPainted(false);
		plusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					new GroupManage(new String("product"), true);
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(plusButton);

		JButton minusButton = new JButton(new ImageIcon("images/buttonsImages/MINUS.png"));
		minusButton.setFont(new Font("굴림", Font.PLAIN, 10));
		minusButton.setBounds(540, 137, 27, 27);
		minusButton.setBorderPainted(false);
		minusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					new GroupManage(new String("product"), false);
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(minusButton);

		JButton plusButton2 = new JButton(new ImageIcon("images/buttonsImages/PLUS.png"));
		plusButton2.setFont(new Font("굴림", Font.PLAIN, 10));
		plusButton2.setBounds(506, 195, 27, 27);
		plusButton2.setBorderPainted(false);
		plusButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					new GroupManage(new String("manufacturer"), true);
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(plusButton2);

		JButton minusButton2 = new JButton(new ImageIcon("images/buttonsImages/MINUS.png"));
		minusButton2.setFont(new Font("굴림", Font.PLAIN, 10));
		minusButton2.setBounds(540, 195, 27, 27);
		minusButton2.setBorderPainted(false);
		minusButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					new GroupManage(new String("manufacturer"), false);
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(minusButton2);
		
		JComboBox comboBox_Date = new JComboBox();
		comboBox_Date.setModel(new DefaultComboBoxModel(new String[] {"\uB144/\uC6D4", "\uC6D4/\uC77C"}));
		comboBox_Date.setBounds(300, 385, 88, 42);
		add(comboBox_Date);

		JButton[] buttons = { plusButton, minusButton, plusButton2, minusButton2 };
		ComponentSettings.imageButtonSetting(buttons);

	}
}
