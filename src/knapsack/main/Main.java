package knapsack.main;

import java.util.Comparator;

import knapsack.constrainedinteger.ConstrainedIntegerKnapsack;
import knapsack.constrainedinteger.ConstraintsComparator;
import knapsack.constrainedinteger.ValueComparator;
import knapsack.fractional.FractionalComparator;
import knapsack.fractional.FractionalKnapsack;
import knapsack.fractional.FractionalSolution;
import knapsack.integer.IntegerKnapsack;

public class Main {
	private static Comparator[] COMPARATORS = {new FractionalComparator(), new ValueComparator(), new ConstraintsComparator()} ;
	private static int[] BRUTE_FORCE_SIZES = {1};		

	
	public static void main(String[] args) {
		String filePath = args[0];
		String problem = args[1];
		
		Instance instance = null;
		Solution solution =null;

		switch (problem){
		
		case "1":
			instance = new Instance(filePath, false);
			solution = FractionalKnapsack.getMaxSubset(instance.getItems(), instance.getCapacity()); 
			break;
		case "2":
			instance = new Instance(filePath, false);
			solution = IntegerKnapsack.getMaxSubset(instance.getItems(), instance.getCapacity());
			break;
		case "3":
			instance = new Instance(filePath, true);
			int bestI = 1;
			String bestComparator = "None";
			for (Comparator comparator : COMPARATORS){
				for( int i : BRUTE_FORCE_SIZES){
					Solution tempSolution = ConstrainedIntegerKnapsack.getMaxSubset(instance, i, comparator );
					if ( solution == null || tempSolution.getTotalValue() > solution.getTotalValue()){
						solution = tempSolution;
						bestComparator = comparator.getClass().getName();
						bestI = i;
					}
				}
			}
			System.out.println("Best Solution found with "+bestComparator+" using brute force of size "+bestI);
			break;
		default:
			System.out.println("Type of problem not recognized");
		}
		
		solution.sortItems();
		System.out.println(solution);
	}
}
