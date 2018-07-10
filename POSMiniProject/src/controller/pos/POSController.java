package controller.pos;

import java.util.ArrayList;

import barcode.AddProduct;
import model.dao.pos.MoneyDao;
import model.dao.pos.OrderDao;
import model.vo.pos.Moneys;
import model.vo.pos.ProductStock;
import model.vo.totalManageSystem.Product;

public class POSController {
	private OrderDao od = new OrderDao();
	private MoneyDao md = new MoneyDao();
	
	public ArrayList<Product> selectProductOnName(String text) {
		return od.seletProductOnName(text);
	}

	public void saveMoney(Moneys moneys) {
		// TODO Auto-generated method stub
		md.saveMoneys(moneys);
	}

	public void orderProduct(ArrayList<ProductStock> orderList) {
		// TODO Auto-generated method stub
		AddProduct ap = new AddProduct();
		for (int i = 0; i < orderList.size(); i++) {
			String path = ap.addAction(orderList.get(i));
			orderList.get(i).setBarcodePath(path);
		}
		//md.orderProduct(orderList);
	}
}