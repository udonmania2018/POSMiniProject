package controller.pos;

import java.util.ArrayList;

import model.dao.pos.POSdao;
import model.vo.totalManageSystem.Product;

public class POSController {
	POSdao dao = new POSdao();
	
	// 기본 생성자
	public POSController(){}
	
	public ArrayList<Product> selectProductOnName(String searchName){
		// searchName을 매개변수로 넣은 dao.selectProductOnName을 반환
		return dao.selectProductOnName(searchName);
	}

}
