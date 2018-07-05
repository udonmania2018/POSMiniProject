package view.pos.popup.safe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class SafeMoney extends JFrame {

	private JPanel reviseGroup;
	private JTextField nowTxt;
	private JTextField saveTxt;
	private JButton backButton;

	

	public SafeMoney() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 380);
		reviseGroup = new JPanel();
		reviseGroup.setBackground(Color.WHITE);
		reviseGroup.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(reviseGroup);
		reviseGroup.setLayout(null);
		
		
		//��ǰ �з� �ڵ�
		JTextPane nowMoney = new JTextPane();
		nowMoney.setFont(new Font("���� ���", Font.BOLD, 28));
		nowMoney.setText("\uD604\uC7AC \uCE74\uC6B4\uD130 \uAE08\uC561");
		nowMoney.setBounds(59, 26, 222, 44);
		reviseGroup.add(nowMoney);
		
		//�ڵ� �Է�
		nowTxt = new JTextField("������ �Է����ּ���.");
		nowTxt.setBounds(40, 80, 264, 44);
		reviseGroup.add(nowTxt);
		nowTxt.setColumns(10);
		
		//��ǰ �з���
		JTextPane saveMoney = new JTextPane();
		saveMoney.setText("\uC800\uC7A5\uD560 \uAE08\uC561");
		saveMoney.setFont(new Font("���� ���", Font.BOLD, 28));
		saveMoney.setBounds(96, 143, 156, 44);
		reviseGroup.add(saveMoney);
		
		//�з��� �Է�
		saveTxt = new JTextField("������ �Է����ּ���.");
		saveTxt.setColumns(10);
		saveTxt.setBounds(40, 197, 264, 44);
		reviseGroup.add(saveTxt);
		
		//Ȯ�� ��ư
		JButton chkButton;
		chkButton = new JButton(new ImageIcon("ICONPACK/OK_ICON.PNG"));
		chkButton.setBorderPainted(false); // ��ư �׵θ� ��������
		chkButton.setBounds(79, 272, 75, 34); // ��ư ũ�� ����
		add(chkButton);
		
		//��� ��ư
		JButton backButton;
		backButton = new JButton(new ImageIcon("ICONPACK/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // ��ư �׵θ� ��������
		backButton.setBounds(193, 272, 75, 34); // ��ư ũ�� ����
		add(backButton);
		
		//��
		JPanel line = new JPanel();
		line.setBackground(Color.LIGHT_GRAY);
		line.setBounds(40, 134, 264, 3);
		reviseGroup.add(line);
	}
}