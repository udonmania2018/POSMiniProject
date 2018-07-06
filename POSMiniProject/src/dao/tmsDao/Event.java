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
import model.vo.ProductGroup;

public class Event {
	public void addEventGroup(EventGroup eg) {
		File eventdir = new File("C:\\POSDB");

		if (!eventdir.exists()) {
			eventdir.mkdirs();
		}

		ArrayList<EventGroup> eventorignData = selectEventGroup();

		if (eventorignData == null) {

			eventorignData = new ArrayList<EventGroup>();

		} else {

			eventorignData.add(eg);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(eventdir.getPath() + "\\EventGroup.dat"))) {

			for (int i = 0; i < eventorignData.size(); i++) {
				oos.writeObject(eventorignData.get(i));
			}
			oos.flush();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<EventGroup> selectEventGroup() {
		ArrayList<EventGroup> list = new ArrayList<EventGroup>();
		File eventdir = new File("C:\\POSDB");
		if (!eventdir.exists()) {
			eventdir.mkdirs();
		}

		// 파일 읽어오기
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(eventdir.getPath() + "\\EventGroup.dat"))) {

			EventGroup temp = null;
			while (true) {

				temp = (EventGroup) ois.readObject();

				list.add(temp);
			}

		} catch (EOFException e) {
			System.out.println("데이터 로드 성공");
		} catch (FileNotFoundException e) {

			return null;
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return list;
	}
	public String getEventGroupCode() {

		int cnt = 1;

		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:\\POSDB\\EventGroup.dat"))){

			while(ois.read() != -1){
				cnt++;
			}

		} catch (FileNotFoundException e) {
			return "001";
		} catch (IOException e) {

			e.printStackTrace();
		}

		String code = null;
		if(cnt< 10){
			code = "00"+cnt;
		} else if ( cnt < 100){
			code = "0"+cnt;
		}

		return code;
	}
}
