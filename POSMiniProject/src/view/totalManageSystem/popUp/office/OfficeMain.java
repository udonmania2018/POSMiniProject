package view.totalManageSystem.popUp.office;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import model.dao.pos.OrderDao;
import model.dao.totalManageSystem.ProductDao;
import model.vo.totalManageSystem.OrderList;
import model.vo.totalManageSystem.ProductGroup;

public class OfficeMain extends JPanel {

	private ChartPanel chartPanel; // ��Ʈ�� ���� �г�
	private Font titleFont; // Ÿ��Ʋ�� ��Ʈ
	private JLabel title; // ��� Ÿ��Ʋ
	private JFreeChart chart; // chart
	private DefaultPieDataset dpd; // chart �� ����
	private Vector<String> userColumn;
	private DefaultTableModel model;
	private JTable userTable;
	private JScrollPane scroll;
	private OrderDao od = new OrderDao();

	public OfficeMain(){
		this.setBounds(0,0,580,600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		titleFont = new Font("title", Font.BOLD, 30);
		title = new JLabel("\uBD84\uB958\uBCC4 \uD310\uB9E4 \uD604\uD669");
		title.setFont(titleFont);
		title.setBounds(205,30,275,50);
		
		
/*		userColumn = new Vector<String>();
		
		userColumn.addElement("���ֹ�ȣ");
		userColumn.addElement("����");
		userColumn.addElement("�� ����");
		
		// ������ �׽�Ʈ������ �ӽ÷� 10 ���߿� 0���� �ʱ�ȭ ���ֱ�
		model = new DefaultTableModel(userColumn,10); 
		userTable = new JTable(model);
		scroll = new JScrollPane(userTable);
		
		scroll.setBounds(80,90,400,150);
		
		Vector<String> userRow = new Vector<String>();*/
		// ���Ŀ� ����
		/*for (// DB���� �о�� ����Ʈ�� ũ�⸸ŭ �ݺ����� ) {
				userRow.addElement(list.get(i));
		}
		
		model.addRow(userRow);
		*/
	
		// ��Ʈ �߰�
		chart = null;
		dpd = new DefaultPieDataset();
		
		ArrayList<OrderList> list = od.selectOrderList();
		ProductDao pd = new ProductDao();
		ArrayList<ProductGroup> pglist = pd.selectProductGroup();
		int[] su = new int[pglist.size()];
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < pglist.size(); j++) {
				String checkStr = list.get(i).getBarcode().substring(7,9);
				if(checkStr.equals(pglist.get(j).getProductGroupCode())){
					su[j] += list.get(i).getQuantity();
					break;
				}
			}
		}
		
		for(int i=0; i<pglist.size();i++){
			int n = new Random().nextInt(10)+1;
			// map ���� ��� �� ����
			dpd.setValue(pglist.get(i).getProductGroupName(), su[i]);
		}
		chart = ChartFactory.createPieChart3D("", dpd,true,true,false);
		chart.setBackgroundPaint(Color.WHITE);
		
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(111,143,395,330);
		chartPanel.setVisible(true);
		
		//this.add(scroll);
		this.add(title);
		this.add(chartPanel);
		this.setVisible(true);
	}
}
