package Threads009;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        int cores = 6;
        Thread[] hilos = new Thread[cores];

        for(int i = 0; i < hilos.length; i++){
            Runnable runnable = new MyRunnable(i);
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        }

        for(int i = 0; i < hilos.length; i++){
            try{
                hilos[i].join();
            }catch(Exception ex){}
        }




        //Ejercicio2
        Monitor2 monitor2 = new Monitor2();

        Thread threadA = new Thread(() -> monitor2.printA());
        Thread threadB = new Thread(() -> monitor2.printB());

        threadA.start();
        threadB.start();


        //Ejercicio3
        BankAccount account = new BankAccount();

        Thread depositThread = new Thread(() -> account.deposit(100));
        Thread withdrawThread = new Thread(() -> account.withdraw(50));

        depositThread.start();
        withdrawThread.start();

    }
}
