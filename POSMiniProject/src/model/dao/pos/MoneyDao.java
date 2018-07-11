package model.dao.pos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.vo.pos.Moneys;

public class MoneyDao {
   File checkdir;

   public MoneyDao() {
      // ������ �ִ���
      checkdir = new File("C:\\POSDB");
      if (!checkdir.exists()) {
         checkdir.mkdirs();
      }
   }

   public void saveMoneys(Moneys moneys) {
      // TODO Auto-generated method stub
      Moneys orignMoneys = selectSafeMoneys();
      if (orignMoneys == null) {
         orignMoneys = moneys;
      } else {
         int[] orign = orignMoneys.getMoneys();
         int[] addMoney = moneys.getMoneys();
         for (int i = 0; i < orign.length; i++) {
            orign[i] = orign[i] + addMoney[i];
         }

         orignMoneys.setMoneys(orign);
      }

      try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(checkdir.getPath() + "\\safeMoneys.dat"))) {
         // ��ü ����
         
         for (int i = 0; i < orignMoneys.getMoneys().length; i++) {
            System.out.println(orignMoneys.getMoneys()[i]);
         }
         oos.writeObject(orignMoneys);
         
         oos.flush();

      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public Moneys selectSafeMoneys() {
      Moneys moneys = null;
      // ���� �о����
      try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(checkdir.getPath() + "\\safeMoneys.dat"))) {
         moneys = (Moneys) ois.readObject();
      } catch (EOFException e) {
         System.out.println("������ �ε� ����...");
         return moneys;
      } catch (FileNotFoundException e) {
         // ������ ������ ó���� ��� ó��
         return null;
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return moneys;
   }

}