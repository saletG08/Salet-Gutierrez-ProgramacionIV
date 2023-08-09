package TestPractica007;

import Practica007.Bank;
import Practica007.TypePriority;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBank {

    @Test
    public void insert(){
        Bank bank = new Bank();
        assertTrue(bank.insert(1, TypePriority.NORMAL_CLIENT));
        assertTrue(bank.insert(2, TypePriority.VIP_CLIENT));
        assertTrue(bank.insert(3, TypePriority.NORMAL_CLIENT));
        assertTrue(bank.insert(4, TypePriority.VIP_CLIENT));
    }
}
