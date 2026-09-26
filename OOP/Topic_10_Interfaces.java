/*
 * Topic 10: Interfaces
 * 
 * --- LEVEL 0: BEGINNER ---
 * An Interface is a completely "contractual" blueprint. 
 * By default, it can only contain abstract methods and final variables (constants).
 * 
 * The biggest superpower of Interfaces: Multiple Inheritance!
 * While a Java class can only 'extend' ONE parent class, it can 'implements' 
 * MULTIPLE interfaces simultaneously!
 */

// ==========================================
// 1. DEFINING INTERFACES
// ==========================================
interface Flyable {
    // All variables in an interface are implicitly 'public static final' (Constants)
    int MAX_ALTITUDE = 30000; 

    // All methods in an interface are implicitly 'public abstract' (No body)
    void fly(); 
}

interface Swimmable {
    void swim();
}

// ==========================================
// 2. IMPLEMENTING INTERFACES (Multiple Inheritance)
// ==========================================
// The Duck class is forced to sign a contract: It MUST provide an implementation 
// for every single method defined in both Flyable and Swimmable.
class Duck implements Flyable, Swimmable {

    @Override
    public void fly() {
        System.out.println("The duck flaps its wings and takes off! Max altitude: " + MAX_ALTITUDE);
    }

    @Override
    public void swim() {
        System.out.println("The duck paddles happily in the pond.");
    }
}

// ==========================================
// 3. JAVA 8 ADVANCED: Default Methods
// ==========================================
interface SmartDevice {
    void turnOn();

    // Since Java 8, interfaces CAN have methods with bodies if you mark them as 'default'.
    // This allows you to add new methods to an interface without breaking old classes that already implement it!
    default void connectToWifi() {
        System.out.println("Connecting to 5G network...");
    }
}

class SmartPhone implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Smartphone powering on.");
    }
    // Note: We don't HAVE to override connectToWifi(), we get it for free!
}


public class Topic_10_Interfaces {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Multiple Inheritance (Duck) ---");
        Duck donald = new Duck();
        donald.fly();
        donald.swim();
        
        System.out.println("\n--- 2. Testing Default Methods (SmartPhone) ---");
        SmartPhone iphone = new SmartPhone();
        iphone.turnOn();
        iphone.connectToWifi(); // Uses the default implementation provided by the interface!
        
        
        // --- LEVEL 1: MASTER EDGE CASE (Interface Upcasting) ---
        System.out.println("\n--- 3. Upcasting to an Interface ---");
        // Just like Abstract classes, you can use an Interface as a reference type!
        Flyable mysteryBird = new Duck();
        mysteryBird.fly();
        // mysteryBird.swim(); // COMPILER ERROR! The Flyable reference doesn't know about swimming.
    }
}
