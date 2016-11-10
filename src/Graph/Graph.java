package Graph;

import java.util.List;
import java.util.ArrayList;

/**
 * Adjacency list graph implementation
 * 
 * @author ckubudi
 *
 */
public class Graph {
	List<Vertex> vertices;
	List<Edge> edges;
	int numberVertices ;
	int numberEdges = 0;

	public Edge getEdge(int id)
	{
		return edges.get(id);
	}

	public Graph(int numVertices) {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		numberVertices = numVertices ;
	}

	public Vertex addVertex(int id) {
		Vertex v = new Vertex(id);
		vertices.add(v);
		return v;
	}

	public Edge addEdge(Vertex origem, Vertex destino) {
		Edge e = new Edge(origem, destino);
		origem.addAdj(e);
		edges.add(e);
		numberEdges++ ;
		return e;
	}
	
	public Edge addEdge(Vertex origem, Vertex destino, int cost, int cap) {
		Edge e = new Edge(origem, destino, cost, cap);
		origem.addAdj(e);
		edges.add(e);
		numberEdges++ ;
		return e;
	}

	public Vertex getVertex(int id) {
		return vertices.get(id);
	}
}