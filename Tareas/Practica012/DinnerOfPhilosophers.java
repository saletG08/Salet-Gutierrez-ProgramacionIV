package Practica012;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DinnerOfPhilosophers {
    private final int numberPhilosophers = 5;
    private final Philosopher[] philosophers = new Philosopher[numberPhilosophers];
    private final Object[] forks = new Object[numberPhilosophers];

    public void startDinner() {
        for (int i = 0; i < numberPhilosophers; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < numberPhilosophers; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % numberPhilosophers];

            Lock lock = new ReentrantLock();

            philosophers[i] = new Philosopher(i, leftFork, rightFork, lock);
        }

        for (Philosopher philosopher : philosophers) {
            Thread thread = new Thread(philosopher);
            thread.start();
        }
    }
}
