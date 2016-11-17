package knapsack.integer;

import java.util.ArrayList;

import knapsack.main.Item;
import knapsack.main.Solution;

public class IntegerKnapsack {
	
	
	/**
	 * Returns a solution for the maximum value integer knapsack problem with possible items 
	 * and target capacity, using dynamic programming
	 * 
	 * @param items
	 * @param capacity
	 * @return
	 */
	public static Solution getMaxSubset (ArrayList<Item> items, int capacity ){
		Solution solution = new Solution();
		ArrayList<Item> subset = new ArrayList<Item>();
		int[][] results = new int[items.size()+1][capacity+1];
		boolean[][] itemTaken = new boolean[items.size()+1][capacity+1];  
		
		//both first row and first columns must be 0 - and this is the default value 
		//start dynamic programming to find opt solution for each case
		for (int item_row = 1 ; item_row <= items.size() ; item_row++){
			for ( int subCap=1 ; subCap <= capacity ; subCap++){
				int currentItemWeigth = items.get(item_row-1).getWeigth();
				
				int notTakingItemValue = results[item_row-1][subCap];
				if (currentItemWeigth > subCap){ 
					//if this item weigths more than current subCap, the optimal solution is equal to previous one
					results[item_row][subCap] = notTakingItemValue;
					itemTaken[item_row][subCap] = false;
				} else {
					//otherwise, we check the maximum between the previous optimal and the current item + the optimal solution for the remaining capacity on the previous item
					int takingItemValue = items.get(item_row-1).getValue() + results[item_row-1][subCap - currentItemWeigth];
					if ( takingItemValue > notTakingItemValue){
						results[item_row][subCap] = takingItemValue;
						itemTaken[item_row][subCap] = true;
					} else {
						results[item_row][subCap] = notTakingItemValue;
						itemTaken[item_row][subCap] = false;
					}
				}
			}
		}
		

		solution.setTotalValue(results[items.size()][capacity]);
		
		//check taken items for optimal solution
		double totalWeigth = 0;
		for(int i = items.size() ; i > 0 ; i--){
			if ( itemTaken[i][capacity] ){
				subset.add(items.get(i-1));
				totalWeigth += items.get(i-1).getWeigth();
				capacity -= items.get(i-1).getWeigth();
			}
		}
		solution.setTotalWeigth(totalWeigth);
		solution.setSubset(subset);
		return solution;
	}
}
