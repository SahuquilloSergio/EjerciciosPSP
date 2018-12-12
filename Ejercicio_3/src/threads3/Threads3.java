/*
Realizar un programa que cree un fío, que a súa vez cree outro fío, e así consecutivamente,
ata un total de cinco fíos. Cada fío debe presentar o seu nome indicando que comenzou, crear
o seu fío fillo e presentar o seu nome 10 veces indicando que se está procesando, esperando
un tempo aleatorio entre 100 e 600 milisegundos entre cada presentación. Cada fío deberá
esperar a que o seu fillo termine antes de presentar o seu último mensaxe indicando o seu
nome e que rematou
*/
package threads3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Threads3 extends Thread{
    public Threads3 (String nombre){
        super (nombre);
    }
    Thread thread;
    static int count = 1;

    @Override
    public void run(){
        try{
            System.out.println("El "+getName() +" ha comenzado");
            /**
             * Bucle que crea los thread y los inicia
             */
            while(count <= 5){
                count ++;
                
                thread = new Threads3("Thread "+count);
                thread.start();
                
                for(int i=0;i<10;i++){
                    //hacemos que el thread escriba algo y se duerma
                    System.out.println(getName()+ " en proceso");
                    sleep((long) ((Math.random() * (600 - 100)) + 100));
                }
                //sincronizamos
                thread.join();
                System.out.println("El "+ getName()+" ha terminado");
            }
       
        
    }   catch (InterruptedException ex) {
            Logger.getLogger(Threads3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Threads3("Thread " + count).start();
        
    }
    
}
