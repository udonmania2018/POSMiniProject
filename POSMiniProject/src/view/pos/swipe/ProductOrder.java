package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import view.ComponentSettings;
import view.pos.swipe.ProductSelect.TableCell;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProductOrder extends JPanel {
	private JTable check_table;
	private JTextField textField;
	private JTable order_table;

	public ProductOrder() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);
		this.setLayout(null);

		// 테이블 임시 데이터 반드시 비고값에 true로 초기화
		Object data[][] = { { "ㄹㄹㄹ", "ㄷㄷㄷ", "ㅇㅇㅇ", "ㅌㅌㅌ", true }, { null, null, null, null, true },
				{ null, null, null, null, true }, { null, null, null, null, true }, { null, null, null, null, true },
				{ null, null, null, null, true }, { null, null, null, null, true } };
		String colNames[] = { "제품분류", "제품명", "개수", "가격", "비고" };

		// 테이블 컬럼 수정 여부 설정
		DefaultTableModel dtm1 = new DefaultTableModel(data, colNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column == 2 || column == 4) {
					return true;
				} else {
					return false;
				}
			}
		};

		// ------------------- 왼쪽 상단 뷰 ------------------
		JLabel label = new JLabel("\uC0C1\uD488\uC120\uD0DD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		label.setBounds(0, 24, 188, 63);
		add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "\uC81C\uD488 \uBA85", "\uC81C\uC870 \uD68C\uC0AC" }));
		comboBox.setBounds(176, 39, 80, 36);
		add(comboBox);

		textField = new JTextField();
		textField.setText("\uC785\uB825\uB780");
		textField.setBounds(270, 39, 200, 36);
		add(textField);
		textField.setColumns(10);

		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(555, 39, 100, 40);
		add(enterbtn);

		searchbtn.setBounds(490, 39, 50, 40);
		add(searchbtn);
		// -------------------------------------------------------

		// ----------------------- 왼쪽 테이블 생성 -------------------------
		check_table = new JTable(dtm1);
		check_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		check_table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		check_table.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		check_table.setBounds(0, 0, 750, 260);
		check_table.getColumnModel().getColumn(0).setPreferredWidth(130);
		check_table.getColumnModel().getColumn(1).setPreferredWidth(240);
		check_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		check_table.getColumnModel().getColumn(3).setPreferredWidth(200);
		check_table.getColumnModel().getColumn(4).setPreferredWidth(50);

		// JCheckBox[] checks = new JCheckBox[check_table.getRowCount()];
		check_table.setRowHeight(37);
		check_table.setBounds(0, 0, 620, 260);

		// JScrollPane
		// 체크 박스 생성하는 작업
		DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				JCheckBox box = new JCheckBox();
				box.setSelected(((Boolean) value).booleanValue());
				box.setHorizontalAlignment(JLabel.CENTER);
				return box;
			}
		};
		// 태이블에 체크 박스 넣을 수 있도록 설정
		check_table.getColumn("비고").setCellRenderer(dcr);

		// 테이블에 체크박스 추가
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		check_table.getColumn("비고").setCellEditor(new DefaultCellEditor(box));
		
		JScrollPane check_scrollPane = new JScrollPane(check_table);
		check_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		check_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		check_scrollPane.setBounds(29, 119, 625, 260);
		add(check_scrollPane);
		// -------------------------------------------------------

		// 중앙 분리선
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(675, 29, 12, 350);
		add(separator);
		// ----------------- 오른쪽 상단 메뉴 --------------------------------------------
		/*
		 * JLabel label = new JLabel("2018-06-27"); // 가짜 데이터. 실제로는 날짜를 받아와야 함.
		 * label.setFont(new Font("맑은 고딕", Font.PLAIN, 18)); label.setBorder(new
		 * LineBorder(new Color(0, 0, 0)));
		 * label.setHorizontalAlignment(SwingConstants.CENTER);
		 * label.setBackground(Color.WHITE); label.setBounds(373, 55, 240, 40);
		 */


		/*
		 * JComboBox comboBox = new JComboBox(); comboBox.setModel(new
		 * DefaultComboBoxModel(new String[] {"\uBD84\uB958",
		 * "\uC81C\uD488 \uBA85", "\uC81C\uC870 \uD68C\uC0AC",
		 * "\uBD84\uB958 \uBCC4"})); comboBox.setBounds(184, 29, 130, 38);
		 * add(comboBox);
		 */

		JLabel totalOrder = new JLabel("총발주");
		totalOrder.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		totalOrder.setBounds(700, 28, 206, 63);
		this.add(totalOrder);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(779, 119, 395, 260);
		add(scrollPane_1);

		Object[][] tempData = { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
			{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, };
		 String[] orderTableHeader = { "No","\uC81C\uD488 \uBA85", "보유", "발주",
			"\uC0AD\uC81C" };
		DefaultTableModel dtm = new DefaultTableModel(tempData, orderTableHeader){
			 @Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column == 3){
					return true;
				} else {
					return false;
				}
			}
		 };
		
		order_table = new JTable();
		order_table.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		order_table.setModel(dtm);
		order_table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		order_table.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		order_table.setRowHeight(37);
		order_table.getColumnModel().getColumn(0).setPreferredWidth(50);
		order_table.getColumnModel().getColumn(1).setPreferredWidth(250);
		order_table.getColumnModel().getColumn(2).setPreferredWidth(60);
		order_table.getColumnModel().getColumn(3).setPreferredWidth(60);
		order_table.getColumnModel().getColumn(4).setPreferredWidth(50);
		order_table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
		order_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int check = order_table.getColumnCount() - 1;
				if (order_table.getSelectedColumn() == check) {
					dtm.removeRow(order_table.getSelectedRow());
				}

			}

		});
		scrollPane_1.setViewportView(order_table);
		scrollPane_1.setBounds(700, 118, 475, 260);
		add(scrollPane_1);

		JButton orderendbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		orderendbtn.setBounds(1074, 39, 100, 40);
		add(orderendbtn);
		
		JButton[] settingButtons = { enterbtn, searchbtn, orderendbtn };
		ComponentSettings.imageButtonSetting(settingButtons);
		this.setVisible(true);

	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb;

		public TableCell() {
			// TODO Auto-generated constructor stub
			jb = new JButton(new ImageIcon("images/buttonsImages/Garbage.png"));
			jb.setBorderPainted(false);
			jb.setBackground(Color.WHITE);

		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return jb;
		}

	}
}
