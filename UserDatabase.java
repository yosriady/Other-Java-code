
public class UserDatabase{

	//need to keep a key,value store of the name of a user, and his friendset
	//by using a new class called users
	
	User[] users;
	int numUsers;
	
	//constructor
	public UserDatabase(){
		users = new User[500];
		numUsers = 0;
	}
	
	//contains
	public boolean contains(String name){
		for(int i = 0; i<numUsers;i++){
			if(users[i].name.equals(name)){
				return true;
			}
		}
		return false;
	}
	
	//Helper that returns the user object of a specific name
	//public User get(String name){}
		
	//later throw exceptions if the user does not exist

	public boolean addUser(String name) {
		
		if(name.length()==0 || contains(name)){
			return false;
		} else {
			users[numUsers] = new User(name,new FriendSet());
			return true;
		}
		
	}


	public User findMostPopularUser() {
		
		int maxFriends = 0;
		int maxUserIndex = -1;
		
		for(int i = 0;i<numUsers;i++){
			int friendNum = users[i].friends.size();
			if(friendNum > maxFriends){
				maxFriends = friendNum;
				maxUserIndex = i;				
			}
		}

		return users[maxUserIndex];
		
	}
	
	
	public static void main(String[] args) {
		UserDatabase test = new UserDatabase();
		
	}

}
