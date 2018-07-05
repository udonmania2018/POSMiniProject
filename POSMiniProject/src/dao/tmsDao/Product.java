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

import model.vo.ProductGroup;

public class Product {
	public void addProductGroup(ProductGroup pg) {
		// ������ �ִ���
		File checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}

		// ������ �����Ͱ� �ҷ�����
		ArrayList<ProductGroup> orignData = selectProductGroup();
		if (orignData == null) {
			// ���� �����Ͱ� ���� ���
			orignData = new ArrayList<ProductGroup>();
		} else {
			// ������ �����Ͱ� ���� ���
			orignData.add(pg);
		}
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

		// ������ �ִ��� Ȯ��
		File checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}

		// ���� �о����
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\productGroup.dat"))) {
			// �о�� ������ ������ ���� �ӽ� ProductGroup ��ü temp�� null�� �ʱ�ȭ
			ProductGroup temp = null;
			while (true) {
				// �о�� ������ ������ �ӽ� ����� ��ü�� temp�� ����
				temp = (ProductGroup) ois.readObject();
				// ����� temp��ü�� �÷��ǿ� �߰�
				list.add(temp);
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
	
	public String getProudctGroupCode() {
		
		int cnt = 1;
		
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:\\POSDB\\productGroup.dat"))){
			
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
