package threads8;

public class Threads8 {

    public static void main(String[] args) {
        
       
        Control c=new Control();
        
        //Creamos los objetos de la clase y le pasamos el control
        Tartaruga tartaruga=new Tartaruga(c);
        Lebre lebre=new Lebre(c);
        //Iniciamos ambos objetos
        tartaruga.start();
        lebre.start();
    }
    
}
