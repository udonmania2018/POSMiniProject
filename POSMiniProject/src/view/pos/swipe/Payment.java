// modified 07/10/17:41

package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Payment extends JPanel {
	private JTextField costTxt;
	private JTextField disTxt;
	private JTextField savTxt;
	private JTextField lastTxt;
	private JTable table;
	
	private JScrollPane scrollPane;

	public Payment() {
		setBackground(Color.RED);
		setOpaque(true);
		this.setSize(400,200);
		setLayout(null);
		
		// 계산 테이블 가짜데이터
		Object price[][]={{ "12,000", "100", "0", "11,900"}};
		String colNames[] = { "계산금액", "할인액", "적립금", "최종금액"};
		
		// 임시 테이블
		table = new JTable(price, colNames);
		table.setBounds(20, 20, 560, 70);
		table.setRowHeight(70);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		table.enable(false);		// deprecated. 수정 필요.
				
		// to do add scrollpanel
		scrollPane = new JScrollPane(table);
		// scrollPane.getColumnHeader().setPreferredSize(new Dimension(1200, 66));
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 4, 386, 90);
		this.add(scrollPane, BorderLayout.CENTER);
		
	    // 가운데 정렬 위한 코드
	    // DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
	    DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
	     

	    // DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
	    tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	     

	    // 정렬할 테이블의 ColumnModel을 가져옴
	    TableColumnModel tcmSchedule = table.getColumnModel();
	    
	    // 반복문을 이용하여 테이블을 가운데 정렬로 지정
	    for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
	    tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
	    }
		
		
		// 포인트 버튼
		JButton pointBtn = new JButton("");
		pointBtn.setBounds(63, 105, 105, 40);
		pointBtn.setBorderPainted(false);
		pointBtn.setBackground(Color.WHITE);
		pointBtn.setOpaque(false);
		pointBtn.setVerticalTextPosition(SwingConstants.CENTER);
		pointBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		pointBtn.setIcon(new ImageIcon("images/buttonsImages/POINT_ICON.PNG"));
		pointBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 현금 결제 버튼의 동작 지정
				JOptionPane.showMessageDialog(null, "포인트 결제 모듈이 필요합니다!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(pointBtn);
		
		// 카드 결제 버튼
		JButton cardBtn = new JButton("");
		cardBtn.setBounds(221, 105, 105, 40);
		cardBtn.setBorderPainted(false);
		cardBtn.setBackground(Color.WHITE);
		cardBtn.setOpaque(false);
		cardBtn.setVerticalTextPosition(SwingConstants.CENTER);
		cardBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		cardBtn.setIcon(new ImageIcon("images/buttonsImages/CARDPAY_ICON.PNG"));
		cardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 카드 결제 버튼의 동작 지정
				JOptionPane.showMessageDialog(null, "카드 결제 모듈이 필요합니다!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(cardBtn);
		
		// 현금 결제 버튼
		JButton cashBtn = new JButton("");
		cashBtn.setBounds(63, 155, 105, 40);
		cashBtn.setBorderPainted(false);
		cashBtn.setBackground(Color.WHITE);
		cashBtn.setOpaque(false);
		cashBtn.setVerticalTextPosition(SwingConstants.CENTER);
		cashBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		cashBtn.setIcon(new ImageIcon("images/buttonsImages/CASHPAY_ICON.PNG"));
		cashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 현금 결제 버튼의 동작 지정
				JOptionPane.showMessageDialog(null, "현금 결제 모듈이 필요합니다!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(cashBtn);
		
		// 취소 버튼
		JButton cancelBtn = new JButton("");
		cancelBtn.setBounds(221, 155, 105, 40);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setOpaque(false);
		cancelBtn.setVerticalTextPosition(SwingConstants.CENTER);
		cancelBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelBtn.setIcon(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 현금 결제 버튼의 동작 지정
				JOptionPane.showMessageDialog(null, "결제 취소", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(cancelBtn);		
	}
}
