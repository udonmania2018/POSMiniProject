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
		
		// 패널 상단 팝업 제목
		JLabel lblNewLabel = new JLabel("이벤트 수정");
		lblNewLabel.setBounds(200, 20, 206, 82);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
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
		
		String ColumnNames[] = { "이벤트명", "기간", "이벤트대상", "이벤트분류" };

		Object rowData[][] = { { "핫바1+1", "2018/7/15", "kh카드회원", "1+1" }, { null, null, null, null },
				{ "콜라2+1", null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ "도시락 10%할인", null, null, null }, { null, null, null, null }, { null, null, null, null },
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

		table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 20));
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
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
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addItem("이벤트명");
		comboBox.addItem("이벤트기간");
		comboBox.addItem("이벤트분류");
		comboBox.setBounds(110, 110, 96, 35);
		this.add(comboBox);
		
		
		
		
		
		
		
		
		
		
		
       /* String[] columnNames = {"이벤트 코드",
                "이벤트 명",
                "기간",
                "이벤트 대상",
                "이벤트 분류",
                "이벤트 이미지"};
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
