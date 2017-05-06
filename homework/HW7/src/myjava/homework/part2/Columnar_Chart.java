package myjava.homework.part2;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.DefaultCategoryDataset;  
public class Columnar_Chart extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Data_Store> data;
	private Data_Store one_data;
	private String id;
	private HashMap<String, Integer> product_count;
	public Columnar_Chart(String id ,ArrayList<Data_Store> data){
		this.data = data;
		this.id = id;
	}
	public boolean check_id(String id){
		boolean check = false;
		for(int i = 0; i < data.size(); i++){
			if(id.equals(data.get(i).getid())){
				check = true;
				break;
			}
			else 
				check = false;
		}
		return check;
	}
	void chart(){
		DefaultCategoryDataset chartData = new DefaultCategoryDataset();
		for(Object key : product_count.keySet())
			chartData.addValue(product_count.get(key), "Count", (Comparable) key);
		try{
			 JFreeChart chart = ChartFactory.createBarChart3D("What "+ id + " buy" , "Product type" , "Count" , chartData , PlotOrientation.VERTICAL , true , true , false);
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
	void cau(){
		for(int i = 0; i < data.size(); i++){
			if(id.equals(data.get(i).getid())){
				this.one_data = this.data.get(i);
				product_count = one_data.get_data();
				break;
			}
		}
	}
	public void run(){
		this.cau();
		this.chart();
	}
}
