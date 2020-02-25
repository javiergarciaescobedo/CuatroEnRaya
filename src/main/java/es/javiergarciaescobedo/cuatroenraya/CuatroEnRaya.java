package es.javiergarciaescobedo.cuatroenraya;

public class CuatroEnRaya {
    
    char[][] cuadricula = new char[6][7];
    
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
    
}
