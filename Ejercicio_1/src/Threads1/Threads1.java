/*
Programa en Java que cree dous fíos e os executa. Os fíos escriben dez veces un número de
iteración do bucle e seu nome. En cada iteración, despois de escribir o seu nome, se bloquean
durante un tempo aleatorio de segundos e después volven a estar dispoñibles para a súa
execución.
*/

package threads1;

public class Threads1 {

    public static class ThreadEjercicio1 extends Thread {

        public ThreadEjercicio1(String name) {
            super(name);
        }

        /**
         * Ejecucion do fios
         */
        @Override
        public void run() {
            /**
             * bucle que escribira 10 veces
             */
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + this.getName());
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException ex) {
                    System.out.println("Error: " + ex);
                }
            }
            //Fin do thread
            System.out.println(10 + " " + this.getName());
            System.out.println("Termina thread " + this.getName());
        }
    }

    public static void main(String[] args) {
        //Iniciamos los threads
        new ThreadEjercicio1("Pepe").start();
        new ThreadEjercicio1("Tomás").start();
    }

}