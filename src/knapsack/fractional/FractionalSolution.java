package knapsack.fractional;

import java.util.ArrayList;

import knapsack.main.Item;

/**
 * Stores a solution for the fractional knapsack problem
 * 
 * @author ckubudi
 *
 */
public class FractionalSolution {
	private ArrayList<Item> subset;
	private double lastItemFraction;
	private double totalValue;
	
	public ArrayList<Item> getSubset() {
		return subset;
	}
	public void setSubset(ArrayList<Item> subset) {
		this.subset = subset;
	}
	public double getLastItemFraction() {
		return lastItemFraction;
	}
	public void setLastItemFraction(double lastItemFraction) {
		this.lastItemFraction = lastItemFraction;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
}
