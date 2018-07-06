package view.totalManageSystem.popUp.event;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.tmsDao.Event;
import model.vo.EventGroup;
import view.totalManageSystem.management.ManagementSystem;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;

public class EventMain extends JPanel {
	private JTextField txtTextfield;
	private JTextField txtTextfield_1;
	private JTextField txtTextfield_2;
	private JTextField txtTextfield_3;
	private JTextField textField;

	private Event eventdao = new Event();
	/**
	 * Create the panel.
	 */
	public EventMain(MainFrame frame, ControllPanel mainPanel) {
		setForeground(Color.BLACK);
		this.setBounds(0,0,580,600);
		JPanel panel = new JPanel();
		add(panel);
		setBackground(SystemColor.text);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("이벤트 추가");
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 20, 206, 82);
		add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("이벤트 코드");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 130, 170, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("이벤트명");
		lblNewLabel_6.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(60, 180, 170, 40);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("기간");
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(60, 230, 170, 40);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이벤트대상");
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(60, 280, 170, 40);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이벤트분류");
		lblNewLabel_4.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(60, 330, 170, 40);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이벤트 이미지");
		lblNewLabel_5.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(70, 400, 170, 40);
		add(lblNewLabel_5);
		
		txtTextfield = new JTextField();
		txtTextfield.setText("textField");
		txtTextfield.setHorizontalAlignment(SwingConstants.CENTER);
		txtTextfield.setBounds(300, 134, 200, 40);
		add(txtTextfield);
		txtTextfield.setColumns(10);
		
		txtTextfield_1 = new JTextField();
		txtTextfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTextfield_1.setText("textField");
		txtTextfield_1.setBounds(300, 185, 200, 40);
		add(txtTextfield_1);
		txtTextfield_1.setColumns(10);
		
		txtTextfield_2 = new JTextField();
		txtTextfield_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTextfield_2.setText("textField");
		txtTextfield_2.setBounds(300, 234, 200, 40);
		add(txtTextfield_2);
		txtTextfield_2.setColumns(10);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC544\uC774\uC2A4\uD06C\uB9BC", "\uC6B0\uC720", "\uCD08\uCF5C\uB81B"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(300, 285, 200, 40);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"증정 행사","할인 행사"}));
		comboBox_1.setBounds(300, 335, 100, 40);
		add(comboBox_1);
		
		JPanel temp = this;
		textField = new JTextField("+");
		textField.setBounds(410, 335, 90, 40);
		add(textField);
		textField.setColumns(10);
		comboBox_1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_1.getSelectedItem().equals("증정 행사")){
					textField.setText("+");
				} else if (comboBox_1.getSelectedItem().equals("할인 행사")){
					textField.setText("%");
				}

			}
		});
		
		
		
		JTextField eventComent = new JTextField();
		this.add(eventComent);
		
		txtTextfield_3 = new JTextField();
		txtTextfield_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtTextfield_3.setText("textField");
		txtTextfield_3.setBounds(300, 400, 200, 44);
		add(txtTextfield_3);
		txtTextfield_3.setColumns(10);
		
		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(423, 40, 100, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventModifyFrame(frame,mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(150, 470, 100, 40);
		add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EventGroup eg = new EventGroup(txtTextfield.getText(),txtTextfield_1.getText() ,txtTextfield_2.getText() ,txtTextfield_3.getText() );
				eventdao.addEventGroup(eg);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		btnNewButton_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ManagementSystem.mainPopCheck= true;
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(350, 470, 100, 40);
		add(btnNewButton_2);
		
		/*JButton btnNewButton_3 = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/PLUS.png"));
		btnNewButton_3.setBounds(505, 342, 27, 27);
		add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					new GroupManage(new String("eventGroup"),true);
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		
		JButton btnNewButton_4 = new JButton(new ImageIcon("images/totalManageSystem/Pop/buttonsImages/MINUS.png"));
		btnNewButton_4.setBounds(539, 342, 27, 27);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.popUpMainFrameCheck) {
					new GroupManage(new String("eventGroup"),false);
					MainFrame.popUpMainFrameCheck = false;
				}
			}
		});
		add(btnNewButton_4);
		*/
		
		JLabel lblNewLabel_7 = new JLabel("\uC785\uB825 \uD615\uC2DD xx (2\uC790\uB9AC \uC22B\uC790)");
		lblNewLabel_7.setForeground(Color.GRAY);
		lblNewLabel_7.setBounds(300, 375, 200, 18);
		add(lblNewLabel_7);
	}
}
