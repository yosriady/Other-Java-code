import java.util.HashMap;


public class FindUnique {

	/**
	 * CS2020 dg = find the only element in an array that only happens once, 
	 * every other is a pair using a hash table in O(n)	 
	 */
	
	
	public static void main(String[] args) {
		
		Integer[] a = {2, 2, 1, 3 ,1, 4, 3}; 
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		
		for(int i = 0;i < a.length; i++){
			
			if(hm.get(a[i])==null){
				hm.put(a[i], 1);
			} else if(hm.get(a[i])==1){
				hm.remove(a[i]);
			} else {
				System.err.println("Other case");
			}
			
		}
		
		System.out.println(hm.keySet().toString());
		

	}

}
