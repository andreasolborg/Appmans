package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
			Scene mainScene = new Scene(root);
			primaryStage.setTitle("Hjemmeside");
			primaryStage.setScene(mainScene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		launch(args);
		SaveHandler.loadToOuterMap("UserGrades");
		System.out.println(UserProfile.outerMap.toString());
		
//		ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserData.txt"));
//		in.readObject();
//		System.out.println(in);
	}
}
