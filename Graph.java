import java.util.ArrayList;

public class Graph{
	private final int V; // number of vertices
	private int E; // number of edges
	private static ArrayList<Integer>[] adj; // adjacency lists
	
	public Graph(int V){//V is the number of vertices
		this.V = V; 
		this.E = 0;
		adj = new ArrayList[V]; // Create array of lists.
		for (int v = 0; v < V; v++){ // Initialize all lists
			adj[v] = new ArrayList<Integer>(); // to empty.
		}
		
	}
	
	
	
	public int V() { return V; }
	
	public int E() { return E; }
	
	public void addEdge(int v, int w){
		
		if(v==w){
			throw new IllegalArgumentException("Self loops disallowed.");
		}
		
		if(hasEdge(v,w)){
			throw new IllegalArgumentException("Parallel edges disallowed");
		}
		
		adj[v].add(w); // Add w to v’s list.
		adj[w].add(v); // Add v to w’s list.
		E++;
	}
	
	public ArrayList<Integer> adj(int v)	{ 
		return adj[v]; 
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	
	public boolean hasEdge(int v, int w){
		return contains(adj[v], w) && contains(adj[w], v);
	}
	
	
	public static boolean contains(ArrayList<Integer> a, int x){	
		for(Integer n : a){
			if(n == x){
				return true;
			}
			
		}
		return false;
	}
	
	
	
	

	public static void main(String[] args) {

		Graph g = new Graph(6);

		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 2);
		g.addEdge(3, 4);

		
//		System.out.println(g.V); 
//		System.out.println(g.E);
//		
//		System.out.println(g.adj(0).size());//number of vertices adjacent to vertice 0
//		
		
		DepthFirstPaths s = new DepthFirstPaths(g, 0);
		
		System.out.println(s.hasPathTo(5));

		System.out.println("Connected:" + s.test_connected());
		
		CountComponents c = new CountComponents(g);
		
		System.out.println(c.count());
		System.out.println(c.connected(1, 4));
		System.out.println(c.connected(1, 5));
		
		
		System.out.println(g.hasEdge(4, 1));
		
		
		
	}





}