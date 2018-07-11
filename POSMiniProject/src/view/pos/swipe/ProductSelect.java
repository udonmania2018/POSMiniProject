// modified 07/10/17:41

package view.pos.swipe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.pos.POSController;
import model.vo.totalManageSystem.Product;
import view.ComponentSettings;

public class ProductSelect extends JPanel {

	private DefaultTableModel dtm;
	private JTable jtable;
	private JScrollPane jsp;
	private JTable check_table;
	private JTextField textField;
	private POSController pcr = new POSController();
	// ���̺� ���� field
	private Object[][] data; // scope ���� ������ field�� ����
	private String colNames[] = { "���ڵ�", "��ǰ��", "����", "����", "���" };
	private Object[][] basketData; // ��ٱ��� data Object �迭

	public ProductSelect() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);

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

		// �˻��� �Է�â
		textField = new JTextField();
		textField.setText("��ǰ�� �Է�");
		textField.setBounds(270, 39, 200, 36);
		add(textField);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
			}
		});
		textField.setColumns(10);

		// ��ġ ��ư
		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("�˻� ����");

				String searchName = textField.getText(); // �׳� textField�� �ϸ� �ּ�
															// ������

				// �� ��ü�� �������� ���� searchName�� �Ű������� pcr�� �Ѱܼ� �ٷ� ��ü�� �����ϵ���
				ArrayList<Product> list = pcr.selectProductOnName(searchName);

				data = new Object[list.size()][colNames.length]; // data �迭�� ũ�⸦
																	// �ʱ�ȭ

				// �ٸ� ��ü�� �����ؼ� �ּҸ� �����ϴ� ������� �ϸ� ���ϴ�. �ȴٸ� ���� for�� data[i][j]��
				// ���� ���� �ִ�.
				for (int i = 0; i < list.size(); i++) {
					Object tmp[] = { list.get(i).getBarcode(), list.get(i).getProductName(), 0,
							list.get(i).getProductPrice(), false };
					data[i] = tmp;
				}

				check_table.setModel(new DefaultTableModel(data, colNames) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						if (column == 2 || column == 4) {
							return true;
						} else {
							return false;
						}
					}
				});

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
				JCheckBox bx = new JCheckBox();
				bx.setHorizontalAlignment(JLabel.CENTER);
				check_table.getColumn("���").setCellEditor(new DefaultCellEditor(bx) {
					@Override
					public Object getCellEditorValue() {
						// TODO Auto-generated method stub
						return Boolean.valueOf(bx.isSelected());
					}
				});

				repaint();
			}
		});

		// Ȯ�ι�ư. ��� true�� �׸��� ��ٱ��Ϸ� �̵�
		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(555, 39, 100, 40);
		enterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ���� ���̺��� ���� �� ��ȿ�� �˻�
				if (data == null) {
					// nothing to do
					System.out.println("data�� null");
				} else {
					// �迭�� ũ�⸦ ���� cnt���� ����
					int cnt = 0;
					// ���� ���̺��� ���� ������ �迭
					Object tmpData[][] = new Object[data.length][data[0].length];
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
							
							cnt++;
						}
					}
					// üũ�� ���� ��ŭ�� �迭 ����
					basketData = new Object[cnt][tmpData[0].length - 1];

					// üũ�� �迭�� �� basketData�� ����
					for (int z = 0; z < basketData.length; z++) {
						for (int x = 0; x < basketData[z].length; x++) {
							basketData[z][x] = tmpData[z][x];
						}
						// �Ʒ� sum ���� �ڵ�� �հ谪�� �ʿ��Ҷ�
						// sum += Integer.parseInt(basketData[z][2].toString())
						// * Integer.parseInt(basketData[z][3].toString());
					}

					// �հ� ����
					// txtSum.setText(sum + "");

					// ������ ���̺��� 1���� ���� ��� = ù����
					if (jtable.getRowCount() == 0) {
						// üũ�� ���� �Ѱܹ��� �� ���̺� ����
						for (int i = 0; i < basketData.length; i++) {
							if (!basketData[i][2].toString().trim().equals("0") || basketData[i][2].toString().trim() != "") {
								Object[] rowData = new Object[4];
								rowData[0] = basketData[i][0];
								rowData[1] = basketData[i][1];
								rowData[2] = basketData[i][2];
								rowData[3] = basketData[i][3];
								dtm.addRow(rowData);
							}
						}
					} else { // ������ ���̺��� ���� ������ ���� ���
						for (int j = 0; j < basketData.length; j++) {
							// ���� ���̺�� ���� ��ġ�� ������� �ش� ���� ���̺� �ֱ� ���ؼ� boolean����
							if (!basketData[j][2].toString().trim().equals("0")&&basketData[j][2].toString().trim() != "") {
								boolean addRow = false;
								for (int i = 0; i < jtable.getRowCount(); i++) {
									// ������ ���̺��� �������� �߰��� ���̶� ��ġ�� ��� = ���� ��ǰ�� ��
									// �߰���
									// ���
									if (jtable.getValueAt(i, 0).toString().equals(basketData[j][0].toString())) {
										// ���� ���̺��� �� ����
										Object orderNum = Integer.parseInt(jtable.getValueAt(i, 2).toString())
												+ Integer.parseInt(basketData[j][2].toString());
										Object orderPrice = Integer.parseInt(orderNum.toString())
												* Integer.parseInt(basketData[j][3].toString());
										jtable.setValueAt(orderNum, i, 2);
										jtable.setValueAt(orderPrice, i, 3);
										addRow = true;
									}
								}
								if (!addRow) {
									Object[] rowData = new Object[4];
									rowData[0] = basketData[j][0];
									rowData[1] = basketData[j][1];
									rowData[2] = basketData[j][2];
									rowData[3] = basketData[j][3];
									dtm.addRow(rowData);
								}
							}
						}
					} // else ���� ��
					repaint();
				}
			}
		});

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
				// ����� ��ư�� ���� ����
				System.out.println("�����");
				System.out.println(basketData[0][0]); // �� null?
				POSMainFrame.staticData = basketData;
				System.out.println(POSMainFrame.staticData[0][0]);
				removeAll();
				add(new POSMainCenterMenu());
				repaint();
				synchronized (POSMainFrame.eventSwipe) {
					POSMainFrame.eventSwipe.resume();
				}
			}
		});
		btnNewButton.setBounds(1057, 39, 105, 39);
		this.add(btnNewButton);
		// ----------------------------------------------------------
		// --------------------------������ ���̺� ------------------------------
		jtable = new JTable();

		String[] header = { "���ڵ�", "��ǰ��", "����", "����", "����" };

		dtm = new DefaultTableModel(basketData, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
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