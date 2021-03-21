package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class User {
	static HashMap<String, HashMap<String, String>> outerMap = new HashMap<>();   //2d hashmap
	static HashMap<String, Integer> Users = new HashMap<>();
	
	
	
//	public User(String user, int year) {
//		registerUser(user, year);		
//	}
//	

	
//	public void registerUser(String user, int year) {               //lager ny UserProfile, legger til i HashMap "Users"
//		UserProfile userProfile = new UserProfile(user, year);
//		Users.put(userProfile.getUsernameInput(), userProfile.getYearInput());
//		//System.out.println(Users);
//	}
	
	
//	public void addGradesToMap(User user, UserProfile userProfile) {
//		userProfile.addGrades("Matte 1", 1);
//	}
//	
	
	public List<String> userInfo() {
		List<String> info = new ArrayList<>();
		for(Map.Entry me : outerMap.entrySet()) {
			System.out.println("Du er logget inn som: "+ me.getKey() + ", med fødselsår: " + Users.get(me.getKey()));
		}
		return info;
	}
	

	public static void main(String[] args) {
		User user = new User("Andreas", 1999);
		UserProfile userProfile = new UserProfile("Andreas", 1999);
		userProfile.addGrades("Matte 1", "A");	
		userProfile.addGrades("Diskmat", "A");
		userProfile.addGrades("Introfaget", "A");
		userProfile.addGrades("Matte 2", "A");	
		userProfile.addGrades("ÆÆÆÆÆÆÆÆÆÆÆ faget", "A");
		userProfile.addGrades("Det teie faget", "A");
//		System.out.println(UserProfile.userGrades);  //04.03.2021   -> Dette fungerer nå. Kan hente HashMapet.
//		System.out.println(Users);

		outerMap.put(userProfile.getUsernameInput(), UserProfile.userGrades);
		User user1 = new User("Ludde", 2000);
		UserProfile userProfile1 = new UserProfile("Ludde", 1999);
		UserProfile.userGrades = new HashMap<String, String>();
		userProfile1.addGrades("Matte 1", "A");	
		userProfile1.addGrades("Diskmat", "E");
		userProfile1.addGrades("Introfaget", "C");
		
//		System.out.println(Users.entrySet());
//		System.out.println(UserProfile.userGrades.entrySet());
		
		outerMap.put(userProfile1.getUsernameInput(), UserProfile.userGrades);
		
		System.out.println(outerMap);
		
//		user.registerUser("Chris", 1999);
//		
//		user.registerUser("Sigurd", 1999);
//		user.registerUser("Skjalg", 1999);
//		user.registerUser("Børve", 1999);
		
		user.userInfo();
		
	}
}
