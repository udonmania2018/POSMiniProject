package view.totalManageSystem.popUp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.ComponentSettings;
import view.totalManageSystem.popUp.event.EventMain;
import view.totalManageSystem.popUp.office.OfficeMain;
import view.totalManageSystem.popUp.product.ProductMain;

public class ControllPanel extends JPanel {

	private JButton[] categoryButton; // ���̵� �з� ��ư �迭
	private String category; // ���� ���� �з� ������ ����
	private ImageIcon[] officeImage; // office���� �̹��� �迭
	private ImageIcon[] eventImage; // event���� �̹��� �迭
	private ImageIcon[] productImage; // product���� �̹��� �迭
	private MainFrame frame;
	private JPanel mainPanel;

	public ControllPanel(String category, MainFrame frame) {
		// �г� �ʱ�ȭ
		this.setOpaque(false); // ��� ����
		this.setLayout(null);
		this.setBounds(0, 0, 600, 600);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(20, 0, 580, 600);
		
		// ���޹��� ī�װ��� �ʵ忡 �ʱ�ȭ
		this.category = category;
		this.frame = frame;
		
		categoryButton = new JButton[3];
		// ���̵� ��ư�� �� �̹��� �ʱ�ȭ
		ImageIcon[] officeImage = { new ImageIcon("images/totalManageSystem/Pop/SideMenus/bigOfficeLabel.png"),
				new ImageIcon("images/totalManageSystem/Pop/SideMenus/officeLabelOnMouse.png"),
				new ImageIcon("images/totalManageSystem/Pop/SideMenus/smallOfficeLabel.png") };
		ImageIcon[] eventImage = { new ImageIcon("images/totalManageSystem/Pop/SideMenus/bigEventLabel.png"),
				new ImageIcon("images/totalManageSystem/Pop/SideMenus/eventLabelOnMouse.png"),
				new ImageIcon("images/totalManageSystem/Pop/SideMenus/smallEventLabel.png") };
		ImageIcon[] productImage = { new ImageIcon("images/totalManageSystem/Pop/SideMenus/bigProductLabel.png"),
				new ImageIcon("images/totalManageSystem/Pop/SideMenus/productLabelOnMouse.png"),
				new ImageIcon("images/totalManageSystem/Pop/SideMenus/smallProductLabel.png") };

		// ������ �̹��������� �迭�� �ʵ�� �ʱ�ȭ
		this.officeImage = officeImage;
		this.eventImage = eventImage;
		this.productImage = productImage;

		// ���̵� �޴� ���п� ���� �ʱ�ȭ
		switch (this.category) {
		case "product":
			categoryButton[0] = new JButton(productImage[0]);
			categoryButton[1] = new JButton(officeImage[2]);
			categoryButton[2] = new JButton(eventImage[2]);
			break;
		case "event":
			categoryButton[0] = new JButton(eventImage[0]);
			categoryButton[1] = new JButton(productImage[2]);
			categoryButton[2] = new JButton(officeImage[2]);
			break;
		case "office":
			categoryButton[0] = new JButton(officeImage[0]);
			categoryButton[1] = new JButton(eventImage[2]);
			categoryButton[2] = new JButton(productImage[2]);
			break;
		}

		// �� ��ư�� ��ġ ���
		categoryButton[0].setBounds(-10, 30, 200, 50);
		categoryButton[1].setBounds(-10, 80, 100, 30);
		categoryButton[2].setBounds(-10, 110, 100, 30);

		// ����� ���� ������ ���
		categoryButton[0].addMouseListener(new MyMouserListener());
		categoryButton[1].addMouseListener(new MyMouserListener());
		categoryButton[2].addMouseListener(new MyMouserListener());

		// ��ư�� �׵θ� ����
		ComponentSettings.imageButtonSetting(categoryButton);

		// �гο� ��ư �߰�
		this.add(categoryButton[0]);
		this.add(categoryButton[1]);
		this.add(categoryButton[2]);

		// ������ �з����� ����Ʈ �г� ȣ��
		if (category.equals("product")) {
			mainPanel.add(new ProductMain(frame,this));
		} else if (category.equals("event")) {
			mainPanel.add( new EventMain(frame, this));
		} else {
			mainPanel.add( new OfficeMain());
		}

		mainPanel.setVisible(true);
		this.add(mainPanel);
		this.setVisible(true);
	}

	

