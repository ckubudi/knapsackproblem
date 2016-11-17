package knapsack.main;

import knapsack.constrainedinteger.ConstrainedIntegerKnapsack;
import knapsack.fractional.FractionalKnapsack;
import knapsack.fractional.FractionalSolution;
import knapsack.integer.IntegerKnapsack;

public class Main {
	public static void main(String[] args) {
		Instance instance = new Instance("instances/Data-1000-Q4.txt");
		//System.out.print(instance);
		Solution solution =null;
		
		for( int i=1; i <= 19; i+=2){
			Solution tempSolution = ConstrainedIntegerKnapsack.getMaxSubset(instance, i);
			if ( solution == null || tempSolution.getTotalValue() > solution.getTotalValue()){
				solution = tempSolution;
			}
		}
		//Solution solution = IntegerKnapsack.getMaxSubset(instance.getItems(), instance.getCapacity());
		System.out.println(solution);
	}
}
