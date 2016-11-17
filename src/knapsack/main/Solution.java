package knapsack.main;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Generic solution for Knapsack problem
 * 
 * @author ckubudi
 *
 */
public class Solution {
	protected ArrayList<Item> subset;
	protected double totalValue;
	protected double totalWeigth;
	
	public Solution() {
		subset = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getSubset() {
		return subset;
	}
	public void setSubset(ArrayList<Item> subset) {
		this.subset = subset;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	public double getTotalWeigth() {
		return totalWeigth;
	}
	public void setTotalWeigth(double totalWeigth) {
		this.totalWeigth = totalWeigth;
	}
	
	public String toString (){
		StringBuffer buffer = new StringBuffer();

		DecimalFormat df = new DecimalFormat("0.00");
		
		buffer.append(subset.size()+" "+getTotalWeigth()+" "+df.format(getTotalValue()));
		buffer.append(System.lineSeparator());
		
		for ( Item item : subset) {
			buffer.append(item.getId()+" "+item.getWeigth()+" "+item.getValue()+" 1.00");
			buffer.append(System.lineSeparator());
		}
		
		return buffer.toString();
	}
	public void calculateStats() {
		totalValue = 0;
		totalWeigth = 0;
		for(Item item : subset){
			totalValue += item.getValue();
			totalWeigth += item.getWeigth();
		}
	}
	
	public void appendItems ( ArrayList<Item> extraItems) {
		if (extraItems != null){
			for  ( Item item : extraItems){
				subset.add(item);
			}
		}
	}
}
