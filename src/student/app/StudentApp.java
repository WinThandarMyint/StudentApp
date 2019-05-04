/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Win Thandar
 */
public class StudentApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Before FXML Loader");
        Parent root = FXMLLoader.load(getClass().getResource("/student/app/views/Main.fxml"));
        System.out.println("After FXML Loader");
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("StudentApp");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
