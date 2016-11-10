package Graph;
public class Edge {
    Vertex origem;
    Vertex destino;
	int capacity ;
    int cost ;

	public Edge(Vertex origem, Vertex destino, int cost, int capacity ) {
        this.origem = origem;
        this.destino = destino;
        this.capacity = capacity ;
        this.cost = cost ;
    }

	public Edge(Vertex origem, Vertex destino){
		this(origem, destino, 1, 1);
	}
	
	public Vertex getOrigem() {
		return origem;
	}

	public void setOrigem(Vertex origem) {
		this.origem = origem;
	}

	public Vertex getDestino() {
		return destino;
	}

	public void setDestino(Vertex destino) {
		this.destino = destino;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}


    
    
}

