package view.totalManageSystem.popUp.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.totalManageSystem.EventController;
import controller.totalManageSystem.ProductController;
import model.dao.totalManageSystem.Event;
import model.dao.totalManageSystem.ProductDao;
import model.vo.totalManageSystem.EventGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;
import view.totalManageSystem.management.ManagementSystem;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;

public class EventMain extends JPanel {
	private JTextField eventName;
	private JTextField eventTypetext;
	private Event eventdao = new Event();
	private JTextField txtImages;
	private JTextField caltxt;
	private Date date;
	private EventController ect = new EventController();
	private EventGroup e;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public EventMain(MainFrame frame, ControllPanel mainPanel) {
		setForeground(Color.BLACK);
		this.setBounds(0, 0, 580, 600);
		JPanel panel = new JPanel();
		add(panel);
		setBackground(SystemColor.text);
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("이벤트 추가");
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 20, 206, 82);
		add(lblNewLabel_1);

		JLabel lblNewLabel_6 = new JLabel("이벤트명");
		lblNewLabel_6.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(60, 110, 170, 40);
		add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("기간");
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(60, 170, 170, 40);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("이벤트대상");
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(60, 230, 170, 40);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("이벤트분류");
		lblNewLabel_4.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(60, 300, 170, 40);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("이벤트 이미지");
		lblNewLabel_5.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(70, 380, 170, 40);
		add(lblNewLabel_5);

		eventName = new JTextField();
		eventName.setHorizontalAlignment(SwingConstants.CENTER);
		eventName.setBounds(244, 110, 256, 40);
		add(eventName);
		eventName.setColumns(10);

		ProductController pc = new ProductController();
		ArrayList<Product> list = pc.selectProductOnName("");
		
		JComboBox eventProduct = new JComboBox();
		eventProduct.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		
		for (int i = 0; i < list.size(); i++) {
			eventProduct.addItem(list.get(i).getBarcode()+"/"+list.get(i).getProductName());
		}
		eventProduct.setToolTipText("");
		eventProduct.setBounds(244, 230, 256, 40);
		add(eventProduct);

		
		JLabel lblNewLabel_8 = new JLabel("+");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(421, 309, 19, 18);
		add(lblNewLabel_8);
		

		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(452, 305, 29, 27);
		add(lblNewLabel);
		
