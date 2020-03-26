package es.javiergarciaescobedo.cuatroenraya;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        
        Label labelPuntuacion = new Label();
        labelPuntuacion.setText("Puntación: ");
        vbox.getChildren().add(labelPuntuacion);
        
        Tablero tablero = new Tablero();
        vbox.getChildren().add(tablero);
        
        root.getChildren().add(vbox);         
    }

    public static void main(String[] args) {
        launch();
    }

}