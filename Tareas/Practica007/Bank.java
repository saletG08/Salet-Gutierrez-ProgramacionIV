package Practica007;

import java.util.PriorityQueue;

public class Bank {

    PriorityQueue<Ticket> ticketQueue;

    public Bank() {
        this.ticketQueue = new PriorityQueue<>();
    }

    public boolean insert(int arriveNumber, TypePriority isPriority){
        return ticketQueue.add(new Ticket(arriveNumber, isPriority));
    }

    public void print(){
        while (!ticketQueue.isEmpty()) {
            Ticket nextTicket = ticketQueue.poll();
            System.out.println(nextTicket);
        }
    }
}
