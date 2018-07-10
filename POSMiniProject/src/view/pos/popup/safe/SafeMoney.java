package view.pos.popup.safe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.pos.POSController;
import model.vo.pos.Moneys;

public class SafeMoney extends JPanel {

	// private JPanel reviseGroup;
	// private JTextField nowTxt;
	// private JTextField saveTxt;
	// private JButton backButton;
	private JTextField textField;
	private Vector<String> moneyColumn;
	private DefaultTableModel model;
	private JTable moneyTable;
	private JScrollPane scroll;
	private POSController pc = new POSController();

	public SafeMoney() {
		this.setSize(621, 400);
		this.setLayout(null);
		this.setBackground(Color.WHITE);

		JLabel nowMoney = new JLabel("현재 카운터 금액");
		nowMoney.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		nowMoney.setBounds(35, 25, 222, 60);
		add(nowMoney);

		moneyColumn = new Vector<String>();

		moneyColumn.addElement("권종");
		moneyColumn.addElement("현재 수량");
		moneyColumn.addElement("변경 수량");

		model = new DefaultTableModel(moneyColumn, 8) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column % 2 == 0) {
					return true;

				} else {
					return false;
				}
			}
		};
		moneyTable = new JTable(model);
		moneyTable.setRowHeight(21);
		moneyTable.getTableHeader().setReorderingAllowed(false);
		moneyTable.getTableHeader().setResizingAllowed(false);
		scroll = new JScrollPane(moneyTable);

		scroll.setBounds(35, 90, 555, 193);

		model.setValueAt("50000", 0, 0);
		model.setValueAt("10000", 1, 0);
		model.setValueAt("5000", 2, 0);
		model.setValueAt("1000", 3, 0);
		model.setValueAt("500", 4, 0);
		model.setValueAt("100", 5, 0);
		model.setValueAt("50", 6, 0);
		model.setValueAt("10", 7, 0);

		// 현재 카운터의 금액으로 초기화 할 것 나중에 수정
		model.setValueAt("5", 0, 1);
		model.setValueAt("5", 1, 1);
		model.setValueAt("5", 2, 1);
		model.setValueAt("5", 3, 1);
		model.setValueAt("5", 4, 1);
		model.setValueAt("5", 5, 1);
		model.setValueAt("5", 6, 1);
		model.setValueAt("5", 7, 1);

		textField = new JTextField();
		textField.setBounds(132, 311, 414, 24);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		btnNewButton.setBounds(482, 37, 100, 40);
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int[] moneys = new int[8];
				for (int i = 0; i < moneys.length; i++) {
					if (moneyTable.getValueAt(i, 2).equals("") || moneyTable.getValueAt(i, 2) == null) {
						moneys[i] = 0;
					} else {
						moneys[i] = Integer.parseInt((String) moneyTable.getValueAt(i, 2));
					}	
					System.out.println(moneys[i]);
				}
				pc.saveMoney(new Moneys(moneys));
			}
		});

		this.add(scroll);
		this.setVisible(true);
	}

}