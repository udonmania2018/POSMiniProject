package model.dao.totalManageSystem;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.totalManageSystem.EventGroup;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;


public class Event {
	File checkdir;
	
	public Event(){
		// 폴더가 있는지
		checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}
		
	}
	public void addEventGroup(EventGroup eg) {


		ArrayList<EventGroup> orignData = selectEventGroup();
		
		if (orignData == null) {

			orignData = new ArrayList<EventGroup>();
		} else {

			orignData.add(eg);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\eventGroup.dat"))) {

			for (int i = 0; i < orignData.size(); i++) {
				oos.writeObject(orignData.get(i));
			}
			oos.flush();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<EventGroup> selectEventGroup() {

		ArrayList<EventGroup> list = new ArrayList<EventGroup>();



		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\eventGroup.dat"))) {


			while (true) {
				list.add((EventGroup) ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("데이터 로드 성공...");
		} catch (FileNotFoundException e) {

			return null;
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return list;
	}
	
	
	public void deleteEventGroup(String eg){


		ArrayList<EventGroup> list = selectEventGroup();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEventName().equals(eg)) {
				list.remove(i);
				for (int j = i; j < list.size(); j++) {
					int temp = Integer.parseInt(list.get(j).getEventName());
					temp--;
					String saveCode = "";
					if (temp < 10) {
						saveCode = "0" + temp;
					} else {
						saveCode = temp + "";
					}
					list.get(j).setEventName(saveCode);
					}
				break;
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\eventGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	
	}
	
	public void modifyEvent(EventGroup eg) {

		ArrayList<EventGroup> list = selectEventGroup();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getEventName());

		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\eventGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			oos.flush();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public ArrayList<EventGroup> selectEventOnName(String searchName) {

		ArrayList<EventGroup> list = new ArrayList<EventGroup>();


		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(checkdir.getPath() + "\\eventGroup.dat"))) {
			while (true) {
				list.add((EventGroup) ois.readObject());
			}
		} catch (EOFException e) {
			if (searchName == null || searchName.trim().equals("")) {

			} else {
				for (int i = 0; i < list.size();) {
		               if (!(list.get(i).getEventName().contains(searchName))) {
		                  list.remove(i);
		               } else {
		                  i++;
		               }
		            }

			}
			System.out.println("데이터 로드 성공...");
			return list;
		} catch (FileNotFoundException e) {

			return null;
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return list;
	}
	public void modifyEventGroup(EventGroup eg) {
		ArrayList<EventGroup> list = selectEventGroup();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEventName().equals(eg.getEventName())) {
				list.get(i).setEventName(eg.getEventName());
				break;
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\eventGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	public EventGroup selectEventOnNames(String searchName) {
		ArrayList<EventGroup> list = selectEventGroup();
		System.out.println(searchName);
		for (int i = 0; i < list.size(); i++) {
			// list.get(i)를 하면 i번째에 있는 객체를 리턴
			System.out.println(list.get(i).getEventName());
			if (list.get(i).getEventName().equals(searchName)) {
				System.out.println(list.get(i));
				// 해당하는 Product 타입의 객체를 반환
				return list.get(i);
			}
		}

		// 일치하는 것이 없으면 null을 반환. 그러나 입력값은 무조건 데이터에 있는 것이기 때문에 실제로는 실행되지 않음
		return null;
	}
	
}