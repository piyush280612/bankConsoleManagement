import java.util.ArrayList;

public class BankAccount {
    private static int accountCounter = 10000000;
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public BankAccount(String accountHolder, int initialDeposit){
        this.accountNumber = accountCounter++;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial deposit: $" + initialDeposit);
    }

    // Deposit Money
    public void depositMoney(double amount){
        if (amount > 0 && amount <= 500000){
            balance += amount;
            addTransaction("✅ Amount Deposited: $" + amount);
            System.out.println("💰 Deposit Successful! New Balance: $" + balance);
        } else {
            System.out.println("❌ Invalid Deposit! Amount must be between $1 - $500,000");
        }
    }

    // Withdraw Money
    public void withdrawMoney(double Wmoney){
        if (Wmoney > 0 && Wmoney <= balance){
            balance -= Wmoney;
            addTransaction("💸 Amount Withdrawn: $" + Wmoney);
            System.out.println("✅ Withdrawal Successful! Remaining Balance: $" + balance);
        } else {
            System.out.println("❌ Invalid Withdrawal! Amount exceeds balance.");
            System.out.println("💰 Current Balance: $" + balance);
        }
    }

    // Transfer Money
    public void transfer(BankAccount recipient, double transferAmount){
        if (transferAmount > 0 && transferAmount <= balance){
            this.withdrawMoney(transferAmount);
            recipient.depositMoney(transferAmount);
            addTransaction("🔁 Transferred $" + transferAmount + " to Account #" + recipient.getAccountNumber());
            recipient.addTransaction("📩 Received $" + transferAmount + " from Account #" + this.accountNumber);
            System.out.println("\n✅ MONEY TRANSFERRED SUCCESSFULLY ✅\n");
        } else {
            System.out.println("❌ Transfer Failed! Insufficient balance.");
        }
    }

    // Display Transaction History
    public void displayTransactions() {
        System.out.println("\n📜 Transaction History for " + accountHolder + " (Account #" + accountNumber + ")");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }

    // Helper Method
    private void addTransaction(String transaction){
        transactionHistory.add(transaction);
    }

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
}



