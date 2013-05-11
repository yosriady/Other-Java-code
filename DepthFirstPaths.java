import java.util.Stack;

//uses depth-first search to find paths 
//to all the vertices in a graph that are connected to a given start vertex s
public class DepthFirstPaths {

	public boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	private int count;
	
	public DepthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for (int w : G.adj(v)){
			if (!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v)	{ //if the two vertices are even connected
		return marked[v]; 
	}
	
	//While the current vertex is not the source, 
	//trace back its edgeTo and append it into a stack each time. Return the stack.
	public Iterable<Integer> pathTo(int v){
		
		//checks if they are connected, otherwise no paths exist
		
		if(!hasPathTo(v)){
			return null;
		}
		
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x!=s; x = edgeTo[x]){
			path.push(x);
		}
		
		path.push(s);
		return path;
		
	}
	
	
	public int count(){ //number of marked items
		return count; 
	}
	
	
	public boolean test_connected(){
		return count == marked.length;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
