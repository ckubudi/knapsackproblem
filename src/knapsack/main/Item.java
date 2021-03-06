package knapsack.main;

/**
 * Generic Item class for knapsack problem
 * 
 * @author ckubudi
 *
 */
public class Item {
	private int id;
	private int weigth;
	private int value;
	private double ratio;
	private int numberOfContraints;
	
	public Item (int id, int value, int weigth){
		this.id=id;
		this.weigth=weigth;
		this.value=value;
		this.numberOfContraints=numberOfContraints;
		if ( weigth != 0 ){
			ratio=value * 1.0/weigth;
		} else {
			ratio = Double.MAX_VALUE;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
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

	public int getNumberOfContraints() {
		return numberOfContraints;
	}

	public void setNumberOfContraints(int numberOfContraints) {
		this.numberOfContraints = numberOfContraints;
	}
}
