/*
 * Topic 4: Type Conversion, Casting, and Parsing
 * 
 * --- LEVEL 0: BEGINNER ---
 * Often, you need to convert data from one type to another.
 * - Implicit (Widening): Automatically converting a smaller type to a larger type (e.g., int to double).
 * - Explicit (Narrowing): Manually forcing a larger type into a smaller type (e.g., double to int).
 * - Parsing: Converting a String containing text into a primitive number.
 */
public class Topic_04_TypeConversionAndTypeCasting {
    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Widening Conversion (Implicit Casting) ---");
        // Java handles this automatically because there is no risk of losing data.
        // byte -> short -> int -> long -> float -> double
        int myInt = 100;
        double myDouble = myInt; // Automatic cast: int safely promotes to double
        System.out.println("Int value: " + myInt);
        System.out.println("Promoted to Double: " + myDouble);


        System.out.println("\n--- 2. Narrowing Conversion (Explicit Casting) ---");
        // Converting a larger type to a smaller type requires a manual cast `(type)`.
        // WARNING: This can result in DATA LOSS (truncation).
        double largeDouble = 9.78d;
        int narrowedInt = (int) largeDouble; // Manual casting: fractional part (.78) is dropped!
        System.out.println("Original Double: " + largeDouble);
        System.out.println("Narrowed to Int: " + narrowedInt);


        System.out.println("\n--- 3. Parsing Strings to Primitives ---");
        // You CANNOT cast a String to an int (e.g., `(int) "123"` will not compile).
        // String is an Object, int is a primitive. You must Parse using Wrapper classes.
        String numberStr = "12345";
        int parsedInt = Integer.parseInt(numberStr);
        System.out.println("Successfully parsed String to Int: " + parsedInt);



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 4. Advanced Edge Case: Narrowing Data Corruption ---");
        // A byte can hold values from -128 to +127.
        // What happens if we force an int containing 130 into a byte?
        int hugeInt = 130;
        byte corruptedByte = (byte) hugeInt; 
        
        // WHY does it print -126?
        // 130 in 32-bit binary: 00000000 00000000 00000000 10000010
        // When cast to 8-bit byte, only the last 8 bits remain: 10000010
        // In Two's Complement binary (used by Java), 10000010 represents -126!
        System.out.println("Int 130 explicitly cast to byte results in: " + corruptedByte); 


        System.out.println("\n--- 5. Advanced Edge Case: Type Promotion in Expressions ---");
        // Rule: In any arithmetic expression involving byte, short, or char, 
        // Java automatically promotes them to `int` BEFORE the calculation.
        byte b1 = 40;
        byte b2 = 50;
        
        // EDGE CASE: The following line will NOT compile without a cast:
        // byte b3 = b1 + b2; // ERROR: b1 + b2 results in an 'int', which can't fit directly into a byte.
        
        // Correct way:
        byte b3 = (byte) (b1 + b2);
        System.out.println("Result of byte addition (cast back to byte): " + b3);


        System.out.println("\n--- 6. Advanced Edge Case: Parsing Failures ---");
        String invalidNumberStr = "123a"; // Contains a letter
        try {
            int failedParse = Integer.parseInt(invalidNumberStr);
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse! The string contained non-numeric characters: " + invalidNumberStr);
        }
    }
}