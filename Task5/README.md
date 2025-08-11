# Bank Account Simulation - Task 5

## Overview
This project implements a simple bank account management system in Java that demonstrates object-oriented programming concepts including encapsulation, data hiding, and proper access control.

## Features

### Account Management
- Create bank accounts with account number, holder name, and initial balance
- Maintain account balance with proper validation
- Track complete transaction history with timestamps

### Transaction Operations
- **Deposits**: Add money to account (positive amounts only)
- **Withdrawals**: Remove money from account (with balance validation)
- **Balance Checking**: View current account balance
- **Transaction History**: Complete log of all account activities

### Error Handling
- Prevents negative deposits
- Prevents withdrawals exceeding available balance
- Validates all transaction amounts

## Project Structure

```
Task5/
├── Account.java      # Main account class with all business logic
├── Main.java         # Demo program showing account operations
└── README.md         # This file
```

## Classes

### Account Class
The core class that represents a bank account with the following features:

**Private Fields:**
- `accountNumber` - Unique identifier for the account
- `accountHolderName` - Name of the account holder
- `balance` - Current account balance
- `transactionHistory` - List of all transactions with timestamps

**Public Methods:**
- `deposit(double amount)` - Add money to account
- `withdraw(double amount)` - Remove money from account
- `getBalance()` - Return current balance
- `getAccountNumber()` - Return account number
- `getAccountHolderName()` - Return account holder name
- `printBalance()` - Display formatted balance
- `printTransactionHistory()` - Show complete transaction log

### Main Class
Demonstration program that showcases all account functionality:
- Account creation
- Multiple deposit and withdrawal operations
- Error handling demonstration
- Transaction history display

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
```bash
# Navigate to the parent directory
cd "Elevate Lab"

# Compile all Java files
javac Task5/*.java
```

### Execution
```bash
# Run the main program
java Task5.Main
```

## Sample Output

```
--- Starting Bank Account Simulation ---
Account created for John Doe with account number 123456789

Current Balance for John Doe: $500.00

--- Performing Transactions ---
Deposited: $250.50
Withdrew: $100.00
Insufficient funds. Withdrawal failed.
Deposit amount must be positive.
Withdrew: $50.25

Current Balance for John Doe: $600.25

--- Transaction History for Account 123456789 ---
[2025-08-11 21:44:41] Account created with initial balance: $500.00
[2025-08-11 21:44:41] Deposited: $250.50
[2025-08-11 21:44:41] Withdrew: $100.00
[2025-08-11 21:44:41] Withdrew: $50.25

--- Simulation Finished ---
```

## Key Programming Concepts Demonstrated

### 1. Encapsulation
- Private fields with public getter methods
- Controlled access to account data
- Business logic encapsulation within the Account class

### 2. Data Validation
- Input validation for deposits and withdrawals
- Balance checking before withdrawals
- Error messages for invalid operations

### 3. Transaction Logging
- Automatic recording of all account activities
- Timestamped transaction history
- Persistent transaction tracking

### 4. Error Handling
- Graceful handling of invalid inputs
- User-friendly error messages
- Non-destructive error recovery

## Design Patterns

### Getter Methods
The Account class uses getter methods (`getAccountNumber()`, `getAccountHolderName()`, `getBalance()`) to provide controlled access to private fields, following encapsulation principles.

### Transaction Recording
All account operations automatically record transactions with timestamps, providing a complete audit trail.

## Future Enhancements
- Multiple account support
- Interest calculation
- Account types (Savings, Checking)
- Database integration
- GUI interface
- Transaction export functionality

## Author
Created as part of the Elevate Lab internship program to demonstrate Java OOP concepts and best practices.
