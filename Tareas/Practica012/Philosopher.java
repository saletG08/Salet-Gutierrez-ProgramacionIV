package Practica012;

import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable {
    private final int numberOfPhilosophers;
    private final Object leftFork;
    private final Object rightFork;
    private final Lock lock;

    public Philosopher(int numberOfPhilosophers, Object leftFork, Object rightFork, Lock lock) {
        this.numberOfPhilosophers = numberOfPhilosophers;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.lock = lock;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher :" + numberOfPhilosophers + " is thinking.");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Philosopher :" + numberOfPhilosophers + " is eating.");
            Thread.sleep(1000);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (leftFork) {
                    System.out.println("Philosopher :" + numberOfPhilosophers + " has taken the left fork.");
                    synchronized (rightFork) {
                        System.out.println("Philosopher :" + numberOfPhilosophers + " has taken the right fork.");
                        eat();
                        System.out.println("Philosopher :" + numberOfPhilosophers + " has released the right fork.");
                    }
                    System.out.println("Philosopher :" + numberOfPhilosophers + " has released the left fork.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
