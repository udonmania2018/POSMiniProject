package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ProductScrap extends JPanel {

	private JPanel contentPane;
	private JTextField search_textField;
	private JTable check_table;
	private JTable ProductScrap_table;

	
	public ProductScrap() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);
		
		// 저널 표시 테이블
		// 테이블 임시 데이터
		Object data[][] = {
				{"ㄹㄹㄹ", "ㄷㄷㄷ", "ㅇㅇㅇ", "ㅌㅌㅌ"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}};
		String colNames[] = { "ㅇㅇㅇ", "ㅎㅎㅎ", "ㅁㅁㅁ", "ㅋㅋㅋ" };
		
		// 테이블 생성
		check_table = new JTable(data, colNames);
		check_table.setModel(new DefaultTableModel(
			new Object[][] {
				{" ", " ", "", "", null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"제품분류", "가격비교", "개수", "가격", "비고"
			}
		){
			//표 일부 수정 불가능
			public boolean isCellEditable(int row, int column) { 
				
					return false; 
				
			}});
		check_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		check_table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20)); 
		check_table.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		check_table.setBounds(0, 0, 750, 260);
		check_table.setRowHeight(37);
		
	
		
		// JScrollPane
		JScrollPane check_scrollPane = new JScrollPane(check_table);
		check_scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
	    check_scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    check_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		check_scrollPane.setBounds(29, 119, 625, 260);
		add(check_scrollPane, BorderLayout.CENTER);
		
		// 저널조회 라벨
		JLabel orderLabel = new JLabel("폐기목록");
		orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderLabel.setBounds(670, 28, 206, 63);
		add(orderLabel);
		
		// 중앙 분리선
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(675, 29, 12, 350);
		add(separator);
		
		JLabel label = new JLabel("2018-06-27");				// 가짜 데이터. 실제로는 날짜를 받아와야 함.
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(373, 55, 240, 40);
		
		JLabel choicelabel = new JLabel("\uC0C1\uD488\uC120\uD0DD");
		choicelabel.setHorizontalAlignment(SwingConstants.CENTER);
		choicelabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		choicelabel.setBounds(0, 24, 188, 63);
		add(choicelabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uBD84\uB958", "\uC81C\uD488 \uBA85", "\uC81C\uC870 \uD68C\uC0AC", "\uBD84\uB958 \uBCC4"}));
		comboBox.setBounds(176, 39, 80, 36);
		add(comboBox);
		
		search_textField = new JTextField();
		search_textField.setText("\uC785\uB825\uB780");
		search_textField.setBounds(270, 39, 200, 36);
		add(search_textField);
		search_textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(700, 118, 475, 260);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(scrollPane_1);
		
		ProductScrap_table = new JTable();
		ProductScrap_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"제품명", "입고일", "유통기한", "비고"
			}
			
		){
			//표 일부 수정 불가능
			public boolean isCellEditable(int row, int column) { 
				if (column == 3) { 
					return true; 
				} else { 
					return false; 
				} 
			} 
		
		
		});
		ProductScrap_table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20)); 
		ProductScrap_table.setRowHeight(37);
		scrollPane_1.setViewportView(ProductScrap_table);
		
		JButton orderendbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		orderendbtn.setBounds(1074, 39, 100, 40);
		add(orderendbtn);
		
		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		searchbtn.setBounds(490, 39, 50, 40);
		searchbtn.setBackground(Color.white);
		searchbtn.setBorderPainted(false);
		searchbtn.setOpaque(false);
		add(searchbtn);
		
		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(555, 39, 100, 40);
		enterbtn.setBorderPainted(false);
		add(enterbtn);
	    
		this.setVisible(true);

}
}
