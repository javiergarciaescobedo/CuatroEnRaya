package es.javiergarciaescobedo.cuatroenraya;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Tablero tablero = new Tablero();
        root.getChildren().add(tablero); 
    }

    public static void main(String[] args) {
        launch();
    }

}