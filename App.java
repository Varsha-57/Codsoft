import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        this.balance += amount;
        return String.format("Deposited $%.2f. New balance: $%.2f", amount, this.balance);
    }

    public String withdraw(double amount) {
        if (amount > this.balance) {
            return "Insufficient funds. Withdrawal failed.";
        } else {
            this.balance -= amount;
            return String.format("Withdrew $%.2f. New balance: $%.2f", amount, this.balance);
        }
    }

    public String checkBalance() {
        return String.format("Current balance: $%.2f", this.balance);
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Quit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println(account.withdraw(withdrawAmount));
                    break;
                case "2":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println(account.deposit(depositAmount));
                    break;
                case "3":
                    System.out.println(account.checkBalance());
                    break;
                case "4":
                    System.out.println("Exiting. Thank you for using the ATM.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

public class App{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}