package knapsack.constrainedinteger;

import java.util.ArrayList;
import java.util.Collections;

import Graph.Graph;
import knapsack.fractional.FractionalComparator;
import knapsack.main.Instance;
import knapsack.main.Item;
import knapsack.main.Solution;

public class ConstrainedIntegerKnapsack {
	private static int BRUTE_FORCE_SIZE = 10;
	
	
	public static Solution getMaxSubset (Instance instance){
		Collections.sort(instance.getItems(), new FractionalComparator()); 
		
		ArrayList<Item> subset = new ArrayList<Item>();
		
		for ( int i = 0 ; i < BRUTE_FORCE_SIZE && i < instance.getItems().size() ; i++ ){
			subset.add(instance.getItems().get(i));
		}
		
		Solution solution = new Solution();
		
		ArrayList<Item> solutionItems;
		try {
			solutionItems = getBestByBruteForce(instance, subset, instance.getCapacity());
			solution.setSubset(solutionItems);
			solution.calculateStats();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solution;
	}
	
	
	private static ArrayList<Item> getBestByBruteForce(Instance instance, ArrayList<Item> subset, int currentMaxCap) throws Exception{
		if ( subset.size() > 31 ){
			throw new Exception("Max size for brute force overflow");
		}
		ArrayList<Item> solution = new ArrayList<Item>();		
		int maxCombination = 0 ; //bitwise calculating all combinations
		maxCombination = 1 << subset.size();
		
		int maxValue = 0;
		ArrayList<Item> combinationSet; 
		ArrayList<Item> maxValueSet = null;
		for ( int combination = 1 ; combination < maxCombination; combination++){
			combinationSet = new ArrayList<Item>();
			int index = 0;
			for (int i = 1 ; i < maxCombination ; i=i << 1 ){
				if ( (combination & i) != 0){ //this item is present
					combinationSet.add(subset.get(index));
				}
				index++;
			}
			int value  = checkTotalValue(instance, currentMaxCap, combinationSet);
			if ( value > maxValue){
				maxValueSet = combinationSet;
				maxValue = value;
			}
		}
		
		return maxValueSet;
	}

	private static int checkTotalValue(Instance instance, int currentMaxWeigth, ArrayList<Item> subset) {
		int totalWeigth=0;
		int totalValue=0;
		for ( Item item : subset){
			for (Item subItem : subset){
				if (item != subItem){
					if (instance.isConstrained(item, subItem)){
						return -1; //not feasible solution
					}
				}
			}
			totalWeigth+=item.getWeigth();
			totalValue+=item.getValue();
		}
		
		if ( totalWeigth > currentMaxWeigth){
			return -1;
		}
		
		return totalValue;
	}
	
}
