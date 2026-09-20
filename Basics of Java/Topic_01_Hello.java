/*
 * Topic 1: The Basics of a Java Program
 * 
 * --- LEVEL 0: BEGINNER ---
 * - Java is an object-oriented language. Every application begins with a class name.
 * - The file name MUST match the class name exactly (e.g., Topic_01_Hello.java).
 * - Java is case-sensitive ("Hello" and "hello" are different).
 * - The `public static void main(String[] args)` method is the entry point of the program. 
 *   The JVM (Java Virtual Machine) looks for this exact method to start execution.
 */

public class Topic_01_Hello {

    public static void main(String[] args) {
        
        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        // 1. Standard Output
        // System.out.println prints a message to the console and adds a new line at the end.
        System.out.println("Hello World!");
        
        // System.out.print prints without adding a new line.
        System.out.print("Welcome to ");
        System.out.println("Java Programming.");

        
        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        System.out.println("\n--- Advanced Concepts ---");

        // 2. Standard Error (System.err)
        // Used to print error messages or diagnostics. Often styled differently in consoles (e.g., red text).
        // It is unbuffered, meaning it prints immediately, whereas System.out can sometimes be delayed.
        System.err.println("This is standard error. Use this for logging exceptions or failures.");

        // 3. Command Line Arguments
        // When running `java Topic_01_Hello arg1 arg2`, the `args` array captures ["arg1", "arg2"].
        System.out.println("Number of command-line arguments passed: " + args.length);

        if (args.length > 0) {
            System.out.println("First argument: " + args[0]);
        } else {
            System.out.println("No arguments were provided.");
        }

        // EDGE CASE: Accessing args without bounds checking throws ArrayIndexOutOfBoundsException
        try {
            // If you run this without arguments, args[10] doesn't exist and crashes the program.
            // String missingArg = args[10]; 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Tried to access an argument that doesn't exist!");
        }

        // 4. Program Termination
        // By default, the program naturally terminates when the main method reaches its end.
        // However, you can forcibly exit the JVM using System.exit(status).
        // Status 0 indicates successful termination, non-zero indicates an error.
        System.out.println("Program is finishing successfully.");
        // System.exit(0); // Uncommenting this will force quit the program here.
    }
}