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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
				"\uC81C\uD488\uBD84\uB958", "\uAC00\uACA9\uBE44\uAD50", "\uAC1C\uC218", "\uAC00\uACA9", "\uBE44\uAD50"
			}
		){
			//표 일부 수정 불가능
			public boolean isCellEditable(int row, int column) { 
				
					return false; 
				
			}});
		check_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		check_table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 20)); 
		check_table.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		check_table.setBounds(0, 0, 750, 260);
		check_table.setRowHeight(37);
		
		// JScrollPane
		JScrollPane check_scrollPane = new JScrollPane(check_table);
		check_scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
	    check_scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    check_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		check_scrollPane.setBounds(29, 119, 702, 260);
		add(check_scrollPane, BorderLayout.CENTER);
		
		// 저널조회 라벨
		JLabel orderLabel = new JLabel("\uD3D0\uAE30 \uBAA9\uB85D");
		orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderLabel.setBounds(755, 20, 199, 61);
		add(orderLabel);
		
		// 중앙 분리선
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(755, 29, 12, 350);
		add(separator);
		
		JLabel label = new JLabel("2018-06-27");				// 가짜 데이터. 실제로는 날짜를 받아와야 함.
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(373, 55, 240, 40);
		
		JLabel choicelabel = new JLabel("\uC0C1\uD488\uC120\uD0DD");
		choicelabel.setHorizontalAlignment(SwingConstants.CENTER);
		choicelabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		choicelabel.setBounds(0, 20, 199, 61);
		add(choicelabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uBD84\uB958", "\uC81C\uD488 \uBA85", "\uC81C\uC870 \uD68C\uC0AC", "\uBD84\uB958 \uBCC4"}));
		comboBox.setBounds(184, 29, 130, 38);
		add(comboBox);
		
		search_textField = new JTextField();
		search_textField.setText("\uC785\uB825\uB780");
		search_textField.setBounds(326, 34, 130, 29);
		add(search_textField);
		search_textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(779, 119, 395, 260);
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
				"\uC81C\uD488 \uBA85", "\uC785\uACE0\uC77C", "\uC720\uD1B5\uAE30\uD55C", "\uBE44\uACE0"
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
		ProductScrap_table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 20)); 
		ProductScrap_table.setRowHeight(37);
		scrollPane_1.setViewportView(ProductScrap_table);
		
		JButton orderendbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		orderendbtn.setBounds(1008, 29, 100, 40);
		add(orderendbtn);
		
		JButton searchbtn = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		searchbtn.setBounds(481, 29, 100, 40);
		searchbtn.setBackground(Color.white);
		searchbtn.setOpaque(false);
		add(searchbtn);
		
		JButton enterbtn = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		enterbtn.setBounds(608, 28, 100, 40);
		add(enterbtn);
	    
		this.setVisible(true);

}
}
