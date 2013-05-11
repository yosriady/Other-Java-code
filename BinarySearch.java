package sg.edu.nus.cs2020;

public class BinarySearch {

	public static int search(int[]a, int key){
		int start = 0;
		int end = a.length-1;
		int mid = 0;
		
		
		while (start<=end){
			mid = start + (end-start)/2;
			
			if(start==end){//error check if element not in array
				return -1;
			}else if(a[mid] < key){
				start = mid+1;
			} else if (a[mid]==key){
				return mid;
			} else {//if a[mid] > key
				end = mid-1;
				
			}
		}
		
		return mid;
		
	}
	
	
	
	
	
	
	public static void main(String[] args){
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		int[] b = {0,1,2,3};
		
		System.out.println(search(b,7));
		System.out.println(search(a,5));
		System.out.println(search(a,8));
		
	}
	
	
	
	
	
	
}
