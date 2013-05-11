
public class Counter {

	private int count;
	
	void increment(){
		count++;
	}
	
	int tally(){
		return count;
	}
	
	Counter(){
		count = 0;
	}
	
	Counter(int n){
		count = n;
	}
	
	
	
	static public void main(String[] args){
		
		Counter girls = new Counter(2);
		girls.increment();
		girls.increment();
		girls.increment();
		
		
		System.out.println(girls.tally());
	}
	
	
	
}
