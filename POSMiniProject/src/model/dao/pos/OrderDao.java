package model.dao.pos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.pos.ProductStock;
import model.vo.totalManageSystem.Product;

public class OrderDao {
	File checkdir;

	public OrderDao() {
		// 폴더가 있는지
		checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}
	}

	public ArrayList<Product> seletProductOnName(String text) {
		ArrayList<Product> list = new ArrayList<Product>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(checkdir.getPath() + "\\product.dat"))) {
			while (true) {
				list.add((Product) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println("데이터 로드 성공");
			return list;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ProductStock> seletProductStock() {
		ArrayList<ProductStock> list = new ArrayList<ProductStock>();
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\productStock.dat"))) {
			while (true) {
				list.add((ProductStock) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println("데이터 로드 성공");
			return list;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void orderProduct(ArrayList<ProductStock> orderList) {
		// TODO Auto-generated method stub
		// 기존의 데이터값 불러오기
		ArrayList<ProductStock> orignData = seletProductStock();
		if (orignData == null) {
			// 기존 데이터가 없을 경우
			orignData = new ArrayList<ProductStock>();
		}

		for (int j = 0; j < orderList.size(); j++) {
			boolean check = false;
			for (int i = 0; i < orignData.size(); i++) {
				if (orignData.get(i).getBarcode().equals(orderList.get(j).getBarcode())) {
					orignData.get(i).setQuantity(orignData.get(i).getQuantity() + orderList.get(j).getQuantity());
					check = true;
					break;
				}
			}
			if (!check) {
				orignData.add(orderList.get(j));
			}
		}

		for (int i = 0; i < orignData.size(); i++) {
			System.out.println(orignData.get(i));
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\productStock.dat"))) {
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
}