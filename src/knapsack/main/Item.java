package knapsack.main;

/**
 * Generic Item class for knapsack problem
 * 
 * @author ckubudi
 *
 */
public class Item {
	private int weigth;
	private int value;
	private double ratio;
	
	public Item (int weigth, int value){
		this.weigth=weigth;
		this.value=value;
		if ( weigth != 0 ){
			ratio=value/weigth;
		} else {
			ratio = Integer.MAX_VALUE;
		}
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Double getRatio() {
		return ratio;
	}
}
