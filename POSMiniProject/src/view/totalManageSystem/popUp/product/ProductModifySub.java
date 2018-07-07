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

	// 제목 선언
	private JLabel title;
	private JButton addButton;

	// 목록창 선언
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

		// 제목(제품수정)
		title = new JLabel("제 품 수 정");
		title.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 20, 206, 82);
		this.add(title);

		// 추가 버튼
		JButton addButton;
		addButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/ADD_ICON.PNG"));
		addButton.setBorderPainted(false); // 버튼 테두리 설정해제
		addButton.setBounds(423, 40, 100, 40); // 버튼 크기 지정
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

		// 목록창
		categorize = new JTextField();
		categorize.setAutoscrolls(false);
		categorize.setHorizontalAlignment(SwingConstants.CENTER);
		categorize.setText("제품 분류");
		categorize.setBounds(55, 158, 141, 42);
		categorize.setBackground(Color.LIGHT_GRAY);
		add(categorize);
		categorize.setColumns(10);

		code = new JTextField();
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setText("제품 코드");
		code.setColumns(10);
		code.setBackground(Color.LIGHT_GRAY);
		code.setBounds(55, 199, 141, 42);
		add(code);

		company = new JTextField();
		company.setHorizontalAlignment(SwingConstants.CENTER);
		company.setText("제조 회사");
		company.setColumns(10);
		company.setBackground(Color.LIGHT_GRAY);
		company.setBounds(55, 278, 141, 42);
		add(company);

		productName = new JTextField();
		productName.setHorizontalAlignment(SwingConstants.CENTER);
		productName.setText("제품명");
		productName.setColumns(10);
		productName.setBackground(Color.LIGHT_GRAY);
		productName.setBounds(55, 237, 141, 42);
		add(productName);

		productPrice = new JTextField();
		productPrice.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice.setText("제품 가격");
		productPrice.setColumns(10);
		productPrice.setBackground(Color.LIGHT_GRAY);
		productPrice.setBounds(55, 360, 141, 42);
		add(productPrice);

		sellByDate = new JTextField();
		sellByDate.setHorizontalAlignment(SwingConstants.CENTER);
		sellByDate.setText("유통기한");
		sellByDate.setColumns(10);
		sellByDate.setBackground(Color.LIGHT_GRAY);
		sellByDate.setBounds(55, 319, 141, 42);
		add(sellByDate);

		codInput = new JTextField();
		codInput.setText(productCode);
		codInput.setColumns(10);
		// 수정불가능 하게 설정
		codInput.setEditable(false);
		codInput.setBounds(195, 199, 328, 42);
		add(codInput);

		comInput = new JTextField();
		comInput.setText("입력란");
		comInput.setColumns(10);
		comInput.setBounds(195, 237, 328, 42);
		add(comInput);

		priInput = new JTextField();
		priInput.setText("입력란");
		priInput.setColumns(10);
		priInput.setBounds(195, 319, 328, 42);
		add(priInput);

		sellInput = new JTextField();
		sellInput.setText("입력란");
		sellInput.setColumns(10);
		sellInput.setBounds(195, 360, 328, 42);
		add(sellInput);

		// 수정버튼
		JButton reviseButton;
		reviseButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/MODIFY_ICON.PNG"));
		reviseButton.setBorderPainted(false); // 버튼 테두리 설정해제
		reviseButton.setBounds(66, 470, 100, 40); // 버튼 크기 지정
		add(reviseButton);

		// 삭제버튼
		JButton deleteButton;
		deleteButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/DELETE_ICON.PNG"));
		deleteButton.setBorderPainted(false); // 버튼 테두리 설정해제
		deleteButton.setBounds(247, 470, 100, 40); // 버튼 크기 지정
		add(deleteButton);

		// 취소버튼
		JButton backButton;
		backButton = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // 버튼 테두리 설정해제
		backButton.setBounds(423, 470, 100, 40); // 버튼 크기 지정
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

		// 바코드
		JLabel barCode = new JLabel(
				new ImageIcon("images/totalManageSystem/Pop/buttonsImages/code.png"));
		barCode.setBounds(56, 399, 467, 61);
		add(barCode);

		JLabel label = new JLabel("( \uC81C\uD488\uBA85 )");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 86, 580, 50);
		add(label);
		
		//제품분류 콤보박스
		JComboBox catInput = new JComboBox();
		catInput.setForeground(Color.BLACK);
		catInput.setBackground(new Color(255, 255, 255));
		catInput.addItem("유제품");
		catInput.addItem("아이스크림");
		catInput.setBounds(195, 158, 328, 42);
		add(catInput);
		
		JComboBox nameInput = new JComboBox();
		nameInput.setForeground(Color.BLACK);
		nameInput.setBackground(new Color(255, 255, 255));
		nameInput.addItem("롯데");
		nameInput.addItem("농심");
		nameInput.addItem("삼양");
		nameInput.setBounds(195, 278, 328, 42);
		add(nameInput);

		this.setVisible(true);
	}
}
