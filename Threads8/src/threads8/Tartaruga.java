package threads8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tartaruga extends Thread {

    private int avance;         // casillas que avanza
    private int posicion;       // posicion en la que esta tartaruga 
    Control c = new Control();  // objeto control

    public Tartaruga(Control c) {
        this.c = c;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Control getC() {
        return c;
    }

    public void setC(Control c) {
        this.c = c;
    }

    @Override
    public void run() {

        while (c.isFin() == false) { // comprobamos si alguno llego a la meta
            int posicionI = posicion;
            c.Avancetartaruga(this); // llamamos al metodo para mover la tartaruga
            if (c.isFin() == false) { // comprobamos que no llego a la meta
                if (posicion >= 70) { // si llega a la meta lo indicamos
                    c.setFin(true);
                    System.out.println("¡¡GANA LA TORTUGA!!");
                   
                    break;
                }

                
                //Imprimimos el movimiento de la tartaruga
                if (posicionI < posicion) { 
                    System.out.println("la tartaruga avanzu " + c.getAvance() + " posiciones " + "esta en la posicion " + posicion);
                } else if (posicionI > posicion) { 
                    System.out.println("la tartaruga retrocede " + c.getAvance() + " posiciones " + "esta en la posicion " + posicion);
                } else if (c.getAvance() == 0) { 
                    System.out.println("la tartaruga no avanzo nada ");
                }

            }
        }

    }
}
