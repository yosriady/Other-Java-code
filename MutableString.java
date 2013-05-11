
public class MutableString {

	char[] m_string;//stored string
	
	private Node root;//root node
	
	private class Node{ // tree node class
		Integer key;
		char val;
		Node left;
		Node right;

		public Node(Integer key, char val){
			this.key = key;
			this.val = val;
		}
	}
	
	//constructor
	public MutableString(String s){
		
		//converts the string to a charArray
		m_string = s.toCharArray();
		
		//then we create the binary tree
		//by inserting the characters one by one, index smallest on the left
		//so we can read the string by performing an in-order walk
		
		for(int i = 0;i<m_string.length;i++){
			insert(i,m_string[i]);
			
		}
		
	}

	
	//insert character c at index i
	public void insert(int i, char c){
		root = insert(root,i,c);
	}
	
	private Node insert(Node x, Integer key, char val)
	{
		// Change keyÕs value to val if key in subtree rooted at x.
		// Otherwise, add new node to subtree associating key with val.
		if (x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = insert(x.left, key, val);
		else if (cmp > 0) x.right = insert(x.right, key, val);
		else x.val = val;
		return x;
	}
	
	//get gets character at index i
	public char get(int i){
		return get(root, i);
	}
	
	
	public char get(Node node, Integer i){

		
		if(node==null){
			System.out.println("Not found!");
			return '-';
		}
		
	
		int cmp = i.compareTo(node.key);
		
		if(cmp > 0){
			return get(node.right,i);
		} else if(cmp < 0){
			return get(node.left,i);
		} else {
			return node.val;
		}

	}
	

	

	// reverse
	// performs a post-order-walk, from largest index to smallest
	
	public String reverse(){
		return reverse(root);
	}
	
	
	
	public String reverse(Node node){
		
		
		if(node==null){
			return "";
		}
		
		return reverse(node.left) + reverse(node.right) + node.val;
	}
	
		
	public char first(){
		return min(root).val;
	}
	
	public Node min(Node node){
		
		if(node.left==null){
			return node;
		} else {
			return min(node.left);
		}

	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MutableString test = new MutableString("d");
		System.out.println(test.get(0));
		test.insert(0, 'c');
		System.out.println(test.get(0));
		test.insert(1, 'b');
		System.out.println(test.get(1));
		test.insert(2, 'a');
		

		System.out.println(test.first());
		System.out.println(test.reverse());
		
		
	}

}
