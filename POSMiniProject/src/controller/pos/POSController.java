package controller.pos;

import java.util.ArrayList;

import model.dao.pos.POSdao;
import model.vo.totalManageSystem.Product;

public class POSController {
	POSdao dao = new POSdao();
	
	// �⺻ ������
	public POSController(){}
	
	public ArrayList<Product> selectProductOnName(String searchName){
		// searchName�� �Ű������� ���� dao.selectProductOnName�� ��ȯ
		return dao.selectProductOnName(searchName);
	}

}
