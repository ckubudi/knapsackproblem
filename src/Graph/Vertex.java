package Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.naming.directory.SearchControls;

public class Vertex {
		private ArrayList<Edge> adj;
		private int id; 
		private EdgeComparator comparator = new EdgeComparator();
		
        public Vertex(int id) {
            this.id=id;
        	this.adj = new ArrayList<Edge>();
        }

        void addAdj(Edge e) {
            adj.add(e);
        }
        
        public ArrayList<Edge> getAdj (){
        	return adj;
        }
        
        public int getId(){
        	return id;
        }
        
        public void sortAdjById(){
        	Collections.sort(adj, comparator);
        }
        
        /**
         * Check if this vertex is adjacent to vertex with given idDest.
         * Considers that adjacency list is sorted
         * 
         * @param idDest
         * @return
         */
        public boolean isAdjToBin (int idDest){
        	return search(idDest, 0, adj.size()-1);
        }
        
        private boolean search (int idDest, int low, int high){
        	while (high >= low){
        		int middle = (low + high)/2;
        		int id = adj.get(middle).getDestino().getId();
        		if ( id == idDest ){
        			return true;
        		} else if (id < idDest) {
        			return search(idDest, middle+1, high);
        		} else {
        			return search(idDest, low, middle-1);
        		}
        	}
        	return false;
        }
        
        private class EdgeComparator implements Comparator<Edge>{
			@Override
			public int compare(Edge o1, Edge o2) {
				Integer id1 = o1.getDestino().getId();
				Integer id2 = o2.getDestino().getId();
				
				return id1.compareTo(id2);
			}
        	
        }
}
