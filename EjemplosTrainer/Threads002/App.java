package Threads002;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Counter contadorCompartido = new Counter();

        MiThread hilo1 = new MiThread(contadorCompartido);
        MiThread hilo2 = new MiThread(contadorCompartido);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final del contador: " + contadorCompartido.getValue());
    }
}
