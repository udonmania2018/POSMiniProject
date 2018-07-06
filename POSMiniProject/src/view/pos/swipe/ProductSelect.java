package view.pos.swipe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import view.ComponentSettings;

public class ProductSelect extends JPanel {

	private DefaultTableModel dtm;
	private JTable jtable;
	private JScrollPane jsp;
	private JTable check_table;
	private JTextField textField;

	public ProductSelect() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);

		// ���̺� �ӽ� ������ �ݵ�� ����� true�� �ʱ�ȭ
		Object data[][] = { { "������", "������", "������", "������", true }, { null, null, null, null, true },
				{ null, null, null, null, true }, { null, null, null, null, true }, { null, null, null, null, true },
				{ null, null, null, null, true }, { null, null, null, null, true } };
		String colNames[] = { "��ǰ�з�", "��ǰ��", "����", "����", "���" };

		// ���̺� �÷� ���� ���� ����
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

		// ------------------- ���� ��� �� ------------------
		JLabel label = new JLabel("\uC0C1\uD488\uC120\uD0DD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("���� ���", Font.BOLD, 35));
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

		// ----------------------- ���� ���̺� ���� -------------------------
		check_table = new JTable(dtm1);
		check_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		check_table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 20));
		check_table.setFont(new Font("���� ���", Font.PLAIN, 16));
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
		// üũ �ڽ� �����ϴ� �۾�
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
		// ���̺� üũ �ڽ� ���� �� �ֵ��� ����
		check_table.getColumn("���").setCellRenderer(dcr);

		// ���̺� üũ�ڽ� �߰�
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		check_table.getColumn("���").setCellEditor(new DefaultCellEditor(box));
		
		JScrollPane check_scrollPane = new JScrollPane(check_table);
		check_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		check_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		check_scrollPane.setBounds(29, 119, 625, 260);
		add(check_scrollPane);
		// -------------------------------------------------------

		// �߾� �и���
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(675, 29, 12, 350);
		add(separator);

		// -------------------- ���� �� ��� �޴�
		// --------------------------------------
		

		JLabel lblNewLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(670, 28, 206, 63);
		this.add(lblNewLabel);

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/Counter.png"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(1057, 39, 105, 39);
		this.add(btnNewButton);
		// ----------------------------------------------------------
		// --------------------------������ ���̺� ------------------------------
		jtable = new JTable();

		Object[][] rowData = { { 1, null, null, null, null }, { 2, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null } };

		String[] header = { "No", "��ǰ��", "����", "����", "����" };

		dtm = new DefaultTableModel(rowData, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		jtable.setModel(dtm);
		jtable.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 20));
		jtable.setBounds(1, 0, 450, 300);
		jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(50);
		
		jtable.setFont(new Font("���� ���", Font.PLAIN, 16));
		jtable.setRowHeight(37);
		jsp = new JScrollPane(jtable);

		jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell());

		// jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell());

		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.getTableHeader().setResizingAllowed(false);
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int check = jtable.getColumnCount() - 1;
				if (jtable.getSelectedColumn() == check) {
					dtm.removeRow(jtable.getSelectedRow());
				}

			}

		});
		jsp.setBounds(700, 118, 475, 260);

		this.add(jsp);

		JButton[] settingButtons = { enterbtn, searchbtn, btnNewButton };
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
