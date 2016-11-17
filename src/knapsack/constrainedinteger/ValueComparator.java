package knapsack.constrainedinteger;

import java.util.Comparator;

import knapsack.main.Item;

public class ValueComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		Integer v1 = o1.getValue();
		Integer v2 = o2.getValue();
		return v2.compareTo(v1);
	}
}
