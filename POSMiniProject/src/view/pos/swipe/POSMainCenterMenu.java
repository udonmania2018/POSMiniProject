package view.pos.swipe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import model.vo.totalManageSystem.Product;

public class POSMainCenterMenu extends JPanel {
	private JTable table;
	
	private JTable table3;
	private JScrollPane scrollPane,scrollPane2,scrollPane3 ;
	private JLabel eventImage;

	public POSMainCenterMenu() {
		this.setBounds(0, 0, 1200, 400);
		setLayout(null);
		// ���� ���̺� ��¥������
		Object data[][] = POSMainFrame.staticData;
		
		// tmp code
		if(POSMainFrame.staticData == null){
			System.out.println("staticData�� null");
		}else{

			System.out.println(POSMainFrame.staticData[0][0]);
			
			
		}
		
		// �������
		String colNames[] = { "��ȣ", "��ǰ��", "�ܰ�", "����", "�ݾ�", "���" };

		DefaultTableModel dtm = new DefaultTableModel(data, colNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column == 3){
					return true;
				} else {
					return false;
				}
			}
		};
		// ���� ���̺� ����
		table = new JTable(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(83);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		table.setFont(new Font("���� ���", Font.PLAIN, 20));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(0, 0, 800, 400);
		table.setRowHeight(50);
		table.getTableHeader().setFont(new Font("�������",Font.BOLD,30));
		
		/*// ���� ��� ���̺�
		table2 = new JTable();
		table2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table2.setBounds(600, 0, 400, 200);*/
		
		eventImage = new JLabel(new ImageIcon("images/pos/Event.png"));
		eventImage.setBounds(800, 0, 400, 150);
		
		ImageIcon barcode = new ImageIcon("images/pos/880000100001410617.png");
		Image modifySize = barcode.getImage();
		
		Image afterSize = modifySize.getScaledInstance(400, 40, Image.SCALE_SMOOTH);
		
		JLabel barcodeImage = new JLabel(new ImageIcon(afterSize));
		barcodeImage.setBounds(800, 150, 400, 50);
		
		
		add(eventImage);
		add(barcodeImage);
		
		// ���� �ϴ� ���̺�
		String[] dtm2Column = {"",""};
		Object[][] date2 = new Object[3][2];
		DefaultTableModel dtm2 = new DefaultTableModel(date2,dtm2Column){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dtm2.setValueAt("�հ�", 0, 0);
		dtm2.setValueAt("����", 1, 0);
		dtm2.setValueAt("�Ž���", 2, 0);
		
		table3 = new JTable(dtm2);
		table3.setFont(new Font("���� ���", Font.PLAIN, 30));
		table3.setRowHeight(64);
		
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table3.getColumnModel().getColumn(0).setPreferredWidth(100);
		table3.getColumnModel().getColumn(1).setPreferredWidth(290);
		table3.setBounds(800, 200, 400, 200);
		
		
		TableCellRenderer renderer = new MyTableCellRenderer();
		try {
			table3.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.getColumnHeader().setPreferredSize(new Dimension(1200, 66));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 800, 400);
		add(scrollPane);
		
		scrollPane3 = new JScrollPane(table3);
		scrollPane3.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane3.getViewport().setBackground(Color.WHITE);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane3.setBounds(800, 200, 400, 200);
		add(scrollPane3, BorderLayout.CENTER);
		
	}

	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public JScrollPane getScrollPane2() {
		return scrollPane2;
	}


	public JScrollPane getScrollPane3() {
		return scrollPane3;
	}


	
	public JLabel getEventImage() {
		return eventImage;
	}


	public void click() {
//		this.setBounds(0, 0, 1200, 400);
//		setLayout(null);
		this.remove(table);
		//this.remove(table2);
		this.remove(table3);
//		super.setVisible(false);
		
	}
	
	class MyTableCellRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if(!isSelected){
				if(column == 0){
					cell.setBackground(new Color(238, 238, 238));
				} else {
					cell.setBackground(Color.WHITE);
				}
			}
			return cell;
		}
	}
}
