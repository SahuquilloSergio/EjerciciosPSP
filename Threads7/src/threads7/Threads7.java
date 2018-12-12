/*
Programa que simule un buzón de correo (recurso compartido), de xeito que se
poida leer unha mensaje ou envialo. O buzón soamente pode almacear unha
mensaxe, de xeito que para poder escribir débese atopar baleiro e para poder leer
debe de estar cheo. Crear varios fíos lectores e escritores que manexen o buzón
de xeito sincronizado.
*/
package threads7;

public class Threads7 {

    public static void main(String[] args) {
        Buzon b = new Buzon();
        
        new Lector(b).start();
        new Escritor(b).start();
        
    }
    
}
