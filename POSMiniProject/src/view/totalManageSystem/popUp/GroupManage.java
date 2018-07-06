package view.totalManageSystem.popUp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import dao.tmsDao.Event;
import dao.tmsDao.Product;
import model.vo.EventGroup;

public class GroupManage extends JFrame {

	private JPanel addGroup;
	private JTextField codTxt;
	private JTextField nameTxt;
	private Product dao = new Product();

	public GroupManage(String groupCheck, boolean check) {
		this.setBounds(100, 100, 380, 380);
		addGroup = new JPanel();
		addGroup.setBackground(Color.WHITE);
		addGroup.setLayout(null);
		addGroup.setSize(380, 380);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				MainFrame.popUpMainFrameCheck = true;
			}
		});

		// ��ǰ �з� �ڵ�
		JTextPane code = new JTextPane();
		code.setFont(new Font("���� ���", Font.BOLD, 28));
		String group = null;

		code.setBounds(58, 35, 300, 44);
		code.setEditable(false);
		addGroup.add(code);

		// �ڵ� �Է�
		codTxt = new JTextField("������ �Է����ּ���.");
		codTxt.setBounds(58, 80, 264, 44);
		codTxt.setEditable(false);
		addGroup.add(codTxt);
		codTxt.setColumns(10);

		if (groupCheck.equals("product")) {
			group = "��ǰ �з�";
			codTxt.setText(dao.getProudctGroupCode());
		} else if (groupCheck.equals("manufacturer")) {
			group = "����ȸ�� �з�";
		} else if (groupCheck.equals("eventGroup")) {
			group = "�̺�Ʈ �з�";
		}
		code.setText(group + " �ڵ�");
		// ��ǰ �з���
		JTextPane name = new JTextPane();
		name.setText(group + "��");
		name.setFont(new Font("���� ���", Font.BOLD, 28));
		name.setBounds(58, 148, 300, 44);
		name.setEditable(false);
		addGroup.add(name);

		// �з��� �Է�
		nameTxt = new JTextField("������ �Է����ּ���.");
		nameTxt.setColumns(10);
		nameTxt.setBounds(58, 192, 264, 44);
		
		nameTxt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				nameTxt.setText("");
			}
		});
		
		
		addGroup.add(nameTxt);
		// ��� ��ư
		JButton backButton;
		backButton = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // ��ư �׵θ� ��������

		// ��ư �̺�Ʈ ������ groupCheck ���� ����
		// �����ؼ� DB ����
		if (check) {// �߰� ��ư
			JButton addButton;
			addButton = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
			addButton.setBorderPainted(false); // ��ư �׵θ� ��������
			addButton.setBounds(50, 273, 100, 40); // ��ư ũ�� ����
			addGroup.add(addButton);

			backButton.setBounds(192, 273, 100, 40); // ��ư ũ�� ����
			addGroup.add(backButton);

			addButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ��ǰ �з� DB�� �߰� ó�� ���

					if (groupCheck.equals("product")) {
						ProductGroup pg = new ProductGroup((codTxt.getText()), nameTxt.getText());
						dao.addProductGroup(pg);
					} else if (groupCheck.equals("manufacturer")) {
						ManufactureGroup mfg = new ManufactureGroup(codTxt.getText(), nameTxt.getText());
						dao.addManufacturer(mfg);
					}
				});
			}

						
				
			
		} else {
			JButton modifyBtn;
			modifyBtn = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
			modifyBtn.setBorderPainted(false); // ��ư �׵θ� ��������
			modifyBtn.setBounds(20, 270, 100, 40); // ��ư ũ�� ����
			addGroup.add(modifyBtn);

			// ��� ��ư
			JButton deleteBtn;
			deleteBtn = new JButton(new ImageIcon("images/buttonsImages/DELETE_ICON.PNG"));
			deleteBtn.setBorderPainted(false); // ��ư �׵θ� ��������
			deleteBtn.setBounds(140, 270, 100, 40); // ��ư ũ�� ����
			addGroup.add(deleteBtn);

			backButton.setBounds(260, 270, 100, 40);
			addGroup.add(backButton);

		}
		JFrame temp = this;
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				temp.dispose();
				MainFrame.popUpMainFrameCheck = true;
			}
		});

		getContentPane().add(addGroup);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
