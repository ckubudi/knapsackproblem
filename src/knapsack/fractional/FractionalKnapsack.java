package knapsack.fractional;

import java.util.ArrayList;
import java.util.Collections;

import knapsack.main.Item;

/**
 * Class to implement a greedy algorithm to solve the maximum value fractional knapsack problem
 * 
 * @author ckubudi
 *
 */
public class FractionalKnapsack {
	/**
	 * Gets the items list and target knapsack capacity and returns another list containing all the items that
	 * belong to the maximum subset, loaded with their fraction in the given problem. 
	 * 
	 * @param items
	 * @param capacity
	 * @return
	 */
	public static FractionalSolution getMaxSubset (ArrayList<Item> items, int capacity ){
		ArrayList<Item> subset = new ArrayList<Item>();
		FractionalSolution solution = new FractionalSolution();
		double totalValue = 0;
		
		solution.setSubset(subset);
		solution.setLastItemFraction(1.0);
		
		if ( capacity == 0){
			return solution;
		}
		
		//sorts the items based on their ratio (descending order)
		Collections.sort(items, new FractionalComparator());;
		
		///puts the max ratio items until reaches full capacity
		for (Item item : items ){
			subset.add(item);
			if ( capacity > item.getWeigth()){ //if there is room for another item besides the current
				totalValue += item.getValue();
				capacity -= item.getWeigth();
			} else { //this is the last item
				solution.setLastItemFraction(capacity / item.getWeigth());
				totalValue += item.getValue() * solution.getLastItemFraction();
				solution.setTotalValue(totalValue);
				break;
			}
		}
		return solution;
	}
	
}
