/*
Programa que crea 4 fíos, os executa e espera a que estes terminen. Os fíos escriben 5 veces o
número de iteración do bucle e o seu nome. En cada iteración, despois de escribir o seu nome,
bloquéanse durante un segundo e volven a estar dispoñibles para a súa execución.
*/

package threads2;

public class Threads2 extends Thread {
public Threads2 (String nombre){
    super(nombre);
}

/**
 * Execucion dos thread
 */  
@Override
public void run(){
    for(int i=0; i<5; i++){
        System.out.println(i+" "+getName());
        try{
            //dormimos o thread
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            System.out.println("Error: "+ex);
        }
    }
    System.out.println(5+" "+getName());
    System.out.println("Termina thread "+getName());
}
    public static void main(String[] args) {
        //iniciamos os threads
        new Threads2("Pepe").start();
        new Threads2("Tomas").start();
        new Threads2("Andre").start();
        new Threads2("Diego").start();
    }
    
}
