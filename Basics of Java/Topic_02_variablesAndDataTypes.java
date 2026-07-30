import java.math.BigDecimal;

/*
 * Topic 2: Variables and Data Types
 * 
 * --- LEVEL 0: BEGINNER ---
 * Variables are containers for storing data values. In Java, every variable must be declared with a data type.
 * General Data Types:
 * 1. int     - Integers (whole numbers)
 * 2. float   - Floating point numbers (with decimals), ends with 'f'
 * 3. double  - Large floating point numbers (more precision)
 * 4. char    - Single characters, surrounded by single quotes ('A')
 * 5. boolean - True or false values
 * 6. String  - Text, surrounded by double quotes ("Hello") (Note: String is an Object, not a primitive)
 */
public class Topic_02_variablesAndDataTypes {
    
    // --- LEVEL 1: ADVANCED (Instance Variables) ---
    // Instance variables get default values (e.g., 0, false, null)
    // They don't need to be explicitly initialized before use.
    static int defaultInt; 
    static boolean defaultBool;
    static String defaultString;

    public static void main(String[] args) {
        
        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Basic Variables ---");
        
        int myNum = 5;               // 4 bytes
        float myFloatNum = 5.99f;    // 4 bytes
        double myDoubleNum = 19.99;  // 8 bytes
        char myLetter = 'D';         // 2 bytes
        boolean myBool = true;       // 1 bit
        String myText = "Hello!";    // Reference type
        long myLongNum = 123456789L; // 8 bytes (ends with 'L')
        byte myByteNum = 127;        // 1 byte (-128 to 127)
        short myShortNum = 32767;    // 2 bytes
        
        // final is used to declare constants (values that cannot be changed once assigned)
        final int myConstant = 10;
        // myConstant = 20; // ERROR: Cannot assign a value to a final variable
        
        System.out.println("Integer: " + myNum);
        System.out.println("Float: " + myFloatNum);
        System.out.println("Character: " + myLetter);
        System.out.println("Boolean: " + myBool);
        System.out.println("String: " + myText);


        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        System.out.println("\n--- 2. Default Values vs Uninitialized Local Variables ---");
        System.out.println("Instance int (default): " + defaultInt);       // Prints 0
        System.out.println("Instance boolean (default): " + defaultBool); // Prints false
        
        // Local variables MUST be initialized before use. 
        // EDGE CASE: The compiler throws an error if you try to use an uninitialized local variable.
        int localInt;
        // System.out.println(localInt); // ERROR: variable localInt might not have been initialized

        
        System.out.println("\n--- 3. Primitive Limits and Overflow ---");
        // Wrapper classes provide MIN_VALUE and MAX_VALUE constants.
        System.out.println("Int range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        
        // EDGE CASE: Integer Overflow
        // If you add 1 to the maximum possible int, it wraps around to the lowest negative number!
        int maxInt = Integer.MAX_VALUE;
        int overflowInt = maxInt + 1; 
        System.out.println("Max Int + 1 (Overflow): " + overflowInt); 


        System.out.println("\n--- 4. Floating-Point Precision Loss ---");
        // floats and doubles are meant for scientific calculations, NOT financial calculations.
        // They represent values as fractions of powers of 2, leading to tiny rounding errors.
        double a = 0.1;
        double b = 0.2;
        System.out.println("0.1 + 0.2 using double = " + (a + b)); // Prints 0.30000000000000004

        // Advanced Solution: Use BigDecimal for exact precision (crucial for currency)
        // Always use the String constructor of BigDecimal.
        BigDecimal accurateA = new BigDecimal("0.1");
        BigDecimal accurateB = new BigDecimal("0.2");
        System.out.println("0.1 + 0.2 using BigDecimal = " + accurateA.add(accurateB)); // Prints 0.3


        System.out.println("\n--- 5. Local Variable Type Inference (var) ---");
        // Introduced in Java 10. The compiler figures out the type from the value on the right.
        var inferredString = "Hello Java 10"; 
        var inferredInt = 100;

        // LIMITATIONS OF 'var':
        // 1. Cannot be used for fields/instance variables.
        // 2. Must be initialized immediately (e.g., var x; x = 10; is an ERROR).
        // 3. Cannot be initialized to null.
        
        System.out.println("Inferred String: " + inferredString);
    }
}
