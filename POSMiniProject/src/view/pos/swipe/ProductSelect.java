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
	// 테이블 내용 field
	private Object[][] data; // scope 영역 때문에 field로 선언
	private String colNames[] = { "바코드", "제품명", "개수", "가격", "비고" };
	private Object[][] basketData; // 장바구니 data Object 배열

	public ProductSelect() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);

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

		// 검색어 입력창
		textField = new JTextField();
		textField.setText("상품명 입력");
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

		// 서치 버튼
		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("검색 실행");

				String searchName = textField.getText(); // 그냥 textField라 하면 주소
															// 가져옴

				// 빈 객체를 생성하지 말고 searchName을 매개변수로 pcr에 넘겨서 바로 객체를 생성하도록
				ArrayList<Product> list = pcr.selectProductOnName(searchName);

				data = new Object[list.size()][colNames.length]; // data 배열의 크기를
																	// 초기화

				// 다른 객체를 생성해서 주소를 대입하는 방식으로 하면 편하다. 싫다면 이중 for문 data[i][j]로
				// 넣을 수도 있다.
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

				// 태이블에 체크 박스 넣을 수 있도록 설정
				check_table.getColumn("비고").setCellRenderer(dcr);
				JCheckBox bx = new JCheckBox();
				bx.setHorizontalAlignment(JLabel.CENTER);
				check_table.getColumn("비고").setCellEditor(new DefaultCellEditor(bx) {
					@Override
					public Object getCellEditorValue() {
						// TODO Auto-generated method stub
						return Boolean.valueOf(bx.isSelected());
					}
				});

				repaint();
			}
		});

		// 확인버튼. 비고가 true인 항목을 장바구니로 이동
		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(555, 39, 100, 40);
		enterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 왼쪽 테이블이 없을 때 유효성 검사
				if (data == null) {
					// nothing to do
					System.out.println("data는 null");
				} else {
					// 배열의 크기를 위한 cnt변수 선언
					int cnt = 0;
					// 왼쪽 테이블의 값을 복제할 배열
					Object tmpData[][] = new Object[data.length][data[0].length];
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
							
							cnt++;
						}
					}
					// 체크된 갯수 만큼만 배열 선언
					basketData = new Object[cnt][tmpData[0].length - 1];

					// 체크된 배열의 값 basketData에 복사
					for (int z = 0; z < basketData.length; z++) {
						for (int x = 0; x < basketData[z].length; x++) {
							basketData[z][x] = tmpData[z][x];
						}
						// 아래 sum 관련 코드는 합계값이 필요할때
						// sum += Integer.parseInt(basketData[z][2].toString())
						// * Integer.parseInt(basketData[z][3].toString());
					}

					// 합계 설정
					// txtSum.setText(sum + "");

					// 오른쪽 테이블이 1개도 없을 경우 = 첫시작
					if (jtable.getRowCount() == 0) {
						// 체크를 통해 넘겨받은 값 테이블에 저장
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
					} else { // 오른쪽 테이블의 값이 기존에 있을 경우
						for (int j = 0; j < basketData.length; j++) {
							// 기존 테이블과 값이 겹치지 않을경우 해당 값을 테이블에 넣기 위해서 boolean으로
							if (!basketData[j][2].toString().trim().equals("0")&&basketData[j][2].toString().trim() != "") {
								boolean addRow = false;
								for (int i = 0; i < jtable.getRowCount(); i++) {
									// 오른쪽 테이블의 기존값이 추가될 값이랑 일치할 경우 = 같은 제품을 또
									// 추가할
									// 경우
									if (jtable.getValueAt(i, 0).toString().equals(basketData[j][0].toString())) {
										// 기존 테이블의 값 수정
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
					} // else 블럭의 끝
					repaint();
				}
			}
		});

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

		// -------------------- 오른 쪽 상단 메뉴
		// --------------------------------------

		JLabel lblNewLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(670, 28, 206, 63);
		this.add(lblNewLabel);

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/Counter.png"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 계산대로 버튼의 동작 지정
				System.out.println("계산대로");
				System.out.println(basketData[0][0]); // 왜 null?
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
		// --------------------------오른쪽 테이블 ------------------------------
		jtable = new JTable();

		String[] header = { "바코드", "제품명", "개수", "가격", "삭제" };

		dtm = new DefaultTableModel(basketData, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		jtable.setModel(dtm);
		jtable.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtable.setBounds(1, 0, 450, 300);
		jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(50);

		jtable.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
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