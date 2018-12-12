/*
Realiza un programa en java que execute tres fíos de forma concurrente. Un de eles debe sumar os
números pares del 1 ao 1000, outro os impares, e outro, os que terminen en dous ou en tres.
 */
package threads4;

public class Threads4 extends Thread {

    public Threads4(String nombre) {
        super(nombre);
    }
    Thread thread;

    @Override
    public void run() {
        int suma = 0;       //Variable para almacenar la suma

        thread = new Threads4("SeriePares");
        System.out.println(getName() + " ha comenzado");    //Indicamos que empieza el thread
        for (int i = 0; i <= 10; i += 2) {  //Bucle que suma los pares
            suma = suma + i;
        }

        System.out.println("Serie Par: " + suma);   //Imprimimos el resultado
        suma = 0;   //Reseteamos la variable

        thread = new Threads4("SerieImpares");  //Indicamos que empieza el thread
        System.out.println(getName() + " ha comenzado");
        for (int i = 1; i <= 10; i += 2) {  //Bucle que suma los impares
                 suma = suma + i;

        }
        System.out.println("Serie Impar: " + suma); //Imprimimos la suma
        suma = 0;   //Reseteamos la variable

        thread = new Threads4("Serie2-3");
        System.out.println(getName() + " ha comenzado");    //Indicamos el comienzo
        for (int i = 0; i <= 10; i++) { //Bucle para sumar
            int digito = i % 10;    //Cogemos el ultimo digito del numero
            if (digito == 2 || digito == 3) {   //Comprobamos si es un 2 o 3
                suma = suma + i;    //Lo sumamos
            }
        }
        System.out.println("Serie 2-3: " + suma);   //Imprimimos la sma

    }

    public static void main(String[] args) {

        new Threads4("HiloPadre").start();
    }

}
