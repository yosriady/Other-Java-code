
public class CountComponents {

	
	private boolean[] marked; //boolean vals of marked nodes
	private int[] id; //refers to the ids of connected components
	private int count; //number of connected components
	
	public CountComponents(Graph G){
		
		marked = new boolean[G.V()];
		id = new int[G.V()]; //initializes array, max num is if every vertice is alone
		
		//now we want to dfs every node, and every time we encounter a node outside 
		//of an existing connected component, we increment count and id
		
		for(int i = 0 ; i< G.V() ; i++){
			if(!marked[i]){
				dfs(G,i);
				count++;
			}
		
		}
		
		
		
		
	}
	
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)){
			if (!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	
	
	public boolean connected(int v, int w)
	{ return id[v] == id[w]; }
	
	public int id(int v)
	{ return id[v]; }
	
	public int count()
	{ return count; }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
