package model.vo.pos;

import java.io.Serializable;

public class ProductStock implements Serializable {
	
	private String barcode;
	private int quantity;
	private String barcodePath;
	private String sellByDate ;
	
	public ProductStock() { }

	public ProductStock(String barcode, int quantity, String barcodePath) {
		super();
		this.barcode = barcode;
		this.quantity = quantity;
		this.barcodePath = barcodePath;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getBarcodePath() {
		return barcodePath;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setBarcodePath(String barcodePath) {
		this.barcodePath = barcodePath;
	}

	@Override
	public String toString() {
		return "ProductStock [barcode=" + barcode + ", quantity=" + quantity + ", barcodePath=" + barcodePath + "]";
	}

	public String getSellByDate() {
		return sellByDate;
	}

	public void setSellByDate(String sellByDate) {
		this.sellByDate = sellByDate;
	}


	
	
}
