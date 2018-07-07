package model.vo.totalManageSystem;

import java.io.Serializable;

public class ProductGroup implements Serializable{
	
	private String productGroupCode ;
	private String productGroupName;
	
	public ProductGroup() { }
	
	public ProductGroup(String productGroupCode, String productGroupName) {
		super();
		this.productGroupCode = productGroupCode;
		this.productGroupName = productGroupName;
	}
	
	
	public String getProductGroupName() {
		return productGroupName;
	}
	
	public String getProductGroupCode() {
		return productGroupCode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
	}

	@Override
	public String toString() {
		return "ProductGroup [productGroupCode=" + productGroupCode + ", productGroupName=" + productGroupName + "]";
	}	
}
