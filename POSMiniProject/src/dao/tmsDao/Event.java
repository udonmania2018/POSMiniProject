package dao.tmsDao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.EventGroup;

// 이벤트 테스트 클래스.
public class Event {
	public void addEventGroup(EventGroup eg) {
		// 폴더가 있는지
		File checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}

		// 기존의 데이터값 불러오기
		ArrayList<EventGroup> orignData = selectEventGroup();
		if (orignData == null) {
			// 기존 데이터가 없을 경우
			orignData = new ArrayList<EventGroup>();
		} else {
			// 기존의 데이터가 있을 경우
			orignData.add(eg);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\eventGroup.dat"))) {
			// 객체 저장
			for (int i = 0; i < orignData.size(); i++) {
				oos.writeObject(orignData.get(i));
			}
			oos.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<EventGroup> selectEventGroup() {
		// 읽어온 데이터를 저장할 컬렉션 선언
		ArrayList<EventGroup> list = new ArrayList<EventGroup>();

		// 폴더가 있는지 확인
		File checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}

		// 파일 읽어오기
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\eventGroup.dat"))) {
			// 읽어온 파일의 정보를 담을 임시 ProductGroup 객체 temp를 null로 초기화
			EventGroup temp = null;
			while (true) {
				// 읽어온 파일의 정보를 임시 저장소 객체인 temp에 저장
				temp = (EventGroup) ois.readObject();
				// 저장된 temp객체를 컬렉션에 추가
				list.add(temp);
			}

		} catch (EOFException e) {
			System.out.println("데이터 로드 성공...");
		} catch (FileNotFoundException e) {
			// 데이터 저장이 처음일 경우 처리
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public String getProudctGroupCode() {
		
		int cnt = 1;
		
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:\\POSDB\\eventGroup.dat"))){
			
			while(ois.read() != -1){
				cnt++;
			}
			
		} catch (FileNotFoundException e) {
			return "001";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String code = null;;
		if(cnt< 10){
			code = "00"+cnt;
		} else if ( cnt < 100){
			code = "0"+cnt;
		}
		
		return code;
	}
}
