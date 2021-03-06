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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.totalManageSystem.ProductController;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.ProductGroup;
import view.totalManageSystem.management.ManagementSystem;

public class GroupManage extends JFrame {

	private JPanel addGroup;
	private JTextField codTxt;
	private JTextField nameTxt;
	private ProductController pct = new ProductController();

	public GroupManage(String groupCheck, boolean check, String selectCode, String selectName) {
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

		// 제품 분류 코드
		JTextPane code = new JTextPane();
		code.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		String group = null;

		code.setBounds(58, 35, 300, 44);
		code.setEditable(false);
		addGroup.add(code);

		// 코드 입력
		codTxt = new JTextField("내용을 입력해주세요.");
		codTxt.setBounds(58, 80, 264, 44);
		codTxt.setEditable(false);
		addGroup.add(codTxt);
		codTxt.setColumns(10);

		if (groupCheck.equals("product")) {
			group = "제품 분류";
			if (check) {
				codTxt.setText(pct.getProudctGroupCode());
			} else {
				codTxt.setText(selectCode);
			}
		} else if (groupCheck.equals("manufacturer")) {
			group = "제조회사 분류";
			if (check) {
				codTxt.setText(pct.getManufacturerCode());
			} else {
				codTxt.setText(selectCode);
			}
		}
		code.setText(group + " 코드");
		// 제품 분류명
		JTextPane name = new JTextPane();
		name.setText(group + "명");
		name.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		name.setBounds(58, 148, 300, 44);
		name.setEditable(false);
		addGroup.add(name);

		// 분류명 입력
		nameTxt = new JTextField("내용을 입력해주세요.");
		nameTxt.setColumns(10);
		nameTxt.setBounds(58, 192, 264, 44);
		if(!check){
			nameTxt.setText(selectName);
		}
		nameTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				nameTxt.setText("");
			}
		});

		addGroup.add(nameTxt);
		// 취소 버튼
		JButton backButton;
		backButton = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // 버튼 테두리 설정해제

		// 버튼 이벤트 구현시 groupCheck 값에 따라
		// 구분해서 DB 실행
		if (check) {// 추가 버튼
			JButton addButton;
			addButton = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
			addButton.setBorderPainted(false); // 버튼 테두리 설정해제
			addButton.setBounds(50, 273, 100, 40); // 버튼 크기 지정
			addGroup.add(addButton);

			backButton.setBounds(192, 273, 100, 40); // 버튼 크기 지정
			addGroup.add(backButton);

			addButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 제품 분류 DB에 추가 처리 기능
					if (groupCheck.equals("product")) {
						if(!nameTxt.getText().matches("^[a-zA-Z0-9]*$")){
							JOptionPane.showMessageDialog(null, "영문자 및 숫자로 입력해주세요.");
							return;
						}
						ProductGroup pg = new ProductGroup((codTxt.getText()), nameTxt.getText());
						pct.addProductGroup(pg);
					} else if (groupCheck.equals("manufacturer")) {
						ManufactureGroup mfg = new ManufactureGroup(codTxt.getText(), nameTxt.getText());
						pct.addManufacturer(mfg);
					}
					MainFrame.popUpMainFrameCheck = true;
					dispose();
					ManagementSystem ms = new ManagementSystem();
		            ms.mainPopCheck = false;
		            ms.mainPopCheck = true;
		            new MainFrame("product");
		            ms.mainPopCheck = false;
				}
			});
		}

		else {
			JButton modifyBtn;
			modifyBtn = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
			modifyBtn.setBorderPainted(false); // 버튼 테두리 설정해제
			modifyBtn.setBounds(20, 270, 100, 40); // 버튼 크기 지정
			addGroup.add(modifyBtn);

			modifyBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (groupCheck.equals("product")) {
						if(!nameTxt.getText().matches("^[a-zA-Z0-9]*$")){
							JOptionPane.showMessageDialog(null, "영문자 및 숫자로 입력해주세요.");
							return;
						}
						ProductGroup pg = new ProductGroup((codTxt.getText()), nameTxt.getText());
						pct.modifyProductGroup(pg);
					} else if (groupCheck.equals("manufacturer")) {
						ManufactureGroup mfg = new ManufactureGroup(codTxt.getText(), nameTxt.getText());
						pct.modifyManufacturer(mfg);
					}
					MainFrame.popUpMainFrameCheck = true;
					dispose();
				}
			});
			// 취소 버튼
			JButton deleteBtn;
			deleteBtn = new JButton(new ImageIcon("images/buttonsImages/DELETE_ICON.PNG"));
			deleteBtn.setBorderPainted(false); // 버튼 테두리 설정해제
			deleteBtn.setBounds(140, 270, 100, 40); // 버튼 크기 지정
			addGroup.add(deleteBtn);

			backButton.setBounds(260, 270, 100, 40);
			addGroup.add(backButton);
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 제품 분류 DB에 추가 처리 기능
					if (groupCheck.equals("product")) {
						ProductGroup pg = new ProductGroup((codTxt.getText()), nameTxt.getText());
						pct.deleteProductGroup(pg);
					} else if (groupCheck.equals("manufacturer")) {
						ManufactureGroup mfg = new ManufactureGroup(codTxt.getText(), nameTxt.getText());
						pct.deleteManufacturer(mfg);
					}
					MainFrame.popUpMainFrameCheck = true;
					dispose();
				}
			});

		}
		JFrame temp = this;
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.popUpMainFrameCheck = true;
				temp.dispose();
			}
		});

		getContentPane().add(addGroup);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
