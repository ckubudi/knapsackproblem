package knapsack.main;

import knapsack.constrainedinteger.ConstrainedIntegerKnapsack;
import knapsack.fractional.FractionalKnapsack;
import knapsack.fractional.FractionalSolution;
import knapsack.integer.IntegerKnapsack;

public class Main {
	public static void main(String[] args) {
		Instance instance = new Instance("instances/Data-1000-Q1.txt");
		//System.out.print(instance);
		Solution solution = ConstrainedIntegerKnapsack.getMaxSubset(instance);
		//Solution solution = IntegerKnapsack.getMaxSubset(instance.getItems(), instance.getCapacity());
		System.out.println(solution);
	}
}
