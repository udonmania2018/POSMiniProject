package view;

import javax.swing.JButton;

public class ComponentSettings {
	public static void imageButtonSetting(JButton[] btns) {
		for (int i = 0; i < btns.length; i++) {
			btns[i].setBorderPainted(false); // ��ư �׵θ� ����
			btns[i].setContentAreaFilled(false); // ��ư ���� ��� ����
			btns[i].setFocusPainted(false); // ��Ŀ�� ���� ����
		}
	}
}
