
public class Unimodal {

	//Find index of the largest value in a unimodal array
	public static int findMax(int[] A,int size){
		int begin = 0;
		int end = size-1;
		int mid;
		
		while(begin < end){
			mid = begin + (end-begin)/2;
			
			if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
				return A[mid];
			} else if(A[mid]>A[mid-1]){
				begin=mid+1;
				
			} else {
				//if the element on the left of mid is bigger
				end = mid -1;
				
			}
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		int[] test = {1,3,4,6,7,8,9,11,6,5,4,3,2};

		System.out.println(findMax(test, test.length));
		
		
	}

}
