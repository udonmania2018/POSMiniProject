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
	private Object[][] data = null;	// scope 영역 때문에 field로 선언
	private String colNames[] = { "제품분류", "제품명", "개수", "가격", "비고" };
	private Object[][] basketData = null; // 장바구니 data

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
								
				String searchName = textField.getText();	// 그냥 textField라 하면 주소를 가져옴
				// 빈 객체를 생성하지 말고 searchName을 매개변수로 pcr에 넘겨서 바로 객체를 생성하도록
				
				ArrayList<Product> list = pcr.selectProductOnName(searchName);
				
				data = new Object[list.size()][colNames.length]; // data 배열의 크기를 초기화
				
				for(int i = 0; i < list.size(); i++){
					Object tmp[] = {list.get(i).getProductGroupCode(), list.get(i).getProductName(), 1, list.get(i).getProductPrice(), true};	
					// 다른 객체를 생성해서 주소를 대입하는 방식으로 하면 편하다. 싫다면 이중 for문 data[i][j]로 넣을 수도 있다.
					data[i] = tmp;
				}
				
				check_table.setModel(new DefaultTableModel(data, colNames){
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
				check_table.getColumn("비고").setCellEditor(new DefaultCellEditor(bx));
				
				repaint();
			}
				});

		// 확인버튼. 비고가 true인 항목을 장바구니로 이동
		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(555, 39, 100, 40);
		enterbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("장바구니 이동 실행");
				// 여기에서 장바구니 basketData로 비고가 true인 data를 넘기면 되지 않을까?
				// data 배열의 크기를 받아와 basketData[][]를 초기화
				// 비고가 true인 data만 가져와 basketData에 추가해야 함
				// tmp 배열을 만들어서 해볼까				
				// 여기서만 쓰는 tmpData[][] 생성			
				if(data == null){
					// nothing to do
					System.out.println("data는 null");
				}else{
				
				int cnt = 0;
				Object tmpData[][] = new Object[data.length][data[0].length];
				
				for(int i = 0; i < data.length; i++){
					
					// 체크 위치를 판별해 true면 해당 배열 copy, 아니면 넘기기
					if(data[i][data[0].length - 1].equals(true)){
						for(int j = 0; j < data[i].length - 1; j++){
							System.out.println("data[" + i + "][" + j + "] 카피");
							tmpData[i][j] = data[i][j];
							cnt++;
						}
					}else{
						System.out.println("카피 필요 없음");
					}
					
				}
				
				// tmpData 배열에 있는 정보를 basketData[][]로 넘겨 출력
				
				Object basketData[][] = new Object[cnt][tmpData[0].length];
				
				for(int i = 0; i < tmpData.length; i++){
					for(int j = 0; j < tmpData[i].length; j++){
						basketData[i][j] = tmpData[i][j];
					}
				}
				
				// 우측 장바구니 테이블 다시 그리기
				repaint();
				
				} // else의 끝
				
			
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
				box.setSelected(((Boolean)value).booleanValue());
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

			}
		});
		btnNewButton.setBounds(1057, 39, 105, 39);
		this.add(btnNewButton);
		// ----------------------------------------------------------
		// --------------------------오른쪽 테이블 ------------------------------
		jtable = new JTable();

		/*
		Object[][] rowData = { { 1, null, null, null, null }, { 2, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null },
				{ 3, null, null, null, null }, { 4, null, null, null, null }, { null, null, null, null, null } };
*/
		
		String[] header = { "No", "제품명", "개수", "가격", "삭제" };

		dtm = new DefaultTableModel(basketData, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
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
