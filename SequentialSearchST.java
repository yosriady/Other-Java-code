
	public class SequentialSearchST<Key, Value>	{
		
	private Node first; // first node in the linked list
	
	private class Node	{ // linked-list node
		Key key;
		Value val;
		Node next;
			
		public Node(Key key, Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
		
		public Value get(Key key){
			for (Node x = first; x != null; x = x.next)
				if (key.equals(x.key))
				return x.val; // search hit
				return null; // search miss
		}
		
		public void put(Key key, Value val){
			for(Node x = first;x!=null;x=x.next){
				if(key.equals(x.key)){
					//Update existing key if found
					x.val = val; return;
				}
			}
			//Else, put the new key at the front of the linked list
			first = new Node(key,val,first);
		}
	
	
	
	public static void main(String[] args) {
		SequentialSearchST<Integer, Integer> test = new SequentialSearchST<Integer,Integer>();
		test.put(1, 1);
		test.put(0, 1);
		
		
		System.out.println(test.get(0));
		
	}

}
