//Fixed Length array implementation
public class FriendSet implements ISet{

	private int numFriends;
	private String[] friends;
	
	//empty constructor returns an empty set
	public FriendSet(){
		friends = new String[100];
		
	}
	
	//constructor creates a copy of another set onto friends
	public FriendSet(ISet s){
		friends = new String[100];
		String[] friendArray = s.enumerateSet();
		for(int i = 0; i< s.size();i++){
			friends[i] = friendArray[i];
		}
		numFriends = s.size();
		
		
	}
	
	//contains function
	public boolean contains(String name){
		for(int i = 0; i<numFriends;i++){
			if(friends[i].equals(name)){
				return true;
				
			} 
		}
		
		return false;
		
	}
	
	
	

	public boolean add(String name) throws Exception {
		if(numFriends==100){
			throw new Exception("Set is full!");
		}
		
		
		
		if(contains(name)){
			return false;
		} else {
			friends[numFriends] = name;
			numFriends++;
			return true;
		}
	}


	public ISet intersection(ISet otherSet) {
		ISet result = new FriendSet();
		String[] otherFriends = otherSet.enumerateSet();
		
		for(int i=0;i<size();i++){
			for(int j=0;j<otherSet.size();j++){
				if(friends[i].equals(otherFriends[j])){
					try {
						result.add(friends[i]);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}	
			}
		}

		return result;
		
	}


	public int size() {
		return numFriends;
	}


	public String[] enumerateSet() {
		return friends;
	}
	
	
	
	public static void main(String[] args) {
		
		
	try{
			ISet setA = new FriendSet();
			boolean added = false;
			added = setA.add("Joe"); // Returns true
			added = setA.add("Mary"); // Returns true
			added = setA.add("Sue"); // Returns true
			added = setA.add("Joe"); // Returns false
			int setSize = setA.size(); // Returns 3
			
			
			System.out.println(added);
			System.out.println(setSize);
			System.out.println(setA.enumerateSet()[0]);
			
			
			ISet setB = new FriendSet(setA); // Creates a copy of setA
			added = setB.add("Joe"); // Returns false
			added = setB.add("Leo"); // Returns true
			ISet setC = setA.intersection(setB); // Returns setC containing [Joe, Mary, Sue]
			setSize = setC.size(); // returns 3
			System.out.println(setSize);
			
			
	}catch(Exception e){
		e.printStackTrace();
	}
			
		
	}

}
