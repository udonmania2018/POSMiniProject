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
	
	private ChartPanel chartPanel; // 차트를 담을 패널
	private Font titleFont; // 타이틀용 폰트
	private JLabel title;   // 상단 타이틀 
	private JFreeChart chart;  // chart
	private DefaultPieDataset dpd ;  // chart 값 정의 
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
		
		userColumn.addElement("발주번호");
		userColumn.addElement("내용");
		userColumn.addElement("총 수량");
		
		// 지금은 테스트용으로 임시로 10 나중에 0으로 초기화 해주기
		model = new DefaultTableModel(userColumn,10); 
		userTable = new JTable(model);
		scroll = new JScrollPane(userTable);
		
		scroll.setBounds(80,90,400,150);
		
		Vector<String> userRow = new Vector<String>();
		// 추후에 수정
		/*for (// DB에서 읽어온 리스트의 크기만큼 반복실행 ) {
				userRow.addElement(list.get(i));
		}
		
		model.addRow(userRow);
		*/
	
		// 차트 추가
		chart = null;
		dpd = new DefaultPieDataset();
		
		// 여기에 출력할 값 배열 추가..
		String[] temps = {"Milk","Snack","Drink","Icecream","Sandwich"
							,"Chocolate","Gum","Gift","Gimbob","Alcohol"};
		
		for(int i=0; i<10;i++){
			int n = new Random().nextInt(10)+1;
			// map 형식 사용 값 전달
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
