package view.totalManageSystem.popUp.office;

import java.awt.Color;
import java.awt.Font;
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

public class OfficeMain extends JPanel{
	
	private ChartPanel chartPanel; // ��Ʈ�� ���� �г�
	private Font titleFont; // Ÿ��Ʋ�� ��Ʈ
	private JLabel title;   // ��� Ÿ��Ʋ 
	private JFreeChart chart;  // chart
	private DefaultPieDataset dpd ;  // chart �� ���� 
	private Vector<String> userColumn ;
	private DefaultTableModel model ;
	private JTable userTable ;
	private JScrollPane scroll;
	
	public OfficeMain(){
		this.setBounds(0,0,580,600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		titleFont = new Font("title", Font.BOLD, 30);
		title = new JLabel("\uC9C0\uC810\uBCC4 \uD310\uB9E4 \uD604\uD669");
		title.setFont(titleFont);
		title.setBounds(230,30,250,50);
		
		
		userColumn = new Vector<String>();
		
		userColumn.addElement("���ֹ�ȣ");
		userColumn.addElement("����");
		userColumn.addElement("�� ����");
		
		// ������ �׽�Ʈ������ �ӽ÷� 10 ���߿� 0���� �ʱ�ȭ ���ֱ�
		model = new DefaultTableModel(userColumn,10); 
		userTable = new JTable(model);
		scroll = new JScrollPane(userTable);
		
		scroll.setBounds(80,90,400,150);
		
		Vector<String> userRow = new Vector<String>();
		// ���Ŀ� ����
		/*for (// DB���� �о�� ����Ʈ�� ũ�⸸ŭ �ݺ����� ) {
				userRow.addElement(list.get(i));
		}
		
		model.addRow(userRow);
		*/
	
		// ��Ʈ �߰�
		chart = null;
		dpd = new DefaultPieDataset();
		
		// ���⿡ ����� �� �迭 �߰�..
		String[] temps = {"Milk","Snack","Drink","Icecream","Sandwich"
							,"Chocolate","Gum","Gift","Gimbob","Alcohol"};
		
		for(int i=0; i<10;i++){
			int n = new Random().nextInt(10)+1;
			// map ���� ��� �� ����
			dpd.setValue(temps[i], n);
		}
		chart = ChartFactory.createPieChart3D("", dpd,true,true,false);
		chart.setBackgroundPaint(Color.WHITE);
		
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(80,260,400,300);
		chartPanel.setVisible(true);
		
		this.add(scroll);
		this.add(title);
		this.add(chartPanel);
		this.setVisible(true);
	}
}
