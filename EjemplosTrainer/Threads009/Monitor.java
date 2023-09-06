package Threads009;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Monitor {
    private int cont;
    private int order;
   /* public synchronized void inc() { //hilo4  encole , hilo4, hilo6
        for (int i = 0; i < 20000; i++) {
            cont++;
        }
    }*/

    public synchronized int inc() {
        for (int i = 0; i < 20000; i++) {
            cont++;
        }
        return cont;
    }

   /* public synchronized int getCont() {// encolarse hilo1, hilo2
        return cont;
    }*/

    public synchronized void order(int id) {
        while(id != order) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Soy el hilo " + id);
        order++;
        notifyAll();
    }
}
