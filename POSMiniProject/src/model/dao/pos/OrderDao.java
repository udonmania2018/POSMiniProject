package model.dao.pos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.dao.totalManageSystem.ProductDao;
import model.vo.pos.ProductStock;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.OrderList;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;

public class OrderDao {
   File checkdir;

   public OrderDao() {
      // ������ �ִ���
      checkdir = new File("C:\\POSDB");
      if (!checkdir.exists()) {
         checkdir.mkdirs();
      }
   }

   public ArrayList<Product> selectProductOnName(String searchName) {
      ArrayList<Product> list = new ArrayList();
      // �����͸� ������ ���� InputStream
      // try-with-resources ���
      // ObjectInputStream �������� �Ű������� InputStream type�� �䱸�Ѵ�
      // InputStream�� abstract�̱� ������ ��ü�δ� ��ü���� �Ұ�. ��ӹ޾� �������� Ŭ������ ���
      // ���� ������� ���� FileInputStream�� ���
      try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(checkdir.getPath() + "\\product.dat"));) {
         // �ش� Stream���� File�� read
         while (true) {
            // Product type���� ��ȯ �������� Product�� �������� ������ Class~ exception �߻�
            list.add((Product) ois.readObject());
         }
      } catch (EOFException e) {
         // ���� �дٰ� ���� ������(EOF), EOFException���� while() Ż��
         System.out.println("������ �ε� ����...");
         // ���� list�� ��ȯ���ְ� ��. t-w-r �̱� ������ finally �ʿ� ����

         if ((searchName == null || searchName.trim().equals("")) || searchName.equals("��ǰ�� �Է�")) {
            // ���� searchName�� �ƹ��͵� �ȵ����ų� �⺻ ���¶�� ��ü ����Ʈ ����
            return list;
         }

         for (int i = 0; i < list.size();) {
            // equals: ������ ��ġ, contains: �� ���ڸ� ���� ��ġ
            // searchName�� ProductName�� ���Ե��� ���� ��ü �Ÿ���
            if (!(list.get(i).getProductName().contains(searchName))) {
               list.remove(i);
            } else {
               // list���� remove�� �ϸ� .size()�� �ڵ� �����Ǳ� ������
               // for�� ���ǿ� ���� i++�� ������ ����ϴ�.
               // �׷��� ������ ProductName�� searchName�� contains�ϴ� ��쿡�� ī��Ʈ ����.
               i++;
            }
         }
         return list;
      } catch (FileNotFoundException e) {
         // �ش� ������ ���� ����� ����ó��
         System.out.println("������ ����");
         return null;
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      // �����δ� ����� ���� ����
      return null;
   }

   public ArrayList<ProductStock> seletProductStock() {
      ArrayList<ProductStock> list = new ArrayList<ProductStock>();
      try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(checkdir.getPath() + "\\productStock.dat"))) {
         while (true) {
            list.add((ProductStock) ois.readObject());
         }
      } catch (EOFException e) {
         System.out.println("������ �ε� ����");
         return list;
      } catch (FileNotFoundException e) {
         return list;
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }

   public void orderProduct(ArrayList<ProductStock> orderList) {
      // TODO Auto-generated method stub
      // ������ �����Ͱ� �ҷ�����
      ArrayList<ProductStock> orignData = seletProductStock();
      if (orignData == null) {
         // ���� �����Ͱ� ���� ���
         orignData = new ArrayList<ProductStock>();
      }

      for (int j = 0; j < orderList.size(); j++) {
         boolean check = false;
         for (int i = 0; i < orignData.size(); i++) {
            if (orignData.get(i).getBarcode().equals(orderList.get(j).getBarcode())) {
               orignData.get(i).setQuantity(orignData.get(i).getQuantity() + orderList.get(j).getQuantity());
               check = true;
               break;
            }
         }
         if (!check) {
            orignData.add(orderList.get(j));
         }
      }

      for (int i = 0; i < orignData.size(); i++) {
         System.out.println(orignData.get(i));
      }
      try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(checkdir.getPath() + "\\productStock.dat"))) {
         // ��ü ����
         for (int i = 0; i < orignData.size(); i++) {
            oos.writeObject(orignData.get(i));
         }
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

   public ArrayList<ProductStock> selectProductStockOnName(String text) {
      ArrayList<ProductStock> list = new ArrayList<ProductStock>();
      try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(checkdir.getPath() + "\\productStock.dat"));) {
         while (true) {
            list.add((ProductStock) ois.readObject());
         }
      } catch (EOFException e) {
         System.out.println("������ �ε� ����...");

         if ((text == null || text.trim().equals("")) || text.equals("��ǰ�� �Է�")) {
            return list;
         }
         for (int i = 0; i < list.size();) {
            // equals: ������ ��ġ, contains: �� ���ڸ� ���� ��ġ
            // searchName�� ProductName�� ���Ե��� ���� ��ü �Ÿ���
            if (!(list.get(i).getProductName().contains(text))) {
               list.remove(i);
            } else {
               // list���� remove�� �ϸ� .size()�� �ڵ� �����Ǳ� ������
               // for�� ���ǿ� ���� i++�� ������ ����ϴ�.
               // �׷��� ������ ProductName�� searchName�� contains�ϴ� ��쿡�� ī��Ʈ ����.
               i++;
            }
         }
         return list;
      } catch (FileNotFoundException e) {
         // �ش� ������ ���� ����� ����ó��
         System.out.println("������ ����");
         return null;
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      // �����δ� ����� ���� ����
      return null;
   }

   public void deleteProductStock(ArrayList<ProductStock> stockList) {

      try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(checkdir.getPath() + "\\productStock.dat"))) {
         // ��ü ����
         for (int i = 0; i < stockList.size(); i++) {
            oos.writeObject(stockList.get(i));
         }
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

   public void addOrderList(ArrayList<OrderList> orderList2) {
      // TODO Auto-generated method stub
      ArrayList<OrderList> list = selectOrderList();

      for (int i = 0; i < orderList2.size(); i++) {
         list.add(orderList2.get(i));
      }

      try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(checkdir.getPath() + "\\orderList.dat"))) {
         // ��ü ����
         for (int i = 0; i < list.size(); i++) {
            oos.writeObject(list.get(i));
         }
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

   public ArrayList<OrderList> selectOrderList() {
      ArrayList<OrderList> list = new ArrayList<OrderList>();
      try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(checkdir.getPath() + "\\orderList.dat"))) {
         while (true) {
            list.add((OrderList) ois.readObject());
         }
      } catch (EOFException e) {
         System.out.println("������ �ε� ����");
         return list;
      } catch (FileNotFoundException e) {
         return list;
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }

   public ArrayList<ProductStock> selectProductStockName(String searchName) {
      ArrayList<ProductStock> list = new ArrayList<ProductStock>();
      try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(checkdir.getPath() + "\\productStock.dat"));) {
         while (true) {
            list.add((ProductStock) ois.readObject());
         }
      } catch (EOFException e) {
         System.out.println("������ �ε� ����...");

         for (int i = 0; i < list.size();) {
            // equals: ������ ��ġ, contains: �� ���ڸ� ���� ��ġ
            // searchName�� ProductName�� ���Ե��� ���� ��ü �Ÿ���
            if (!(list.get(i).getProductName().contains(searchName))) {
               list.remove(i);
            } else {
               // list���� remove�� �ϸ� .size()�� �ڵ� �����Ǳ� ������
               // for�� ���ǿ� ���� i++�� ������ ����ϴ�.
               // �׷��� ������ ProductName�� searchName�� contains�ϴ� ��쿡�� ī��Ʈ ����.
               i++;
            }
         }
         return list;
      } catch (FileNotFoundException e) {
         // �ش� ������ ���� ����� ����ó��
         System.out.println("������ ����");
         return null;
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      // �����δ� ����� ���� ����
      return null;
   }


}