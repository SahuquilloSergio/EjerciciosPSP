/*
Escribe unha clase que cree dous fíos e force que a escritura do segundo sexa sempre anterior á
escritura por pantalla do primeiro.
 Exemplo de ejecución:
 Ola, son o fío número 2
 Ola, son o fío número 1

 */
package threads5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Threads5 extends Thread {

    public Threads5(String nombre) {
        super(nombre);
    }

    Thread thread;
    static int count = 1;

    @Override
    public void run() {
        try {
                //Bucle para crear los hilos
            while (count <= 2) {
                count++;

                thread = new Threads5("" + count);  //Creacion del hilo

                thread.start(); //Iniciamos el hilo
                thread.join();  //Lo sincronizamos

                for (int i = 0; i < 1; i++) {   //Escribe por pantalla
                    System.out.println("Soy el thread " + getName());
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new Threads5("" + count).start();

    }

}
