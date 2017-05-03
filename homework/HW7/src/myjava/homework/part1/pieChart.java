package myjava.homework.part1;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PiePlot3D;    
import org.jfree.data.general.DefaultPieDataset;  
public class pieChart extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Data_Store> data;
	private HashMap<String,String> map;
	private String S_product_A = "Product_A";
	private String S_product_B = "Product_B";
	private String S_product_C = "Product_C";
	private String S_male = "M";
	private String S_female = "F";
	private int product_A = 0;
	private int product_B = 0;
	private int product_C = 0;
	private int male = 0;
	private int female = 0;
	private double product_A_P;
	private double product_B_P;
	private double product_C_P;
	private double male_P;
	private double female_P;
	private String S_product_A_P;
	private String S_product_B_P;
	private String S_product_C_P;
	private String S_male_P;
	private String S_female_P;
	public pieChart(ArrayList<Data_Store> input,HashMap<String,String> map){
		this.data = input;
		this.map = map;
	}
	void cau(){
		for(int i = 0; i < data.size(); i++){
			if(data.get(i).getbuy().equals(S_product_A))
				product_A++;
			else if(data.get(i).getbuy().equals(S_product_B))
				product_B++;
			else if(data.get(i).getbuy().equals(S_product_C))
				product_C++;
		}
		for (Object key : map.keySet()){
			if(map.get(key).equals( S_male))
				male++;
			else if(map.get(key).equals(S_female))
				female++;
		}
		product_A_P = (double)product_A / data.size() * 100;
		product_B_P = (double)product_B / data.size() * 100;
		product_C_P = (double)product_C / data.size() * 100;
		male_P = (double)male / map.size() * 100;
		female_P = (double)female / map.size() * 100;
		DecimalFormat df=new DecimalFormat("#.##");
		S_product_A_P = df.format(product_A_P);
		S_product_B_P = df.format(product_B_P);
		S_product_C_P = df.format(product_C_P);
		S_male_P = df.format(male_P);
		S_female_P = df.format(female_P);
	}
	//pie1 and pie2 is used for only one chart, pie is used for multiple chart
	void pie1(){
		DefaultPieDataset dataType = new DefaultPieDataset();
		dataType.setValue("Product_A " + S_product_A_P, product_A);  
        dataType.setValue("Product_B " + S_product_B_P, product_B);  
        dataType.setValue("Product_C " + S_product_C_P, product_C);    
		try{
			DefaultPieDataset data = dataType; 
			PiePlot3D plot = new PiePlot3D(data);
			JFreeChart chart = new JFreeChart(  
                    "product_type",            
                    JFreeChart.DEFAULT_TITLE_FONT,  
                    plot,                            
                    true                            
            );
			ChartPanel chartPanel = new ChartPanel(chart);  
			chartPanel.setPreferredSize(new java.awt.Dimension(700, 300)); 
			this.setContentPane(chartPanel);
			this.pack();
			this.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void pie2(){
		DefaultPieDataset dataType = new DefaultPieDataset();
		dataType.setValue("Male " + S_male_P, male);  
        dataType.setValue("Female " + S_female_P, female);     
		try{
			DefaultPieDataset data = dataType; 
			PiePlot3D plot = new PiePlot3D(data);
			JFreeChart chart = new JFreeChart(  
                    "id_sex",            
                    JFreeChart.DEFAULT_TITLE_FONT,  
                    plot,                            
                    true                            
            );
			ChartPanel chartPanel = new ChartPanel(chart);  
			chartPanel.setPreferredSize(new java.awt.Dimension(500, 200)); 
			this.setContentPane(chartPanel);
			this.pack();
			this.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void pie(){
		DefaultPieDataset productType = new DefaultPieDataset();
		productType.setValue("Product_A " + S_product_A_P + "%", product_A);  
		productType.setValue("Product_B " + S_product_B_P + "%", product_B);  
		productType.setValue("Product_C " + S_product_C_P + "%", product_C); 
		DefaultPieDataset sexType = new DefaultPieDataset();
		sexType.setValue("Male " + S_male_P + "%", male);  
        sexType.setValue("Female " + S_female_P + "%", female);
        try{
        	JFreeChart productchart = ChartFactory.createPieChart("Product_Type",productType);
        	JFreeChart sexchart = ChartFactory.createPieChart("ID_sex",sexType);
        	this.getContentPane().add(new ChartPanel(productchart), BorderLayout.WEST);
        	this.getContentPane().add(new ChartPanel(sexchart), BorderLayout.EAST);
        	this.pack();
        	this.setResizable(false);
        	this.setVisible(true);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}
	public void run(){
		cau();
		pie();
	}
}
