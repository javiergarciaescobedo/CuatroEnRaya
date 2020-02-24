package es.javiergarciaescobedo.cuatroenraya;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Tablero extends Pane {
                    
    public Tablero() {
        for(int i=0; i<8; i++) {
            Line line = new Line(Ficha.TAM_FICHA*i, Ficha.TAM_FICHA, 
                    Ficha.TAM_FICHA*i, Ficha.TAM_FICHA*7);
            this.getChildren().add(line);
        }
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X,Y: " +
                    mouseEvent.getX() + " : " + mouseEvent.getY());
            int clicX = (int)mouseEvent.getX();
            int columna = clicX / Ficha.TAM_FICHA;
            System.out.println("Columna: " + columna);
            colocarFicha(columna, 2);
        });
    }
    
    private void colocarFicha(int columna, int jugador) {
        Ficha ficha = new Ficha(jugador);
//        ficha.setLayoutX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
        ficha.setLayoutX((columna + 0.5) * Ficha.TAM_FICHA);
        ficha.setLayoutY(Ficha.TAM_FICHA / 2);
        this.getChildren().add(ficha);
        
        caerFicha(ficha);
    }
    
    private void caerFicha(Ficha ficha) {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                ficha.setLayoutY(ficha.getLayoutY() + 1);
            })
        );
        timeline.setCycleCount(Ficha.TAM_FICHA * 6);
        timeline.play();
        timeline.setOnFinished((ActionEvent ae) -> {
            System.out.println("Ficha colocada en su sitio");
        });
    }
    
}
