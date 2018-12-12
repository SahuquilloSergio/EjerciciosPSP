package threads8;

public class Control {

    private boolean available = true;   // indica si se puede acceder o no
    private int posibilidad;            // probabilidad de avanzar o retroceder
    private int movimiento;             // numero de casillas que se mueve el personaje
    private boolean fin = false;        // para indicar cuando se acaba el juego(true cuando acaba)

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isFin() {
        return fin;
    }

    public int getPosibilidad() {
        return posibilidad;
    }

    public int getAvance() {
        return movimiento;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    /**
     * metodo sincronizado para mover la tartaruga en funcion de la probabilidad
     *
     * @param t objeto de tipo tartaruga que se mueve
     */
    public synchronized void Avancetartaruga(Tartaruga t) {
        while (available == false) {    // Esperamos si no podemos acceder
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }

        if (fin == false) {     //Se comprueba que no llego al final
            available = false;  // Cambiamos la condicion a false, para que no se acceda
            posibilidad = (int) (Math.random() * 100 - 1); //calculamos un numero para la probabilidad

            if (posibilidad > 0 && posibilidad < 51) { //50% de probabilidad de avanzar 3 casillas
                t.setPosicion(t.getPosicion() + 3);
                movimiento = 3;
            }

            if (posibilidad >= 51 && posibilidad <= 70) { //20% de probabilidad de retroceder 6 casillas 
                if (t.getPosicion() >= 6) {     //Comprobamos si llego a la posicion 6 
                    t.setPosicion(t.getPosicion() - 6);
                    movimiento = 6;
                } else {                        //Si no llego a la posicion 6, lo reposicionamos en 0
                    t.setPosicion(0);
                    movimiento = t.getPosicion();
                }
            }

            if (posibilidad > 70 && posibilidad <= 100) { //30% de probabilidad de avanzar 1 casilla

                t.setPosicion(t.getPosicion() + 1);
                movimiento = 1;
            }

        }
//        available = true;   //liberamos el metodo
        notify();   //avisamos a los otros metodos
    }

    /**
     * metodo sincronizado para mover la lebre en funcion de la probabilidad
     *
     * @param l objeto lebre que movemos
     */
    public synchronized void AvanceLebre(Lebre l) {
        while (available == true) { //esperamos
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
        if (fin == false) {     //Comprobamos que no llego a la meta
            available = false;   //Cambiamos la condicion a false, para que no se acceda
            posibilidad = (int) (Math.random() * 100 + 1); //calculamos un numero para la probabilidad

            if (posibilidad > 0 && posibilidad < 21) { //20% de probabilidad de no avanzar
                movimiento = 0;
            }

            if (posibilidad >= 21 && posibilidad <= 40) { //20% de probabilidad de avanzar 9 casillas
                l.setPosicion(l.getPosicion() + 9);
                movimiento = 9;
            }
            if (posibilidad > 40 && posibilidad <= 51) { //10% de probabilidad de retroceder 12 casillas 
                if (l.getPosicion() >= 12) { // se esta na posicion 12 ou superior retrocedera 
                    l.setPosicion(l.getPosicion() - 12);
                    movimiento = 12;
                } else {    // Comprobamos si llego a la casilla 12, si no, lo reseteamos a 0
                    l.setPosicion(0);
                    movimiento = l.getPosicion();
                }
            }
            if (posibilidad > 51 && posibilidad <= 80) {    //30% de avanzar 1 casilla
                l.setPosicion(l.getPosicion() + 1);
                movimiento = 1;
            }
            if (posibilidad >= 80 && posibilidad <= 100) {  //20% de probabilidad de retroceder 2 casillas 
                if (l.posicion > 2) { //Comprobamos que se movio 2 casillas, si no lo reseteamos a 0
                    l.setPosicion(l.getPosicion() - 2);
                    movimiento = 2;
                } else {
                    l.setPosicion(0);
                    movimiento = l.getPosicion();
                }

            }
            available = true;
            notify(); // notifica a quen este esperando
        }

    }
}
