package model.dao.pos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.dao.totalManageSystem.ProductDao;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;

public class POSdao {
	private ProductDao pd = new ProductDao();
	File checkdir;

	// 기본 생성자
	public POSdao() {
		// c:에 POSDB 폴더가 있는지 확인
		checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}
	}

	public ArrayList<Product> selectProductOnName(String searchName) {
		ArrayList<Product> list = new ArrayList();
		// 데이터를 가져올 때는 InputStream
		// try-with-resources 방식
		// ObjectInputStream 생성자의 매개변수로 InputStream type을 요구한다
		// InputStream은 abstract이기 때문에 자체로는 객체생성 불가. 상속받아 구현받은 클래스를 사용
		// 파일 입출력을 위해 FileInputStream을 사용
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\product.dat"));) {
			// 해당 Stream에서 File을 read
			while (true) {
				// Product type으로 변환 과정에서 Product가 존재하지 않으면 Class~ exception 발생
				list.add((Product)ois.readObject());
			}
		} catch (EOFException e) {
			// 파일 읽다가 끝을 만나면(EOF), EOFException으로 while() 탈출
			System.out.println("데이터 로드 성공...");
			// 뽑은 list를 반환해주고 끝. t-w-r 이기 때문에 finally 필요 없음
			
			if((searchName == null && searchName.trim().equals("")) || searchName.equals("상품명 입력")){
				// 만약 searchName에 아무것도 안들어오거나 기본 상태라면 전체 리스트 리턴
				return list;
			}
			
			for(int i = 0; i < list.size();){
				// equals: 완전히 일치, contains: 그 문자를 포함 일치
				// searchName이 ProductName에 포함되지 않은 객체 거르기
				if(!(list.get(i).getProductName().contains(searchName))){
					list.remove(i);
				}else{
					// list에서 remove를 하면 .size()가 자동 조정되기 때문에
					// for문 조건에 직접 i++를 넣으면 곤란하다. 
					// 그렇기 때문에 ProductName와 searchName을 contains하는 경우에만 카운트 증가.
					i++;
				}	
			}
			return list;
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을 경우의 예외처리
			System.out.println("파일이 없다");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 실제로는 여기로 오지 않음
		return null;
	}
	
	

}
