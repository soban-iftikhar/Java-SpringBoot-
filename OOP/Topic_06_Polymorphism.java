/*
 * Topic 6: Polymorphism (Overloading vs. Overriding)
 * 
 * --- LEVEL 0: BEGINNER ---
 * Polymorphism means "many forms". It allows methods to do different things based on the object 
 * that it is acting upon or the parameters passed to it.
 * 
 * There are two main types of Polymorphism in Java:
 * 1. Compile-Time Polymorphism (Method Overloading)
 * 2. Run-Time Polymorphism (Method Overriding)
 */

// ==========================================
// 1. METHOD OVERLOADING (Compile-Time)
// ==========================================
// Happens within the SAME class.
// Rule: Methods must have the SAME NAME but DIFFERENT PARAMETERS (different type, number, or order).
class Printer {
    
    // Method 1: Prints a string
    public void print(String text) {
        System.out.println("Printing Text: " + text);
    }
    
    // Method 2: OVERLOADED - Prints an integer
    public void print(int number) {
        System.out.println("Printing Number: " + number);
    }
    
    // Method 3: OVERLOADED - Prints multiple strings
    public void print(String text1, String text2) {
        System.out.println("Printing Two Texts: " + text1 + " & " + text2);
    }
    
    // Note: You CANNOT overload a method by just changing its return type!
    // public int print(String text) { return 1; } // This would cause a compile error.
}

// ==========================================
// 2. METHOD OVERRIDING (Run-Time)
// ==========================================
// Happens between a PARENT and CHILD class (Requires Inheritance).
// Rule: The method in the child class must have the EXACT SAME name and parameters as the parent.

class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

class Dog extends Animal {
    
    // The @Override annotation is optional but HIGHLY recommended.
    // It tells the compiler to double-check that you are actually overriding a parent method.
    // If you misspell it as 'makeSounds()', the compiler will throw an error saving you from a bug!
    @Override
    public void makeSound() {
        System.out.println("Bark! Bark! 🐕");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow! 🐈");
    }
}


public class Topic_06_Polymorphism {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Method Overloading (Printer) ---");
        Printer myPrinter = new Printer();
        // The Java Compiler knows exactly which method to call based on the argument provided!
        myPrinter.print("Hello Java");  // Calls Method 1
        myPrinter.print(404);           // Calls Method 2
        myPrinter.print("Alpha", "Beta"); // Calls Method 3
        
        
        System.out.println("\n--- 2. Testing Method Overriding (Animals) ---");
        Animal generic = new Animal();
        Dog myDog = new Dog();
        Cat myCat = new Cat();
        
        generic.makeSound();
        myDog.makeSound(); // Overridden behavior executes!
        myCat.makeSound(); // Overridden behavior executes!
        
        
        // --- LEVEL 1: MASTER EDGE CASE (Dynamic Method Dispatch) ---
        System.out.println("\n--- 3. Master Concept: Upcasting & Dynamic Dispatch ---");
        // Because of the 'IS-A' relationship, we can store a Dog in an Animal reference variable.
        Animal mysteryAnimal = new Dog(); 
        
        // Which makeSound() will run? The Animal's or the Dog's?
        // Answer: The JVM looks at the ACTUAL OBJECT created on the Heap (Dog), not the reference type (Animal).
        // This decision happens while the program is running (Run-Time Polymorphism).
        System.out.print("Mystery Animal says: ");
        mysteryAnimal.makeSound(); // Outputs: Bark! Bark!
    }
}
