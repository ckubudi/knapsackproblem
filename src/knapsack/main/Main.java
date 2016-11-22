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
	private static int[] BRUTE_FORCE_SIZES = {1, 5, 10, 15, 20};		

	
	public static void main(String[] args) {
		String filePath = args[0];
		String problem = args[1];
		
		Instance instance = new Instance(filePath);
		Solution solution =null;

		switch (problem){
		
		case "1":
			solution = FractionalKnapsack.getMaxSubset(instance.getItems(), instance.getCapacity()); 
			break;
		case "2":
			solution = IntegerKnapsack.getMaxSubset(instance.getItems(), instance.getCapacity());
			break;
		case "3":
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
			//System.out.println("Best Solution found with "+bestComparator+" using brute force of size "+bestI);
			break;
		default:
			System.out.println("Type of problem not recognized");
		}
		
		System.out.println(solution);
	}
}
