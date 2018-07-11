package model.vo.totalManageSystem;

import java.io.Serializable;
import java.util.Date;

public class OrderList implements Serializable {
	private String branchOfficeName;
	private String barcode;
	private int quantity;
	private Date orderDate;

	public OrderList() {
	}

	public OrderList(String branchOfficeName, String barcode, int quantity, Date orderDate) {
		super();
		this.branchOfficeName = branchOfficeName;
		this.barcode = barcode;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	public String getBranchOfficeName() {
		return branchOfficeName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setBranchOfficeName(String branchOfficeName) {
		this.branchOfficeName = branchOfficeName;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
