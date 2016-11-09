package knapsack.fractional;

import java.util.Comparator;

import knapsack.main.Item;

/**
 * Compares using the ratio (default descending order)
 * 
 * @author ckubudi
 *
 */
public class FractionalComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o2.getRatio().compareTo(o1.getRatio());
	}
	
}
