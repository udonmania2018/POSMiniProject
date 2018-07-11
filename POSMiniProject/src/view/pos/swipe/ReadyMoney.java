package view.pos.swipe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.pos.POSController;
import model.vo.pos.Moneys;

public class ReadyMoney extends JPanel {
   private JTextField textField;
   private JTextField txtKh;
   private Vector<String> userColumn;
   private DefaultTableModel model;
   private JTable userTable;
   private JScrollPane scroll;
   private POSController pc = new POSController();

   public ReadyMoney() {
      this.setSize(1200, 400);
      this.setLayout(null);
      this.setBackground(Color.WHITE);

      JLabel lblNewLabel_1 = new JLabel("시 재 확 인");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 28));
      lblNewLabel_1.setBounds(35, 25, 222, 60);
      add(lblNewLabel_1);

      userColumn = new Vector<String>();

      userColumn.addElement("권종");
      userColumn.addElement("수량");
      userColumn.addElement("금액");

      model = new DefaultTableModel(userColumn, 8){
         @Override
         public boolean isCellEditable(int row, int column) {
            // TODO Auto-generated method stub
            if(column % 2 == 0){
               return false;
            } else {
               return true;
            }
         }
      };
      userTable = new JTable(model);
      userTable.setRowHeight(21);
      userTable.getTableHeader().setReorderingAllowed(false);
      userTable.getTableHeader().setResizingAllowed(false);
      scroll = new JScrollPane(userTable);

      scroll.setBounds(35, 90, 555, 193);

      model.setValueAt("50000", 0, 0);
      model.setValueAt("10000", 1, 0);
      model.setValueAt("5000", 2, 0);
      model.setValueAt("1000", 3, 0);
      model.setValueAt("500", 4, 0);
      model.setValueAt("100", 5, 0);
      model.setValueAt("50", 6, 0);
      model.setValueAt("10", 7, 0);
   
      JLabel lblNewLabel_2 = new JLabel("실현금");
      lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      lblNewLabel_2.setBounds(60, 300, 80, 40);
      add(lblNewLabel_2);

      textField = new JTextField();
      textField.setBounds(132, 311, 414, 24);
      add(textField);
      textField.setColumns(10);

      JButton btnNewButton = new JButton(new ImageIcon("images/buttonsImages/OK_ICON.PNG"));
      btnNewButton.setBounds(482, 37, 100, 40);
      add(btnNewButton);

      btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               // TODO Auto-generated method stub
               int[] moneys = new int[8];
               for (int i = 0; i < moneys.length; i++) {
                  if (userTable.getValueAt(i, 1).equals("") || userTable.getValueAt(i, 1) == null) {
                     moneys[i] = 0;
                  } else {
                     moneys[i] = Integer.parseInt((String) userTable.getValueAt(i, 1));
                  }   
                  System.out.println(moneys[i]);
               }
               pc.saveMoney(new Moneys(moneys));
               
                 
                     int a = 50000*(Integer.parseInt((String)userTable.getValueAt(0, 1)));
                     model.setValueAt(a, 0, 2);
                     int b = 10000*(Integer.parseInt((String)userTable.getValueAt(1, 1)));
                    model.setValueAt(b, 1, 2);
                     int c = 5000*(Integer.parseInt((String)userTable.getValueAt(2, 1)));
                     model.setValueAt(c, 2, 2);
                     int d = 1000*(Integer.parseInt((String)userTable.getValueAt(3, 1)));
                     model.setValueAt(d, 3, 2);
                     int e = 500*(Integer.parseInt((String)userTable.getValueAt(4, 1)));
                     model.setValueAt(e, 4, 2);
                     int f = 100*(Integer.parseInt((String)userTable.getValueAt(5, 1)));
                     model.setValueAt(f, 5, 2);
                     int g = 50*(Integer.parseInt((String)userTable.getValueAt(6, 1)));
                     model.setValueAt(g, 6, 2);
                     int h = 10*(Integer.parseInt((String)userTable.getValueAt(7, 1)));
                     model.setValueAt(h, 7, 2);

                     //누적 합계 나오게 수정 필요
               textField.setText((a+b+c+d+e+f+g+h) + "");
            }
            
            
         });
      

      JLabel lblNewLabel_3 = new JLabel("영 수 증");
      lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 28));
      lblNewLabel_3.setBounds(648, 37, 148, 47);
      add(lblNewLabel_3);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(771, 48, 372, 277);
      add(scrollPane);
      
      // 중앙 분리선
            JSeparator separator = new JSeparator();
            separator.setOrientation(SwingConstants.VERTICAL);
            separator.setForeground(Color.DARK_GRAY);
            separator.setBackground(Color.BLACK);
            separator.setBounds(620, 29, 12, 350);
            add(separator);

      txtKh = new JTextField();
      txtKh.setEditable(true);
      txtKh.setText("KH편의점(역삼점) 발행일 : 현재날짜 \n\t 시재 확인 ");
      scrollPane.add(txtKh);
      txtKh.setColumns(2);

      this.add(scroll);
      this.add(scrollPane);
      this.setVisible(true);
   }
}