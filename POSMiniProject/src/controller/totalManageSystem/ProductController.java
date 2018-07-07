package controller.totalManageSystem;

import java.util.ArrayList;

import model.dao.totalManageSystem.ProductDao;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;

public class ProductController {
	ProductDao dao = new ProductDao();
	
	public ArrayList<ProductGroup> selectProductGroup() {
		// TODO Auto-generated method stub
		return dao.selectProductGroup();
	}

	public ArrayList<ManufactureGroup> selectManufacturerGroup(){
		return dao.selectManufactureGroup();
	}
	
	public String getProudctGroupCode() {
		// TODO Auto-generated method stub
		return dao.getProudctGroupCode();
	}

	public void addProductGroup(ProductGroup pg) {
		// TODO Auto-generated method stub
		dao.addProductGroup(pg);
	}

	public void addManufacturer(ManufactureGroup mfg
			) {
		// TODO Auto-generated method stub
		dao.addManufacturer(mfg);
	}

	public String getManufacturerCode() {
		// TODO Auto-generated method stub
		return dao.getManufacturerCode();
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		dao.addProduct(product);
	}

	public void deleteProductGroup(ProductGroup pg) {
		// TODO Auto-generated method stub
		dao.deleteProductGroup(pg);
	}

	public void deleteManufacturer(ManufactureGroup mfg) {
		// TODO Auto-generated method stub
		dao.deleteManufactureGroup(mfg);
	}

	public void modifyProductGroup(ProductGroup pg) {
		// TODO Auto-generated method stub
		dao.modifyProductGroup(pg);
	}

	public void modifyManufacturer(ManufactureGroup mfg) {
		// TODO Auto-generated method stub
		dao.modifyManufacturer(mfg);
	}
	
	public ArrayList<Product> selectProductOnName(String serchName){
		return dao.selectProductOnName(serchName);
	}
	
}
