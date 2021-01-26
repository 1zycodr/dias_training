package lesson_3.oop;

public class BankAccount {
    private int cents;

    BankAccount(int cents) {
        this.cents = cents;
    }

    public void deposit(int cents) {
        this.cents += cents;
    }

    public void deposit(int dollars, int cents) {
        this.cents += 100 * dollars + cents;
    }
}