	public class MyMouserListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(!e.getSource().equals(categoryButton[0])){
				removeAll();
				if (e.getSource().equals(categoryButton[1])) {
					if (category.equals("product")) {
						frame.add(new ControllPanel("office", frame));
					} else if (category.equals("event")) {
						frame.add(new ControllPanel("product", frame));
					} else {
						frame.add(new ControllPanel("event", frame));
					}

				} else if (e.getSource().equals(categoryButton[2])){
					if (category.equals("product")) {
						frame.add(new ControllPanel("event", frame));
					} else if (category.equals("event")) {
						frame.add(new ControllPanel("office", frame));
					} else {
						frame.add(new ControllPanel("product", frame));
					}
				}
				repaint();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(categoryButton[0])) {
				if (category.equals("product")) {
					categoryButton[0].setIcon(productImage[1]);
				} else if (category.equals("event")) {
					categoryButton[0].setIcon(eventImage[1]);
				} else {
					categoryButton[0].setIcon(officeImage[1]);
				}

			} else if (e.getSource().equals(categoryButton[1])) {
				if (category.equals("product")) {
					categoryButton[0].setIcon(productImage[2]);
					categoryButton[1].setIcon(officeImage[1]);
				} else if (category.equals("event")) {
					categoryButton[0].setIcon(eventImage[2]);
					categoryButton[1].setIcon(productImage[1]);
				} else {
					categoryButton[0].setIcon(officeImage[2]);
					categoryButton[1].setIcon(eventImage[1]);
				}

				categoryButton[0].setBounds(-10, 30, 100, 30);
				categoryButton[1].setBounds(-10, 60, 200, 50);
				categoryButton[2].setBounds(-10, 110, 100, 30);

			} else {
				if (category.equals("product")) {
					categoryButton[0].setIcon(productImage[2]);
					categoryButton[2].setIcon(eventImage[1]);
				} else if (category.equals("event")) {
					categoryButton[0].setIcon(eventImage[2]);
					categoryButton[2].setIcon(officeImage[1]);
				} else {
					categoryButton[0].setIcon(officeImage[2]);
					categoryButton[2].setIcon(productImage[1]);
				}
				categoryButton[0].setBounds(-10, 30, 100, 30);
				categoryButton[1].setBounds(-10, 60, 100, 30);
				categoryButton[2].setBounds(-10, 90, 200, 50);
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(categoryButton[0])) {
				if (category.equals("product")) {
					categoryButton[0].setIcon(productImage[0]);
				} else if (category.equals("event")) {
					categoryButton[0].setIcon(eventImage[0]);
				} else {
					categoryButton[0].setIcon(officeImage[0]);
				}
			} else if (e.getSource().equals(categoryButton[1])) {
				if (category.equals("product")) {
					categoryButton[0].setIcon(productImage[0]);
					categoryButton[1].setIcon(officeImage[2]);
				} else if (category.equals("event")) {
					categoryButton[0].setIcon(eventImage[0]);
					categoryButton[1].setIcon(productImage[2]);
				} else {
					categoryButton[0].setIcon(officeImage[0]);
					categoryButton[1].setIcon(eventImage[2]);
				}
				categoryButton[0].setBounds(-10, 30, 200, 50);
				categoryButton[1].setBounds(-10, 80, 100, 30);
				categoryButton[2].setBounds(-10, 110, 100, 30);
			} else {
				if (category.equals("product")) {
					categoryButton[0].setIcon(productImage[0]);
					categoryButton[2].setIcon(eventImage[2]);
				} else if (category.equals("event")) {
					categoryButton[0].setIcon(eventImage[0]);
					categoryButton[2].setIcon(officeImage[2]);
				} else {
					categoryButton[0].setIcon(officeImage[0]);
					categoryButton[2].setIcon(productImage[2]);
				}
				categoryButton[0].setBounds(-10, 30, 200, 50);
				categoryButton[1].setBounds(-10, 80, 100, 30);
				categoryButton[2].setBounds(-10, 110, 100, 30);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}



	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

}
