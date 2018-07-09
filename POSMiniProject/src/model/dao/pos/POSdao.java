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

	// �⺻ ������
	public POSdao() {
		// c:�� POSDB ������ �ִ��� Ȯ��
		checkdir = new File("C:\\POSDB");
		if (!checkdir.exists()) {
			checkdir.mkdirs();
		}
	}

	public ArrayList<Product> selectProductOnName(String searchName) {
		ArrayList<Product> list = new ArrayList();
		// �����͸� ������ ���� InputStream
		// try-with-resources ���
		// ObjectInputStream �������� �Ű������� InputStream type�� �䱸�Ѵ�
		// InputStream�� abstract�̱� ������ ��ü�δ� ��ü���� �Ұ�. ��ӹ޾� �������� Ŭ������ ���
		// ���� ������� ���� FileInputStream�� ���
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(checkdir.getPath() + "\\product.dat"));) {
			// �ش� Stream���� File�� read
			while (true) {
				// Product type���� ��ȯ �������� Product�� �������� ������ Class~ exception �߻�
				list.add((Product)ois.readObject());
			}
		} catch (EOFException e) {
			// ���� �дٰ� ���� ������(EOF), EOFException���� while() Ż��
			System.out.println("������ �ε� ����...");
			// ���� list�� ��ȯ���ְ� ��. t-w-r �̱� ������ finally �ʿ� ����
			
			if((searchName == null && searchName.trim().equals("")) || searchName.equals("��ǰ�� �Է�")){
				// ���� searchName�� �ƹ��͵� �ȵ����ų� �⺻ ���¶�� ��ü ����Ʈ ����
				return list;
			}
			
			for(int i = 0; i < list.size();){
				// equals: ������ ��ġ, contains: �� ���ڸ� ���� ��ġ
				// searchName�� ProductName�� ���Ե��� ���� ��ü �Ÿ���
				if(!(list.get(i).getProductName().contains(searchName))){
					list.remove(i);
				}else{
					// list���� remove�� �ϸ� .size()�� �ڵ� �����Ǳ� ������
					// for�� ���ǿ� ���� i++�� ������ ����ϴ�. 
					// �׷��� ������ ProductName�� searchName�� contains�ϴ� ��쿡�� ī��Ʈ ����.
					i++;
				}	
			}
			return list;
		} catch (FileNotFoundException e) {
			// �ش� ������ ���� ����� ����ó��
			System.out.println("������ ����");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// �����δ� ����� ���� ����
		return null;
	}
	
	

}
