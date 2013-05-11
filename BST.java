
public class BST {

	
	private Node root;//root node
	
	private class Node{ // tree node
		Integer key;
		String val;
		Node left;
		Node right;
		int N; //node count of subtree rooted here
		
		public Node(Integer key, String val, int N){
			this.key = key;
			this.val = val;
			this.N=N;
			
		}
	}

	
	public int size(){
		return size(root);
	}
	
	private int size(Node node){
		if(node==null){
			return 0;
		} else {
			return node.N; //number of nodes in subtree
		}
	}
	
	
	public String get(Integer key){
		return get(root, key);
	}
	
	private String get(Node node, Integer key){
		
		//if we've reached the leaves without finding the key node 
		if(node==null){
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		//if key is greater than node key
		if(cmp > 0){
			return get(node.right,key);
		} else if(cmp < 0){
			return get(node.left,key);
		} else {
			return node.val;
		}

	}
	
	//Put
	public void put(Integer key, String val){
		root = put(root,key,val);
	}
	
	private Node put(Node node, Integer key, String val){
		
		//then if either the left or right child is null
		//, put a new node there
		if(node==null){
			return new Node(key,val,1);
		}
		
		
		//First check if such a key exists
		int cmp = key.compareTo(node.key);
		
		if(cmp > 0){
			put(node.right,key,val);
		} else if(cmp < 0){
			put(node.left,key,val);
		} else {
			//updates node value if key is found
			node.val = val;
		}
		
		//we update all the Ns of the nodes we passed 
		node.N = 1 + size(node.left) + size(node.right);
		
		return node;

	}
	
	//Min
	public Integer min(){
		return min(root).key;
	}
	
	private Node min(Node node){
		
		if(node.left == null){
			return node;
		} else {
			return min(node.left);
		}
	}
	
	
	//Max
	public Integer max(){
		return max(root).key;
	}
	
	private Node max(Node node){
		
		if(node.right == null){
			return node;
		} else {
			return max(node.right);
		}
	}
	

	
	//Definition of floor: the largest key in the BST less than or 
	//equal to the key being searched aka predecesor
	
	public Integer floor(Integer key){
		return floor(root, key).key;
	}
	
	private Node floor(Node node ,Integer key){
		if(node == null){
			return null;
		}
		
		int cmp = node.key.compareTo(key);
		
		// if the key we're looking for is 
		// less than the key of the current node
		// then we search the left subtree for the floor
		
		if(cmp == 0){
			return node;
		}
			
		if(cmp < 0){
			return floor(node.left, key);
		} 

		Node t = floor(node.right, key);
		//if there is 
		if(t!=null){
			return t;
		} else {
			//returns the current node since it is the closest
			return node;
		}
	}
	

	
	// Definition of celling, the smallest item greater than or
	// equal to a particular key aka successor
	
	//if the key being searched is greater than the current node key,
	//we search the right subtree
	public Integer ceiling(Integer key){
		return ceiling(root, key).key;

	}
	
	private Node ceiling(Node node, Integer key){
		
		int cmp = node.key.compareTo(key);
		
		if(cmp == 0){
			return node;
		} 
		
		if(cmp > 0){
			return ceiling(node.right, key);
		}
		
		Node t = ceiling(node.left, key);
		
		//if there is an element greater than or equal to on the left
		//subtree
		
		if(t!=null){
			return t;
		} else {
			return node;
		}
		
	}
	
	
	//Select
	public Node select(Integer key){
		return select(root, key);
	}
	
	private Node select(Node node, Integer k){
		
		if(node==null){
			return null;
		}
		
		Integer t = size(node.left);
		
		if(node.N==k){
			return node;
		} else if(t > k){
			return select(node.left,k);
		} else {//if node.left.N < k
			return select(node.right, k - t - 1);
		}
	}
	
	
	// Rank 
	// the number of keys smaller than a particular key
	
	
	public int rank(Integer key){
		
		return rank(root, key);
	}
	
	private int rank(Node node, Integer key){
		
		if(node==null){
			return 0;
		}
		
		
		int cmp = key.compareTo(node.key);
		
		//if current node key is greater than key
		//we search left subtree
		if(cmp < 0){
			return rank(node.left,key);
		} else if(cmp > 0){
			//if current node key is less than key
			// we add left rank and search right subtree
			return 1 + size(node.left) + rank(node.right,key);
		} else {
			return size(node.left);
		}
	}
	
	
		//write code that 
	
	

	
	
	
	
	
	public static void main(String[] args) {
	
		
	
	
	
	}
	
	
	

}
