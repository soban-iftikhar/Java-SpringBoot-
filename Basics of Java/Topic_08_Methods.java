/*
 * Topic 8: Methods
 * 
 * --- LEVEL 0: BEGINNER ---
 * Methods are blocks of code that perform a specific task, promoting code reusability.
 * - They can take inputs (parameters).
 * - They can return an output (return type) or return nothing (`void`).
 * - Method Overloading: Having multiple methods with the same name but different parameters.
 */
public class Topic_08_Methods {
    
    // Helper class for reference testing later
    static class Person {
        String name;
        Person(String name) { this.name = name; }
    }

    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Basic Methods ---");
        greet(); // Calling a method without parameters
        
        int sum = add(5, 10); // Calling a method with parameters and a return value
        System.out.println("Sum: " + sum);


        System.out.println("\n--- 2. Method Overloading ---");
        // Java knows which method to call based on the arguments provided.
        System.out.println("Multiply 2 ints: " + multiply(5, 5));
        System.out.println("Multiply 3 ints: " + multiply(5, 5, 5));



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 3. Advanced Concept: Pass-by-Value (Primitives) ---");
        // Java is STRICTLY pass-by-value. 
        // When you pass a primitive, you are passing a COPY of the value.
        int x = 10;
        modifyPrimitive(x);
        System.out.println("Value of x after modifyPrimitive: " + x); // Still 10!


        System.out.println("\n--- 4. Advanced Concept: Pass-by-Reference-Value (Objects) ---");
        // When you pass an object, you pass a COPY of the MEMORY ADDRESS (reference).
        Person p = new Person("Alice");
        
        // Scenario A: Mutating the object's internals
        // Because the copy points to the same object in memory, modifications ARE visible.
        mutateObject(p);
        System.out.println("Name after mutateObject: " + p.name); // Bob!
        
        // Scenario B: Reassigning the reference entirely
        // This only changes the local copy of the reference. The original object is untouched.
        reassignReference(p);
        System.out.println("Name after reassignReference: " + p.name); // Still Bob!


        System.out.println("\n--- 5. Advanced Feature: Varargs (...) ---");
        // Variable-length arguments allow you to pass zero or multiple arguments. 
        // The method receives them as an array.
        printNames("Charlie"); // One arg
        printNames("Dave", "Eve", "Frank"); // Multiple args


        System.out.println("\n--- 6. Advanced Edge Case: Overloading Ambiguity ---");
        // The compiler determines which overloaded method to call based on the MOST SPECIFIC match.
        // EDGE CASE: Passing 'null' can cause ambiguity.
        
        // String is a subclass of Object, so it is more specific.
        // This will call the 'String' version, not the 'Object' version.
        process(null); 
    }


    // --- Beginner Method Definitions ---

    static void greet() {
        System.out.println("Hello, welcome to methods!");
    }

    static int add(int a, int b) {
        return a + b;   
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int multiply(int a, int b, int c) {
        return a * b * c;
    }


    // --- Advanced Method Definitions ---

    static void modifyPrimitive(int num) {
        num = 99; // Only modifies the local copy
    }

    static void mutateObject(Person p) {
        p.name = "Bob"; // Modifies the actual object on the heap
    }

    static void reassignReference(Person p) {
        p = new Person("Charlie"); // Only changes the local reference variable!
    }

    // RULES FOR VARARGS: 
    // 1. You can only have ONE varargs parameter.
    // 2. It MUST be the very last parameter in the list (e.g., `void m(int x, String... y)`).
    static void printNames(String... names) {
        System.out.print("Received " + names.length + " names: ");
        for (String n : names) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    static void process(Object o) {
        System.out.println("Processed as Object");
    }

    static void process(String s) {
        System.out.println("Processed as String (More specific than Object!)");
    }
    
    // Uncommenting the following method would cause a COMPILER ERROR when calling process(null).
    // String and Integer are siblings in the class hierarchy, and 'null' matches both equally, 
    // causing an ambiguous method call error!
    // static void process(Integer i) { }
}
