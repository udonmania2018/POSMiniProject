package barcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.vo.pos.ProductStock;

public class AddProduct {
	public String addAction(ProductStock productStock){
		//System.out.print("��ǰ�� ����ȸ�� �����ڵ�(4�ڸ�), ��ǰ�ڵ�(5�ڸ�), �������ڸ� �Է����ּ��� ( �������� ) : ");
		//String addInfor = sc.nextLine();
		
		// barcode�� �����ڵ� �츮���� 880
		// ����ȸ�� �����ڵ� ( �������� �߱� ���� ) ����� �ӽ÷� ���
		// ����ȸ���� ��ǰ �����ڵ� 5�ڸ�
		// ��ȿ�� �˻� 1�ڸ� ( ��ǰ�� Ȧ���ڸ��� �� + ¦���ڸ����� * 3�� 10�� ����� �ǰԲ� ����� �� )
		// �������� 5�ڸ� ������� ( 1 + 4�ڸ��� ��� ���� ��¥���� ������� ) ex 11706 06�� 17�ϱ���
		// 				   ( 2 + 4�ڸ��� ��� ���� ��¥ �ð����� )    ex 20817 17�� ���� 8�ñ��� �ǸŰ��� 
		
		// ��ȿ�� �˻�� ���� �����ϱ�
		String tempStr = productStock.getBarcode(); // �������ڸ� ������ ���� ��� 
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
		
		
		String check = productStock.getSellByDate().substring(0,1);
		DateFormat df = null;
		Date date = new Date();
		String strDate = "";
	
		if(check.equals("1")){
			df = new SimpleDateFormat("yyMM");
		} else if (check.equals("2")){
			df = new SimpleDateFormat("MMdd");
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
	
		String first = productStock.getSellByDate().substring(1,3);
		String second = productStock.getSellByDate().substring(3);
		if(check.equals("1")){
			cal.add(Calendar.YEAR, Integer.parseInt(first));
			cal.add(Calendar.MONTH, Integer.parseInt(second));
			
		} else if (check.equals("2")){
			cal.add(Calendar.MONTH, Integer.parseInt(first));
			cal.add(Calendar.DATE, Integer.parseInt(second));
		}
		
		System.out.println(first+","+second+" // ");
		System.out.println(date);
		System.out.println(cal.getTime());
		
		String strDate2 = df.format(date.getTime());
		System.out.println(strDate2);

		// �Է� ���� ���� ��ȿ�� �˻� ���ڿ� �߰�
		tempStr += String.valueOf(effectivenessNum) + check+strDate2;

		// ���ڵ� ����
		CreateBarcode cb = new CreateBarcode();
		String path = cb.createBarcode(tempStr);
		return path;
	}
}
