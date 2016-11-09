package knapsack.main;

/**
 * Generic Item class for knapsack problem
 * 
 * @author ckubudi
 *
 */
public class Item {
	private double weigth;
	private double value;
	private double ratio;
	
	public Item (double weigth, double value){
		this.weigth=weigth;
		this.value=value;
		ratio=value/weigth;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public Double getRatio() {
		return ratio;
	}
}
