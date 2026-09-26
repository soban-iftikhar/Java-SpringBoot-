/*
 * Topic 9: Abstraction & Inner Classes
 * 
 * --- LEVEL 0: BEGINNER ---
 * 1. Abstraction (The 'abstract' keyword): Hiding the complex implementation details and 
 *    showing only the essential features of an object.
 * 2. Inner Classes: Creating a class inside another class.
 * 3. Anonymous Inner Classes: Creating a class on the fly without giving it a name!
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
        System.out.println("Driving silently using electricity... ⚡");
    }
}

// ==========================================
// 2. INNER CLASSES
// ==========================================
class OuterComputer {
    private String cpu = "Intel i9";

    // A class created INSIDE another class.
    // Useful when the inner class is logically tied to the outer class and shouldn't be used anywhere else.
    class InnerRAM {
        public void loadMemory() {
            // The Inner class has magical access to the Outer class's PRIVATE variables!
            System.out.println("Loading memory for the " + cpu + " processor.");
        }
    }
}


public class Topic_09_AbstractAndInnerClasses {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Abstraction ---");
        // Vehicle v = new Vehicle(); // COMPILER ERROR! Cannot instantiate abstract class!
        Vehicle myCar = new Tesla(); // Upcasting works perfectly!
        myCar.honkHorn(); // Inherited normal method
        myCar.drive();    // Overridden abstract method
        
        
        System.out.println("\n--- 2. Testing Inner Classes ---");
        // Creating an Inner Class object is weird. You need an Outer object first!
        OuterComputer myPC = new OuterComputer();
        OuterComputer.InnerRAM myRAM = myPC.new InnerRAM();
        myRAM.loadMemory();
        
        
        System.out.println("\n--- 3. Testing Anonymous Inner Classes ---");
        // What if we want a ONE-TIME use Vehicle, but we don't want to create a whole new named class file?
        // We can create an Anonymous Inner Class on the fly!
        Vehicle batmobile = new Vehicle() {
            @Override
            public void drive() {
                System.out.println("Jet engine engages... The Batmobile vanishes into the night! 🦇");
            }
        }; // Notice the semicolon here!
        
        batmobile.drive();
    }
}
