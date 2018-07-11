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
		 * // 테이블 임시 데이터 반드시 비고값에 true로 초기화 Object data[][] = {{ "ㄹㄹㄹ", "ㄷㄷㄷ",
		 * "ㅇㅇㅇ", "ㅌㅌㅌ", true }, { null, null, null, null, true }, { null, null,
		 * null, null, true }, { null, null, null, null, true }, { null, null,
		 * null, null, true }, { null, null, null, null, true }, { null, null,
		 * null, null, true }};
		 */

		String colNames[] = { "바코드", "제품명", "개수", "가격", "비고" };

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
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "제품명" }));
		comboBox.setBounds(176, 39, 80, 36);
		add(comboBox);

		textField = new JTextField();
		textField.setText("\uC785\uB825\uB780"); // 입력란
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

		// 돋보기버튼임

		/*
		 * if (textField.contains(null)) { Object response="검색하실 제품명을 입력하시오시오!";
		 * PrintWriter out=(PrintWriter) response;
		 * 
		 * out.println("<script>alert('경고창!');</script>");
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
					System.out.println("실행");
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
		// 테이블 수정x
		check_table.getTableHeader().setReorderingAllowed(false);
		check_table.getTableHeader().setResizingAllowed(false);
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
		check_table.getColumn("비고").setCellEditor(new DefaultCellEditor(box) {
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

		// 중앙 분리선
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(675, 29, 12, 350);
		add(separator);
		// ----------------- 오른쪽 상단 메뉴
		// --------------------------------------------
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
		totalOrder.setFont(new Font("함초롬돋움", Font.BOLD, 35));
		totalOrder.setBounds(700, 28, 206, 63);
		this.add(totalOrder);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(779, 119, 395, 260);
		add(scrollPane_1);

		Object[][] tempData = null;
		String[] orderTableHeader = { "바코드", "제품명", "가격", "보유", "발주", "삭제" };
		DefaultTableModel dtm = new DefaultTableModel(tempData, orderTableHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		// ArrayList<ArrayList<Product>> list = pc.selectStock();

		order_table = new JTable();
		order_table.setFont(new Font("함초롱돋움", Font.PLAIN, 26));
		order_table.setModel(dtm);
		order_table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		order_table.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		order_table.setRowHeight(37);
		order_table.getColumnModel().getColumn(0).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(1).setPreferredWidth(160);
		order_table.getColumnModel().getColumn(2).setPreferredWidth(120);
		order_table.getColumnModel().getColumn(3).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(4).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(5).setPreferredWidth(40);
		order_table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
		// 테이블 수정x
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

		// 왼쪽테이블에서 오른쪽 테이블로 넘기는 버튼 ( 확인버튼 )
		enterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 왼쪽 테이블이 없을 때 유효성 검사
				if (data == null) {
					// nothing to do
					System.out.println("data는 null");
				} else {
					// 배열의 크기를 위한 cnt변수 선언
					int cnt = 0;
					// 왼쪽 테이블의 값을 복제할 배열
					Object tmpData[][] = new Object[data.length][6];
					for (int i = 0; i < check_table.getRowCount(); i++) {
						// 왼쪽 테이블에서 check된 값들만 배열에 저장
						boolean check = (boolean) check_table.getValueAt(i, 4);
						if (check) {
							for (int k = 0; k < data[i].length - 1; k++) {
								tmpData[cnt][k] = check_table.getValueAt(i, k);
							}
							if(!tmpData[cnt][2].toString().matches("^[0-9]*$") || tmpData[cnt][2].equals("")){
								JOptionPane.showMessageDialog(null, "숫자만 입력 가능합니다. 또는 공백이 있나 확인해주세요.");
								return;
							}
							tmpData[cnt][5] = data[i][5];
							cnt++;
						}
					}
					// 체크된 갯수 만큼만 배열 선언
					Object basketData[][] = new Object[cnt][6];
					// 체크된 배열의 값을 복사
					for (int z = 0; z < basketData.length; z++) {
						for (int x = 0; x < basketData[z].length; x++) {
							basketData[z][x] = tmpData[z][x];
						}
						sum += Integer.parseInt(basketData[z][2].toString())
								* Integer.parseInt(basketData[z][3].toString());
					}
					// 합계 설정
					txtSum.setText(sum + "");

					// 오른쪽 테이블이 1개도 없을 경우 = 첫시작
					if (order_table.getRowCount() == 0) {
						// 체크를 통해 넘겨받은 값 테이블에 저장
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
					} else { // 오른쪽 테이블의 값이 기존에 있을 경우
						for (int j = 0; j < basketData.length; j++) {
							// 기존 테이블과 값이 겹치지 않을경우 해당 값을 테이블에 넣기 위해서 boolean으로
							// 유효성 체크
							if (!basketData[j][2].toString().equals("0") ||  basketData[j][2] != "") {
								boolean addRow = false;
								for (int i = 0; i < order_table.getRowCount(); i++) {
									// 오른쪽 테이블의 기존값이 추가될 값이랑 일치할 경우 = 같은 제품을 또
									// 추가할
									// 경우
									if (order_table.getValueAt(i, 0).toString().equals(basketData[j][0].toString())) {
										// 기존 테이블의 값 수정
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
				} // else의 끝
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

					OrderList ol = new OrderList("역삼점", order_table.getValueAt(i, 0).toString(),
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
