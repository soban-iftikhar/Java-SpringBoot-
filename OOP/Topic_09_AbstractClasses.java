/*
 * Topic 9: Abstraction
 * 
 * --- LEVEL 0: BEGINNER ---
 * Abstraction (The 'abstract' keyword) is the process of hiding the complex 
 * implementation details and showing only the essential features of an object.
 */

// ==========================================
// 1. ABSTRACTION ('abstract' keyword)
// ==========================================
// Abstract classes CANNOT be instantiated! (You cannot say: new Vehicle(); )
// They exist purely to act as a Blueprint for other classes to inherit from.
abstract class Vehicle {
    
    // Abstract Method: Has no body {}. 
    // It FORCES all child classes to provide their own implementation.
    public abstract void drive();
    
    // Abstract classes CAN have normal (concrete) methods too!
    public void honkHorn() {
        System.out.println("Beep Beep!");
    }
}

class Tesla extends Vehicle {
    // We are FORCED to override the abstract method from the parent!
    @Override
    public void drive() {
        System.out.println("Driving silently using electricity...");
    }
}

public class Topic_09_AbstractClasses {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Abstraction ---");
        // Vehicle v = new Vehicle(); // COMPILER ERROR! Cannot instantiate abstract class!
        
        Vehicle myCar = new Tesla(); // Upcasting works perfectly!
        myCar.honkHorn(); // Inherited normal method
        myCar.drive();    // Overridden abstract method
    }
}
