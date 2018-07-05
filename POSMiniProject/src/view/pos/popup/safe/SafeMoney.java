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
		
		
		//제품 분류 코드
		JTextPane nowMoney = new JTextPane();
		nowMoney.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		nowMoney.setText("\uD604\uC7AC \uCE74\uC6B4\uD130 \uAE08\uC561");
		nowMoney.setBounds(59, 26, 222, 44);
		reviseGroup.add(nowMoney);
		
		//코드 입력
		nowTxt = new JTextField("내용을 입력해주세요.");
		nowTxt.setBounds(40, 80, 264, 44);
		reviseGroup.add(nowTxt);
		nowTxt.setColumns(10);
		
		//제품 분류명
		JTextPane saveMoney = new JTextPane();
		saveMoney.setText("\uC800\uC7A5\uD560 \uAE08\uC561");
		saveMoney.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		saveMoney.setBounds(96, 143, 156, 44);
		reviseGroup.add(saveMoney);
		
		//분류명 입력
		saveTxt = new JTextField("내용을 입력해주세요.");
		saveTxt.setColumns(10);
		saveTxt.setBounds(40, 197, 264, 44);
		reviseGroup.add(saveTxt);
		
		//확인 버튼
		JButton chkButton;
		chkButton = new JButton(new ImageIcon("ICONPACK/OK_ICON.PNG"));
		chkButton.setBorderPainted(false); // 버튼 테두리 설정해제
		chkButton.setBounds(79, 272, 75, 34); // 버튼 크기 지정
		add(chkButton);
		
		//취소 버튼
		JButton backButton;
		backButton = new JButton(new ImageIcon("ICONPACK/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // 버튼 테두리 설정해제
		backButton.setBounds(193, 272, 75, 34); // 버튼 크기 지정
		add(backButton);
		
		//선
		JPanel line = new JPanel();
		line.setBackground(Color.LIGHT_GRAY);
		line.setBounds(40, 134, 264, 3);
		reviseGroup.add(line);
	}
}