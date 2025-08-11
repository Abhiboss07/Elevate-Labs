package Task5;
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Starting Bank Account Simulation ---");

        // 1. Create a new bank account
        Account myAccount = new Account("123456789", "John Doe", 500.00);
        System.out.println("Account created for " + myAccount.getAccountHolderName() + " with account number " + myAccount.getAccountNumber());
        
        // Print the initial balance
        myAccount.printBalance();
        
        System.out.println("\n--- Performing Transactions ---");

        // 2. Perform a series of transactions
        myAccount.deposit(250.50);    // Successful deposit
        myAccount.withdraw(100.00);   // Successful withdrawal
        myAccount.withdraw(700.00);   // Failed withdrawal (insufficient funds)
        myAccount.deposit(-50.00);    // Failed deposit (negative amount)
        myAccount.withdraw(50.25);    // Successful withdrawal

        // 3. Print the final balance
        myAccount.printBalance();

        // 4. Print the full transaction history
        myAccount.printTransactionHistory();

        System.out.println("\n--- Simulation Finished ---");
    }
}