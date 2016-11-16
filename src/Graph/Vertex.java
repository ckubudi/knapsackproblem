package Graph;
import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
		List<Edge> adj;

        public Vertex(T content) {
            this.adj = new ArrayList<Edge>();
        }

        void addAdj(Edge e) {
            adj.add(e);
        }
}
