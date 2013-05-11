import java.util.ArrayList;


public class Digraph {
	private final int V;
	private int E;
	private ArrayList<Integer>[] adj;
	
	public int V() { return V; }
	public int E() { return E; }
	
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for (int v = 0; v < V; v++){
			adj[v] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add((Integer)w); //add only one! direction
		E++; //increment number of edges in the digraph
	}
	
	public Digraph reverse(){
		//have a new digraph
		//we iterate through every vertice,
		//at every iteration, add that vertice as the destination of 
		//every vertice in its adjacency list IN THE NEW DIGRAPH
		
		Digraph d = new Digraph(V);
		for(int i = 0; i < V; i++){
			for(int j : adj[i]){
				d.addEdge(j, i);
			}
		}
		return d;
	}
	
	
	
	
	
	
	
	
	
	
	
}
