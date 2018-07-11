package view.pos.popup.safe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.pos.POSController;
import model.dao.pos.MoneyDao;
import model.vo.pos.Moneys;
import view.pos.swipe.POSMainFrame;

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
	private MoneyDao m = new MoneyDao();
	private int[] list;
	private POSMainFrame pmf;
	private Moneys mo;
	private JPanel safeMoneyPanel;

	public SafeMoney(JFrame popFrame) {
		this.setSize(621, 400);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.safeMoneyPanel = this;
		JLabel nowMoney = new JLabel("현재 카운터 금액");
		nowMoney.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		nowMoney.setBounds(35, 25, 222, 60);
		add(nowMoney);

		moneyColumn = new Vector<String>();

		moneyColumn.addElement("권종");
		moneyColumn.addElement("카운터 보유화폐");
		moneyColumn.addElement("회수금액");
		moneyColumn.addElement("금고 보유화폐 ");

		System.out.println(POSMainFrame.counterMoneys[0]);
		model = new DefaultTableModel(moneyColumn, 8) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column == 2) {
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

		// list = m.getMoneys();

		Moneys moneys = m.selectSafeMoneys();
		int[] marr = new int[8];
		if(moneys == null){
			for (int i = 0; i < marr.length; i++) {
				marr[i] = 0;
			}
		} else {
			marr = moneys.getMoneys();
		}

		/*
		 * for(int i = 0 ; i <marr.length;i++){ System.out.println(marr[i]); }
		 */
		// add(pc.saveMoney(textField.getText()));

		model.setValueAt("50000", 0, 0);
		model.setValueAt("10000", 1, 0);
		model.setValueAt("5000", 2, 0);
		model.setValueAt("1000", 3, 0);
		model.setValueAt("500", 4, 0);
		model.setValueAt("100", 5, 0);
		model.setValueAt("50", 6, 0);
		model.setValueAt("10", 7, 0);

		// 현재수량
		model.setValueAt(pmf.counterMoneys[0], 0, 1);
		model.setValueAt(pmf.counterMoneys[1], 1, 1);
		model.setValueAt(pmf.counterMoneys[2], 2, 1);
		model.setValueAt(pmf.counterMoneys[3], 3, 1);
		model.setValueAt(pmf.counterMoneys[4], 4, 1);
		model.setValueAt(pmf.counterMoneys[5], 5, 1);
		model.setValueAt(pmf.counterMoneys[6], 6, 1);
		model.setValueAt(pmf.counterMoneys[7], 7, 1);

		model.setValueAt(marr[0], 0, 3);
		model.setValueAt(marr[1], 1, 3);
		model.setValueAt(marr[2], 2, 3);
		model.setValueAt(marr[3], 3, 3);
		model.setValueAt(marr[4], 4, 3);
		model.setValueAt(marr[5], 5, 3);
		model.setValueAt(marr[6], 6, 3);
		model.setValueAt(marr[7], 7, 3);

		/*
		 * // 현재 카운터의 금액으로 초기화 할 것 나중에 수정 model.setValueAt("5", 0, 1);
		 * model.setValueAt("5", 1, 1); model.setValueAt("5", 2, 1);
		 * model.setValueAt("5", 3, 1); model.setValueAt("5", 4, 1);
		 * model.setValueAt("5", 5, 1); model.setValueAt("5", 6, 1);
		 * model.setValueAt("5", 7, 1);
		 */

		/*
		 * textField = new JTextField(); textField.setBounds(132, 311, 414, 24);
		 * add(textField); textField.setColumns(10);
		 */

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		btnNewButton.setBounds(482, 37, 100, 40);
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] saveMoneys = new int[8];
				for (int i = 0; i < saveMoneys.length; i++) {
					Object temp = model.getValueAt(i, 2);
					Object inMoneys = model.getValueAt(i, 1);
					if (temp != null) {
						boolean checkPatter = temp.toString().matches("^[0-9]*$");
						if (!checkPatter) {
							JOptionPane.showMessageDialog(null, "숫자만 입력 가능합니다.");
							return;
						}
						if(temp.toString().trim() == "" || temp == null){
							temp = temp.toString()+"0";
						}
						
						if (Integer.parseInt(inMoneys.toString()) - Integer.parseInt(temp.toString()) < 0) {
							JOptionPane.showMessageDialog(null, "저장 금액이 보유 현금보다 많습니다.\n확인해 주세요");
							return;
						}
						saveMoneys[i] = Integer.parseInt(temp.toString().trim());
					} else {
						saveMoneys[i] = 0;
					}
				}
				for (int i = 0; i < saveMoneys.length; i++) {
					POSMainFrame.counterMoneys[i] = POSMainFrame.counterMoneys[i] - saveMoneys[i];
				}
				
				Moneys mo = new Moneys(saveMoneys);
				pc.saveMoney(mo);
				safeMoneyPanel.removeAll();
				safeMoneyPanel.add(new SafeMoney(popFrame));
				popFrame.repaint();
			}
		});

		/*
		 * btnNewButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { // TODO
		 * Auto-generated method stub int[] moneys = new int[8]; for (int i = 0;
		 * i < moneys.length; i++) { if (moneyTable.getValueAt(i, 2).equals("")
		 * || moneyTable.getValueAt(i, 2) == null) { moneys[i] = 0; } else {
		 * moneys[i] = Integer.parseInt((String) moneyTable.getValueAt(i, 2)); }
		 * System.out.println(moneys[i]); } pc.saveMoney(new Moneys(moneys)); }
		 * });
		 */

		this.add(scroll);
		/*
		 * JLabel label = new JLabel("총 회수금액"); label.setFont(new Font("맑은 고딕",
		 * Font.BOLD, 18)); label.setHorizontalAlignment(SwingConstants.CENTER);
		 * label.setBounds(28, 310, 100, 24); add(label);
		 */
		this.setVisible(true);
	}
}