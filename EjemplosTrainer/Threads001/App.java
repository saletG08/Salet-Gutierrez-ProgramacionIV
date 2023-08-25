package Threads001;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        MyThread1 hiloNumeros = new MyThread1();
        hiloNumeros.start();


        try {
            hiloNumeros.join(); // Esperar a que el hilo de números termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finaliza Hilo Principal.");
    }
}
