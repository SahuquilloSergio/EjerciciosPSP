package threads9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Planta extends Thread{

    Ascensor ascensor;
    int planta;
    
    public Planta(Ascensor asc, int num){
        super();
        ascensor = asc;
        planta = num;
    }
    @Override
    public void run(){
        try {
            ascensor.llamada(planta);
        } catch (InterruptedException ex) {
            Logger.getLogger(Planta.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
