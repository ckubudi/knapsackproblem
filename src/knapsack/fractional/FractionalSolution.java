package knapsack.fractional;

import knapsack.main.Item;
import knapsack.main.Solution;

/**
 * Stores a solution for the fractional knapsack problem
 * 
 * @author ckubudi
 *
 */
public class FractionalSolution extends Solution{
	private double lastItemFraction;
	private int lastItemId;
	
	public double getLastItemFraction() {
		return lastItemFraction;
	}
	public void setLastItemFraction(double lastItemFraction) {
		this.lastItemFraction = lastItemFraction;
	}
	
	public String toString (){
		StringBuffer buffer = new StringBuffer();

		buffer.append(subset.size()+" "+getTotalWeigth()+" "+getTotalValue());
		buffer.append(System.lineSeparator());
		
		for ( int i = 0 ; i < subset.size() ; i++){
			Item item = subset.get(i);
			if ( item.getId() == lastItemId){
				buffer.append(item.getId()+" "+ lastItemFraction);
			} else {
				buffer.append(item.getId()+" 1.00");
			}
			buffer.append(System.lineSeparator());
		}
		
		return buffer.toString();
	}
	public void setLastItemId(int id) {
		lastItemId=id;
	}
}