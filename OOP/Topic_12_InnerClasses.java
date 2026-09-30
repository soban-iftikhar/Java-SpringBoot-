/*
 * Topic 12: Inner Classes & Anonymous Inner Classes
 * 
 * --- LEVEL 0: BEGINNER ---
 * 1. Inner Classes: Creating a class completely inside another class.
 * 2. Anonymous Inner Classes: Creating a class on the fly without giving it a name!
 */

// ==========================================
// 1. INNER CLASSES
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

// Needed for the anonymous inner class example
abstract class SecretAgent {
    public abstract void doMission();
}

public class Topic_12_InnerClasses {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Inner Classes ---");
        // Creating an Inner Class object is unique. You need an Outer object first!
        OuterComputer myPC = new OuterComputer();
        OuterComputer.InnerRAM myRAM = myPC.new InnerRAM();
        myRAM.loadMemory();
        
        
        System.out.println("\n--- 2. Testing Anonymous Inner Classes ---");
        // What if we want a ONE-TIME use SecretAgent, but we don't want to create a whole new named class file?
        // We can create an Anonymous Inner Class on the fly!
        SecretAgent jamesBond = new SecretAgent() {
            @Override
            public void doMission() {
                System.out.println("Infiltrating the enemy base in a tuxedo...");
            }
        }; // Notice the semicolon here!
        
        jamesBond.doMission();
    }
}
