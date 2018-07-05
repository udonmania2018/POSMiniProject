package view.pos.swipe;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReadyMoney extends JPanel {
	private JTextField textField;
	private JTextField txtKh;
	private Vector<String> userColumn;
	private DefaultTableModel model;
	private JTable userTable;
	private JScrollPane scroll;

	public ReadyMoney() {
		this.setSize(1200, 400);
		this.setLayout(null);
		this.setBackground(Color.WHITE);

		JLabel lblNewLabel_1 = new JLabel("시 재 확 인");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		lblNewLabel_1.setBounds(35, 25, 222, 60);
		add(lblNewLabel_1);

		userColumn = new Vector<String>();

		userColumn.addElement("권종");
		userColumn.addElement("수량");
		userColumn.addElement("금액");

		model = new DefaultTableModel(userColumn, 8){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column % 2 == 0){
					return false;
				} else {
					return true;
				}
			}
		};
		userTable = new JTable(model);
		userTable.setRowHeight(21);
		userTable.getTableHeader().setReorderingAllowed(false);
		userTable.getTableHeader().setResizingAllowed(false);
		scroll = new JScrollPane(userTable);

		scroll.setBounds(35, 90, 555, 193);

		model.setValueAt("50000", 0, 0);
		model.setValueAt("10000", 1, 0);
		model.setValueAt("5000", 2, 0);
		model.setValueAt("1000", 3, 0);
		model.setValueAt("500", 4, 0);
		model.setValueAt("100", 5, 0);
		model.setValueAt("50", 6, 0);
		model.setValueAt("50", 7, 0);
	

		JLabel lblNewLabel_2 = new JLabel("실현금");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblNewLabel_2.setBounds(60, 300, 80, 40);
		add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(132, 311, 414, 24);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		btnNewButton.setBounds(482, 37, 100, 40);
		add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("영 수 증");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		lblNewLabel_3.setBounds(648, 37, 148, 47);
		add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(771, 48, 372, 277);
		add(scrollPane);

		txtKh = new JTextField();
		txtKh.setEditable(true);
		txtKh.setText("KH편의점(역삼점) 발행일 : 현재날짜 \n\t 시재 확인 ");
		scrollPane.add(txtKh);
		txtKh.setColumns(2);

		this.add(scroll);
		this.add(scrollPane);
		this.setVisible(true);
	}
}
