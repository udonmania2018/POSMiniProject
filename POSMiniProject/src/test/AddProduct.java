package test;

import java.util.Scanner;

public class AddProduct {
	public void addAction(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ǰ�� ����ȸ�� �����ڵ�(4�ڸ�), ��ǰ�ڵ�(5�ڸ�), �������ڸ� �Է����ּ��� ( �������� ) : ");
		String addInfor = sc.nextLine();
		
		// barcode�� �����ڵ� �츮���� 880
		// ����ȸ�� �����ڵ� ( �������� �߱� ���� ) ����� �ӽ÷� ���
		// ����ȸ���� ��ǰ �����ڵ� 5�ڸ�
		// ��ȿ�� �˻� 1�ڸ� ( ��ǰ�� Ȧ���ڸ��� �� + ¦���ڸ����� * 3�� 10�� ����� �ǰԲ� ����� �� )
		// �������� 5�ڸ� ������� ( 1 + 4�ڸ��� ��� ���� ��¥���� ������� ) ex 11706 06�� 17�ϱ���
		// 				   ( 2 + 4�ڸ��� ��� ���� ��¥ �ð����� )    ex 20817 17�� ���� 8�ñ��� �ǸŰ��� 
		
		// ��ȿ�� �˻�� ���� �����ϱ�
		String tempStr = addInfor.substring(0, 12); // �������ڸ� ������ ���� ��� 
		char[] numberInforCharArr = tempStr.toCharArray(); // �������ڸ� ������ ���ڸ� char�� ��ȯ
		
		int oddNumSum = 0 , evenNumSum = 0 ;	// Ȧ���� ¦���� ������ ����
		for (int i = 0; i < numberInforCharArr.length; i++) {
			if(i % 2== 0){
				// ¦�� �� ����
				evenNumSum += Integer.parseInt(String.valueOf(numberInforCharArr[i]));
			} else {
				// Ȧ�� �� ����
				oddNumSum += Integer.parseInt(String.valueOf(numberInforCharArr[i]));
			}
		}
		
		// ��ȿ�� �˻� �� ó��
		int effectivenessNum = 10 - (oddNumSum + (3*evenNumSum)) % 10;
		
		// �Է� ���� ���� ��ȿ�� �˻� ���ڿ� �߰�
		addInfor = tempStr + String.valueOf(effectivenessNum) + addInfor.substring(12);

		// ���ڵ� ����
		CreateBarcode cb = new CreateBarcode();
		cb.createBarcode(addInfor);
	}
}
