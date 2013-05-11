
public class StackUnderflow {


//hi handsome =D
	
	
	public int numItems;
	
	public StackUnderflow(){
		numItems = 0;
	}
	

	public boolean test(String s){
		
		if(s.length()==0){
			if(numItems >= 0){
				return false;
			}
		}
		
		if(numItems < 0){
			return true;
		}
		
		
		if(s.substring(0,1).equalsIgnoreCase("u")){
			numItems++;
			return test(s.substring(1,s.length()));
		} else if(s.substring(0,1).equalsIgnoreCase("p")){
			numItems--;
			return test(s.substring(1,s.length()));
		} else {
			return test(s.substring(1,s.length()));
		}			
	}
	
	
	public static void main(String[] args) {
	
		String test1 = "u32pu1u7u10ppu007ppu99pp";
		String test2 = "u1u2u3";
		
		StackUnderflow t = new StackUnderflow();
		System.out.println(t.test(test1));
		
		t = new StackUnderflow();
		System.out.println(t.test(test2));
		
	}
		


}
