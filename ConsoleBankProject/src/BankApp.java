public class BankApp {
    public static void main(String[] args) {
        // Creating two accounts
        BankAccount account1 = new BankAccount("Monkey", 5000);
        BankAccount account2 = new BankAccount("Panda", 25000);

        // Performing transactions
        account1.depositMoney(20000);  // Alice deposits $1000
        account1.withdrawMoney(5000); // Alice withdraws $2000

        // Transfer money from Alice to Bob
        account1.transfer(account2, 10000);

        // Display transactions
        account1.displayTransactions();
        account2.displayTransactions();
    }
}

