package threads8;

public class Lebre extends Thread{

    int avance;                // casillas que avanza la lebre 
    int posicion;              // posicion actual
    Control c = new Control(); // objeto control 

    public Lebre(Control c) {
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
        while (c.isFin() == false) {    // mientras ninguno de los 2 llegue al final
            int posicionI = posicion;   // guardamos la posicion inicial
            c.AvanceLebre(this);        // movemos el personaje en funcion de la probabilidad

            if (c.isFin() == false) {   // en caso de que alguen non acabase a carreira, e necesario porque pudo entrar
                //neste bucle e quedar en wait, polo tanto cando o anterior o desperte non se executara nada
                //porque esta tratado no monitor, pero si fara as impresions por pantalla que aparecen a continuacion cos datos da anterior xogada

                if (posicion >= 70) {   //Si llega al final se imprime un mensaje
                    c.setFin(true);
                    System.out.println("¡¡GANA LA LIEBRE!!");
                    
                    break;
                }

                //Imprimimos el movimiento de la lebre
                if (posicionI < posicion) {
                    System.out.println("la liebre avanzo " + c.getAvance() + " posiciones " + "esta en la posicion " + posicion);
                } else if (posicionI > posicion) {
                    System.out.println("la liebre retrasouse " + c.getAvance() + " posiciones " + "esta en la posicion " + posicion);
                } else if (c.getAvance() == 0) {
                    System.out.println("la liebre no avanzo nada");
                }

            }
        }

    }
}
