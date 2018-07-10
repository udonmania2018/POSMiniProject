package model.dao.pos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.vo.totalManageSystem.Product;

public class OrderDao {
   File checkdir;

   public OrderDao() {
      // 폴더가 있는지
      checkdir = new File("C:\\POSDB");
      if (!checkdir.exists()) {
         checkdir.mkdirs();
      }
   }

   public ArrayList<Product> seletProductOnName(String text) {
      ArrayList<Product> list = new ArrayList<Product>();
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(checkdir.getPath() + "\\product.dat"))) {
         while (true) {
            list.add((Product) ois.readObject());
         }
      } catch (EOFException e) {
         System.out.println("데이터 로드 성공"); 
         return list;
      } catch (FileNotFoundException e) {
         return null;
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;

   }

}