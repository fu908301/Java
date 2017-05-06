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
	HashMap<String, Integer> product_count = new HashMap<String, Integer>();
	private ArrayList<Data_Store> data;
	private HashMap<String,String> map;
	private String S_male = "M";
	private String S_female = "F";
	private int male = 0;
	private int female = 0;
	private double male_P;
	private double female_P;
	private String S_male_P;
	private String S_female_P;
	public pieChart(ArrayList<Data_Store> input,HashMap<String,String> map){
		this.data = input;
		this.map = map;
	}
	void cau(){
		for(int i = 0; i < data.size(); i++){
			final String productName = data.get(i).getbuy();
			final Integer count = product_count.get(productName);
			if(count == null)
				product_count.put(productName, 1);
			else
				product_count.put(productName, count + 1);
		}
		for (Object key : map.keySet()){
			if(map.get(key).equals( S_male))
				male++;
			else if(map.get(key).equals(S_female))
				female++;
		}
		male_P = (double)male / map.size() * 100;
		female_P = (double)female / map.size() * 100;
		DecimalFormat df=new DecimalFormat("#.##");
		S_male_P = df.format(male_P);
		S_female_P = df.format(female_P);
	}
	void pie(){
		DefaultPieDataset productType = new DefaultPieDataset();
		for(Object key : product_count.keySet()){
			final double product_P = (double) product_count.get(key) / data.size() * 100;
			DecimalFormat df=new DecimalFormat("#.##");
			final String S_product_P = df.format(product_P);;
			productType.setValue(key + " " + S_product_P + "%", product_count.get(key)); 
		}
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
