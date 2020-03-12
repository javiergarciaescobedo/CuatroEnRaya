package es.javiergarciaescobedo.cuatroenraya;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Tablero extends Pane {     
            
    CuatroEnRaya cuatroEnRaya;
    final byte VELOCIDAD_CAIDA = 4;
            
    public Tablero() {
        cuatroEnRaya = new CuatroEnRaya();
        
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
            colocarFicha(columna);
        });
    }
    
    private void colocarFicha(int columna) {
        Ficha ficha = new Ficha(cuatroEnRaya.turnoJugador);
//        ficha.setLayoutX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
        ficha.setLayoutX((columna + 0.5) * Ficha.TAM_FICHA);
        ficha.setLayoutY(Ficha.TAM_FICHA / 2);
        this.getChildren().add(ficha);
        
        int filaColocar = cuatroEnRaya.getFilaColocar(columna);
        
        this.caerFicha(ficha, filaColocar);
        
        cuatroEnRaya.colocarFicha(filaColocar, columna);
        cuatroEnRaya.mostrarConsola();
        // Chequeo horizontal
        int numFichasRayaHoriz = cuatroEnRaya.getNumFichasRaya(filaColocar, columna, 0, 1);
        // Chequeo vertical
        int numFichasRayaVert = cuatroEnRaya.getNumFichasRaya(filaColocar, columna, 1, 0);
        // Chequeo diagonal 1
        int numFichasRayaDiag1 = cuatroEnRaya.getNumFichasRaya(filaColocar, columna, -1, 1);
        // Chequeo diagonal 2
        int numFichasRayaDiag2 = cuatroEnRaya.getNumFichasRaya(filaColocar, columna, 1, 1);
        System.out.println("numFichasRayaHoriz: " + numFichasRayaHoriz);
        System.out.println("numFichasRayaVert: " + numFichasRayaVert);
        System.out.println("numFichasRayaDiag1: " + numFichasRayaDiag1);
        System.out.println("numFichasRayaDiag2: " + numFichasRayaDiag2);
        
        if(cuatroEnRaya.isGanador(numFichasRayaHoriz, numFichasRayaVert, 
                numFichasRayaDiag1, numFichasRayaDiag2)) {
            System.out.println("Ha ganado");
        }
                
        cuatroEnRaya.cambiarJugador();
    }
    
    private void caerFicha(Ficha ficha, int filaColocar) {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                ficha.setLayoutY(ficha.getLayoutY() + VELOCIDAD_CAIDA);
            })
        );
        
        timeline.setCycleCount((Ficha.TAM_FICHA * (filaColocar+1)) / VELOCIDAD_CAIDA);
        timeline.play();
        timeline.setOnFinished((ActionEvent ae) -> {
            System.out.println("Ficha colocada en su sitio");
        });
    }
    
}
