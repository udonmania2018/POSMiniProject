package barcode;

import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class CreateBarcode {
	public String createBarcode(String productInfor) {
		try {
			// 저장할 주소
			String add = "C:\\POSDB\\barcode";
			File dirCheck = new File(add);
			
			// 폴더가 없으면 폴더 생성
			if(!dirCheck.exists()){
				dirCheck.mkdirs();
			}
			
			// 바코드 생성
			Barcode barcode = BarcodeFactory.createCode128B(productInfor);
			File file = new File(add+"\\"+productInfor+".png");
			
			BarcodeImageHandler.savePNG(barcode, file);
			
			return add + "\\"+productInfor+".png";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
