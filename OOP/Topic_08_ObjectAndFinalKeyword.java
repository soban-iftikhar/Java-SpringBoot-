/*
 * Topic 8: The Object Class & The 'final' Keyword
 * 
 * --- LEVEL 0: BEGINNER ---
 * 1. The 'final' Keyword: Used to apply restrictions. It can lock a variable (constant),
 *    lock a method (prevent overriding), or lock a class (prevent inheritance).
 * 2. The Object Class: The cosmic mother of all classes in Java. EVERY class you ever write 
 *    automatically inherits from java.lang.Object behind the scenes!
 */

// ==========================================
// 1. THE 'final' KEYWORD
// ==========================================
final class LockedClass {
    // Because the class is final, NO ONE can extend (inherit) this class.
}
// class Hacker extends LockedClass {} // COMPILER ERROR! 

class ParentRules {
    public final void strictMethod() {
        System.out.println("This logic cannot be overridden by children!");
    }
}

class RebelChild extends ParentRules {
    // public void strictMethod() {} // COMPILER ERROR! Cannot override a final method!
}


// ==========================================
// 2. THE OBJECT CLASS (equals, toString, hashCode)
// ==========================================
class Laptop {
    String brand;
    int serialNumber;

    public Laptop(String brand, int serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    // OVERRIDING toString()
    // By default, printing an object prints its memory address (e.g., Laptop@15db9742).
    // We override this to print actual readable data!
    @Override
    public String toString() {
        return "Laptop [Brand: " + brand + ", Serial: " + serialNumber + "]";
    }

    // OVERRIDING equals()
    // By default, `==` and `.equals()` on objects only check if they share the exact same MEMORY ADDRESS.
    // We override it to check if their ACTUAL DATA is the same.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Are they the exact same object in memory?
        if (obj == null || getClass() != obj.getClass()) return false; // Is the other object even a Laptop?
        
        Laptop other = (Laptop) obj; // Downcast safely!
        // We consider two laptops "equal" if they share the same serial number.
        return this.serialNumber == other.serialNumber;
    }

    // OVERRIDING hashCode()
    // Rule: If two objects are .equals(), they MUST return the exact same hashCode integer!
    // HashCodes are used for fast lookups in Data Structures like HashMaps.
    @Override
    public int hashCode() {
        return serialNumber; 
    }
}


public class Topic_08_ObjectAndFinalKeyword {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing the 'final' keyword ---");
        // Final variables become Constants. Their value can NEVER change after initialization.
        final double PI = 3.14159;
        // PI = 3.14; // COMPILER ERROR! 
        System.out.println("Final Variable PI: " + PI);
        
        
        System.out.println("\n--- 2. Testing The Object Class Methods ---");
        Laptop mac1 = new Laptop("Apple", 9999);
        Laptop mac2 = new Laptop("Apple", 9999);
        Laptop dell = new Laptop("Dell", 1111);

        // Testing toString()
        System.out.println("Printing Object directly (toString): " + mac1);

        // Testing equals()
        System.out.println("\nAre mac1 and mac2 the exact same object in memory (==)? " + (mac1 == mac2)); // False
        System.out.println("Do mac1 and mac2 contain the same data (.equals)? " + mac1.equals(mac2)); // True!
        
        // Testing hashCode()
        System.out.println("\nmac1 HashCode: " + mac1.hashCode());
        System.out.println("mac2 HashCode: " + mac2.hashCode()); // Must be identical to mac1!
        System.out.println("dell HashCode: " + dell.hashCode());
    }
}
