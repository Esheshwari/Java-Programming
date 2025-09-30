// 1. Bank Account Withdrawal
// Create a BankAccount class with a balance of 1000. Start two threads representing two people
// trying to withdraw money. Without synchronization, withdrawals may cause incorrect balances. Use
// synchronized to make withdrawals safe.
  class BankAccount {
    private int balance = 1000;

    // Synchronized method to ensure thread safety
    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is trying to withdraw ₹" + amount);
            try {
                Thread.sleep(100); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            balance -= amount;
            System.out.println(name + " successfully withdrew ₹" + amount);
        } else {
            System.out.println(name + " tried to withdraw ₹" + amount + " but insufficient balance.");
        }
        System.out.println("Remaining balance: ₹" + balance);
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private String personName;

    public WithdrawalThread(BankAccount account, String personName) {
        this.account = account;
        this.personName = personName;
    }

    public void run() {
        account.withdraw(personName, 700);
    }
}

public class bankwithdraw {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

        WithdrawalThread person1 = new WithdrawalThread(sharedAccount, "Alice");
        WithdrawalThread person2 = new WithdrawalThread(sharedAccount, "Bob");

        person1.start();
        person2.start();
    }
}