		JComboBox eventType = new JComboBox();
		eventType.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		eventType.setModel(new DefaultComboBoxModel(new String[] { "증정 행사", "할인 행사" }));
		eventType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getItem().equals("증정 행사")) {
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNewLabel_8.setVisible(true);
					eventTypetext.setVisible(false);
					lblNewLabel.setVisible(false);
					
				} else {
					textField.setVisible(false);
					textField_1.setVisible(false);
					lblNewLabel_8.setVisible(false);
					eventTypetext.setVisible(true);
					lblNewLabel.setVisible(true);
				}
			}
		});
		eventType.setBounds(244, 302, 100, 40);
		add(eventType);

		JPanel temp = this;
		eventTypetext = new JTextField("");
		eventTypetext.setBounds(358, 302, 90, 40);
		add(eventTypetext);
		eventTypetext.setColumns(10);

		JTextField eventComent = new JTextField();
		this.add(eventComent);

		JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(423, 40, 100, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.getMainPanel().removeAll();
				mainPanel.getMainPanel().add(new EventModifyFrame(frame, mainPanel));
				mainPanel.add(mainPanel.getMainPanel());
				mainPanel.repaint();
			}
		});
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(150, 470, 100, 40);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(new ImageIcon("images/buttonsImages/CANCEL_ICON.PNG"));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ManagementSystem.mainPopCheck = true;
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(350, 470, 100, 40);
		add(btnNewButton_2);

		/*
		 * JButton btnNewButton_3 = new JButton(new
		 * ImageIcon("images/totalManageSystem/Pop/buttonsImages/PLUS.png"));
		 * btnNewButton_3.setBounds(505, 342, 27, 27); add(btnNewButton_3);
		 * btnNewButton_3.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub if (MainFrame.popUpMainFrameCheck) { new
		 * GroupManage(new String("eventGroup"),true);
		 * MainFrame.popUpMainFrameCheck = false; } } });
		 * 
		 * JButton btnNewButton_4 = new JButton(new
		 * ImageIcon("images/totalManageSystem/Pop/buttonsImages/MINUS.png"));
		 * btnNewButton_4.setBounds(539, 342, 27, 27);
		 * btnNewButton_4.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub if (MainFrame.popUpMainFrameCheck) { new
		 * GroupManage(new String("eventGroup"),false);
		 * MainFrame.popUpMainFrameCheck = false; } } }); add(btnNewButton_4);
		 */

		JLabel lblNewLabel_7 = new JLabel("\uC785\uB825 \uD615\uC2DD xx (2\uC790\uB9AC \uC22B\uC790)");
		lblNewLabel_7.setForeground(Color.GRAY);
		lblNewLabel_7.setBounds(300, 350, 200, 18);
		add(lblNewLabel_7);

		

		txtImages = new JTextField();
		txtImages.setBounds(244, 383, 142, 38);
		add(txtImages);
		txtImages.setColumns(10);
		txtImages.setEditable(false);

		JButton calbtn = new JButton(new ImageIcon("images/buttonsImages/calimage.png"));
		calbtn.setBackground(Color.WHITE);
		calbtn.setBorderPainted(false);
		calbtn.setBounds(459, 170, 40, 40);
		add(calbtn);

		caltxt = new JTextField();
		caltxt.setText("");
		caltxt.setHorizontalAlignment(SwingConstants.CENTER);
		caltxt.setColumns(10);
		caltxt.setEditable(false);
		caltxt.setBounds(244, 170, 206, 40);
		add(caltxt);


		textField = new JTextField();
		textField.setBounds(440, 302, 60, 40);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(358, 302, 60, 40);
		add(textField_1);
		textField_1.setColumns(10);

		

		// File eventdir = new File("EventGroup.txt");

		
		JButton eventImagebtn = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		eventImagebtn.setBounds(400, 380, 100, 40);
		add(eventImagebtn);
		
		eventImagebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "PNG");
				jfc.setFileFilter(filter);
				// jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showDialog(eventImagebtn, null);
				File dir = jfc.getSelectedFile();

				txtImages.setText(dir != null ? dir.getPath() : "");

			}
		});

		calbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("Calendar");
				Container c = f.getContentPane();
				c.setLayout(new FlowLayout());

				// for this test driver, hardcode 1995/02/10.
				// c.add(new Cal(1995, 2 - 1, 10));

				// and beside it, the current month.
				CalendarDialog dal = new CalendarDialog();
				c.add(dal);

				f.pack();
				f.setVisible(true);
				// c.getWindowListeners();

			}
		});
		CalendarDialog cd = new CalendarDialog();
		date = new Date(cd.yy, cd.mm, cd.dd);

		ArrayList<EventGroup> elist = ect.selectEventGroup();

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(eventName.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "이벤트명을 입력해 주세요.");
					return;
				}

				if(eventType.getSelectedIndex() == 0){
					if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("") ||
							!textField.getText().matches("^[0-9]*$") || !textField_1.getText().matches("^[0-9]*$")){
						JOptionPane.showMessageDialog(null, "이벤트 분류의 내용을 확인해 주세요.");
						return;
					}
				} else {
					if(eventTypetext.getText().trim().equals("") || !eventTypetext.getText().matches("^[0-9]*$")){
						JOptionPane.showMessageDialog(null, "이벤트 분류의 내용을 확인해 주세요.");
						return;
					}
					
					if(Integer.parseInt(eventTypetext.getText().trim())>100 ){
						JOptionPane.showMessageDialog(null, "할인율이 100%를 넘습니다.");
						return;
					}
				}
				
				if(txtImages.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "이벤트 이미지를 선택해 주세요.");
					return;
				}
				
				EventGroup event = new EventGroup(eventName.getText(), (eventType.getSelectedIndex() == 0 ? true : false),
						(eventType.getSelectedIndex() == 0 ? textField.getText()+"+"+textField_1.getText() : eventTypetext.getText()+"%"),
						date, eventProduct.getSelectedItem(), txtImages.getText());
				
				ect.addEvent(event);

				eventType.setSelectedIndex(0);
				eventProduct.setSelectedIndex(0);
				eventName.setText("");
				eventTypetext.setText("");
				txtImages.setText("");
				textField.setText("");
				textField_1.setText("");
				JOptionPane.showMessageDialog(null, "이벤트가 추가 되었습니다.");

			}
		});
		
		textField.setVisible(true);
		textField_1.setVisible(true);
		lblNewLabel_8.setVisible(true);
		eventTypetext.setVisible(false);
		lblNewLabel.setVisible(false);
	}

	public class CalendarDialog extends JPanel {
		/** The currently-interesting year (not modulo 1900!) */
		protected int yy;

		/** Currently-interesting month and day */
		protected int mm, dd;

		/** The buttons to be displayed */
		protected JButton labs[][];

		/**
		 * The number of day squares to leave blank at the start of this month
		 */
		protected int leadGap = 0;

		/** A Calendar object used throughout */
		Calendar calendar = new GregorianCalendar();

		/** Today's year */
		protected final int thisYear = calendar.get(Calendar.YEAR);

		/** Today's month */
		protected final int thisMonth = calendar.get(Calendar.MONTH);

		/**
		 * One of the buttons. We just keep its reference for getBackground().
		 */
		private JButton b0;

		/** The month choice */
		private JComboBox monthChoice;

		/** The year choice */
		private JComboBox yearChoice;

		private String dateText = null;

		/**
		 * Construct a Cal, starting with today.
		 */
		public CalendarDialog() {
			super();
			setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
			buildGUI();
			recompute();
		}

		/**
		 * Construct a Cal, given the leading days and the total days
		 *
		 * @exception IllegalArgumentException
		 *                If year out of range
		 */
		public CalendarDialog(int year, int month, int today) {
			super();
			setYYMMDD(year, month, today);
			buildGUI();
			recompute();
		}

		private void setYYMMDD(int year, int month, int today) {
			yy = year;
			mm = month;
			dd = today;
		}

		String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		/** Build the GUI. Assumes that setYYMMDD has been called. */
		private void buildGUI() {
			getAccessibleContext().setAccessibleDescription("Calendar not accessible yet. Sorry!");
			setBorder(BorderFactory.createEtchedBorder());

			setLayout(new BorderLayout());

			JPanel tp = new JPanel();
			monthChoice = new JComboBox();
			for (int i = 0; i < months.length; i++)
				monthChoice.addItem(months[i]);
			monthChoice.setSelectedItem(months[mm]);
			monthChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					int i = monthChoice.getSelectedIndex();
					if (i >= 0) {
						mm = i;
						// System.out.println("Month=" + mm);
						recompute();
					}
				}
			});
			monthChoice.getAccessibleContext().setAccessibleName("Months");
			monthChoice.getAccessibleContext().setAccessibleDescription("Choose a month of the year");

			tp.add(yearChoice = new JComboBox());
			yearChoice.setEditable(true);
			for (int i = yy - 5; i < yy + 5; i++)
				yearChoice.addItem(Integer.toString(i));
			yearChoice.setSelectedItem(Integer.toString(yy));
			yearChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					int i = yearChoice.getSelectedIndex();
					if (i >= 0) {
						yy = Integer.parseInt(yearChoice.getSelectedItem().toString());
						// System.out.println("Year=" + yy);
						recompute();
					}
				}
			});

			tp.add(monthChoice);
			add(BorderLayout.CENTER, tp);

			JPanel bp = new JPanel();
			bp.setLayout(new GridLayout(7, 7));
			labs = new JButton[6][7]; // first row is days

			bp.add(b0 = new JButton("일"));
			bp.add(new JButton("월"));
			bp.add(new JButton("화"));
			bp.add(new JButton("수"));
			bp.add(new JButton("목"));
			bp.add(new JButton("금"));
			bp.add(new JButton("토"));

			ActionListener dateSetter = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String num = e.getActionCommand();
					if (!num.equals("")) {
						// set the current day highlighted
						setDayActive(Integer.parseInt(num));

						StringBuffer buffer = new StringBuffer();
						buffer.append(yy).append("-");

						String temp = "" + (mm + 1);
						if (temp.length() <= 1) {
							buffer.append("0").append(mm + 1);
						} else {
							buffer.append(mm + 1);
						}
						buffer.append("-");

						temp = "" + dd;
						if (temp.length() <= 1) {
							buffer.append("0").append(dd);
						} else {
							buffer.append(dd);
						}

						dateText = buffer.toString().trim();

						caltxt.setText(yy + "년 " + (mm + 1) + "월 " + dd + "일");
						setDate(yy, mm, dd);
						date = new Date(yy, mm, dd);

						// setYYMMDD(yy, mm, dd);

						// date = new Date(yy, mm, dd);
						// closeDispose();

						// When this becomes a Bean, you can
						// fire some kind of DateChanged event here.
						// Also, build a similar daySetter for day-of-week btns.
					}
				}

			};
			caltxt.setText(yy + "년 " + (mm + 1) + "월 " + dd + "일");

			// Construct all the buttons, and add them.
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 7; j++) {
					bp.add(labs[i][j] = new JButton(""));
					labs[i][j].addActionListener(dateSetter);
				}

			add(BorderLayout.SOUTH, bp);
		}

		int[] dom = { 31, 28, 31, 30, /* jan feb mar apr */ 31, 30, 31, 31,
				/* may jun jul aug */ 30, 31, 30, 31 /* sep oct nov dec */ };

		private void closeDispose() {

			Component compo = getParent();

			while (compo != null) {
				if (compo instanceof JDialog) {
					((JDialog) compo).dispose();
					break;
				} else {
					compo = compo.getParent().getParent().getParent();
				}
			}

		}

		/** Compute which days to put where, in the Cal panel */
		protected void recompute() {
			// System.out.println("Cal::recompute: " + yy + ":" + mm + ":" +
			// dd);
			if (mm < 0 || mm > 11)
				throw new IllegalArgumentException("Month " + mm + " bad, must be 0-11");
			clearDayActive();
			calendar = new GregorianCalendar(yy, mm, dd);

			// Compute how much to leave before the first.
			// getDay() returns 0 for Sunday, which is just right.
			leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;
			// System.out.println("leadGap = " + leadGap);

			int daysInMonth = dom[mm];
			if (isLeap(calendar.get(Calendar.YEAR)) && mm == 1)
				++daysInMonth;

			// 추가
			for (int k = 0; k < labs.length; k++) {
				for (int r = 0; r < labs[k].length; r++) {
					labs[k][r].setText("");
				}
			}

			// Blank out the labels before 1st day of month
			for (int i = 0; i < leadGap; i++) {
				labs[0][i].setText("");
			}

			// Fill in numbers for the day of month.
			for (int i = 1; i <= daysInMonth; i++) {
				JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
				b.setText(Integer.toString(i));
			}

			// 7 days/week * up to 6 rows
			for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++) {
				labs[(i) / 7][(i) % 7].setText("");
			}

			// Shade current day, only if current month
			if (thisYear == yy && mm == thisMonth)
				setDayActive(dd); // shade the box for today

			// Say we need to be drawn on the screen
			repaint();
		}

		/**
		 * isLeap() returns true if the given year is a Leap Year.
		 *
		 * "a year is a leap year if it is divisible by 4 but not by 100, except
		 * that years divisible by 400 *are* leap years." -- Kernighan &
		 * Ritchie, _The C Programming Language_, p 37.
		 */
		public boolean isLeap(int year) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
				return true;
			return false;
		}

		/** Set the year, month, and day */
		public void setDate(int yy, int mm, int dd) {
			// System.out.println("Cal::setDate");
			this.yy = yy;
			this.mm = mm; // starts at 0, like Date
			this.dd = dd;
			recompute();
		}

		/** Unset any previously highlighted day */
		private void clearDayActive() {
			JButton b;

			// First un-shade the previously-selected square, if any
			if (activeDay > 0) {
				b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
				b.setBackground(b0.getBackground());
				b.repaint();
				activeDay = -1;
			}
		}

		private int activeDay = -1;

		/** Set just the day, on the current month */
		public void setDayActive(int newDay) {

			clearDayActive();

			// Set the new one
			if (newDay <= 0)
				dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
			else
				dd = newDay;
			// Now shade the correct square
			Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
			square.setBackground(Color.red);
			square.repaint();
			activeDay = newDay;
		}

		public String getDateText() {

			return dateText;
		}

	}
}