/*
 * Topic 5: Operators and Operations
 * 
 * --- LEVEL 0: BEGINNER ---
 * Operators are symbols that perform operations on variables and values.
 * - Arithmetic: +, -, *, /, % (modulo/remainder)
 * - Relational: ==, !=, >, <, >=, <=
 * - Logical: && (AND), || (OR), ! (NOT)
 * - Assignment: =, +=, -=, etc.
 * - Unary: ++ (increment), -- (decrement)
 */
public class Topic_05_OperatorsAndOperations {
    
    // Helper method for demonstrating short-circuit evaluation later
    static boolean expensiveOperation() {
        System.out.println("   [Side Effect: expensiveOperation() executed!]");
        return true;
    }

    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Basic Arithmetic & Relational ---");
        int a = 10;
        int b = 3;
        
        System.out.println("Addition (a + b): " + (a + b)); // 13
        System.out.println("Division (a / b): " + (a / b)); // 3 (Integer division drops remainder!)
        System.out.println("Modulo (a % b): " + (a % b));   // 1 (The remainder of 10/3)
        System.out.println("Is a greater than b?: " + (a > b)); // true


        System.out.println("\n--- 2. Unary Operators (Increment/Decrement) ---");
        int count = 5;
        count++; // Increases by 1
        System.out.println("Count after ++: " + count); // 6



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 3. Advanced Edge Case: Prefix vs Postfix ---");
        int x = 5;
        // Postfix: Use the value first, THEN increment
        int y = x++; 
        System.out.println("After Postfix (y = x++): y=" + y + ", x=" + x); // y=5, x=6
        
        x = 5; // Reset
        // Prefix: Increment the value first, THEN use it
        int z = ++x;
        System.out.println("After Prefix (z = ++x): z=" + z + ", x=" + x); // z=6, x=6


        System.out.println("\n--- 4. Advanced Edge Case: Floating-Point Modulo ---");
        // Unlike some languages (C/C++), Java allows modulo on floating-point numbers!
        System.out.println("10.5 % 3 = " + (10.5 % 3)); // 1.5
        // Modulo with negative numbers preserves the sign of the numerator!
        System.out.println("-10 % 3 = " + (-10 % 3)); // -1


        System.out.println("\n--- 5. Advanced Edge Case: Short-Circuit (&&) vs Non-Short-Circuit (&) ---");
        // Short-circuit operators stop evaluating as soon as the result is known.
        System.out.println("Testing Short-Circuit (&&):");
        boolean result1 = false && expensiveOperation(); // expensiveOperation() is NEVER called because false && anything is false.
        
        System.out.println("Testing Non-Short-Circuit (&):");
        // The bitwise & operator, when used on booleans, evaluates BOTH sides unconditionally.
        boolean result2 = false & expensiveOperation(); // expensiveOperation() IS called!


        System.out.println("\n--- 6. Advanced Edge Case: Bitwise Shift Operators ---");
        // Java uses Two's Complement to represent negative numbers.
        int positiveNum = 12;  // Binary: 00000000 ... 00001100
        int negativeNum = -12; // Binary: 11111111 ... 11110100
        
        // Signed Right Shift (>>): Shifts bits right, padding with the sign bit (preserves sign)
        int signedShift = negativeNum >> 1; // Shifts right by 1
        System.out.println("-12 >> 1 (Signed Shift): " + signedShift); // Result: -6

        // Unsigned Right Shift (>>>): Shifts bits right, padding with 0s ALWAYS.
        // This forces a negative number to become a massive positive number!
        int unsignedShift = negativeNum >>> 1;
        System.out.println("-12 >>> 1 (Unsigned Shift): " + unsignedShift); // Result: 2147483642
    }
}
