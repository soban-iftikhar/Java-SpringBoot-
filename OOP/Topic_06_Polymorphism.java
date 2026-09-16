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
    @Override
    public void makeSound() {
        System.out.println("Bark! Bark! 🐕");
    }

    // A method specific ONLY to Dog
    public void fetch() {
        System.out.println("The dog is fetching the ball! 🎾");
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
        myPrinter.print("Hello Java"); 
        myPrinter.print(404);           
        myPrinter.print("Alpha", "Beta"); 
        
        System.out.println("\n--- 2. Testing Method Overriding (Animals) ---");
        Animal generic = new Animal();
        Dog myDog = new Dog();
        
        generic.makeSound();
        myDog.makeSound(); 
        myDog.fetch(); // Works perfectly, myDog is a Dog reference pointing to a Dog object.
        
        // =========================================================================
        // --- LEVEL 1: THE HARDEST PART (Upcasting, Downcasting & Visibility) ---
        // =========================================================================
        System.out.println("\n--- 3. Upcasting & Dynamic Method Dispatch ---");
        
        // UPCASTING: Storing a Child object in a Parent reference variable.
        // Rule: The REFERENCE TYPE (Animal) determines WHAT methods you can call (Visibility).
        // Rule: The ACTUAL OBJECT (Dog) determines WHICH version of the method runs (Execution).
        Animal mysteryAnimal = new Dog(); 
        
        System.out.print("Mystery Animal says: ");
        mysteryAnimal.makeSound(); // Outputs: Bark! Bark! (Dynamic Dispatch to Dog's overridden method)
        
        // THE TRAP: Can we call fetch()?
        // mysteryAnimal.fetch(); // COMPILER ERROR! 
        // Why? The compiler only looks at the REFERENCE TYPE (`Animal`). 
        // The `Animal` class does NOT have a `fetch()` method, so the compiler panics and blocks it.
        // It doesn't care that the actual object in memory is a Dog.
        
        System.out.println("\n--- 4. Downcasting (Solving the Trap) ---");
        // DOWNCASTING: Telling the compiler "Trust me, I know this Animal is actually a Dog!"
        // We temporarily cast the reference back down to a Dog so we can access Dog-specific methods.
        Dog revealedDog = (Dog) mysteryAnimal;
        revealedDog.fetch(); // Works perfectly! 
        
        // Or done in one line:
        // ((Dog) mysteryAnimal).fetch();

        // THE DOWNCASTING DANGER (ClassCastException)
        // If you try to downcast an object into something it isn't, your program will crash at runtime.
        /*
        Animal sneakyCat = new Cat();
        Dog fakeDog = (Dog) sneakyCat; // COMPILER ALLOWS THIS, but crashes at RUNTIME (ClassCastException)
        */
        
        // SAFE DOWNCASTING using 'instanceof'
        Animal unknown = new Cat();
        if (unknown instanceof Dog) {
            ((Dog) unknown).fetch();
        } else {
            System.out.println("Cannot downcast: This animal is not a Dog!");
        }
    }
}
