package Practica007;

public class Ticket implements Comparable<Ticket> {

    private final int arriveNumber;
    private final TypePriority isPriority;

    public Ticket(int arriveNumber, TypePriority isPriority) {
        this.arriveNumber = arriveNumber;
        this.isPriority = isPriority;
    }

    @Override
    public int compareTo(Ticket other) {
        if (this.isPriority.getIsPriority() && !other.isPriority.getIsPriority()) {
            return -1;
        } else if (!this.isPriority.getIsPriority() && other.isPriority.getIsPriority()) {
            return 1;
        } else {
            return Integer.compare(this.arriveNumber, other.arriveNumber);
        }
    }

    @Override
    public String toString() {
        return "Ticket # " + arriveNumber + " (" + (isPriority.getIsPriority() ? "Priority)" : "Regular)");
    }
}
