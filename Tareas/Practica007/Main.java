package Practica007;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.insert(1, TypePriority.NORMAL_CLIENT);
        bank.insert(2, TypePriority.NORMAL_CLIENT);
        bank.insert(3, TypePriority.VIP_CLIENT);
        bank.insert(4, TypePriority.NORMAL_CLIENT);
        bank.insert(5, TypePriority.NORMAL_CLIENT);
        bank.insert(6, TypePriority.NORMAL_CLIENT);
        bank.insert(7, TypePriority.NORMAL_CLIENT);
        bank.insert(8, TypePriority.NORMAL_CLIENT);
        bank.insert(9, TypePriority.NORMAL_CLIENT);
        bank.insert(10, TypePriority.VIP_CLIENT);
        bank.insert(11, TypePriority.VIP_CLIENT);

        bank.print();
    }
}
