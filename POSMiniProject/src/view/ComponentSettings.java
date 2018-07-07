package view;

import javax.swing.JButton;

public class ComponentSettings {
	public static void imageButtonSetting(JButton[] btns) {
		for (int i = 0; i < btns.length; i++) {
			btns[i].setBorderPainted(false); // 버튼 테두리 설정
			btns[i].setContentAreaFilled(false); // 버튼 영역 배경 설정
			btns[i].setFocusPainted(false); // 포커스 영역 설정
		}
	}
}
