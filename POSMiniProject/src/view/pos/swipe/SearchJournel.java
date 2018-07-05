package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

public class SearchJournel extends JPanel {

	public SearchJournel() {
		JPanel panel = new JPanel();
		JTable table = new JTable();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1199, 399);
		
		// Àú³Î Ç¥½Ã Å×ÀÌºí
		// Å×ÀÌºí ÀÓ½Ã µ¥ÀÌÅÍ
		Object data[][] = {
				{"06/29", "13:30", "5000", "Çö±Ý"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}};
		String colNames[] = { "ÀÏÀÚ", "½Ã°£", "±Ý¾×", "°Å·¡±¸ºÐ" };
		
		// Å×ÀÌºí »ý¼º
		table = new JTable(data, colNames);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.getTableHeader().setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 26)); 
		table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 26));
		table.setBounds(0, 0, 750, 260);
		table.getColumnModel().getColumn(0).setMaxWidth(187);
		table.getColumnModel().getColumn(0).setMinWidth(187); 
		table.getColumnModel().getColumn(0).setWidth(187);
		table.setRowHeight(37);
		
		// JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(29, 119, 750, 260);
		add(scrollPane, BorderLayout.CENTER);
		
		// Àú³ÎÁ¶È¸ ¶óº§
		JLabel lblNewLabel = new JLabel("Àú³Î Á¶È¸");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(17, 17, 199, 61);
		add(lblNewLabel);
		
		// Áß¾Ó ºÐ¸®¼±
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(804, 19, 1, 360);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("2018-06-27");		// °¡Â¥ µ¥ÀÌÅÍ
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(373, 7, 240, 40);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("2018-06-27");				// °¡Â¥ µ¥ÀÌÅÍ. ½ÇÁ¦·Î´Â ³¯Â¥¸¦ ¹Þ¾Æ¿Í¾ß ÇÔ.
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(373, 55, 240, 40);
		
		JLabel label_3 = new JLabel("2018-06-27");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(373, 55, 240, 40);
		add(label_3);
		
		JButton btnNewButton = new JButton("<<");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton.setBounds(317, 7, 39, 39);
		btnNewButton.setIcon(new ImageIcon("images/buttonsImages/PREVIOUS_ICON.PNG"));
		add(btnNewButton);
		
		JButton button = new JButton("<<");
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		button.setBounds(317, 55, 39, 39);
		button.setIcon(new ImageIcon("images/buttonsImages/PREVIOUS_ICON.PNG"));
		add(button);
		
		JButton button_1 = new JButton(">>");
		button_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		button_1.setBounds(624, 7, 39, 39);
		button_1.setIcon(new ImageIcon("images/buttonsImages/NEXT_ICON.PNG"));
		add(button_1);
		
		JButton button_2 = new JButton(">>");
		button_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		button_2.setBounds(624, 55, 39, 39);
		button_2.setIcon(new ImageIcon("images/buttonsImages/NEXT_ICON.PNG"));
		add(button_2);
		
		JLabel label_1 = new JLabel("\uC601\uC218\uC99D");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		label_1.setBounds(899, 17, 199, 61);
		add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("KH\uD3B8\uC758\uC810(\uC5ED\uC0BC\uC810)");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(909, 93, 189, 21);
		add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("2018-06-27");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		label_2.setBounds(909, 131, 189, 21);
		add(label_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC2DC\uC791\uC77C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(233, 7, 78, 39);
		add(lblNewLabel_3);
		
		JLabel label_4 = new JLabel("\uB9C8\uC9C0\uB9C9\uC77C");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		label_4.setBounds(233, 55, 78, 39);
		add(label_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textPane.setText("\uC815\uBD80\uBC29\uCE68\uC5D0 \uC758\uD574 \uAD50\uD658 / \uD658\uBD88\uC740 \uBC18\uB4DC\uC2DC \uC601\uC218\uC99D\uC744 \uC9C0\uCC38\uD558\uC154\uC57C \uD558\uBA70, \uCE74\uB4DC\uACB0\uC81C\uB294 30\uC77C\uC774\uB0B4 \uCE74\uB4DC\uC640 \uC601\uC218\uC99D \uC9C0\uCC38 \uC2DC \uAC00\uB2A5\uD569\uB2C8\uB2E4.\r\n\r\n-------------------------------------------------------------------\r\n\r\n\uCE6B\uC194 1 2500\r\n\uCE58\uC57D 1 2000");
		textPane.setBounds(834, 175, 348, 197);
		add(textPane);
	    
		this.setVisible(true);
	}
}
