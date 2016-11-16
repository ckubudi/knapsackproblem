package knapsack.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Graph.Graph;

public class Instance {
	private ArrayList<Item> items;
	private int capacity;
	private Graph constraints;
	
	public Instance(String filePath) {
		loadFromFile(filePath);
	}
	
	private void loadFromFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    String line = br.readLine() ;
		    String[] lineArr = line.split(" ");
		    int numItems=Integer.parseInt(lineArr[0]);
		    this.capacity = Integer.parseInt(lineArr[1]);
		    this.items = new ArrayList<>(numItems);
		    this.constraints = new Graph(numItems);
		    for ( int i = 1; i <= numItems ; i++){
		    	constraints.addVertex(i);
		    }
		    
		    while ((line = br.readLine()) != null) {
		    	lineArr = line.split(" ");
		    	Item item = new Item(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1]),Integer.parseInt(lineArr[2]));
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
