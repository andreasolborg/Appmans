package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class SaveHandler {

	public final static String SAVE_FOLDER = "";

	public static void loadData(String filename) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(
				new FileReader(getFilePath(filename)));
	}

	public void addDataToList() {
		
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
		
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(getFilePath(filename), true));
			BufferedReader br = new BufferedReader(
					new FileReader(getFilePath(filename)));	
			for(Map.Entry me : UserProfile.outerMap.entrySet()) {
				bw.append(me.getKey() + ";" + me.getValue()+"\n");
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
				load(getFilePath(filename));
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
	 
	public void load(String filename) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File(getFilePath(filename)))) {   //usikker på om dette funker
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
	}
	
	private static String getFilePath(String filename) {
		return SAVE_FOLDER + filename + ".txt";
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
	}
}