import java.util.Iterator;


public class FixedLengthList implements Iterable<Integer>{

	private Integer[] array;
	private int numItems;
	
	
	public FixedLengthList(int size){
		array = new Integer[size];
		numItems = 0;
		
	}
	
	public void add(int item){
		array[numItems++] = item;
	}
	
	public int size(){
		return numItems;
	}
	
	public int get(int index){
		return array[index];
	}
	

	@Override
	public Iterator<Integer> iterator() {
		return new FLLIterator();
	}




	private class FLLIterator implements Iterator<Integer> {

		int currentIndex;
		
		public FLLIterator(){
			currentIndex = 0;
			
		}
		
		
		@Override
		public boolean hasNext() {
			return array[currentIndex] != null;
		}

		@Override
		public Integer next() {
			return array[currentIndex++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	public static void main(String[] args) {
		FixedLengthList test = new FixedLengthList(10);
		
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		
		for(Integer i : test){
			System.out.println(i);
		}
		
		
	}
	
	
	
	
}
