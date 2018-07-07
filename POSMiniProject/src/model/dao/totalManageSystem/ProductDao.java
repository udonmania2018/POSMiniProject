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

import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;

public class ProductDao {
	File checkdir;

	public ProductDao() {
		// 폴더가 있는지
		checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}
	}

	public void addProductGroup(ProductGroup pg) {

		// 기존의 데이터값 불러오기
		ArrayList<ProductGroup> orignData = selectProductGroup();
		int codeNum = 1;
		if (orignData == null) {
			// 기존 데이터가 없을 경우
			orignData = new ArrayList<ProductGroup>();
		}
		orignData.add(pg);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\productGroup.dat"))) {
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

	public ArrayList<ProductGroup> selectProductGroup() {
		// 읽어온 데이터를 저장할 컬렉션 선언
		ArrayList<ProductGroup> list = new ArrayList<ProductGroup>();

		// 파일 읽어오기
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			while (true) {
				list.add((ProductGroup) ois.readObject());
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

	// 제품분류 코드 값의 마지막 번호 +1 받아 오기
	public String getProudctGroupCode() {
		// 제품분류 코드는 1부터 시작하기 때문에 초기값 1
		int cnt = 1;
		// 스트림 연결
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			Object temp = null;
			while (true) {
				temp = ois.readObject();
				cnt++;
			}

		} catch (EOFException e) {
			String code = "";
			if (cnt < 10) {
				code = "0" + cnt;
			} else {
				code = cnt + "";
			}
			return code;
		} catch (FileNotFoundException e) {
			return "01";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ManufactureGroup> selectManufactureGroup() {
		// 읽어온 데이터를 저장할 컬렉션 선언
		ArrayList<ManufactureGroup> list = new ArrayList<ManufactureGroup>();

		// 파일 읽어오기
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
			while (true) {
				list.add((ManufactureGroup) ois.readObject());
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

	public void addManufacturer(ManufactureGroup mfg) {
		// 기존의 데이터값 불러오기
		ArrayList<ManufactureGroup> orignData = selectManufactureGroup();
		if (orignData == null) {
			// 기존 데이터가 없을 경우
			orignData = new ArrayList<ManufactureGroup>();
		}
		orignData.add(mfg);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
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

	public String getManufacturerCode() {
		// 제품분류 코드는 1부터 시작하기 때문에 초기값 1
		int cnt = 1;
		// 스트림 연결
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
			Object temp = null;
			while (true) {
				temp = ois.readObject();
				cnt++;
			}

		} catch (EOFException e) {
			String code = "";
			if (cnt < 10) {
				code = "000" + cnt;
			} else if (cnt < 100) {
				code = "00" + cnt;
			} else if (cnt < 1000) {
				code = "0" + cnt;
			} else {
				code = cnt + "";
			}
			return code;
		} catch (FileNotFoundException e) {
			return "0001";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Product> selectProduct() {
		// 읽어온 데이터를 저장할 컬렉션 선언
		ArrayList<Product> list = new ArrayList<Product>();

		// 파일 읽어오기
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\product.dat"))) {
			while (true) {
				list.add((Product)ois.readObject());
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

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		// 기존의 데이터값 불러오기
		ArrayList<Product> orignData = selectProduct();
		if (orignData == null) {
			// 기존 데이터가 없을 경우
			orignData = new ArrayList<Product>();
		}

		int productCnt = 1;

		for (int i = 0; i < orignData.size(); i++) {
			if (product.equals(orignData.get(i).getProductGroupCode())) {
				productCnt++;
			}
		}
		String saveProCnt = "";
		if (productCnt < 10) {
			saveProCnt = "00" + productCnt;
		} else if (productCnt < 100) {
			saveProCnt = "0" + productCnt;
		} else {
			saveProCnt = productCnt + "";
		}

		String manufacturerCode = product.getManufacturerCode();
		String productCode = "880" + product.getManufacturerCode() + product.getProductGroupCode() + saveProCnt;
		product.setBarcode(productCode);
		orignData.add(product);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\product.dat"))) {
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

	public void deleteProductGroup(ProductGroup pg) {
		// TODO Auto-generated method stub
		ArrayList<ProductGroup> list = selectProductGroup();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProductGroupCode().equals(pg.getProductGroupCode())) {
				list.remove(i);
				for (int j = i; j < list.size(); j++) {
					int temp = Integer.parseInt(list.get(j).getProductGroupCode());
					temp--;
					String saveCode = "";
					if (temp < 10) {
						saveCode = "0" + temp;
					} else {
						saveCode = temp + "";
					}
					list.get(j).setProductGroupCode(saveCode);
				}
				break;
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteManufactureGroup(ManufactureGroup mfg) {
		// TODO Auto-generated method stub
		ArrayList<ManufactureGroup> list = selectManufactureGroup();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getManufactureGroupCode().equals(mfg.getManufactureGroupCode())) {
				list.remove(i);
				for (int j = i; j < list.size(); j++) {
					int temp = Integer.parseInt(list.get(j).getManufactureGroupCode());
					temp--;
					String saveCode = "";
					if (temp < 10) {
						saveCode = "000" + temp;
					} else if (temp < 100) {
						saveCode = "00" + temp;
					} else if (temp < 1000) {
						saveCode = "0" + temp;
					} else {
						saveCode = temp + "";
					}
					list.get(j).setManufactureGroupCode(saveCode);
				}
				break;
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modifyProductGroup(ProductGroup pg) {
		// TODO Auto-generated method stub
		ArrayList<ProductGroup> list = selectProductGroup();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProductGroupCode().equals(pg.getProductGroupCode())) {
				list.get(i).setProductGroupName(pg.getProductGroupName());
				break;
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifyManufacturer(ManufactureGroup mfg) {
		// TODO Auto-generated method stub
		ArrayList<ManufactureGroup> list = selectManufactureGroup();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getManufactureGroupCode());
			if (list.get(i).getManufactureGroupCode().equals(mfg.getManufactureGroupCode())) {
				list.get(i).setManufactureGroupName(mfg.getManufactureGroupName());
				break;
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Product> selectProductOnName(String serchName) {
		// 읽어온 데이터를 저장할 컬렉션 선언
		ArrayList<Product> list = new ArrayList<Product>();

		// 파일 읽어오기
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(checkdir.getPath() + "\\product.dat"))) {
			while (true) {
				list.add((Product) ois.readObject());
			}
		} catch (EOFException e) {
			if (serchName == null || serchName.trim().equals("")) {

			} else {
				for (int i = 0; i < list.size();) {
					if (!(list.get(i).getProductName().contains(serchName))) {
						list.remove(i);
					} else {
						i++;
					}
				}
			}
			System.out.println("데이터 로드 성공...");
			return list;
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
}
