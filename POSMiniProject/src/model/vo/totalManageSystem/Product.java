package model.vo.totalManageSystem;

import java.io.Serializable;

public class Product implements Serializable{
	private String barcode;
	private String productGroupCode;
	private String manufacturerCode;
	private String productName;
	private int productPrice;
	private int orderPrice;
	private String sellByDate;
	
	public Product() {}
	

	public Product( String productGroupCode, String manufacturerCode,
			String productName, int productPrice, int orderPrice, String sellByDate) {

		this.productGroupCode = productGroupCode;
		this.manufacturerCode = manufacturerCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orderPrice = orderPrice;
		this.sellByDate = sellByDate;
	}

	public Product(String barcode, String productGroupCode, String manufacturerCode, String eventCode,
			String productName, int productPrice, int orderPrice, String sellByDate) {
		super();
		this.barcode = barcode;
		this.productGroupCode = productGroupCode;
		this.manufacturerCode = manufacturerCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orderPrice = orderPrice;
		this.sellByDate = sellByDate;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getProductGroupCode() {
		return productGroupCode;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}


	public String getProductName() {
		return productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public String getSellByDate() {
		return sellByDate;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void setSellByDate(String sellByDate) {
		this.sellByDate = sellByDate;
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", productGroupCode=" + productGroupCode + ", manufacturerCode="
				+ manufacturerCode +  ", productName=" + productName + ", productPrice="
				+ productPrice + ", orderPrice=" + orderPrice + ", sellByDate=" + sellByDate + "]";
	}
}
