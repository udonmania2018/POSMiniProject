package view.totalManageSystem.popUp.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.totalManageSystem.EventController;
import controller.totalManageSystem.ProductController;
import model.vo.totalManageSystem.EventGroup;
import model.vo.totalManageSystem.Product;
import view.totalManageSystem.popUp.ControllPanel;
import view.totalManageSystem.popUp.MainFrame;

public class EventModifySub extends JPanel {

	// 제목 선언
	private JLabel title;
	private JButton addButton;
	private JTextField eveName;
	private JTextField evePeriod;
	private JTextField eveDaesang;
	private JTextField eveGroup;
	private JTextField eveImage;
	private JTextField nameInput;
	private JTextField caltxt;
	private Date date;

	private JComboBox DaeBox;
	private JComboBox GroBox;

	private JLabel eveLabel;

	private EventController ec = new EventController();
	private EventGroup e;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField_3;

	public EventModifySub(MainFrame frame, ControllPanel mainPanel, String eventName) {
		this.setBounds(0, 0, 580, 600);
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		e = ec.selectEventOnNames(eventName);

		// 제목(이벤트수정)
		title = new JLabel("이 벤 트 수 정");
		title.setBounds(200, 20, 206, 82);
		title.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(title);

		// 추가 버튼
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
		eveName.setBounds(55, 152, 141, 42);
		eveName.setHorizontalAlignment(SwingConstants.CENTER);
		eveName.setText("이벤트 명");
		eveName.setColumns(10);
		eveName.setBackground(Color.LIGHT_GRAY);
		add(eveName);

		evePeriod = new JTextField();
		evePeriod.setBounds(55, 193, 141, 42);
		evePeriod.setHorizontalAlignment(SwingConstants.CENTER);
		evePeriod.setText("기간");
		evePeriod.setColumns(10);
		evePeriod.setBackground(Color.LIGHT_GRAY);
		add(evePeriod);

		eveDaesang = new JTextField();
		eveDaesang.setBounds(55, 234, 141, 42);
		eveDaesang.setHorizontalAlignment(SwingConstants.CENTER);
		eveDaesang.setText("이벤트 대상");
		eveDaesang.setColumns(10);
		eveDaesang.setBackground(Color.LIGHT_GRAY);
		add(eveDaesang);

		eveGroup = new JTextField();
		eveGroup.setBounds(55, 273, 141, 42);
		eveGroup.setHorizontalAlignment(SwingConstants.CENTER);
		eveGroup.setText("이벤트 분류");
		eveGroup.setColumns(10);
		eveGroup.setBackground(Color.LIGHT_GRAY);
		add(eveGroup);

		eveImage = new JTextField();
		eveImage.setBounds(55, 313, 141, 100);
		eveImage.setHorizontalAlignment(SwingConstants.CENTER);
		eveImage.setText("이벤트 이미지");
		eveImage.setColumns(10);
		eveImage.setBackground(Color.LIGHT_GRAY);
		add(eveImage);

		nameInput = new JTextField();
		nameInput.setEnabled(false);
		nameInput.setBounds(195, 152, 328, 42);
		nameInput.setText(e.getEventName());
		nameInput.setColumns(10);
		add(nameInput);

		// 이벤트대상 콤보박스
		DaeBox = new JComboBox();
		DaeBox.setForeground(Color.BLACK);
		ProductController pc = new ProductController();
		ArrayList<Product> list = pc.selectProductOnName("");
		DaeBox.setBackground(new Color(255, 255, 255));
		for (int i = 0; i < list.size(); i++) {
			DaeBox.addItem(list.get(i).getBarcode() + "/" + list.get(i).getProductName());
			if (e.getEventTarget().equals(list.get(i).getProductName())) {
				DaeBox.setSelectedIndex(i);
			}
		}
		DaeBox.setBounds(195, 234, 328, 42);
		this.add(DaeBox);

		// 이벤트분류 콤보박스

		GroBox = new JComboBox();
		GroBox.setForeground(Color.BLACK);
		GroBox.setBackground(new Color(255, 255, 255));
		GroBox.addItem("증정행사");
		GroBox.addItem("할인행사");
		GroBox.setBounds(195, 273, 114, 42);
		this.add(GroBox);

		// 수정버튼
		JButton reviseButton;
		reviseButton = new JButton(new ImageIcon("images/buttonsImages/MODIFY_ICON.PNG"));
		reviseButton.setBorderPainted(false); // 버튼 테두리 설정해제
		reviseButton.setBounds(66, 470, 100, 40); // 버튼 크기 지정
		add(reviseButton);

		// 삭제버튼
		JButton deleteButton;
		deleteButton = new JButton(new ImageIcon("images/buttonsImages/DELETE_ICON.PNG"));
		deleteButton.setBorderPainted(false); // 버튼 테두리 설정해제
		deleteButton.setBounds(247, 470, 100, 40); // 버튼 크기 지정
		add(deleteButton);

		// 취소버튼
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

		ImageIcon loadImage = new ImageIcon(e.getEventImagePath());
		Image modifySize = loadImage.getImage();

		Image afterSize = modifySize.getScaledInstance(400, 40, Image.SCALE_SMOOTH);

		eveLabel = new JLabel(new ImageIcon(afterSize));
		eveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eveLabel.setIcon(new ImageIcon(e.getEventImagePath()));
		eveLabel.setBounds(195, 315, 328, 69);
		add(eveLabel);

		textField = new JTextField();
		textField.setBounds(317, 282, 60, 24);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(391, 282, 60, 24);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(317, 282, 60, 24);
		add(textField_2);

		label = new JLabel("+");
		label.setBounds(380, 285, 15, 18);
		add(label);

		label_1 = new JLabel("%");
		label_1.setBounds(380, 285, 15, 18);
		add(label_1);

		if (e.isEventType()) {
			GroBox.setSelectedIndex(0);
			textField.setVisible(true);
			int index = e.getEventContent().indexOf("+");
			String temp = e.getEventContent().substring(0, index);
			textField.setText(temp);
			textField_1.setVisible(true);
			temp = e.getEventContent().substring(index + 1);
			textField_1.setText(temp);
			textField_2.setVisible(false);
			label.setVisible(true);
			label_1.setVisible(false);
		} else {
			GroBox.setSelectedIndex(1);
			textField.setVisible(false);
			textField_1.setVisible(false);
			textField_2.setVisible(true);
			int index = e.getEventContent().lastIndexOf("%");
			String emp = e.getEventContent().substring(0, index);
			textField_2.setText(emp);
			label.setVisible(false);
			label_1.setVisible(true);
		}

		reviseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean etype;
				
				if(reviseButton.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "이벤트 기간을 선택해 주세요");
					return;
				}
				
				
				System.out.println(textField_3.getText());
				EventGroup eg = new EventGroup(nameInput.getText(), (GroBox.getSelectedIndex() == 0 ? true : false),
						(GroBox.getSelectedIndex() == 0 ? textField.getText() + "+" + textField_1.getText()
								: textField_2.getText() + "%"),
						date, DaeBox.getSelectedItem().toString(), textField_3.getText());

