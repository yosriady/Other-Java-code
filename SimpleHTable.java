import java.util.LinkedList;


public class SimpleHTable {

	
	LinkedList<Character>[] table;
	
	SimpleHTable(int size){
		table = new LinkedList[size];	
		for(int i = 0; i<size;i++){
			table[i] = new LinkedList<Character>();//initializes empty linked list to cells
		}
		
	}
	
	public int hash(char c){
		return (11*c) % 5;
	}
	
	
	public void put(char c){
		table[hash(c)].add(c);//adds character to a cell's linked list
	}
	
	public int size(){
		int sum = 0;
		
		for(int i = 0; i<table.length;i++){
			sum += table[i].size();
		}
		
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		
		char[] test = "EASYQUESTION".toCharArray();
		SimpleHTable t = new SimpleHTable(5);
		
		
		for(char c : test){
			t.put(c);
		}
			
		System.out.println(t.size()==test.length);
			
			
	}

}
