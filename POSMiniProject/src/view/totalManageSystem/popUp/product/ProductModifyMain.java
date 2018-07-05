package view.totalManageSystem.popUp.product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import view.ComponentSettings;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;

public class ProductModifyMain extends JPanel {

	private JTextField textField;
	private JTable table;
	private JComboBox comboBox;
	private JButton button;

	public ProductModifyMain(MainFrame frame, ControllPanel mainPanel) {
		this.setBounds(
				0,0,580,600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC81C \uD488 \uC218 \uC815");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 20, 206, 82);

		this.add(lblNewLabel);

		textField = new JTextField();
		textField.setText("\uC785\uB825\uB780");
		textField.setBounds(220, 110, 221, 35);
		this.add(textField);
		textField.setColumns(10);

		String ColumnNames[] = { "코드", "제품명", "제조회사", "가격" };

		Object rowData[][] = { { "001", "test", "test", "test" }, { null, null, null, null },
				{ "002", null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ "003", null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } };

		table = new JTable();
		table.setModel(new DefaultTableModel(rowData, ColumnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		});

		table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 20));
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		table.setLocation(17, 159);
		table.setSize(564, 280);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(2).setWidth(150);
		table.setRowHeight(30);
		table.setVisible(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == 1) {
					JTable temp = (JTable) e.getSource();
					int row = temp.getSelectedRow();
					if (row != -1) {
						mainPanel.getMainPanel().removeAll();
						mainPanel.getMainPanel().add(new ProductModifySub(frame,mainPanel,temp.getValueAt(row, 0).toString()));
						mainPanel.add(mainPanel.getMainPanel());
						mainPanel.repaint();
					}
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setLocation(56, 164);
		scrollPane.setSize(479, 361);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollPane);
		// contentPane.add(table);

		// 가운데 정렬 위한 코드
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = table.getColumnModel();

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addItem("제품명");
		comboBox.addItem("제조회사");
		comboBox.addItem("분류");
		comboBox.setBounds(110, 110, 96, 35);
		this.add(comboBox);
		
		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		btnNewButton.setBounds(423, 40, 100, 40);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new ProductMain(frame, mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		this.add(btnNewButton);

		button = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		JButton[] btn = { button };
		ComponentSettings.imageButtonSetting(btn);
		button.setBounds(454, 107, 70, 42);
		this.add(button);

		this.setVisible(true);
	}
}
