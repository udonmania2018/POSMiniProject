package view.pos.popup.pay;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

// 디자인 수정 필요
public class Point extends JPanel {
	private JTextField textField_2;


	public Point() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		//제목(포인트)
		JTextPane title = new JTextPane();
		title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.setText("포인트");
		title.setBounds(249, 37, 96, 47);
		add(title);
		
		//가용포인트
		JTextPane allPoint = new JTextPane();
		allPoint.setText("가용 포인트 : ");
		allPoint.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		allPoint.setBounds(54, 324, 182, 47);
		add(allPoint);
		
		//사용포인트
		JTextPane usePoint = new JTextPane();
		usePoint.setText("사용 포인트 : ");
		usePoint.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		usePoint.setBounds(54, 399, 182, 47);
		add(usePoint);
		
		//확인버튼
		JButton checkButton = new JButton("images/OK_ICON.PNG");
		checkButton.setBounds(107, 523, 96, 47);
		add(checkButton);
		
		//취소버튼
		JButton backButton = new JButton("images/CANCEL_ICON.PNG");
		backButton.setBounds(380, 523, 96, 47);
		add(backButton);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("가용 포인트 : ");
		textPane_3.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		textPane_3.setBounds(54, 131, 182, 47);
		add(textPane_3);
		
		textField_2 = new JTextField("카드번호 입력");
		textField_2.setColumns(10);
		textField_2.setBounds(236, 131, 195, 47);
		add(textField_2);
		
		JButton button_1 = new JButton("images/READ.PNG");
		button_1.setBounds(455, 131, 79, 47);
		add(button_1);
		
		JLabel lblNewLabel = new JLabel("카드 정보가 존재하지 않습니다.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 207, 449, 70);
		add(lblNewLabel);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(236, 324, 297, 47);
		add(label);
		
		JLabel label_1 = new JLabel("0");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_1.setBounds(237, 399, 297, 47);
		add(label_1);

	}
}
