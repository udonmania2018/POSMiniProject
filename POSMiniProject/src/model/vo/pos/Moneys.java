package model.vo.pos;

import java.io.Serializable;
import java.util.Arrays;

public class Moneys implements Serializable{
	private int[] moneys;
	
	public Moneys() { }

	public Moneys(int[] moneys) {
		super();
		this.moneys = moneys;
	}

	public int[] getMoneys() {
		return moneys;
	}

	public void setMoneys(int[] moneys) {
		this.moneys = moneys;
	}

	@Override
	public String toString() {
		return "Moneys [moneys=" + Arrays.toString(moneys) + "]";
	}
	

}
