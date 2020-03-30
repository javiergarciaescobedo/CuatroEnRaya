package es.javiergarciaescobedo.cuatroenraya;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
        
        Label labelPuntuacionJ1 = new Label();
        labelPuntuacionJ1.setText("Puntuación J1: ");
        Label labelPuntosJ1 = new Label();
        labelPuntosJ1.setText("0");
        Label labelPuntuacionJ2 = new Label();
        labelPuntuacionJ2.setText("Puntuación J2: ");
        Label labelPuntosJ2 = new Label();
        labelPuntosJ2.setText("0");
        Label labelTurno = new Label();
        labelTurno.setText("Turno: ");
        Label labelTurnoJugador = new Label();
        labelTurnoJugador.setText("1");
        
        HBox hboxControl = new HBox();
        hboxControl.getChildren().add(labelPuntuacionJ1);
        hboxControl.getChildren().add(labelPuntosJ1);
        hboxControl.getChildren().add(labelPuntuacionJ2);
        hboxControl.getChildren().add(labelPuntosJ2);
        hboxControl.getChildren().add(labelTurno);
        hboxControl.getChildren().add(labelTurnoJugador);
        hboxControl.setSpacing(10);
        hboxControl.setAlignment(Pos.CENTER);
                
        vbox.getChildren().add(hboxControl);
        
        Tablero tablero = new Tablero(labelTurnoJugador);
        vbox.getChildren().add(tablero);
        
        root.getChildren().add(vbox);         
    }

    public static void main(String[] args) {
        launch();
    }

}