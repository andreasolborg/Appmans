//jeg må lage en løkke eller en metode som kan hente ut dette fra UserGrades: navn, fag = karakter. dette skal skje når man registrerer nye fag
//så må jeg kjøre metodene som legger de til hashmapet, (legg til fag knappen)
//deretter må dette hashmappet skrive til fil, og overwrite det som står der fra før.



package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class SaveHandler {

	static List<String> gradesList = new ArrayList<String>();
	static String[] gradeSplitter;
	static HashMap<String, String> outerMap1 = new HashMap<>();
	
	public final static String SAVE_FOLDER = "";

	public static void loadData(String filename) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(
				new FileReader(getFilePath(filename)));
	}

	
	public static void saveUserData(String filename) throws FileNotFoundException {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(getFilePath(filename), true));
			BufferedReader br = new BufferedReader(
					new FileReader(getFilePath(filename)));
			
			for(Map.Entry me : UserProfile.Users.entrySet()) {
				bw.append(me.getKey() + ";" + me.getValue()+"\n");
			}
			
//			String s;
//			while((s = br.readLine()) != null) {
//				bw.write(s + "\n");
//			}
			br.close();
			bw.close();
		}catch(Exception ex) {
			return;
		}
}
	
	
	public static void saveUserGrades(String filename) throws FileNotFoundException {
		try {
//			System.out.println("UserProfile.outerMap.toString(): --------------- " + UserProfile.outerMap.toString());	
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(getFilePath(filename)));
			BufferedReader br = new BufferedReader(
					new FileReader(getFilePath(filename)));
			
			for(Map.Entry me : UserProfile.outerMap.entrySet()) {	
				bw.write(me.getKey() + ";" + me.getValue().toString().replaceAll("(\\{|\\})", "")+"\n");
//				System.out.println("me.getKey() + me.getValue().toString() -------------->" + me.getKey() + me.getValue().toString());
			}
			
			br.close();
			bw.close();					
			}catch(Exception ex) {
		return;
	}
	}
	
	
	public void saveUserData1(String filename) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(getFilePath(filename))) {
				System.out.println(UserProfile.Users);
//				List<String> info = new ArrayList<>();
				loadToOuterMap(getFilePath(filename));
				for(Map.Entry me : UserProfile.Users.entrySet()) {
					writer.println("Du er logget inn som: "+ me.getKey() + ", med fødselsår: " + UserProfile.Users.get(me.getKey()));
			}
		}
}

	public void saveUserGrades1(String filename) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(getFilePath(filename))),true)) {
//				System.out.println(UserProfile.outerMap);
//				List<String> info = new ArrayList<>();
				for(Map.Entry me : UserProfile.outerMap.entrySet()) {
					writer.println(me.getKey() + "har karakterene: " + UserProfile.outerMap.get(me.getKey()));
			}
		}
}
	 
	public static void loadToOuterMap(String filename) throws FileNotFoundException {
		String[] stringSplitter = null;
		
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(getFilePath(filename), true));
			BufferedReader br = new BufferedReader(
					new FileReader(getFilePath(filename)));
			String s;
			while((s = br.readLine()) != null) {
				stringSplitter = s.split(";");                                 //splitter navn og karakterer
				String [] gradesSplitter = stringSplitter[1].split(", ");
//				System.out.println(stringSplitter[0]);
//				System.out.println(stringSplitter[1].split(", ")[0].split("=")[0]);				   //printer det første faget til hver person								
//				System.out.println(stringSplitter[0]);
				UserProfile userProfile = new UserProfile(stringSplitter[0], 1999);
				UserProfile.outerMap.put(stringSplitter[0], new HashMap<>());
				for(int i = 0; i < gradesSplitter.length; i++) {
//					System.out.println(gradesSplitter[i].split("=")[0]);
//					System.out.println(gradesSplitter[i].split("=")[1]);   //hver brukers karakter
//					UserProfile.addGrades(gradesSplitter[i].split("=")[0], gradesSplitter[i].split("=")[1]);
					UserProfile.outerMap.get(stringSplitter[0]).put(gradesSplitter[i].split("=")[0], gradesSplitter[i].split("=")[1]);
					
//					(stringSplitter[0], UserProfile.addGrades(gradesSplitter[i].split("=")[0], gradesSplitter[i].split("=")[1]));  //må putte et unikt hashmap, ikke userGrades
//					UserProfile.userGrades.c
				}
				

				
				
			}
//			System.out.println(UserProfile.userGrades.toString());
			br.close();
			bw.close();	
		}catch(Exception ex) {
			System.err.println(ex);
			return;
		}
		}
		

	
	private static String getFilePath(String filename) {
		return SAVE_FOLDER + filename + ".txt";
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		loadToOuterMap("UserGrades");
		MainController.isLoggedIn = true;
		MainController.loggedInUser = "Andreas Olborg";
		UserProfile.userGrades = new HashMap<String, String>();   //denne er viktig, uten denne får jeg bugen som oppstod i hashmap
//		UserProfile.addGrades("Diskmat", "C");
//		UserProfile.addGrades("ITGK", "B");
//		UserProfile.addGrades("JAVA", "D");
//		UserProfile.addGrades("Matte 2", "C");
//		UserProfile.outerMap.put(MainController.loggedInUser, UserProfile.userGrades);


		SaveHandler.saveUserGrades("UserGrades");
	}
}