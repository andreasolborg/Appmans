package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserProfile {
	
	private static String usernameInput;
	private int yearInput;
	static String fileName = "saver.txt";
	
	static HashMap<String, HashMap<String, String>> outerMap = new HashMap<>();   //2d hashmap
	static HashMap<String, Integer> Users = new HashMap<>();
	static HashMap<String, String> userGrades = new HashMap<>();
	
	public static void makeGradeMap(HashMap userGrades) { //prøver lage metode slik at hvert student sine karakterer er et eget objekt. så må jeg endre hashmap til (username, object (der object er hashmap)))
		
	}

	public UserProfile(String usernameInput, int yearInput) {
		validUsername(usernameInput, yearInput);
		this.usernameInput = usernameInput;
		this.yearInput = yearInput;
	}
	
	public UserProfile() {  //tom konstruktør
		
	}
	
	public static void addGrades(String courseName, String grade) {   //prøve å legge til karakterer i et eget hashmap tilegnet brukeren som er innlogget
		if(!courseName.isEmpty() && !grade.isEmpty()) {
			Course course = new Course(courseName, grade);						//lager et course med input som brukeren sender inn
			userGrades.put(course.getCourseName(), course.getGrade());	    	//legger det til i hashmappet.
			
		}
		return;
		
	}
	
	public static void registerUser(String user, int year) throws FileNotFoundException {               //lager ny UserProfile, legger til i HashMap "Users"	
		UserProfile userProfile = new UserProfile(user, year);
		Users.put(userProfile.getUsernameInput(), userProfile.getYearInput());
		SaveHandler.saveUserData("UserData");	
	}
	
	

	public void validUsername(String user, int year) {	     //valideringsmetode
		if (user.isEmpty() || user.isBlank() || year <= 0) {
			throw new IllegalArgumentException("år må være >= 0 og brukernavn ikke blank");
			}
	}
	
	
	//Setters og Getters
	public static String getUsernameInput() {
		return usernameInput;
	}

	public void setUsernameInput(String usernameInput) {
		this.usernameInput = usernameInput;
	}

	public int getYearInput() {
		return yearInput;
	}

	public void setYearInput(int yearInput) {
		this.yearInput = yearInput;
	}
	
	
	public static HashMap<String, String> getUserGrades() {
		return userGrades;
	}

	public static void setUserGrades(HashMap<String, String> userGrades) {
		UserProfile.userGrades = userGrades;
	}

	
	public static void main(String[] args) {
		UserProfile userProfile = new UserProfile("Andreas", 1999);
		userProfile.addGrades("Matte 1", "a");
		userProfile.addGrades("Diskmat", "b");
		userProfile.addGrades("Introfaget", "v");
		System.out.println(userGrades);
		System.out.println(userProfile.getUsernameInput());
		
		
	}
}
