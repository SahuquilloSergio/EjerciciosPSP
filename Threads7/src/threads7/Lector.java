package threads7;

public class Lector extends Thread{

    Buzon b;
    
    public Lector(Buzon b){
        super();
        this.b = b;
    }
    
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            b.leer();
        }
    }
}
