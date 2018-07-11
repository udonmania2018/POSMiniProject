package view.pos.swipe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.pos.POSController;
import model.vo.pos.ProductStock;
import model.vo.totalManageSystem.OrderList;
import model.vo.totalManageSystem.Product;
import view.ComponentSettings;

public class ProductOrder extends JPanel {
	private JTable check_table;
	private JTextField textField;
	private JTable order_table;
	private POSController pc = new POSController();
	private JTextField txtSum;
	private Object data[][];
	private ArrayList<Product> list;
	private int sum;
	private ArrayList<ProductStock> stockList;

	public ProductOrder(JPanel contentPanel) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);
		this.setLayout(null);
		data = null;
		stockList = pc.selectProductStock();
		/*
		 * // ���̺� �ӽ� ������ �ݵ�� ����� true�� �ʱ�ȭ Object data[][] = {{ "������", "������",
		 * "������", "������", true }, { null, null, null, null, true }, { null, null,
		 * null, null, true }, { null, null, null, null, true }, { null, null,
		 * null, null, true }, { null, null, null, null, true }, { null, null,
		 * null, null, true }};
		 */

		String colNames[] = { "���ڵ�", "��ǰ��", "����", "����", "���" };

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
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "��ǰ��" }));
		comboBox.setBounds(176, 39, 80, 36);
		add(comboBox);

		textField = new JTextField();
		textField.setText("\uC785\uB825\uB780"); // �Է¶�
		textField.setBounds(270, 39, 200, 36);
		add(textField);
		textField.setColumns(10);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
			}
		});

		txtSum = new JTextField();
		txtSum.setText("0");
		txtSum.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSum.setBounds(899, 44, 130, 42);
		add(txtSum);
		txtSum.setColumns(10);
		txtSum.setEditable(false);

		JLabel lblNewLabel = new JLabel("\uC6D0");
		lblNewLabel.setToolTipText("\uC6D0");
		lblNewLabel.setBounds(1031, 48, 43, 36);
		add(lblNewLabel);

		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));

		// �������ư��

		/*
		 * if (textField.contains(null)) { Object response="�˻��Ͻ� ��ǰ���� �Է��Ͻÿ��ÿ�!";
		 * PrintWriter out=(PrintWriter) response;
		 * 
		 * out.println("<script>alert('���â!');</script>");
		 * 
		 * out.flush();
		 * 
		 * out.close();
		 * 
		 * 
		 * 
		 * textField.getText(); return; } textField.getText();
		 * textField.add(check_table);
		 */

		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));

		enterbtn.setBounds(555, 39, 100, 40);
		add(enterbtn);

		searchbtn.setBounds(490, 39, 50, 40);
		add(searchbtn);
		searchbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] rowData = new Object[6];
				for (int i = 0; i < dtm1.getRowCount();) {
					dtm1.removeRow(i);
					System.out.println("����");
				}
				// dtm1.addRow(rowData);
				list = pc.selectProductOnName(textField.getText());

				data = new Object[list.size()][6];
				int cnt = 0;
				for (Product p : list) {
					if (p.getProductName().contains(textField.getText())) {
						rowData[0] = p.getBarcode();
						rowData[1] = p.getProductName();
						rowData[2] = 0;
						rowData[3] = p.getProductPrice();
						rowData[4] = false;
						rowData[5] = p.getSellByDate();
						dtm1.addRow(rowData);
					}
					data[cnt][5] = p.getSellByDate();
					cnt++;
				}
			}
		});
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
		// ���̺� ����x
		check_table.getTableHeader().setReorderingAllowed(false);
		check_table.getTableHeader().setResizingAllowed(false);
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
		check_table.getColumn("���").setCellEditor(new DefaultCellEditor(box) {
			@Override
			public Object getCellEditorValue() {
				return Boolean.valueOf(box.isSelected());
			}
		});

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
		// ----------------- ������ ��� �޴�
		// --------------------------------------------
		/*
		 * JLabel label = new JLabel("2018-06-27"); // ��¥ ������. �����δ� ��¥�� �޾ƿ;� ��.
		 * label.setFont(new Font("���� ���", Font.PLAIN, 18)); label.setBorder(new
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

		JLabel totalOrder = new JLabel("�ѹ���");
		totalOrder.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		totalOrder.setBounds(700, 28, 206, 63);
		this.add(totalOrder);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(779, 119, 395, 260);
		add(scrollPane_1);

		Object[][] tempData = null;
		String[] orderTableHeader = { "���ڵ�", "��ǰ��", "����", "����", "����", "����" };
		DefaultTableModel dtm = new DefaultTableModel(tempData, orderTableHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		// ArrayList<ArrayList<Product>> list = pc.selectStock();

		order_table = new JTable();
		order_table.setFont(new Font("���ʷյ���", Font.PLAIN, 26));
		order_table.setModel(dtm);
		order_table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 20));
		order_table.setFont(new Font("���� ���", Font.PLAIN, 16));
		order_table.setRowHeight(37);
		order_table.getColumnModel().getColumn(0).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(1).setPreferredWidth(160);
		order_table.getColumnModel().getColumn(2).setPreferredWidth(120);
		order_table.getColumnModel().getColumn(3).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(4).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(5).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
		// ���̺� ����x
		order_table.getTableHeader().setReorderingAllowed(false);
		order_table.getTableHeader().setResizingAllowed(false);
		order_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int check = order_table.getColumnCount() - 1;
				if (order_table.getSelectedColumn() == check) {
					Object tempPrice = order_table.getValueAt(order_table.getSelectedRow(), 2);
					int resultPrice = Integer.parseInt(txtSum.getText()) - Integer.parseInt(tempPrice.toString());
					txtSum.setText(resultPrice + "");
					dtm.removeRow(order_table.getSelectedRow());
				}

			}

		});
		scrollPane_1.setViewportView(order_table);
		scrollPane_1.setBounds(700, 118, 475, 260);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane_1);

		JButton orderendbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		orderendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		orderendbtn.setBounds(1074, 39, 100, 40);
		add(orderendbtn);

		// �������̺��� ������ ���̺�� �ѱ�� ��ư ( Ȯ�ι�ư )
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
						boolean check = (boolean) check_table.getValueAt(i, 4);
						if (check) {
							for (int k = 0; k < data[i].length - 1; k++) {
								tmpData[cnt][k] = check_table.getValueAt(i, k);
							}
							if(!tmpData[cnt][2].toString().matches("^[0-9]*$") || tmpData[cnt][2].equals("")){
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
						sum += Integer.parseInt(basketData[z][2].toString())
								* Integer.parseInt(basketData[z][3].toString());
					}
					// �հ� ����
					txtSum.setText(sum + "");

					// ������ ���̺��� 1���� ���� ��� = ù����
					if (order_table.getRowCount() == 0) {
						// üũ�� ���� �Ѱܹ��� �� ���̺� ����
						for (int i = 0; i < basketData.length; i++) {
							if (!basketData[i][2].toString().equals("0") || basketData[i][2] != "" ) {
								Object[] rowData = new Object[6];
								rowData[0] = basketData[i][0];
								rowData[1] = basketData[i][1];
								rowData[2] = Integer.parseInt(basketData[i][2].toString())
										* Integer.parseInt(basketData[i][3].toString());
								int quantity = 0;
								for (int j = 0; j < stockList.size(); j++) {
									if (stockList.get(j).getBarcode().equals(basketData[i][0].toString())) {
										quantity += stockList.get(j).getQuantity();
									}
								}
								rowData[3] = quantity;
								rowData[4] = basketData[i][2];
								rowData[5] = basketData[i][5];
								dtm.addRow(rowData);
							}
						}
					} else { // ������ ���̺��� ���� ������ ���� ���
						for (int j = 0; j < basketData.length; j++) {
							// ���� ���̺�� ���� ��ġ�� ������� �ش� ���� ���̺� �ֱ� ���ؼ� boolean����
							// ��ȿ�� üũ
							if (!basketData[j][2].toString().equals("0") ||  basketData[j][2] != "") {
								boolean addRow = false;
								for (int i = 0; i < order_table.getRowCount(); i++) {
									// ������ ���̺��� �������� �߰��� ���̶� ��ġ�� ��� = ���� ��ǰ�� ��
									// �߰���
									// ���
									if (order_table.getValueAt(i, 0).toString().equals(basketData[j][0].toString())) {
										// ���� ���̺��� �� ����
										Object orderNum = Integer.parseInt(order_table.getValueAt(i, 4).toString())
												+ Integer.parseInt(basketData[j][2].toString());
										Object orderPrice = Integer.parseInt(orderNum.toString())
												* Integer.parseInt(basketData[j][3].toString());
										order_table.setValueAt(orderNum, i, 4);
										order_table.setValueAt(orderPrice, i, 2);

										addRow = true;
									}
								}
								if (!addRow) {
									Object[] rowData = new Object[6];
									rowData[0] = basketData[j][0];
									rowData[1] = basketData[j][1];
									rowData[2] = Integer.parseInt(basketData[j][2].toString())
											* Integer.parseInt(basketData[j][3].toString());
									int quantity = 0;
									for (int k = 0; k < stockList.size(); k++) {
										if (stockList.get(k).getBarcode().equals(basketData[j][0].toString())) {
											quantity += stockList.get(k).getQuantity();
										}
									}
									rowData[3] = quantity;
									rowData[4] = basketData[j][2];
									rowData[5] = basketData[j][5];
									dtm.addRow(rowData);
								}
							}
						}
					}
					repaint();
				} // else�� ��
			}
		});

		orderendbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<ProductStock> orderList = new ArrayList<ProductStock>();
				ArrayList<OrderList> orderList2 = new ArrayList<OrderList>();
				for (int i = 0; i < order_table.getRowCount(); i++) {
					ProductStock temp = new ProductStock(order_table.getValueAt(i, 0).toString(),
							Integer.parseInt(order_table.getValueAt(i, 4).toString()), null,
							order_table.getValueAt(i, 1).toString());
					temp.setSellByDate(order_table.getValueAt(i, 5).toString());
					orderList.add(temp);

					OrderList ol = new OrderList("������", order_table.getValueAt(i, 0).toString(),
							Integer.parseInt(order_table.getValueAt(i, 4).toString()), new Date());
					orderList2.add(ol);
				}
				pc.orderProduct(orderList);
				pc.addOrderList(orderList2);

				contentPanel.removeAll();
				contentPanel.add(new POSMainCenterMenu());
				contentPanel.repaint();
				synchronized (POSMainFrame.eventSwipe) {
					POSMainFrame.eventSwipe.resume();
				}
			}
		});

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
