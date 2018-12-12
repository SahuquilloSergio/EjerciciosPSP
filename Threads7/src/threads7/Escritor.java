package threads7;

public class Escritor extends Thread{

    Buzon b;
    
    public Escritor(Buzon b){
        super();
        this.b = b;
    }
    
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            b.escribir("Saludos "+i);
        }
    }
}
