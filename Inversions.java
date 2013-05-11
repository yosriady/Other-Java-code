import java.util.ArrayList;
import java.util.Arrays;


public class Inversions {
	//an inversion is a pair where i < j but a[i] > a[j]
	//this is an O(n^2) soln
	public static int countInversions(ArrayList<Integer> intArray){
		
		int count = 0;
		
		for(int i = 0; i<intArray.size();i++){
			
			for(int j = i; j < intArray.size();j++){
				if((i < j) && (intArray.get(i) > intArray.get(j))){
					count++;
				}	
			}
		}
		
		return count;
	}
	
	
	
	//this method returns a permutation of the original list 
	//containing exactly numInversions inversions
	//input is a sorted list with zero inversions
	
	public static ArrayList<Integer> createInversions(ArrayList<Integer> intArray, int numInversions){
		
		int size = intArray.size();
		
		if(numInversions-1 >= size){
			System.err.println("Invalid number of Inversions!");
		}
		
		
		//reverse bubble sort
		for(int i=0;i<numInversions;i++){
			int temp = intArray.get(i);
			intArray.set(i, intArray.get(i+1));
			intArray.set(i+1, temp);
		}
		
		return intArray;
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList(Arrays.asList(1, 2, 5,3,10));
		ArrayList<Integer> list2 = new ArrayList(Arrays.asList(1, 2, 10, 5,3));
		ArrayList<Integer> list3 = new ArrayList(Arrays.asList(1, 2, 3, 4,5));

		
		System.out.println(countInversions(list2));
		System.out.println(countInversions(createInversions(list3, 3)));
		
		
	}

}
