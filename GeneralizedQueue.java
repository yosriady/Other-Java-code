
public class GeneralizedQueue<Item> {
	int numItems;
	Item[] q;
	int first;
	int last;
	
	
	public GeneralizedQueue(int size){
		first = 0;
		last = size-1;
		q = (Item[]) new Object[last];//H4x
	}
	
	public int size(){
		return numItems;
	}	
	
	public boolean isEmpty(){
		return numItems == 0;
	}
	
	public void insert(Item i){
			q[first] = i;
			first++;
			numItems++;

	}
	
	public Item delete(){
		Item temp = q[0];

		for(int i=0;i<numItems;i++){
			
			q[i] = q[i+1];
		}
		
		numItems--;
		return temp;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		GeneralizedQueue<Integer> test = new GeneralizedQueue<Integer>(5);
		test.insert(1);
		test.insert(2);
		test.insert(3);
		
		System.out.print(test.delete());
		System.out.print(test.delete());
		
	}
	
	
	
}
