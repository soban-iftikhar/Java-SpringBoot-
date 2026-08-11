/*
 * Topic 3: Encapsulation, Constructors, and Keywords
 * 
 * --- LEVEL 0: BEGINNER ---
 * This file covers the core building blocks of creating robust objects:
 * 1. Encapsulation (Data Hiding)
 * 2. Getters and Setters
 * 3. The 'this' keyword
 * 4. Constructors (Default vs Parameterized)
 * 5. Static methods vs Instance methods
 * 6. The 'this()' and 'super()' constructor methods
 */

class BankAccount {
    
    // ==========================================
    // 1. ENCAPSULATION
    // ==========================================
    // Data is hidden (private). It can only be accessed through public methods.
    private String accountHolder;
    private double balance;

    // A static variable belongs to the CLASS, not the object instances.
    private static int totalAccountsCreated = 0;


    // ==========================================
    // 2. CONSTRUCTORS (Default vs Parameterized)
    // ==========================================
    // A constructor is a special method used to initialize objects. It has NO return type.

    // A. Default Constructor (No parameters)
    // If you don't write any constructors, Java provides an empty default one automatically.
    // BUT, if you write a Parameterized one (like below), the default one disappears unless you explicitly write it!
    public BankAccount() {
        // 3. 'this()' METHOD (Constructor Chaining)
        // 'this()' calls ANOTHER constructor in the same class.
        // It MUST be the very first line of code in the constructor!
        this("Unknown Account", 0.0); 
        System.out.println("Default Constructor called. Chained to Parameterized constructor.");
    }

    // B. Parameterized Constructor
    public BankAccount(String accountHolder, double balance) {
        // 4. 'super()' METHOD
        // 'super()' calls the constructor of the PARENT class.
        // Every class implicitly inherits from the 'Object' class, so Java silently puts super() here if you don't.
        // Like this(), it must be the first line (you can only have one or the other, not both).
        super(); 

        // 5. 'this' KEYWORD
        // 'this' refers to the CURRENT OBJECT instance. 
        // We use it to resolve naming collisions between class variables and method parameters.
        this.accountHolder = accountHolder;
        this.balance = balance;
        
        totalAccountsCreated++; // Increment the static counter
    }


    // ==========================================
    // 6. GETTERS AND SETTERS
    // ==========================================
    
    // Getter: Allows the outside world to READ the data securely
    public String getAccountHolder() {
        return accountHolder; // 'this.' is optional here since there is no naming collision
    }

    // Setter: Allows the outside world to MODIFY the data securely
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder; 
    }

    public double getBalance() {
        return balance;
    }

    // --- LEVEL 1: ADVANCED (The True Power of Encapsulation) ---
    // Setter with VALIDATION. 
    // By forcing users through a setter, we prevent illegal states (like negative balances).
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.err.println("Transaction Failed: Balance cannot be negative!");
        }
    }


    // ==========================================
    // 7. STATIC METHODS
    // ==========================================
    // Static methods belong to the class itself, meaning you can call them without creating an object!
    // Rule: Static methods CANNOT use the 'this' keyword, because 'this' refers to an object instance.
    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }
}

public class Topic_03_Encapsulation {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Using the Default Constructor (with this() chaining) ---");
        BankAccount account1 = new BankAccount();
        System.out.println("Account 1 Holder: " + account1.getAccountHolder());
        System.out.println("Account 1 Balance: $" + account1.getBalance());

        
        System.out.println("\n--- 2. Using the Parameterized Constructor ---");
        BankAccount account2 = new BankAccount("Alice", 500.0);
        System.out.println("Account 2 Holder: " + account2.getAccountHolder());
        
        
        System.out.println("\n--- 3. Encapsulation Validation in Action ---");
        account2.setBalance(-1000); // Attempting to hack the balance (will be blocked by setter!)
        System.out.println("Account 2 Balance: $" + account2.getBalance());


        System.out.println("\n--- 4. Calling a Static Method ---");
        // We call the static method on the CLASS NAME, not the object variable!
        System.out.println("Total Accounts Created in System: " + BankAccount.getTotalAccountsCreated());
    }
}
