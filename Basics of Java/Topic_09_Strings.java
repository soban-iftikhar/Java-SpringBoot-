/*
 * Topic 9: Strings and String Manipulation
 * 
 * --- LEVEL 0: BEGINNER ---
 * A String in Java is an object that represents a sequence of characters.
 * They are so commonly used that Java provides special syntax and features for them.
 * 
 * Core Concept: IMMUTABILITY
 * - Strings in Java are IMMUTABLE. Once created, their value cannot be changed.
 * - Any operation that seems to "modify" a string actually creates a brand new string object.
 */
public class Topic_09_Strings {

    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. String Basics & Creation ---");
        
        // Method A: String Literal (Stored in the String Pool for memory efficiency)
        String s1 = "Hello";
        
        // Method B: The 'new' keyword (Forces creation of a new object in Heap memory)
        String s2 = new String("World");

        
        System.out.println("\n--- 2. String Concatenation ---");
        // You can join strings using the '+' operator or the concat() method.
        String greeting = s1 + " " + s2; 
        System.out.println(greeting);
        
        // Note: Java automatically converts primitives to strings when concatenated with a string.
        String ageText = "Age: " + 25; 


        System.out.println("\n--- 3. Basic String Methods (Manipulation) ---");
        String text = "  Java Spring Boot  ";
        
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed (removes edge spaces): '" + text.trim() + "'");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Character at index 2: " + text.charAt(2));
        System.out.println("Substring (starts at index 7): " + text.substring(7));
        System.out.println("Replace 'a' with 'o': " + text.replace('a', 'o'));


        System.out.println("\n--- 4. String Comparison ---");
        String a = "Java";
        String b = "Java";
        String c = new String("Java");
        
        // EXACT VALUE matching (.equals())
        System.out.println("a equals c? " + a.equals(c)); // true (Content is identical)
        System.out.println("a equalsIgnoreCase 'JAVA'? " + a.equalsIgnoreCase("JAVA")); // true
        
        // EDGE CASE: Memory Address matching (==)
        System.out.println("a == b? " + (a == b)); // true (Both point to the same String Pool object)
        System.out.println("a == c? " + (a == c)); // false (c was forced into the Heap using 'new')



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 5. Advanced Concept: Mutable vs Immutable ---");
        // Because Strings are immutable, modifying them in a loop is a performance disaster.
        String badLoop = "";
        for (int i = 0; i < 5; i++) {
            badLoop += i; // WARNING: This creates 5 separate String objects in memory!
        }
        System.out.println("Result of bad loop: " + badLoop);


        System.out.println("\n--- 6. Advanced Solution: StringBuilder vs StringBuffer ---");
        // To manipulate strings efficiently without creating garbage objects, we use mutable classes.
        
        // StringBuilder: Fast, efficient, but NOT thread-safe (Best for single-threaded use).
        StringBuilder sb = new StringBuilder("Initial ");
        sb.append("Data ");
        sb.insert(0, "Start: ");
        sb.reverse(); // Reverses the string in-place
        System.out.println("StringBuilder result: " + sb.toString());
        
        // StringBuffer: Slower, but THREAD-SAFE because its methods are synchronized.
        // Use this only when multiple threads are modifying the same string simultaneously.
        StringBuffer sbuf = new StringBuffer("Thread ");
        sbuf.append("Safe");
        System.out.println("StringBuffer result: " + sbuf.toString());


        System.out.println("\n--- 7. Advanced Feature: String Formatting ---");
        // When you need to inject many variables into a string, concatenation gets messy.
        // Use String.format() or System.out.printf()
        
        String user = "Soban";
        int score = 95;
        double price = 12.997;
        
        // %s = String, %d = Integer, %.2f = Float/Double rounded to 2 decimal places
        String formatted = String.format("User %s scored %d points and spent $%.2f", user, score, price);
        System.out.println(formatted);


        System.out.println("\n--- 8. Master Edge Case: String Performance Considerations ---");
        // 1. Avoid using `new String("text")`. It bypasses the String Pool and wastes memory.
        // 2. Never use `+` for string concatenation inside loops. ALWAYS use `StringBuilder`.
        // 3. String Immutability is actually a feature, not a bug! It makes Strings intrinsically 
        //    thread-safe and secure (which is why database passwords or URLs are stored as strings).
    }
}
