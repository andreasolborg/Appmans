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
	List<String> gradesList = new ArrayList<String>();
	String[] gradeSplitter;
	
	
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
//		System.out.println(gradesList);       //tester for liste med navn og hashmap(grades)
		try {
			BufferedReader br = new BufferedReader(new FileReader("UserGrades.txt"));     //legger til i en liste, dette trenger jeg for å korrigere slik at man kan replace karaktere
			String s;
			while((s = br.readLine()) != null) {
				gradesList.add(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		for(int i = 0; i < gradesList.size(); i++) {
			gradeSplitter = gradesList.get(i).split(";");    //sjekker om brukeren ligger inne i UserGrades
			if(gradeSplitter[0].equals(loggedInUser)) {
				System.out.println(gradesList.get(i));
			}
		}
		
		
		
		
		String str0 = (String)course1.getValue();
		String str1 = (String)course2.getValue();
		String str2 = (String)course3.getValue();
		String str3 = (String)course4.getValue();
		String str4 = (String)course5.getValue();
		String str5 = (String)course6.getValue();
		String str6 = (String)course7.getValue();
		String str7 = (String)course8.getValue();
		
		UserProfile.userGrades = new HashMap<String, String>();   //denne er viktig, uten denne får jeg bugen som oppstod i hashmap
		UserProfile.addGrades(courseName1.getText(), str0);
		UserProfile.addGrades(courseName2.getText(), str1);
		UserProfile.addGrades(courseName3.getText(), str2);
		UserProfile.addGrades(courseName4.getText(), str3);  //lage en løkke for disse
		UserProfile.addGrades(courseName5.getText(), str4);
		UserProfile.addGrades(courseName6.getText(), str5);
		UserProfile.addGrades(courseName7.getText(), str6);
		UserProfile.addGrades(courseName8.getText(), str7);
		
		UserProfile.outerMap.put(loggedInUser, UserProfile.userGrades);
		
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserData.txt"));
//		out.writeObject(User.Users);
//		new SaveHandler().saveUserGrades("UserGrades");
		
		System.out.println(UserProfile.outerMap);
		SaveHandler.saveUserGrades("UserGrades");
		
	}
	
	
}
