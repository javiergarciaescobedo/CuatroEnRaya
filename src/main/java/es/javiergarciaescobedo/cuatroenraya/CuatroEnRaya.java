package es.javiergarciaescobedo.cuatroenraya;

public class CuatroEnRaya {

    final byte NUM_FILAS = 6;
    final byte NUM_COLUMNAS = 7;
    char[][] cuadricula = new char[NUM_FILAS][NUM_COLUMNAS];
    char turnoJugador = '1';
    static final char JUGADOR_1 = '1';
    static final char JUGADOR_2 = '2';

    public CuatroEnRaya() {
        for (int f = 0; f < NUM_FILAS; f++) {
            for (int c = 0; c < NUM_COLUMNAS; c++) {
                cuadricula[f][c] = '.';
            }
        }
    }

    public void mostrarConsola() {
        for (int f = 0; f < NUM_FILAS; f++) {
            for (int c = 0; c < NUM_COLUMNAS; c++) {
                System.out.print(cuadricula[f][c]);
            }
            System.out.println("");
        }
    }

    public int getFilaColocar(int columnaColocar) {
        int filaColocar = -1;
        // Mientras no hayamos llegado al final y está vacía debajo
        while (filaColocar < 5 && cuadricula[filaColocar + 1][columnaColocar] == '.') {
            filaColocar++;
        }
        System.out.println("Colocar en fila: " + filaColocar);
        return filaColocar;
    }

    public void colocarFicha(int fila, int columna) {
        System.out.println("Colocando ficha en matriz: " + fila + "," + columna + "," + turnoJugador);
        cuadricula[fila][columna] = turnoJugador;
    }

    public void cambiarJugador() {
        if (turnoJugador == JUGADOR_1) {
            turnoJugador = JUGADOR_2;
        } else {
            turnoJugador = JUGADOR_1;
        }
    }

    public int getNumFichasRaya(int fila, int columna, int incFil, int incCol) {
        char jugador = cuadricula[fila][columna];
        int contadorFichasRaya = 1;
        int i = 1;
        try {
            while (cuadricula[fila + (i * incFil)][columna + (i * incCol)] == jugador) {
                contadorFichasRaya++;
                i++;
            }
        } catch (Exception e) {

        }
        // Otra manera de hacer el bucle
//        for(int i=1; cuadricula[fila][columna+i] == jugador; i++) {            
//        }  
        i = 1;
        try {
            while (cuadricula[fila - (i * incFil)][columna - (i * incCol)] == jugador) {
                contadorFichasRaya++;
                i++;
            }
        } catch (Exception e) {

        }
        return contadorFichasRaya;
    }

    public boolean isGanador(int numFichasRayaHoriz, int numFichasRayaVert, int numFichasRayaDiag1, int numFichasRayaDiag2) {
        if (numFichasRayaHoriz >= 4 || numFichasRayaVert >= 4 || numFichasRayaDiag1 >= 4 || numFichasRayaDiag2 >= 4) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isEmpatado() {
        for (int f = 0; f < NUM_FILAS; f++) {
            for (int c = 0; c < NUM_COLUMNAS; c++) {
                if (cuadricula[f][c] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

}
