package es.javiergarciaescobedo.cuatroenraya;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ficha extends Group {
    
//    Group group = new Group();
    static final short TAM_FICHA = 40;
        
    // Método constructor
    public Ficha(char numJugador) {
        Circle circle1 = new Circle();
        circle1.setRadius(TAM_FICHA * 0.5);
        this.getChildren().add(circle1);
        
        Circle circle2 = new Circle();
        circle2.setRadius(TAM_FICHA * 0.35);
        this.getChildren().add(circle2);
        
        if(numJugador == CuatroEnRaya.JUGADOR_1) {
            circle1.setFill(Color.RED);
            circle2.setFill(Color.web("0x8B0000"));
        } else {
            circle1.setFill(Color.BLUE);
            circle2.setFill(Color.rgb(0,0,175));
        }
    }
    
}
