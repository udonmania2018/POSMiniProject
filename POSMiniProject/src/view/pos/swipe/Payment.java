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
		
		// ��� ���̺� ��¥������
		Object price[][]={{ "12,000", "100", "0", "11,900"}};
		String colNames[] = { "���ݾ�", "���ξ�", "������", "�����ݾ�"};
		
		// �ӽ� ���̺�
		table = new JTable(price, colNames);
		table.setBounds(20, 20, 560, 70);
		table.setRowHeight(70);
		table.setFont(new Font("���� ���", Font.PLAIN, 25));
		table.enable(false);		// deprecated. ���� �ʿ�.
				
		// to do add scrollpanel
		scrollPane = new JScrollPane(table);
		// scrollPane.getColumnHeader().setPreferredSize(new Dimension(1200, 66));
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 4, 386, 90);
		this.add(scrollPane, BorderLayout.CENTER);
		
	    // ��� ���� ���� �ڵ�
	    // DefaultTableCellHeaderRenderer ���� (��� ������ ����)
	    DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
	     

	    // DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
	    tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	     

	    // ������ ���̺��� ColumnModel�� ������
	    TableColumnModel tcmSchedule = table.getColumnModel();
	    
	    // �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
	    for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
	    tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
	    }
		
		
		// ����Ʈ ��ư
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
				// ���� ���� ��ư�� ���� ����
				JOptionPane.showMessageDialog(null, "����Ʈ ���� ����� �ʿ��մϴ�!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(pointBtn);
		
		// ī�� ���� ��ư
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
				// ī�� ���� ��ư�� ���� ����
				JOptionPane.showMessageDialog(null, "ī�� ���� ����� �ʿ��մϴ�!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(cardBtn);
		
		// ���� ���� ��ư
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
				// ���� ���� ��ư�� ���� ����
				JOptionPane.showMessageDialog(null, "���� ���� ����� �ʿ��մϴ�!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(cashBtn);
		
		// ��� ��ư
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
				// ���� ���� ��ư�� ���� ����
				JOptionPane.showMessageDialog(null, "���� ���", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.add(cancelBtn);		
	}
}
