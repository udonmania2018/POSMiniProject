package model.vo;

import java.io.Serializable;

public class ManufactureGroup implements Serializable{

	private String manufactureGroupName ;
	private String manufactureGroupCode;
	
	public ManufactureGroup() { }
	
	
	public ManufactureGroup(String manufactureGroupName, String manufactureGroupCode) {
		super();
		this.manufactureGroupName = manufactureGroupName;
		this.manufactureGroupCode = manufactureGroupCode;
	}
	
	public String getManufactureGroupName() {
		return manufactureGroupName;
	}
	public String getManufactureGroupCode() {
		return manufactureGroupCode;
	}
	public void setManufactureGroupName(String manufactureGroupName) {
		this.manufactureGroupName = manufactureGroupName;
	}
	public void setManufactureGroupCode(String manufactureGroupCode) {
		this.manufactureGroupCode = manufactureGroupCode;
	}
	
	
}
