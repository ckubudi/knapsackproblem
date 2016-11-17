package knapsack.constrainedinteger;

import java.util.ArrayList;
import java.util.Collections;

import Graph.Edge;
import Graph.Graph;
import knapsack.fractional.FractionalComparator;
import knapsack.main.Instance;
import knapsack.main.Item;
import knapsack.main.Solution;

public class ConstrainedIntegerKnapsack {
	
	public static Solution getMaxSubset (Instance instance, int bruteForceSize){
		ArrayList<Item> subset = new ArrayList<Item>();
		Solution solution = new Solution();
		boolean isFiltered[] = new boolean[instance.getItems().size()];
		
		//Collections.sort(instance.getItems(), new FractionalComparator()); 
		Collections.sort(instance.getItems(), new ValueComparator()); 
		
		
		try{
			double currentCapacity = instance.getCapacity();
			ArrayList<Item> solutionItems;
			for ( int i = 0 ; i < instance.getItems().size() && currentCapacity > 0.0 ;  ){
				Item item = instance.getItems().get(i);
				if (subset.size() < bruteForceSize){
					if (!isFiltered[item.getId()-1]){
						subset.add(item);
					}
					i++;
				} else {
					solutionItems = getBestByBruteForce(instance, subset, currentCapacity);
					filterEdges(instance, isFiltered, solutionItems);
					solution.appendItems(solutionItems);
					solution.calculateStats();
					currentCapacity = instance.getCapacity() - solution.getTotalWeigth();
					subset.clear();
				}
			}
			
			if(!subset.isEmpty()){
				solutionItems = getBestByBruteForce(instance, subset, currentCapacity);
				solution.appendItems(solutionItems);
				solution.calculateStats();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		return solution;
	}
	
	
	private static void filterEdges(Instance instance, boolean[] isFiltered, ArrayList<Item> solutionItems) {
		if ( solutionItems != null){
			for (Item item : solutionItems){
				ArrayList<Edge> edges = instance.getConstraints().getVertex(item.getId()).getAdj();
				for(Edge edge : edges){
					isFiltered[edge.getDestino().getId()-1] = true;
				}
			}
		}
	}

	private static ArrayList<Item> getBestByBruteForce(Instance instance, ArrayList<Item> subset, double currentMaxCap) throws Exception{
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

	private static int checkTotalValue(Instance instance, double currentMaxWeigth, ArrayList<Item> subset) {
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
