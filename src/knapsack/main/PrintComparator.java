package knapsack.main;

import java.util.Comparator;

public class PrintComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		Integer i1 = o1.getId();
		Integer i2 = o2.getId();
		return i1.compareTo(i2);
	}
}