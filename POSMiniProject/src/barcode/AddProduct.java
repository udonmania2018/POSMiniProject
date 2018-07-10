package barcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.vo.pos.ProductStock;

public class AddProduct {
	public String addAction(ProductStock productStock){
		//System.out.print("제품의 제조회사 고유코드(4자리), 제품코드(5자리), 제조일자를 입력해주세요 ( 숫자형식 ) : ");
		//String addInfor = sc.nextLine();
		
		// barcode는 나라코드 우리나라 880
		// 제조회사 고유코드 ( 국가에서 발급 받음 ) 저희는 임시로 사용
		// 제조회사의 제품 고유코드 5자리
		// 유효성 검사 1자리 ( 제품의 홀수자리의 합 + 짝수자리의합 * 3이 10의 배수가 되게끔 만드는 수 )
		// 제조일자 5자리 구성방법 ( 1 + 4자리일 경우 지정 날짜까지 유통기한 ) ex 11706 06월 17일까지
		// 				   ( 2 + 4자리일 경우 지정 날짜 시간까지 )    ex 20817 17일 오전 8시까지 판매가능 
		
		// 유효성 검사용 숫자 생성하기
		String tempStr = productStock.getBarcode(); // 제조일자를 제외한 숫자 출력 
		char[] numberInforCharArr = tempStr.toCharArray(); // 제조일자를 제외한 숫자를 char로 변환
		
		int oddNumSum = 0 , evenNumSum = 0 ;	// 홀수와 짝수를 저장할 변수
		for (int i = 0; i < numberInforCharArr.length; i++) {
			if(i % 2== 0){
				// 짝수 값 저장
				evenNumSum += Integer.parseInt(String.valueOf(numberInforCharArr[i]));
			} else {
				// 홀수 값 저장
				oddNumSum += Integer.parseInt(String.valueOf(numberInforCharArr[i]));
			}
		}
		// 유효성 검사 값 처리
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

		// 입력 받은 값에 유효성 검사 문자열 추가
		tempStr += String.valueOf(effectivenessNum) + check+strDate2;

		// 바코드 생성
		CreateBarcode cb = new CreateBarcode();
		String path = cb.createBarcode(tempStr);
		return path;
	}
}
