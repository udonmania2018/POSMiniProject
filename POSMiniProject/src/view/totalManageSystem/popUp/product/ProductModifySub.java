package view.totalManageSystem.popUp.product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.totalManageSystem.ProductController;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;

public class ProductModifySub extends JPanel {

	// ���� ����
	private JLabel title;
	private JButton addButton;

	// ���â ����
	private JTextField categorize;
	private JTextField code;
	private JTextField company;
	private JTextField productName;
	private JTextField productPrice;
	private JTextField sellByDate;
	private JTextField codInput;

	private JTextField comInput;
	private JTextField sellInput;
	private JComboBox comboDate;
	private JComboBox monthday;
	private JComboBox yearmonth;
	
	private ProductController pc = new ProductController();
	private Product p ;
	private JTextField textField;
	private JTextField textField_1;

	public ProductModifySub(MainFrame frame, ControllPanel mainPanel, String productCode) {
		this.setBounds(0,0,580,600);
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		p = pc.selectProductOnCode(productCode);
		
		// ����(��ǰ����)
		title = new JLabel("�� ǰ �� ��");
		title.setFont(new Font("���ʷҵ���", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 20, 206, 82);
		this.add(title);

		// �߰� ��ư
		JButton addButton;
		addButton = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		addButton.setBorderPainted(false); // ��ư �׵θ� ��������
		addButton.setBounds(423, 40, 100, 40); // ��ư ũ�� ����
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new ProductMain(frame, mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		add(addButton);

		// ���â
		categorize = new JTextField();
		categorize.setAutoscrolls(false);
		categorize.setHorizontalAlignment(SwingConstants.CENTER);
		categorize.setText("��ǰ �з�");
		categorize.setBounds(55, 158, 141, 42);
		categorize.setBackground(Color.LIGHT_GRAY);
		add(categorize);
		categorize.setColumns(10);

		code = new JTextField();
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setText("��ǰ �ڵ�");
		code.setColumns(10);
		code.setBackground(Color.LIGHT_GRAY);
		code.setBounds(55, 199, 141, 42);
		add(code);

		company = new JTextField();
		company.setHorizontalAlignment(SwingConstants.CENTER);
		company.setText("���� ȸ��");
		company.setColumns(10);
		company.setBackground(Color.LIGHT_GRAY);
		company.setBounds(55, 278, 141, 42);
		add(company);

		productName = new JTextField();
		productName.setHorizontalAlignment(SwingConstants.CENTER);
		productName.setText("��ǰ��");
		productName.setColumns(10);
		productName.setBackground(Color.LIGHT_GRAY);
		productName.setBounds(55, 237, 141, 42);
		add(productName);

		productPrice = new JTextField();
		productPrice.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice.setText("��ǰ ����");
		productPrice.setColumns(10);
		productPrice.setBackground(Color.LIGHT_GRAY);
		productPrice.setBounds(55, 360, 141, 42);
		add(productPrice);

		sellByDate = new JTextField();
		sellByDate.setHorizontalAlignment(SwingConstants.CENTER);
		sellByDate.setText("�������");
		sellByDate.setColumns(10);
		sellByDate.setBackground(Color.LIGHT_GRAY);
		sellByDate.setBounds(55, 319, 141, 42);
		add(sellByDate);

		codInput = new JTextField();
		codInput.setText(productCode);
		codInput.setColumns(10);
		// �����Ұ��� �ϰ� ����
		codInput.setEditable(false);
		codInput.setBounds(195, 199, 328, 42);
		add(codInput);

		// ��ǰ�� �ؽ�Ʈ�ʵ�
		comInput = new JTextField();
		comInput.setText(p.getProductName());
		comInput.setColumns(10);
		comInput.setBounds(195, 237, 328, 42);
		add(comInput);

		// ��ǰ���� �ؽ�Ʈ�ʵ�
		sellInput = new JTextField();
		sellInput.setText(p.getProductPrice() + "");
		sellInput.setColumns(10);
		sellInput.setBounds(195, 360, 328, 42);
		add(sellInput);

		// ������ư
		JButton reviseButton;
		reviseButton = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
		reviseButton.setBorderPainted(false); // ��ư �׵θ� ��������
		reviseButton.setBounds(66, 470, 100, 40); // ��ư ũ�� ����
		add(reviseButton);

		// ������ư
		JButton deleteButton;
		deleteButton = new JButton(new ImageIcon("images/buttonsImages/DELETE_ICON.PNG"));
		deleteButton.setBorderPainted(false); // ��ư �׵θ� ��������
		deleteButton.setBounds(247, 470, 100, 40); // ��ư ũ�� ����
		add(deleteButton);
		
		

		// ��ҹ�ư
		JButton backButton;
		backButton = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // ��ư �׵θ� ��������
		backButton.setBounds(423, 470, 100, 40); // ��ư ũ�� ����
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new ProductModifyMain(frame, mainPanel));
				mainPanel.repaint();
			}
		});
		add(backButton);

		JLabel label = new JLabel("( \uC81C\uD488\uBA85 )");
		label.setFont(new Font("���� ���", Font.PLAIN, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 86, 580, 50);
		add(label);
		
		//��ǰ�з� �޺��ڽ�
		JComboBox catInput = new JComboBox();
		catInput.setForeground(Color.BLACK);
		catInput.setBackground(new Color(255, 255, 255));
		
		// ArrayList ���� �� ManufactureGroup ���׸���
		ArrayList<ProductGroup> list = pc.selectProductGroup();
		for(int i = 0; i < list.size(); i++) {
			catInput.addItem(list.get(i).getProductGroupName());	
		}
		
		int tempcode = Integer.parseInt(p.getProductGroupCode());
		System.out.println("Tempcode = " + tempcode);
		for(int i = 0; i < catInput.getItemCount(); i++){
			if(i == tempcode - 1){
				catInput.setSelectedIndex(i);
				break;
			}
		}
		catInput.setBounds(195, 158, 328, 42);
		add(catInput);
		
		JComboBox nameInput = new JComboBox();
		
		
		nameInput.setForeground(Color.BLACK);
		nameInput.setBackground(new Color(255, 255, 255));
		
		// manufacturegroupname
		ArrayList<ManufactureGroup> list2 = pc.selectManufacturerGroup();
		for (int i = 0; i < list2.size(); i++) {
			nameInput.addItem(list2.get(i).getManufactureGroupName());
		}
		
		tempcode = Integer.parseInt(p.getManufacturerCode());
		System.out.println("Tempcode = " + tempcode);
		for(int i = 0; i < nameInput.getItemCount(); i++){
			if(i == tempcode - 1){
				nameInput.setSelectedIndex(i);
				break;
			}
		}
		
		
		nameInput.setBounds(195, 278, 328, 42);
		add(nameInput);
		
		
		comboDate = new JComboBox();
		comboDate.setModel(new DefaultComboBoxModel(new String[] { "��/����", "����/��" }));
		comboDate.setBounds(195, 319, 110, 42);
		add(comboDate);

		monthday = new JComboBox();
		monthday.setBounds(410, 319, 113, 42);
		add(monthday);

		yearmonth = new JComboBox();
		yearmonth.setBounds(303, 319, 110, 42);
		add(yearmonth);

		monthday.setModel(new DefaultComboBoxModel(
				new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		yearmonth.setModel(new DefaultComboBoxModel(new String[] { "00","01", "02", "03", "04", "05" }));
		
		textField = new JTextField();
		textField.setText("\uBC1C\uC8FC \uAC00\uACA9");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(55, 400, 141, 42);
		textField.setEditable(false);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(195, 400, 328, 42);
		add(textField_1);
		textField_1.setText(p.getOrderPrice()+"");

		Calendar c = Calendar.getInstance();
		comboDate.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				Object a = e.getItem();

				if (comboDate.getSelectedIndex() == 0) {
					monthday.setModel(new DefaultComboBoxModel(
							new String[] { "00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
					yearmonth.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05" }));
					frame.repaint();
					frame.setVisible(true);
				}
				if (comboDate.getSelectedIndex() == 1) {
					monthday.setModel(new DefaultComboBoxModel(new String[] { "00","01", "02", "03", "04", "05", "06", "07",
							"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
							"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
					yearmonth.setModel(new DefaultComboBoxModel(
							new String[] {"00" ,"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
					frame.repaint();
					frame.setVisible(true);
				}
			}
		});
		
		
		for (int i = 0; i < comboDate.getItemCount(); i++) {
			if(p.getSellByDate().substring(0,1).equals("1")){	
				comboDate.setSelectedIndex(0);
				break;
			} else {
				comboDate.setSelectedIndex(1);
				break;
			}
		}
		
		int selectMonth = Integer.parseInt(p.getSellByDate().substring(3));
		System.out.println(p.getSellByDate().substring(3) + "����");
		for (int i = 0; i < monthday.getItemCount(); i++) {
			if(selectMonth == i){
				monthday.setSelectedIndex(i);
				break;
			}
		}
		int selectYear = Integer.parseInt(p.getSellByDate().substring(1,3));
		for (int i = 0; i < yearmonth.getItemCount(); i++) {
			if(selectYear == i){
				yearmonth.setSelectedIndex(i);
				break;
			}
		}
		
		reviseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 int checkPgCode = catInput.getSelectedIndex() + 1;
	               int checkManuCode = nameInput.getSelectedIndex() + 1;
	               String savePgCode = "";
	               String saveManuCode = "";
	               if (checkPgCode < 10) {
	                  savePgCode = "0" + checkPgCode;
	               } else {
	                  savePgCode = checkPgCode + "";
	               }

	               if (checkManuCode < 10) {
	                  saveManuCode = "000" + checkManuCode;
	               } else if (checkManuCode < 100) {
	                  saveManuCode = "00" + checkManuCode;
	               } else if (checkManuCode < 1000) {
	                  saveManuCode = "0" + checkManuCode;
	               } else {
	                  saveManuCode = checkManuCode + "";
	               }
				
				pc.modifyProduct(new Product(savePgCode, saveManuCode, comInput.getText(), Integer.parseInt(sellInput.getText().trim()), Integer.parseInt(textField_1.getText().trim()),
	                     (comboDate.getSelectedIndex() == 0 ? "1" : "2") + yearmonth.getSelectedItem()
                         + monthday.getSelectedItem()),p);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new ProductModifyMain(frame, mainPanel));
				mainPanel.repaint();
			}
		});
		deleteButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pc.deleteProduct(p.getBarcode());	
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new ProductModifyMain(frame, mainPanel));
				mainPanel.repaint();
			}
		});
		this.setVisible(true);
	}
}
