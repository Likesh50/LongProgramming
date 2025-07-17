package bankManagement;

import java.util.List;
import java.util.Scanner;

public class BankSystem {
    private DataStore dataStore;
    private Scanner scanner;

    public BankSystem() {
        dataStore = new DataStore();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Welcome to Zoho Bank ===");
        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    System.out.println("Thank you for using Zoho Bank!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void register() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();

        System.out.print("Enter new password: ");
        String password = scanner.nextLine();

        if (dataStore.registerUser(username, password)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists. Try a different one.");
        }
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = dataStore.loginUser(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            userDashboard(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void userDashboard(User user) {
        while (true) {
            System.out.println("\n--- Welcome, " + user.getUsername() + " ---");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Logout");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.printf("Current Balance: ₹%.2f%n", user.getBalance());
                    break;
                case "2":
                    deposit(user);
                    break;
                case "3":
                    withdraw(user);
                    break;
                case "4":
                    viewTransactions(user);
                    break;
                case "5":
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void deposit(User user) {
        System.out.print("Enter deposit amount: ₹");
        double amount = Double.parseDouble(scanner.nextLine());
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        user.deposit(amount);
        dataStore.recordTransaction(user.getUsername(), new Transaction("Deposit", amount));
        System.out.println("Deposit successful.");
    }

    private void withdraw(User user) {
        System.out.print("Enter withdrawal amount: ₹");
        double amount = Double.parseDouble(scanner.nextLine());
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (user.withdraw(amount)) {
            dataStore.recordTransaction(user.getUsername(), new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void viewTransactions(User user) {
        List<Transaction> transactions = dataStore.getTransactions(user.getUsername());
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("--- Transaction History ---");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
