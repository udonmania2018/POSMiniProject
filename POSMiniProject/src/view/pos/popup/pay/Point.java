package view.pos.popup.pay;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

// ������ ���� �ʿ�
public class Point extends JPanel {
	private JTextField textField_2;


	public Point() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		//����(����Ʈ)
		JTextPane title = new JTextPane();
		title.setFont(new Font("���� ���", Font.BOLD, 30));
		title.setText("����Ʈ");
		title.setBounds(249, 37, 96, 47);
		add(title);
		
		//��������Ʈ
		JTextPane allPoint = new JTextPane();
		allPoint.setText("���� ����Ʈ : ");
		allPoint.setFont(new Font("���� ���", Font.PLAIN, 28));
		allPoint.setBounds(54, 324, 182, 47);
		add(allPoint);
		
		//�������Ʈ
		JTextPane usePoint = new JTextPane();
		usePoint.setText("��� ����Ʈ : ");
		usePoint.setFont(new Font("���� ���", Font.PLAIN, 28));
		usePoint.setBounds(54, 399, 182, 47);
		add(usePoint);
		
		//Ȯ�ι�ư
		JButton checkButton = new JButton("images/OK_ICON.PNG");
		checkButton.setBounds(107, 523, 96, 47);
		add(checkButton);
		
		//��ҹ�ư
		JButton backButton = new JButton("images/CANCEL_ICON.PNG");
		backButton.setBounds(380, 523, 96, 47);
		add(backButton);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("���� ����Ʈ : ");
		textPane_3.setFont(new Font("���� ���", Font.PLAIN, 28));
		textPane_3.setBounds(54, 131, 182, 47);
		add(textPane_3);
		
		textField_2 = new JTextField("ī���ȣ �Է�");
		textField_2.setColumns(10);
		textField_2.setBounds(236, 131, 195, 47);
		add(textField_2);
		
		JButton button_1 = new JButton("images/READ.PNG");
		button_1.setBounds(455, 131, 79, 47);
		add(button_1);
		
		JLabel lblNewLabel = new JLabel("ī�� ������ �������� �ʽ��ϴ�.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 207, 449, 70);
		add(lblNewLabel);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("���� ���", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(236, 324, 297, 47);
		add(label);
		
		JLabel label_1 = new JLabel("0");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("���� ���", Font.PLAIN, 20));
		label_1.setBounds(237, 399, 297, 47);
		add(label_1);

	}
}
