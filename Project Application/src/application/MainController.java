package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController implements Initializable{
	
	public boolean isLoggedIn;
	public static String loggedInUser;
	
	@FXML
	public Button loginButton;
	@FXML
	public Button registerButton;
	@FXML
	private TextField usernameInput;	
	@FXML
	private TextField yearInput;	
	/**
	 * informasjon om brukeren, navn og f�dsel�r
	 */
	private UserProfile userProfile;

	@FXML	
	private AnchorPane rootPane;
	@FXML
	private Text loggedInText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public Text getLoggedInText() {
		return loggedInText;
	}

	public void setLoggedInText(Text isLoggedIn) {
		this.loggedInText = isLoggedIn;
	}
	
	private void tester() {
		if(isLoggedIn) {
			System.out.println("Logged in!!!!!");
		}
		else {
			System.out.println("Ikke logged inn!");
		}
	}

//		return usernameInput;
	public String test() {
		return usernameInput.getAccessibleText();
	}

	

	public void verifyLoginCredentials(ActionEvent event) throws IOException {
		int year = Integer.parseInt(yearInput.getText());
		String username = usernameInput.getText();
		isLoggedIn = false;
		BufferedReader br = new BufferedReader(new FileReader("UserData.txt"));
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			line = line.split(";")[0];
//			System.out.println(line);   printer ut navn på alle som er registrert
			if(line.equals(username)){
				isLoggedIn = true;
				loggedInUser = username;
				loggedInText.setText("Velkommen " + loggedInUser);
//				break;
			}
		}
		if (!isLoggedIn) {
			loggedInText.setText("Ikke registrert bruker");
		}
		

	}	
	
	
	public void registerUser(ActionEvent event) throws FileNotFoundException {
		int year = Integer.parseInt(yearInput.getText());
		String username = usernameInput.getText();
		UserProfile.registerUser(username, year);
		loggedInText.setText("Velkommen " + username);
		isLoggedIn = true;
	}

	
	
	public void openGradesWindow(ActionEvent event) throws IOException {
		if(isLoggedIn) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("grades.fxml"));
		Parent mainRoot = loader.load();
		Scene mainScene = new Scene(mainRoot);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(mainScene);
		window.show();
		}else {
			loggedInText.setText("Du må logge inn først.");
		}
	}
	

	public void openAvgWindow(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("average.fxml"));
		Parent mainRoot = loader.load();
		Scene mainScene = new Scene(mainRoot);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(mainScene);
		window.show();
	}
	
	public void openSettings(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
		Parent mainRoot = loader.load();
		Scene mainScene = new Scene(mainRoot);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(mainScene);
		window.show();
	}
	

}
