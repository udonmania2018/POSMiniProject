package test;

import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class CreateBarcode {
	public void createBarcode(String productInfor) {
		try {
			// ������ �ּ�
			String add = "C:\\Users\\lee\\Desktop\\barcode";
			File dirCheck = new File(add);
			
			// ������ ������ ���� ����
			if(!dirCheck.exists()){
				dirCheck.mkdirs();
			}
			
			// ���ڵ� ����
			Barcode barcode = BarcodeFactory.createCode128B(productInfor);
			File file = new File(add+"\\"+productInfor+".png");
			
			BarcodeImageHandler.savePNG(barcode, file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
