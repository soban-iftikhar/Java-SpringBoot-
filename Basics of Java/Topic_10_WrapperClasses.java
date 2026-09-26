/*
 * Topic 10: Wrapper Classes & Autoboxing
 * 
 * --- LEVEL 0: BEGINNER ---
 * In Java, there are 8 primitive data types (int, double, char, etc.). They are NOT objects.
 * However, Data Structures like ArrayLists can ONLY store Objects, not primitives.
 * 
 * To solve this, Java provides "Wrapper Classes" which wrap a primitive value inside a true Object.
 * Examples: int -> Integer, double -> Double, char -> Character, boolean -> Boolean.
 * 
 * Java automatically converts between them:
 * 1. Autoboxing: Automatically converting a primitive into a Wrapper object.
 * 2. Unboxing: Automatically converting a Wrapper object back into a primitive.
 */

public class Topic_10_WrapperClasses {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Manual Boxing & Unboxing (The Old Way) ---");
        // MANUAL BOXING: Explicitly converting primitive to Object
        int num1 = 10;
        Integer manualBox = Integer.valueOf(num1); // Preferred way over 'new Integer()'
        System.out.println("Manually Boxed: " + manualBox);
        
        // MANUAL UNBOXING: Explicitly converting Object back to primitive
        int manualUnbox = manualBox.intValue();
        System.out.println("Manually Unboxed: " + manualUnbox);
        
        
        System.out.println("\n--- 2. Autoboxing & Unboxing (Java 5+) ---");
        
        // AUTOBOXING: Primitive 'int' is automatically wrapped into an 'Integer' object
        int primitiveNum = 42;
        Integer wrappedNum = primitiveNum; // Autoboxing in action (Compiler does Integer.valueOf() invisibly)
        
        System.out.println("Auto Wrapped Number: " + wrappedNum);
        
        // UNBOXING: The 'Integer' object is automatically unwrapped back to an 'int'
        int newPrimitive = wrappedNum; // Unboxing in action (Compiler does .intValue() invisibly)
        System.out.println("Auto New Primitive: " + newPrimitive);
        
        
        // --- LEVEL 1: ADVANCED (Interview Traps) ---
        
        System.out.println("\n--- 2. The Unboxing Trap (NullPointerException) ---");
        // Because Wrapper classes are Objects, they can be 'null' (primitives cannot be null).
        Integer dangerousNull = null;
        
        try {
            // UNBOXING TRAP: Java tries to unwrap the null object to do math.
            // You cannot do math on 'null', so it crashes!
            int result = dangerousNull + 10; 
        } catch (NullPointerException e) {
            System.out.println("Caught an Exception! You cannot unbox a null Wrapper object.");
        }
        
        
        System.out.println("\n--- 3. The Integer Cache Trick (Master Level) ---");
        // To save memory, Java automatically caches Integer objects for values between -128 and +127.
        
        // Example A: Inside the cache (-128 to 127)
        Integer a = 100;
        Integer b = 100;
        // Because 100 is in the cache, Java points both 'a' and 'b' to the exact same object in memory!
        System.out.println("a == b (Values are 100): " + (a == b)); // TRUE
        
        // Example B: Outside the cache (Greater than 127)
        Integer x = 500;
        Integer y = 500;
        // Because 500 is outside the cache, Java is forced to create TWO separate objects on the Heap.
        System.out.println("x == y (Values are 500): " + (x == y)); // FALSE
        
        // The Solution: Always use .equals() when comparing Wrapper objects!
        System.out.println("x.equals(y): " + x.equals(y)); // TRUE
    }
}
