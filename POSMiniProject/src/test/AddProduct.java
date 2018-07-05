package test;

import java.util.Scanner;

public class AddProduct {
	public void addAction(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제품의 제조회사 고유코드(4자리), 제품코드(5자리), 제조일자를 입력해주세요 ( 숫자형식 ) : ");
		String addInfor = sc.nextLine();
		
		// barcode는 나라코드 우리나라 880
		// 제조회사 고유코드 ( 국가에서 발급 받음 ) 저희는 임시로 사용
		// 제조회사의 제품 고유코드 5자리
		// 유효성 검사 1자리 ( 제품의 홀수자리의 합 + 짝수자리의합 * 3이 10의 배수가 되게끔 만드는 수 )
		// 제조일자 5자리 구성방법 ( 1 + 4자리일 경우 지정 날짜까지 유통기한 ) ex 11706 06월 17일까지
		// 				   ( 2 + 4자리일 경우 지정 날짜 시간까지 )    ex 20817 17일 오전 8시까지 판매가능 
		
		// 유효성 검사용 숫자 생성하기
		String tempStr = addInfor.substring(0, 12); // 제조일자를 제외한 숫자 출력 
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
		
		// 입력 받은 값에 유효성 검사 문자열 추가
		addInfor = tempStr + String.valueOf(effectivenessNum) + addInfor.substring(12);

		// 바코드 생성
		CreateBarcode cb = new CreateBarcode();
		cb.createBarcode(addInfor);
	}
}
