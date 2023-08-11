package Practica007;

import java.util.PriorityQueue;

public class Bank {

    PriorityQueue<Ticket> ticketQueue;

    public Bank() {
        this.ticketQueue = new PriorityQueue<>();
    }

    public boolean insert(int arriveNumber, TypePriority isPriority){
        for (int i = 0; i < ticketQueue.size(); i++) {
            return ticketQueue.add(new Ticket(i, isPriority));
        }
        return true;
    }

    public void remove(){
        ticketQueue.poll();
    }

    public int sizeQueue(){
        return ticketQueue.size();
    }

    public void print(){
        while (!ticketQueue.isEmpty()) {
            Ticket nextTicket = ticketQueue.poll();
            System.out.println(nextTicket);
        }
    }
}
