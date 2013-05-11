import java.util.Arrays;


public class MergeSort {

	static Integer[] aux;
	
	public static void sort(Integer[] a){
		
		aux = new Integer[a.length];
		sort(a, 0, a.length-1);
		
	}

	
	public static void sort(Integer[] a, int lo, int hi){
		
		//Base case
		if(lo>=hi){
			return;
		}

		int mid = lo + (hi-lo)/2;
		
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
		
		
	}
	
	public static void merge(Integer[] a, int lo, int mid, int hi){
		//Merge a[lo..mid] & a[mid+1..hi]
		
		
		//copies contents of the array to a working copy for us to
		//use the two fingered approach on
		
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		
		//then we use the two fingered approach, overwriting the 
		//elements of a
		
		//to refer to the beginning of the first half of the array
		int i = lo;
		
		//to refer to the beginning of the second half of the array
		int j = mid+1;
		
		for(int k=lo; k<=hi;k++){
		//at every iteraction, we're working on lo,lo+1,lo+2...hi,
		//adding one sorted element to the new merged array
			
			if(i>mid){
				//if the first half is empty
				a[k] = aux[j];
				j++;
			} else if(j>hi){
				//if the second half is empty
				
				a[k] = aux[i];
				i++;
			} else if(aux[j] < aux[i]){
				//if the second half has the smaller element
				//put the smaller element in a
				a[k] = aux[j];
				j++;
			} else {
				//if the first hall has the smaller element
				a[k] = aux[i];
				i++;
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = {32,5432,546,67,5648,99,678};
		sort(test);
		
		System.out.println(Arrays.toString(test));
		
	}

}
