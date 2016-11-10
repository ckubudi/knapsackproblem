package Graph;
import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
        private T content;
		List<Edge> adj;

        public Vertex(T content) {
            this.adj = new ArrayList<Edge>();
            this.content = content;
        }

        void addAdj(Edge e) {
            adj.add(e);
        }
        
        Edge getAdj(T s) {
        	for(Edge e : adj){
        		if(e.getDestino().getContent() == s)
        			return e ;
        	}
            return null ;
        }
        
        private T getContent() {
			return content;
		}
}
