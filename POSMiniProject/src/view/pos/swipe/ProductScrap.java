package view.pos.swipe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.pos.POSController;
import model.vo.pos.ProductStock;

public class ProductScrap extends JPanel {

	private JPanel contentPane;
	private JTextField search_textField;
	private JTable check_table;
	private JTable ProductScrap_table;
	private Object data[][];
	private ArrayList<ProductStock> stockList;
	private POSController pc = new POSController();

	public ProductScrap(JPanel contentPanel) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);
		stockList = pc.selectProductStock();
		// ���� ǥ�� ���̺�
		// ���̺� �ӽ� ������
		data = null;
		String colNames[] = { "���ڵ�", "��ǰ��", "�������", "��������", "��ⰳ��", "���" };

		// ���̺� �÷� ���� ���� ����
		DefaultTableModel dtm1 = new DefaultTableModel(data, colNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column == 5 || column == 4) {
					return true;
				} else {
					return false;
				}
			}
		};

		search_textField = new JTextField();
		search_textField.setText("\uC785\uB825\uB780");
		search_textField.setBounds(270, 39, 200, 36);
		add(search_textField);
		search_textField.setColumns(10);
		search_textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				search_textField.setText("");
			}
		});

		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		searchbtn.setBounds(490, 39, 50, 40);
		searchbtn.setBackground(Color.white);
		searchbtn.setBorderPainted(false);
		searchbtn.setOpaque(false);
		add(searchbtn);
		searchbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] rowData = new Object[6];
				for (int i = 0; i < dtm1.getRowCount();) {
					dtm1.removeRow(i);
				}
				// dtm1.addRow(rowData);
				stockList = pc.selectProductStockOnName(search_textField.getText());
				data = new Object[stockList.size()][6];
				for (ProductStock p : stockList) {
					int firIndex = p.getBarcodePath().lastIndexOf("\\") + 1;
					String firStr = p.getBarcodePath().substring(firIndex + 14, firIndex + 16);
					String seconStr = p.getBarcodePath().substring(firIndex + 16, firIndex + 18);
					rowData[0] = p.getBarcode();
					rowData[1] = p.getProductName();
					if (p.getSellByDate().substring(0, 1).equals("1")) {

						rowData[2] = firStr + "��" + seconStr + "��";
					} else if (p.getSellByDate().substring(0, 1).equals("2")) {
						rowData[2] = firStr + "��" + seconStr + "��";
					}
					rowData[3] = p.getQuantity();
					rowData[4] = "0";
					rowData[5] = false;
					dtm1.addRow(rowData);
				}
			}
		});

		// ���̺� ����
		check_table = new JTable(dtm1);
		check_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		check_table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 20));
		check_table.setFont(new Font("���� ���", Font.PLAIN, 16));
		check_table.setBounds(0, 0, 750, 260);
		check_table.getColumnModel().getColumn(0).setPreferredWidth(200);
		check_table.getColumnModel().getColumn(1).setPreferredWidth(200);
		check_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		check_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		check_table.getColumnModel().getColumn(4).setPreferredWidth(100);
		check_table.getColumnModel().getColumn(5).setPreferredWidth(50);
		check_table.getTableHeader().setReorderingAllowed(false);
		check_table.getTableHeader().setResizingAllowed(false);
		check_table.setRowHeight(37);

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
		check_table.getColumn("���").setCellEditor(new DefaultCellEditor(box) {
			@Override
			public Object getCellEditorValue() {
				return Boolean.valueOf(box.isSelected());
			}
		});

		// JScrollPane
		JScrollPane check_scrollPane = new JScrollPane(check_table);
		check_scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		check_scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		check_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		check_scrollPane.setBounds(29, 119, 625, 260);
		add(check_scrollPane);

		// ������ȸ ��
		JLabel orderLabel = new JLabel("�����");
		orderLabel.setFont(new Font("���� ���", Font.BOLD, 35));
		orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderLabel.setBounds(670, 28, 206, 63);
		add(orderLabel);

		// �߾� �и���
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(675, 29, 12, 350);
		add(separator);

		JLabel label = new JLabel("2018-06-27"); // ��¥ ������. �����δ� ��¥�� �޾ƿ;� ��.
		label.setFont(new Font("���� ���", Font.PLAIN, 18));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(373, 55, 240, 40);

		JLabel choicelabel = new JLabel("\uC0C1\uD488\uC120\uD0DD");
		choicelabel.setHorizontalAlignment(SwingConstants.CENTER);
		choicelabel.setFont(new Font("���� ���", Font.BOLD, 35));
		choicelabel.setBounds(0, 24, 188, 63);
		add(choicelabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "��ǰ��" }));
		comboBox.setBounds(176, 39, 80, 36);
		add(comboBox);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(700, 118, 475, 260);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(scrollPane_1);

		Object[][] tempData = null;
		String[] orderTableHeader = { "���ڵ�", "��ǰ��", "��������", "��ⰳ��", "����" };

		DefaultTableModel dtm = new DefaultTableModel(tempData, orderTableHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column == 4) {
					return true;
				} else {
					return false;
				}
			}
		};

		ProductScrap_table = new JTable(dtm);
		ProductScrap_table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 20));
		ProductScrap_table.setFont(new Font("���� ���", Font.PLAIN, 16));
		ProductScrap_table.setRowHeight(37);
		ProductScrap_table.getColumnModel().getColumn(0).setPreferredWidth(80);
		ProductScrap_table.getColumnModel().getColumn(1).setPreferredWidth(160);
		ProductScrap_table.getColumnModel().getColumn(2).setPreferredWidth(80);
		ProductScrap_table.getColumnModel().getColumn(3).setPreferredWidth(80);
		ProductScrap_table.getColumnModel().getColumn(4).setPreferredWidth(50);
		ProductScrap_table.getTableHeader().setReorderingAllowed(false);
		ProductScrap_table.getTableHeader().setResizingAllowed(false);
		ProductScrap_table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());

		ProductScrap_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int check = ProductScrap_table.getColumnCount() - 1;
				if (ProductScrap_table.getSelectedColumn() == check) {
					dtm.removeRow(ProductScrap_table.getSelectedRow());
				}

			}

		});
		scrollPane_1.setViewportView(ProductScrap_table);
		scrollPane_1.setBounds(700, 118, 475, 260);
		add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(555, 39, 100, 40);
		enterbtn.setBorderPainted(false);
		add(enterbtn);
		enterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ���̺��� ���� �� ��ȿ�� �˻�
				if (data == null) {
					// nothing to do
					System.out.println("data�� null");
				} else {
					// �迭�� ũ�⸦ ���� cnt���� ����
					int cnt = 0;
					// ���� ���̺��� ���� ������ �迭
					Object tmpData[][] = new Object[data.length][6];
					for (int i = 0; i < check_table.getRowCount(); i++) {
						// ���� ���̺��� check�� ���鸸 �迭�� ����
						boolean check = (boolean) check_table.getValueAt(i, 5);
						if (check) {
							for (int k = 0; k < data[i].length - 1; k++) {
								tmpData[cnt][k] = check_table.getValueAt(i, k);
							}
							if(!tmpData[cnt][4].toString().matches("^[0-9]*$")|| tmpData[cnt][4].equals("")){
								JOptionPane.showMessageDialog(null, "���ڸ� �Է� �����մϴ�. �Ǵ� ������ �ֳ� Ȯ�����ּ���.");
								return;
							}
							
							tmpData[cnt][5] = data[i][5];
							cnt++;
						}
					}
					// üũ�� ���� ��ŭ�� �迭 ����
					Object basketData[][] = new Object[cnt][6];
					// üũ�� �迭�� ���� ����
					for (int z = 0; z < basketData.length; z++) {
						for (int x = 0; x < basketData[z].length; x++) {
							basketData[z][x] = tmpData[z][x];
						}
					}

					// ������ ���̺��� 1���� ���� ��� = ù����
					if (ProductScrap_table.getRowCount() == 0) {
						// üũ�� ���� �Ѱܹ��� �� ���̺� ����
						for (int i = 0; i < basketData.length; i++) {
							if (!basketData[i][4].toString().equals("0") || basketData[i][4] != "") {
							Object[] rowData = new Object[5];
							rowData[0] = basketData[i][0];
							rowData[1] = basketData[i][1];
							rowData[2] = basketData[i][3];
							rowData[3] = basketData[i][4];
							rowData[4] = null;
							dtm.addRow(rowData);
							}
						}
					} else { // ������ ���̺��� ���� ������ ���� ���
						for (int j = 0; j < basketData.length; j++) {
							// ���� ���̺�� ���� ��ġ�� ������� �ش� ���� ���̺� �ֱ� ���ؼ� boolean����
							// ��ȿ�� üũ
							if (!basketData[j][4].toString().equals("0")|| basketData[j][4] != "") {
								boolean addRow = false;
								for (int i = 0; i < ProductScrap_table.getRowCount(); i++) {
									// ������ ���̺��� �������� �߰��� ���̶� ��ġ�� ��� = ���� ��ǰ�� ��
									// �߰���
									// ���
									if (ProductScrap_table.getValueAt(i, 0).toString()
											.equals(basketData[j][0].toString())) {
										// ���� ���̺��� �� ����
										System.out.println("����");
										Object orderNum = Integer
												.parseInt(ProductScrap_table.getValueAt(i, 3).toString())
												+ Integer.parseInt(basketData[j][4].toString());
										ProductScrap_table.setValueAt(orderNum, i, 3);
										addRow = true;
									}
								}
								if (!addRow) {
									Object[] rowData = new Object[5];
									rowData[0] = basketData[j][0];
									rowData[1] = basketData[j][1];
									rowData[2] = basketData[j][3];
									rowData[3] = basketData[j][4];
									rowData[4] = null;
									dtm.addRow(rowData);
								}
							}
						}
					}
					repaint();
				} // else�� ��
			}
		});

		JButton orderendbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		orderendbtn.setBounds(1074, 39, 100, 40);
		add(orderendbtn);
		orderendbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ArrayList<ProductStock> orderList = new
				// ArrayList<ProductStock>();
				for (int i = 0; i < ProductScrap_table.getRowCount(); i++) {
					for (int j = 0; j < stockList.size(); j++) {
						if (ProductScrap_table.getValueAt(i, 0).toString().equals(stockList.get(j).getBarcode())) {
							int su = stockList.get(j).getQuantity()
									- Integer.parseInt(ProductScrap_table.getValueAt(j, 3).toString());
							System.out.println(su);
							if (su < 0) {
								File file = new File(stockList.get(j).getBarcodePath());
								file.delete();
								stockList.remove(j);
								break;
							} else {
								stockList.get(j).setQuantity(su);
								break;
							}
						}
					}
					/*
					 * ProductStock temp = new
					 * ProductStock(ProductScrap_table.getValueAt(i,
					 * 0).toString(), Integer.parseInt(order_table.getValueAt(i,
					 * 4).toString()), null,order_table.getValueAt(i,
					 * 1).toString());
					 * temp.setSellByDate(order_table.getValueAt(i,
					 * 5).toString()); orderList.add(temp);
					 */
				}
				pc.deleteProductStock(stockList);
				contentPanel.removeAll();
				contentPanel.add(new POSMainCenterMenu());
				contentPanel.repaint();
				synchronized (POSMainFrame.eventSwipe) {
					POSMainFrame.eventSwipe.resume();
				}
			}
		});

		this.setVisible(true);

	}
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
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return jb;
	}

}