				ec.modifyEventGroup(eg);
				// EventGroup(nameInput.getText(),etype,nameInput.getText(),perInput.getText()+"",DaeBox.getSelectedItem(),eveLabel.setText(eventName)));
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

		caltxt = new JTextField();
		caltxt.setText("");
		caltxt.setHorizontalAlignment(SwingConstants.CENTER);
		caltxt.setColumns(10);
		caltxt.setEditable(false);
		caltxt.setBounds(195, 194, 256, 40);
		add(caltxt);

		JButton calbtn = new JButton(new ImageIcon("images/buttonsImages/calimage.png"));
		calbtn.setBackground(Color.WHITE);
		calbtn.setBorderPainted(false);
		calbtn.setBounds(465, 193, 40, 40);
		add(calbtn);

		JButton eventImagebtn = new JButton(new ImageIcon("images/buttonsImages/ADD_ICON.PNG"));
		eventImagebtn.setBounds(423, 383, 100, 30);
		add(eventImagebtn);

		textField_3 = new JTextField();
		textField_3.setBounds(195, 383, 230, 30);
		add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(e.getEventImagePath());
		textField_3.setEditable(false);

		eventImagebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "PNG");
				jfc.setFileFilter(filter);
				// jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showDialog(eventImagebtn, null);
				File dir = jfc.getSelectedFile();

				textField_3.setText(dir != null ? dir.getPath() : "");

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
		this.setVisible(true);
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
