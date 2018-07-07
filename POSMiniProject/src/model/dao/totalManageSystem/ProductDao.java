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
		// ������ �ִ���
		checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}
	}

	public void addProductGroup(ProductGroup pg) {

		// ������ �����Ͱ� �ҷ�����
		ArrayList<ProductGroup> orignData = selectProductGroup();
		int codeNum = 1;
		if (orignData == null) {
			// ���� �����Ͱ� ���� ���
			orignData = new ArrayList<ProductGroup>();
		}
		orignData.add(pg);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			// ��ü ����
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
		// �о�� �����͸� ������ �÷��� ����
		ArrayList<ProductGroup> list = new ArrayList<ProductGroup>();

		// ���� �о����
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			while (true) {
				list.add((ProductGroup) ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("������ �ε� ����...");
		} catch (FileNotFoundException e) {
			// ������ ������ ó���� ��� ó��
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

	// ��ǰ�з� �ڵ� ���� ������ ��ȣ +1 �޾� ����
	public String getProudctGroupCode() {
		// ��ǰ�з� �ڵ�� 1���� �����ϱ� ������ �ʱⰪ 1
		int cnt = 1;
		// ��Ʈ�� ����
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
		// �о�� �����͸� ������ �÷��� ����
		ArrayList<ManufactureGroup> list = new ArrayList<ManufactureGroup>();

		// ���� �о����
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
			while (true) {
				list.add((ManufactureGroup) ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("������ �ε� ����...");
		} catch (FileNotFoundException e) {
			// ������ ������ ó���� ��� ó��
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
		// ������ �����Ͱ� �ҷ�����
		ArrayList<ManufactureGroup> orignData = selectManufactureGroup();
		if (orignData == null) {
			// ���� �����Ͱ� ���� ���
			orignData = new ArrayList<ManufactureGroup>();
		}
		orignData.add(mfg);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(checkdir.getPath() + "\\manufactureGroup.dat"))) {
			// ��ü ����
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
		// ��ǰ�з� �ڵ�� 1���� �����ϱ� ������ �ʱⰪ 1
		int cnt = 1;
		// ��Ʈ�� ����
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
		// �о�� �����͸� ������ �÷��� ����
		ArrayList<Product> list = new ArrayList<Product>();

		// ���� �о����
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\product.dat"))) {
			while (true) {
				list.add((Product)ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("������ �ε� ����...");
		} catch (FileNotFoundException e) {
			// ������ ������ ó���� ��� ó��
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
		// ������ �����Ͱ� �ҷ�����
		ArrayList<Product> orignData = selectProduct();
		if (orignData == null) {
			// ���� �����Ͱ� ���� ���
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
			// ��ü ����
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
		// �о�� �����͸� ������ �÷��� ����
		ArrayList<Product> list = new ArrayList<Product>();

		// ���� �о����
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
			System.out.println("������ �ε� ����...");
			return list;
		} catch (FileNotFoundException e) {
			// ������ ������ ó���� ��� ó��
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
