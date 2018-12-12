package threads9;

public class Ascensor extends Thread{
    
    private int nivel;
    private boolean enMov;
    
    public Ascensor(){
        nivel = 0;
        enMov = false;
    }
    
    
    public synchronized void llamada(int planta) throws InterruptedException {
        if(enMov == true){
            try{
                System.out.println("El ascensor esta en movimiento");
                wait();
            }catch(InterruptedException ex){
                System.out.println(ex);
            }
        }
        System.out.println("El ascensor esta en el piso: "+nivel);
        enMov=true;
        nivel = planta;
        System.out.println("El ascensor llega a la planta: "+nivel+"\n");
        enMov = false;
        notify();
    }
}
