package knapsack.main;

import java.util.ArrayList;

/**
 * Generic solution for Knapsack problem
 * 
 * @author ckubudi
 *
 */
public class Solution {
	private ArrayList<Item> subset;
	private double totalValue;
	
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
}
