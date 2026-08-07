import java.util.Arrays;

/*
 * Topic 2: Array of Objects
 * 
 * --- LEVEL 0: BEGINNER ---
 * Just like you can create an array of primitives (like int or double), you can create an array 
 * of custom objects. 
 * - An array of objects doesn't actually store the objects themselves; it stores REFERENCES 
 *   (memory addresses) pointing to where the objects live on the Heap.
 */

// A simple custom class to demonstrate Array of Objects
class Student {
    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // --- LEVEL 1: ADVANCED (The Need for toString) ---
    // If we don't override this method, printing the object will use the default Object.toString(),
    // which outputs something useless like "Student@452b3a41".
    // Overriding toString() allows us to define EXACTLY how we want this object to look as text.
    @Override
    public String toString() {
        return "{Name: '" + name + "', RollNo: " + rollNumber + "}";
    }
}

public class Topic_02_ArrayOfObjects {
    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Creating an Array of Objects ---");
        
        // Step 1: Create the array structure (this ONLY creates the slots for references, NOT the objects!)
        // Right now, classroom[0], classroom[1], and classroom[2] are all 'null'.
        Student[] classroom = new Student[3];
        
        // Step 2: Instantiate the actual objects and assign them to the array slots
        classroom[0] = new Student("Alice", 101);
        classroom[1] = new Student("Bob", 102);
        classroom[2] = new Student("Charlie", 103);
        
        // Accessing object properties from the array
        System.out.println("The first student is: " + classroom[0].name);


        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 2. Advanced Concept: Why do we need toString()? ---");
        
        // Scenario A: Without toString()
        // Imagine if we commented out the @Override toString() method in the Student class above.
        // If we tried to print `classroom[0]`, Java wouldn't know how to format a "Student" into text.
        // It would fall back to the default Object class implementation and print a memory hash (e.g., Student@15db9742).
        
        // Scenario B: With toString()
        // Because we overrode toString(), Java automatically calls it whenever we try to print the object.
        System.out.println("Printing a single object: " + classroom[1]); 
        
        
        System.out.println("\n--- 3. Advanced Feature: Printing the entire Array of Objects ---");
        // What happens if we want to print the entire array at once?
        
        // EDGE CASE: If you print the array directly, you get the ARRAY's memory hash, not the contents!
        System.out.println("Wrong way to print array: " + classroom); // Output: [LStudent;@...
        
        // Correct Way: Use Arrays.toString()
        // Arrays.toString() loops through your array and calls the overridden toString() on EACH object inside.
        // This is why having a custom toString() method is absolutely critical for debugging arrays of objects!
        System.out.println("Right way to print array:");
        System.out.println(Arrays.toString(classroom));


        System.out.println("\n--- 4. Master Edge Case: NullPointerException in Object Arrays ---");
        // Because arrays of objects are initialized with 'null' by default, 
        // forgetting to instantiate an object before accessing it will cause a crash.
        Student[] emptyClass = new Student[2]; // Slots exist, but they point to null.
        
        try {
            // Attempting to access the 'name' property of a null reference
            System.out.println(emptyClass[0].name);
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException! You forgot to initialize the object in the array slot.");
        }
    }
}
