package view.totalManageSystem.popUp.event;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import view.ComponentSettings;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;

public class EventModifyFrame extends JPanel {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JComboBox comboBox;
	private JButton button;

	public EventModifyFrame(MainFrame frame, ControllPanel mainPanel) {
		this.setBackground(Color.WHITE);
		this.setBounds(0,0,580,600);
		this.setLayout(null);
		
		// �г� ��� �˾� ����
		JLabel lblNewLabel = new JLabel("�̺�Ʈ ����");
		lblNewLabel.setBounds(200, 20, 206, 82);
		lblNewLabel.setFont(new Font("���ʷҵ���", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblNewLabel);
		
		
		button = new JButton(new ImageIcon("images/buttonsImages/SEARCH.PNG"));
		JButton[] btn = { button };
		ComponentSettings.imageButtonSetting(btn);
		button.setBounds(454, 107, 70, 42);
		this.add(button);

		this.setVisible(true);
		
		
		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		btnNewButton.setBounds(423, 40, 100, 40);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventMain(frame, mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		this.add(btnNewButton);
		
		
		
		
		
		textField = new JTextField();
		textField.setText("\uC785\uB825\uB780");
		textField.setBounds(220, 110, 221, 35);
		this.add(textField);
		textField.setColumns(10);
		
		String ColumnNames[] = { "�̺�Ʈ��", "�Ⱓ", "�̺�Ʈ���", "�̺�Ʈ�з�" };

		Object rowData[][] = { { "�ֹ�1+1", "2018/7/15", "khī��ȸ��", "1+1" }, { null, null, null, null },
				{ "�ݶ�2+1", null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ "���ö� 10%����", null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } };

		table = new JTable();
		table.setModel(new DefaultTableModel(rowData, ColumnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		});

		table.getTableHeader().setFont(new Font("�������", Font.BOLD, 20));
		table.setFont(new Font("���� ���", Font.PLAIN, 18));
		table.setLocation(17, 159);
		table.setSize(564, 280);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(80);
		table.getColumnModel().getColumn(2).setWidth(150);
		table.setRowHeight(30);
		table.setVisible(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == 1) {
					JTable temp = (JTable) e.getSource();
					int row = temp.getSelectedRow();
					if (row != -1) {
						mainPanel.getMainPanel().removeAll();
						mainPanel.getMainPanel().add(new EventModifySub(frame,mainPanel,temp.getValueAt(row, 0).toString()));
						mainPanel.add(mainPanel.getMainPanel());
						mainPanel.repaint();
					}
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setLocation(56, 164);
		scrollPane.setSize(479, 361);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollPane);
		// contentPane.add(table);

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
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addItem("�̺�Ʈ��");
		comboBox.addItem("�̺�Ʈ�Ⱓ");
		comboBox.addItem("�̺�Ʈ�з�");
		comboBox.setBounds(110, 110, 96, 35);
		this.add(comboBox);
		
		
		
		
		
		
		
		
		
		
		
       /* String[] columnNames = {"�̺�Ʈ �ڵ�",
                "�̺�Ʈ ��",
                "�Ⱓ",
                "�̺�Ʈ ���",
                "�̺�Ʈ �з�",
                "�̺�Ʈ �̹���"};
        Object[][] data = {
                {"Kathy"},
                {"John"},
                {"Sue"},
                {"Jane"},
                {"Joe"}
            };

        table = new JTable(data, columnNames){};
        
		table.setLocation(17, 159);
		table.setSize(564, 282);
		table.getColumnModel().getColumn(0).setMaxWidth(141);
	    table.getColumnModel().getColumn(0).setMinWidth(141); 
	    table.getColumnModel().getColumn(0).setWidth(141);
	    table.setRowHeight(56);
	    this.setVisible(true);*/
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
     /*   JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setLocation(17, 159);
	    scrollPane.setSize(564, 318);
	    scrollPane.setVisible(true);
	    contentPane.add(scrollPane);*/
	}

}
