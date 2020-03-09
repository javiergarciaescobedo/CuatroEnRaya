package es.javiergarciaescobedo.cuatroenraya;

public class CuatroEnRaya {
    
    char[][] cuadricula = new char[6][7];
    char turnoJugador = '1';
    static final char JUGADOR_1 = '1';
    static final char JUGADOR_2 = '2';
    
    public CuatroEnRaya() {
        for(int f=0; f<6; f++) {
            for(int c=0; c<7; c++) {
                cuadricula[f][c] = '.';
            }
        }
    }
    
    public void mostrarConsola() {
        for(int f=0; f<6; f++) {
            for(int c=0; c<7; c++) {
                System.out.print(cuadricula[f][c]);
            }
            System.out.println("");
        }        
    }
    
    public int getFilaColocar(int columnaColocar) {
        int filaColocar = -1;
        // Mientras no hayamos llegado al final y está vacía debajo
        while(filaColocar<5 && cuadricula[filaColocar+1][columnaColocar]=='.') {
            filaColocar++;
        }
        System.out.println("Colocar en fila: " + filaColocar);
        return filaColocar;
    }
    
    public void colocarFicha(int fila, int columna) {
        System.out.println("Colocando ficha en matriz: "+fila+","+columna+","+turnoJugador);
        cuadricula[fila][columna] = turnoJugador;
    }
    
    public void cambiarJugador() {
        if(turnoJugador == JUGADOR_1) {
            turnoJugador = JUGADOR_2;
        } else {
            turnoJugador = JUGADOR_1;
        }
    }
    
}
