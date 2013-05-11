
public class Quicksort {

	
	public static void sort(Integer[] a, int lo, int hi){
		//base case
		if(hi<=lo) return;
		
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1,hi);
	}

	private static void exch(Integer[] a, int i, int j)
	{ Integer t = a[i]; a[i] = a[j]; a[j] = t; }
	
	public static int partition(Integer[] a,int lo, int hi){
		
		int i = lo;
		int j = hi+1;
		
		//We arbitrarily decide the first element is the partition
		int p = a[lo];
		
		
		while(hi>lo){
			
			while (a[i+1] < p) {
				i++;
				if (i == hi) {
					break;
				}
			}
			
			//prefix decrement: refers to j--; a[j] 
			while (p < a[--j]){ 
				if (j == lo) {break;}
			}
			if (i >= j) break;
			exch(a, i, j);
			
		}
		
		//Finally, we move the partition to its fixed position
		exch(a, lo,j);
		return j;
	}
	

	public static void main(String[] args) {
		Integer[] test = {123,4,51,36,6453,567,3,6678,7,678,5};
		sort(test,0,test.length-1);
		
		for(int i = 0; i<test.length;i++){
			System.out.print(test[i] + ",");
		}
		

	}

}
