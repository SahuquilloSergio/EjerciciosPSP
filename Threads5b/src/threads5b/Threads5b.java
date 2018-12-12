/*
Escribe unha clase que cree dous fíos e force que a escritura do segundo sexa sempre anterior á
escritura por pantalla do primeiro.
 Exemplo de ejecución:
 Ola, son o fío número 2
 Ola, son o fío número 1
*/
package threads5b;

public class Threads5b extends Thread{
    
    
    public Threads5b(String nombre){
        super(nombre);
    }

    
    public static void main(String[] args) {
        //Creamos los hilos
        Thread t1 = new Threads5b("Thread1");
        Thread t2 = new Threads5b("Thread2");
        //Asignamos las prioridades
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(MAX_PRIORITY);
        //Iniciamos los hilos
        t2.start();
        t1.start();
        
    }
    
    public void run(){
        for(int i=0; i<=0; i++){
            System.out.println("Soy el thread " + getName());
        }
    }
    
}
