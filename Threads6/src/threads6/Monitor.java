package threads6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Monitor extends Thread {

    int dinero = 10;
    String nombre;
    boolean ingreso=false;
    boolean retirada=false;

    public Monitor(String nombre) {
        super(nombre);
        this.nombre = nombre;
    }
            
    public synchronized void ingresar() throws InterruptedException {
        while(retirada==true){
            wait();
        }
        ingreso=true;
        System.out.println(getName() + " va a realizar un ingreso, dinero actual: " + dinero);
        dinero++;
        System.out.println(nombre + " total: " + dinero + "\n");
        ingreso=false;
        notify();
    }

    public synchronized void retirar() throws InterruptedException {
        while(ingreso==true){
            wait();
        }
        retirada=true;
        System.out.println(getName() + " va a realizar una retirada, dinero actual: " + dinero);
        if (dinero <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }

        dinero--;
        System.out.println(nombre + " total: " + dinero + "\n");
        retirada=false;
        notify();

    }

    @Override
    public void run() {
        if ("Consumidor".equalsIgnoreCase(nombre)) {
            for (int i = 0; i < 5; i++) {
                try {
                    retirar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if ("Productor".equalsIgnoreCase(nombre)) {
            for (int i = 0; i < 5; i++) {
                try {
                    ingresar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
