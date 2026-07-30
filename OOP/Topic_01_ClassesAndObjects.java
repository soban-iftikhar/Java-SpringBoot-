/*
 * OOP Topic 1: Classes and Objects
 * 
 * --- LEVEL 0: BEGINNER ---
 * - A Class is a blueprint for creating objects. It defines properties (attributes) and behaviors (methods).
 * - An Object is a physical instance of a class, created using the `new` keyword.
 * - Constructors are special methods called when an object is created to set up its initial state.
 */

class Car {
    
    // --- LEVEL 0: BEGINNER (Properties & Behaviors) ---
    
    // Instance variables (Properties)
    String color;
    String model;

    // Default Constructor (Takes no arguments)
    public Car() {
        // --- LEVEL 1: ADVANCED (Constructor Chaining) ---
        // `this(...)` calls another constructor in the SAME class. 
        // EDGE CASE: It MUST be the very first statement in the constructor.
        this("Unknown Color", "Unknown Model"); 
        System.out.println("[CONSTRUCTOR] Default constructor finished chaining.");
    }

    // Parameterized Constructor
    public Car(String color, String model) {
        // 'this' refers to the current object. It differentiates instance variables from parameters.
        this.color = color;
        this.model = model;
        System.out.println("[CONSTRUCTOR] Parameterized constructor built: " + this.color + " " + this.model);
    }

    // Behaviors (Methods)
    void startEngine() {
        System.out.println("The engine of the " + color + " " + model + " is starting.");
    }
    

    // --- LEVEL 1: ADVANCED (Advanced Memory & Initialization) ---

    // Static variable: Shared among ALL instances of the class. Stored in the Metaspace.
    // Memory is allocated exactly once when the class is loaded.
    static int totalCarsBuilt = 0;

    // Static Initialization Block:
    // Executes EXACTLY ONCE when the class is first loaded, before any objects are created.
    static {
        System.out.println("[STATIC BLOCK] Car class is loaded into memory.");
    }

    // Instance Initialization Block:
    // Executes EVERY TIME an object is created, BEFORE the constructor runs.
    {
        totalCarsBuilt++;
        System.out.println("[INSTANCE BLOCK] A new car chassis is being assembled...");
    }

    // Static Method: Can only access static data! Cannot use 'this'.
    static void printTotalCars() {
        System.out.println("Total cars factory has built so far: " + totalCarsBuilt);
    }
}


public class Topic_01_ClassesAndObjects {
    public static void main(String[] args) {
        
        // --- LEVEL 0: BEGINNER (Object Creation) ---
        System.out.println("--- 1. Creating Objects ---");
        Car defaultCar = new Car(); // Uses default constructor
        defaultCar.startEngine();
        
        Car myCar = new Car("Red", "Toyota"); // Uses parameterized constructor
        myCar.startEngine();



        // --- LEVEL 1: ADVANCED (Advanced Access & Lifecycle) ---
        
        System.out.println("\n--- 2. Static vs Instance Access ---");
        // Static variables/methods should be accessed via the Class name, not the object reference.
        // Doing `myCar.printTotalCars()` is legal but considered bad practice.
        Car.printTotalCars(); 


        System.out.println("\n--- 3. Anonymous Objects & Garbage Collection ---");
        // If an object is created but its reference is not stored in a variable, it is an anonymous object.
        // It can be used EXACTLY once.
        new Car("Blue", "Ford").startEngine();
        
        // Because there is no reference variable pointing to the Blue Ford, 
        // it instantly becomes unreachable and is eligible for Garbage Collection by the JVM.
    }
}