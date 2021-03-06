package knapsack.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Graph.Edge;
import Graph.Graph;

public class Instance {
	private ArrayList<Item> items;
	private int capacity;
	private Graph constraints;
	
	public Instance(String filePath, boolean loadGraph) {
		loadFromFile(filePath, loadGraph);
	}
	
	private void loadFromFile(String filePath, boolean loadGraph) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    String line = br.readLine() ;
		    String[] lineArr = line.split(" ");
		    int numItems=Integer.parseInt(lineArr[0]);
		    this.capacity = Integer.parseInt(lineArr[1]);
		    this.items = new ArrayList<>(numItems);
		    if (loadGraph){
			    this.constraints = new Graph(numItems);
			    for ( int i = 1; i <= numItems ; i++){
			    	constraints.addVertex(i);
			    }
		    }
		    
		    while ((line = br.readLine()) != null) {
		    	lineArr = line.split(" ");
		    	if ( lineArr.length >= 3){
			    	int currId = Integer.parseInt(lineArr[0]);
			    	Item item = new Item(currId ,Integer.parseInt(lineArr[1]),Integer.parseInt(lineArr[2]));
			    	if (loadGraph){
				    	for ( int indexIt = 3 ; indexIt < lineArr.length ; indexIt++){
				    		constraints.addEdge( constraints.getVertex(currId) , constraints.getVertex(Integer.parseInt(lineArr[indexIt])));
				    	}
			    	}
			    	items.add(item);
		    	}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (loadGraph){
			setNumberOfConstraints();
			constraints.sortAdjacencyLists();
		}
	}
	
	public void setNumberOfConstraints(){
		for( Item item : items ){
			int numEdges =  constraints.getVertex(item.getId()).getAdj().size();
			item.setNumberOfContraints(numEdges);
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
	
	public Graph getConstraints() {
		return constraints;
	}

	public void setConstraints(Graph constraints) {
		this.constraints = constraints;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(items.size()+" "+capacity);
		buffer.append(System.lineSeparator());

		
		//Collections.sort(items, new PrintComparator());
		
		for( Item item : items){
			int id = item.getId();
			buffer.append(id+" "+item.getValue()+" "+item.getWeigth());
			List<Edge> adj = constraints.getVertex(id).getAdj();
			for ( Edge e : adj){
				buffer.append(" "+e.getDestino().getId());
			}
			buffer.append(System.lineSeparator());
		}
		
		
		return buffer.toString();
	}
	
	public boolean isConstrained (Item i1, Item i2){
		return constraints.getVertex(i1.getId()).isAdjToBin(i2.getId());
	}
}
