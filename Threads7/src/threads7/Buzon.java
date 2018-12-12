package threads7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buzon {
    
    private String mensaje;

    public Buzon() {
        mensaje = "";
    }
    
    public synchronized void leer(){
        if(mensaje==""){
            try {
                System.out.println("No hay mensaje, esperamos al escritor");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buzon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Leemos el mensaje: "+mensaje);
        mensaje="";
        notify();
    }
    
    public synchronized void escribir(String msj){
        if(mensaje != ""){
            try {
                System.out.println("Mensaje sin leer, esperamos al lector");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buzon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Se escribe el mensaje");
        mensaje = msj;
        notify();
    }
    
}
