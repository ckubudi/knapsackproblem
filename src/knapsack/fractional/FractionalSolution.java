package knapsack.fractional;


import knapsack.main.Solution;

/**
 * Stores a solution for the fractional knapsack problem
 * 
 * @author ckubudi
 *
 */
public class FractionalSolution extends Solution{
	private double lastItemFraction;
	
	public double getLastItemFraction() {
		return lastItemFraction;
	}
	public void setLastItemFraction(double lastItemFraction) {
		this.lastItemFraction = lastItemFraction;
	}
}