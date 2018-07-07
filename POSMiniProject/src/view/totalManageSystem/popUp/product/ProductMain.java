package view.totalManageSystem.popUp.product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.totalManageSystem.ProductController;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;
import view.ComponentSettings;
import view.totalManageSystem.management.ManagementSystem;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.GroupManage;
import view.totalManageSystem.popUp.MainFrame;

public class ProductMain extends JPanel {
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboDate;
	private JComboBox monthday;
	private JComboBox yearmonth;
	private ProductController pct = new ProductController();

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

		JLabel label = new JLabel("상품명");
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

		JLabel lblNewLabel_4 = new JLabel("발주가격");
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

		ArrayList<ProductGroup> glist = pct.selectProductGroup();

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

		ArrayList<ManufactureGroup> mfList = pct.selectManufacturerGroup();

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("Table.sortIconLight"));
		if (mfList != null) {
			for (int i = 0; i < mfList.size(); i++) {
				comboBox.addItem(mfList.get(i).getManufactureGroupName());
			}
		} else {
			comboBox.addItem("제조 회사를 추가해주세요...");
		}
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
					new GroupManage(new String("product"), true,"","");
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(plusButton);

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pct = new ProductController();
				String productCode = comboBox.getSelectedIndex() + 1 + "";
				String manufacturerCode = comboBox2.getSelectedIndex() + "";

				System.out.println(productCode + " , " + manufacturerCode);
			}
		});

		JButton minusButton = new JButton(new ImageIcon("images/buttonsImages/MINUS.png"));
		minusButton.setFont(new Font("굴림", Font.PLAIN, 10));
		minusButton.setBounds(540, 137, 27, 27);
		minusButton.setBorderPainted(false);
		minusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					int tempCode = comboBox2.getSelectedIndex()+1;
					String saveCode = "";
					if(tempCode < 10) {
						saveCode = "0" + tempCode;
					} else {
						saveCode = tempCode+"";
					}
					new GroupManage(new String("product"), false,saveCode,comboBox2.getSelectedItem().toString());
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
					new GroupManage(new String("manufacturer"), true,"","");
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
					int tempCode = comboBox.getSelectedIndex()+1;
					String saveCode = "";
					
					if(tempCode < 10){
						saveCode = "000" + tempCode;
					} else if(tempCode < 100){
						saveCode = "00" + tempCode;
					} else if (tempCode < 1000){
						saveCode = "0" + tempCode;
					} else {
						saveCode = tempCode+"";
					}
					new GroupManage(new String("manufacturer"), false,saveCode,comboBox.getSelectedItem()+"");
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(minusButton2);

		comboDate = new JComboBox();
		comboDate.setModel(new DefaultComboBoxModel(new String[] { "년/개월", "개월/일" }));
		comboDate.setBounds(300, 385, 85, 42);
		add(comboDate);

		monthday = new JComboBox();
		monthday.setBounds(446, 385, 55, 42);
		add(monthday);

		yearmonth = new JComboBox();
		yearmonth.setBounds(388, 385, 55, 42);
		add(yearmonth);

		monthday.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		yearmonth.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05" }));

		Calendar c = Calendar.getInstance();
		comboDate.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				Object a = e.getItem();

				if (comboDate.getSelectedIndex() == 0) {
					monthday.setModel(new DefaultComboBoxModel(
							new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
					yearmonth.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05" }));
					frame.repaint();
					frame.setVisible(true);
				}
				if (comboDate.getSelectedIndex() == 1) {
					monthday.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07",
							"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
							"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
					yearmonth.setModel(new DefaultComboBoxModel(
							new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
					frame.repaint();
					frame.setVisible(true);
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int checkPgCode = comboBox2.getSelectedIndex() + 1;
				int checkManuCode = comboBox.getSelectedIndex() + 1;
				String savePgCode = "";
				String saveManuCode = "";
				if (checkPgCode < 10) {
					savePgCode = "0" + checkPgCode;
				} else {
					savePgCode = checkPgCode+"";
				}

				if (checkManuCode < 10) {
					saveManuCode = "000" + checkManuCode;
				} else if (checkManuCode < 100) {
					saveManuCode = "00" + checkManuCode;
				} else if (checkManuCode < 1000) {
					saveManuCode = "0" + checkManuCode;
				} else {
					saveManuCode = checkManuCode+"";
				}

				Product product = new Product(savePgCode, saveManuCode, textField_1.getText(),
						Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()),
						(comboDate.getSelectedIndex() == 0 ? "1" : "2") + yearmonth.getSelectedItem()
								+ monthday.getSelectedItem());
				pct.addProduct(product);
				
				comboBox.setSelectedIndex(0);
				comboBox2.setSelectedIndex(0);
				comboDate.setSelectedIndex(0);
				monthday.setSelectedIndex(0);
				yearmonth.setSelectedIndex(0);
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				
			}
		});

		JButton[] buttons = { plusButton, minusButton, plusButton2, minusButton2 };
		ComponentSettings.imageButtonSetting(buttons);

	}

}
