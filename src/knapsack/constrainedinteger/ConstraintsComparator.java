package knapsack.constrainedinteger;

import java.util.Comparator;

import knapsack.main.Item;

public class ConstraintsComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		Integer v1 = o1.getNumberOfContraints();
		Integer v2 = o2.getNumberOfContraints();
		return v1.compareTo(v2);
	}
}
