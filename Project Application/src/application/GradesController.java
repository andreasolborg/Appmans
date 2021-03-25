package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;





public class GradesController implements Initializable {
	public boolean isLoggedIn = true;
	public String loggedInUser = MainController.loggedInUser;
	static List<String> gradesList = new ArrayList<String>();
	static String[] gradeSplitter;
	static HashMap<String, HashMap<String, String>> outerMap1 = new HashMap<>();
	
	
	@FXML
	public ComboBox<String> course1, course2, course3, course4, course5, course6, course7, course8;
	@FXML
	private TextField courseName1, courseName2, courseName3, courseName4, courseName5, courseName6, courseName7, courseName8; 
	
	ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F");
	

	public void openHomeWindow(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent mainRoot = loader.load();
		Scene mainScene = new Scene(mainRoot);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(mainScene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		System.out.println("Bruker som er logget inn er: "+ MainController.loggedInUser);
		loggedInUser = MainController.loggedInUser;
		isLoggedIn = true;
		try {
			SaveHandler.loadToOuterMap("UserGrades");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("outerMap.toString() " + UserProfile.outerMap.toString());

//		System.out.println(gradesList);       //tester for liste med navn og hashmap(grades)
		
		
		System.out.println(gradesList);
		
		course1.setItems(list);
		course2.setItems(list);
		course3.setItems(list);
		course4.setItems(list);
		course5.setItems(list); //legger til A-F på alle felt
		course6.setItems(list);
		course7.setItems(list);
		course8.setItems(list);
	}
	
	public void addGrades(ActionEvent event) throws FileNotFoundException, IOException {
			
		String str0 = (String)course1.getValue();
		String str1 = (String)course2.getValue();
		String str2 = (String)course3.getValue();
		String str3 = (String)course4.getValue();
		String str4 = (String)course5.getValue();
		String str5 = (String)course6.getValue();
		String str6 = (String)course7.getValue();
		String str7 = (String)course8.getValue();
		
		UserProfile.userGrades = new HashMap<String, String>();   //denne er viktig, uten denne får jeg bugen som oppstod i hashmap
		UserProfile.addGradesInApp(courseName1.getText(), str0);
		
		System.out.println(UserProfile.outerMap.get(loggedInUser));
		
		UserProfile.outerMap.put(loggedInUser, new HashMap<>());
		
		UserProfile.outerMap.get(loggedInUser).put(courseName1.getText(), str0);
		UserProfile.outerMap.get(loggedInUser).put(courseName2.getText(), str1);
		UserProfile.outerMap.get(loggedInUser).put(courseName3.getText(), str2);
		UserProfile.outerMap.get(loggedInUser).put(courseName4.getText(), str3);
		UserProfile.outerMap.get(loggedInUser).put(courseName5.getText(), str4);
		UserProfile.outerMap.get(loggedInUser).put(courseName6.getText(), str5);
		UserProfile.outerMap.get(loggedInUser).put(courseName7.getText(), str6);
		UserProfile.outerMap.get(loggedInUser).put(courseName8.getText(), str7);
		
//		UserProfile.addGradesInApp(courseName2.getText(), str1);
//		UserProfile.addGradesInApp(courseName3.getText(), str2);
//		UserProfile.addGradesInApp(courseName4.getText(), str3);  //lage en løkke for disse
//		UserProfile.addGradesInApp(courseName5.getText(), str4);
//		UserProfile.addGradesInApp(courseName6.getText(), str5);
//		UserProfile.addGradesInApp(courseName7.getText(), str6);
//		UserProfile.addGradesInApp(courseName8.getText(), str7);
//		System.out.println(UserProfile.userGrades.toString());
		
//		UserProfile.outerMap.put(loggedInUser, UserProfile.userGrades);
		
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserData.txt"));
//		out.writeObject(User.Users);
//		new SaveHandler().saveUserGrades("UserGrades");
		
//		System.out.println(outerMap1);
//		SaveHandler.saveUserGrades("UserGrades");
		
		
//		for(int i = 0; i < gradesList.size(); i++) {
//			gradeSplitter = gradesList.get(i).split(";");    //sjekker om brukeren ligger inne i UserGrades
//			System.out.println("Syso gradesplitter[0]" + gradeSplitter[0]);
//			outerMap1.put(gradeSplitter[0], UserProfile.userGrades);
//			if(gradeSplitter[0].equals(loggedInUser)) {
//				System.out.println(gradeSplitter[0]);
//				System.out.println(gradeSplitter[1]);
//				
//			}
//		}
//		outerMap1.toString();
		SaveHandler.saveUserGrades("UserGrades");
		
	}
	
	public static void main(String[] args) {
		
	}
}
