package threads6;

public class main {

    public static void main(String[] args) {
        
        
        Monitor p = new Monitor("Productor");
        Monitor c = new Monitor("Consumidor");
        
        p.start();
        c.start();
    }

}
