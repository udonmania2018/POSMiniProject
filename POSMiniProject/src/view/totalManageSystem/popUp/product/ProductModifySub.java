package view.totalManageSystem.popUp.product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;
import javax.swing.JComboBox;

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

	private JTextField priInput;
	private JTextField sellInput;

	public ProductModifySub(MainFrame frame, ControllPanel mainPanel, String productCode) {
		this.setBounds(0,0,580,600);
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		// ����(��ǰ����)
		title = new JLabel("�� ǰ �� ��");
		title.setFont(new Font("���ʷҵ���", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 20, 206, 82);
		this.add(title);

		// �߰� ��ư
		JButton addButton;
		addButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/ADD_ICON.PNG"));
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

		comInput = new JTextField();
		comInput.setText("�Է¶�");
		comInput.setColumns(10);
		comInput.setBounds(195, 237, 328, 42);
		add(comInput);

		priInput = new JTextField();
		priInput.setText("�Է¶�");
		priInput.setColumns(10);
		priInput.setBounds(195, 319, 328, 42);
		add(priInput);

		sellInput = new JTextField();
		sellInput.setText("�Է¶�");
		sellInput.setColumns(10);
		sellInput.setBounds(195, 360, 328, 42);
		add(sellInput);

		// ������ư
		JButton reviseButton;
		reviseButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/MODIFY_ICON.PNG"));
		reviseButton.setBorderPainted(false); // ��ư �׵θ� ��������
		reviseButton.setBounds(66, 470, 100, 40); // ��ư ũ�� ����
		add(reviseButton);

		// ������ư
		JButton deleteButton;
		deleteButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/DELETE_ICON.PNG"));
		deleteButton.setBorderPainted(false); // ��ư �׵θ� ��������
		deleteButton.setBounds(247, 470, 100, 40); // ��ư ũ�� ����
		add(deleteButton);

		// ��ҹ�ư
		JButton backButton;
		backButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/CANCEL_ICON.PNG"));
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

		// ���ڵ�
		JLabel barCode = new JLabel(
				new ImageIcon("images/totalManageSystem/Pop/buttonsImages/code.png"));
		barCode.setBounds(56, 399, 467, 61);
		add(barCode);

		JLabel label = new JLabel("( \uC81C\uD488\uBA85 )");
		label.setFont(new Font("���� ���", Font.PLAIN, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 86, 580, 50);
		add(label);
		
		//��ǰ�з� �޺��ڽ�
		JComboBox catInput = new JComboBox();
		catInput.setForeground(Color.BLACK);
		catInput.setBackground(new Color(255, 255, 255));
		catInput.addItem("����ǰ");
		catInput.addItem("���̽�ũ��");
		catInput.setBounds(195, 158, 328, 42);
		add(catInput);
		
		JComboBox nameInput = new JComboBox();
		nameInput.setForeground(Color.BLACK);
		nameInput.setBackground(new Color(255, 255, 255));
		nameInput.addItem("�Ե�");
		nameInput.addItem("���");
		nameInput.addItem("���");
		nameInput.setBounds(195, 278, 328, 42);
		add(nameInput);

		this.setVisible(true);
	}
}
