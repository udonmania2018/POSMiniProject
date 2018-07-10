package view.totalManageSystem.popUp.event;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import controller.totalManageSystem.EventController;
import model.vo.totalManageSystem.EventGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;
import view.totalManageSystem.popUp.product.ProductMain;
import view.totalManageSystem.popUp.product.ProductModifyMain;

import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DropMode;

public class EventModifySub extends JPanel {

	//제목 선언
	private JLabel title;
	private JButton addButton;
	private JTextField eveName;
	private JTextField evePeriod;
	private JTextField eveDaesang;
	private JTextField eveGroup;
	private JTextField eveImage;
	private JTextField nameInput;
	private JTextField perInput;
	
	private JComboBox DaeBox;
	private JComboBox GroBox;
	
	private JLabel eveLabel;
	
	private EventController ec = new EventController();
	private EventGroup e ;
	

	public EventModifySub(MainFrame frame, ControllPanel mainPanel, String eventName) {
		this.setBounds(0,0,580,600);
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		e = ec.selectEventOnNames(eventName);
		
		//제목(이벤트수정)
		title = new JLabel("이 벤 트 수 정");
		title.setBounds(200, 20, 206, 82);
		title.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(title);
		
		//추가 버튼
		JButton addButton;
		addButton = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		addButton.setBorderPainted(false); // 버튼 테두리 설정해제
		addButton.setBounds(423, 40, 100, 40); // 버튼 크기 지정
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventMain(frame, mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		add(addButton);
		
		eveName = new JTextField();
		eveName.setBounds(55, 199, 141, 42);
		eveName.setHorizontalAlignment(SwingConstants.CENTER);
		eveName.setText("이벤트 명");
		eveName.setColumns(10);
		eveName.setBackground(Color.LIGHT_GRAY);
		add(eveName);
		
		evePeriod = new JTextField();
		evePeriod.setBounds(55, 240, 141, 42);
		evePeriod.setHorizontalAlignment(SwingConstants.CENTER);
		evePeriod.setText("기간");
		evePeriod.setColumns(10);
		evePeriod.setBackground(Color.LIGHT_GRAY);
		add(evePeriod);
		
		eveDaesang = new JTextField();
		eveDaesang.setBounds(55, 281, 141, 42);
		eveDaesang.setHorizontalAlignment(SwingConstants.CENTER);
		eveDaesang.setText("이벤트 대상");
		eveDaesang.setColumns(10);
		eveDaesang.setBackground(Color.LIGHT_GRAY);
		add(eveDaesang);
		
		eveGroup = new JTextField();
		eveGroup.setBounds(55, 320, 141, 42);
		eveGroup.setHorizontalAlignment(SwingConstants.CENTER);
		eveGroup.setText("이벤트 분류");
		eveGroup.setColumns(10);
		eveGroup.setBackground(Color.LIGHT_GRAY);
		add(eveGroup);
		
		eveImage = new JTextField();
		eveImage.setBounds(55, 360, 141, 100);
		eveImage.setHorizontalAlignment(SwingConstants.CENTER);
		eveImage.setText("이벤트 이미지");
		eveImage.setColumns(10);
		eveImage.setBackground(Color.LIGHT_GRAY);
		add(eveImage);
		
		nameInput = new JTextField();
		nameInput.setEnabled(false);
		nameInput.setBounds(195, 199, 328, 42);
		nameInput.setText(e.getEventName());
		nameInput.setColumns(10);
		add(nameInput);
	
		perInput = new JTextField();
		perInput.setEnabled(false);
		perInput.setBounds(195, 240, 328, 42);
		perInput.setText(e.getEventTearm() + "");
		perInput.setColumns(10);
		add(perInput);
		
		//이벤트대상 콤보박스
		DaeBox = new JComboBox();
		DaeBox.setForeground(Color.BLACK);
		DaeBox.setBackground(new Color(255, 255, 255));
		DaeBox.addItem("모든 고객");
		DaeBox.addItem("5만원 이상 구매 고객");
		DaeBox.addItem("kh카드 회원");
		DaeBox.setBounds(195, 281, 328, 42);
		this.add(DaeBox);
		
		//이벤트분류 콤보박스
		
		GroBox = new JComboBox();
		GroBox.setForeground(Color.BLACK);
		GroBox.setBackground(new Color(255, 255, 255));

		if(e.isEventType()==false){
			GroBox.addItem("10%");
			GroBox.addItem("20%");
			GroBox.addItem("30%");
		}else{
			GroBox.addItem("1+1 행사");
			GroBox.addItem("2+1 행사");
			GroBox.addItem("할인 행사");
			
		}
		
		
		
		
		GroBox.setBounds(195, 320, 328, 42);
		this.add(GroBox);
		
		//수정버튼
		JButton reviseButton;
		reviseButton = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
		reviseButton.setBorderPainted(false); // 버튼 테두리 설정해제
		reviseButton.setBounds(66, 470, 100, 40); // 버튼 크기 지정
		add(reviseButton);
		
		
		//삭제버튼
		JButton deleteButton;
		deleteButton = new JButton(new ImageIcon("images/buttonsImages/DELETE_ICON.PNG"));
		deleteButton.setBorderPainted(false); // 버튼 테두리 설정해제
		deleteButton.setBounds(247, 470, 100, 40); // 버튼 크기 지정
		add(deleteButton);
		
		
		//취소버튼
		JButton backButton;
		backButton = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		backButton.setBorderPainted(false); // 버튼 테두리 설정해제
		backButton.setBounds(423, 470, 100, 40); // 버튼 크기 지정
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventModifyFrame(frame, mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		add(backButton);
	
		
		eveLabel = new JLabel("Event Image");
		eveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eveLabel.setIcon(new ImageIcon(e.getEventImagePath()));
		eveLabel.setBounds(195, 362, 328, 100);
		add(eveLabel);
		
		
		
		reviseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean etype;
				 
				/*String eventName, boolean eventType, String eventContent, Date eventTearm,
         Object eventTarget, String eventImagePath*/
				/*if(!GroBox.equals("증정 행사")){
					etype = false;
				}else{
					etype = true;
					
				}*/
				
//				ec.modifyEventGroup(new EventGroup(nameInput.getText(),etype,nameInput.getText(),perInput.getText()+"",DaeBox.getSelectedItem(),eveLabel.setText(eventName)));
				JOptionPane.showMessageDialog(null, "수정완료");
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventModifyFrame(frame, mainPanel));
				mainPanel.repaint();
			
				}
		});
	
			
		
		
		deleteButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ec.deleteEventGroup(e.getEventName());
				JOptionPane.showMessageDialog(null, "삭제완료");
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventModifyFrame(frame, mainPanel));
				mainPanel.repaint();
			}
		});
		
		
		this.setVisible(true);		
	}
}

