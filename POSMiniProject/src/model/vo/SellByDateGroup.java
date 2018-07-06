package model.vo;

import java.io.Serializable;

public class SellByDateGroup implements Serializable{
	private int selldatenum;
	
	public SellByDateGroup(){
		
	}

	public SellByDateGroup(int selldatenum) {
		super();
		this.selldatenum = selldatenum;
	}

	public int getSelldatenum() {
		return selldatenum;
	}

	public void setSelldatenum(int selldatenum) {
		this.selldatenum = selldatenum;
	}

	
	
	
}
