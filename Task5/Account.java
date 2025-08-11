package Task5;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a bank account with basic operations like deposit and withdrawal.
 * It maintains the account balance and a history of all transactions.
 */
public class Account {

    // Fields to store account data
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    // A list to store the history of transactions as simple strings
    private List<String> transactionHistory;

    /**
     * Constructor to initialize a new Account object.
     * @param accountNumber The unique number for the account.
     * @param accountHolderName The name of the account holder.
     * @param initialBalance The starting balance of the account.
     */
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        // Record the initial account creation
        addTransaction("Account created with initial balance: $" + String.format("%.2f", initialBalance));
    }

    /**
     * Deposits a specified amount into the account.
     * @param amount The amount to deposit. Must be positive.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        this.balance += amount;
        String transactionDetails = "Deposited: $" + String.format("%.2f", amount);
        addTransaction(transactionDetails);
        System.out.println(transactionDetails);
    }

    /**
     * Withdraws a specified amount from the account.
     * The amount must be positive and not exceed the current balance.
     * @param amount The amount to withdraw.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return;
        }
        this.balance -= amount;
        String transactionDetails = "Withdrew: $" + String.format("%.2f", amount);
        addTransaction(transactionDetails);
        System.out.println(transactionDetails);
    }

    /**
     * Adds a formatted transaction record to the history.
     * @param details A string describing the transaction.
     */
    private void addTransaction(String details) {
        // Get current timestamp
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // Add timestamp to the transaction details
        this.transactionHistory.add("[" + timeStamp + "] " + details);
    }

    /**
     * Prints the complete transaction history for the account.
     */
    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for Account " + this.accountNumber + " ---");
        for (String transaction : this.transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("-------------------------------------------------");
    }

    /**
     * Returns the current balance of the account.
     * @return The current balance.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Returns the account number.
     * @return The account number.
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Returns the account holder name.
     * @return The account holder name.
     */
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    /**
     * Prints the current account balance in a formatted way.
     */
    public void printBalance() {
        System.out.printf("\nCurrent Balance for %s: $%.2f%n", this.accountHolderName, this.balance);
    }
}