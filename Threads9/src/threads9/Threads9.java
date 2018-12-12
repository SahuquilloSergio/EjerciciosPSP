package threads9;

public class Threads9 {

    public static void main(String[] args) {

        Ascensor a = new Ascensor();
        
        Planta p1 = new Planta(a, 1);
        Planta p7 = new Planta(a, 1);
        Planta p3 = new Planta(a, 1);
        Planta p8 = new Planta(a, 1);
        
        p1.start();
        p7.start();
        p3.start();
        p8.start();
    }
    
}
