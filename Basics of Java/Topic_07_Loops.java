import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Topic 7: Loops and Iteration
 * 
 * --- LEVEL 0: BEGINNER ---
 * Loops are used to execute a block of code repeatedly.
 * 1. for loop: When you know the exact number of iterations.
 * 2. while loop: When you want to loop until a condition becomes false.
 * 3. do-while loop: Guarantees the code runs at least once.
 * 4. enhanced for loop (for-each): For easily iterating arrays/collections.
 */
public class Topic_07_Loops {
    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. For Loop ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("For iteration: " + i);
        }

        System.out.println("\n--- 2. While Loop ---");
        int j = 0;
        while (j < 3) {
            System.out.println("While iteration: " + j);
            j++;
        }

        System.out.println("\n--- 3. Do-While Loop ---");
        // Executes at least once, even if the condition is already false!
        int k = 10;
        do {
            System.out.println("Do-While ran! k is: " + k);
        } while (k < 3);

        System.out.println("\n--- 4. Enhanced For Loop (For-Each) ---");
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 5. Advanced Concept: Variable Scope ---");
        // Variables declared inside the initialization block of a for-loop 
        // are scoped strictly to that loop.
        // EDGE CASE: 'i' is out of scope here.
        // System.out.println(i); // COMPILER ERROR

        // If you need the variable after the loop finishes, declare it outside.
        int x;
        for (x = 0; x < 3; x++) { }
        System.out.println("Outside loop, x ended at: " + x); // Prints 3


        System.out.println("\n--- 6. Advanced Feature: Labeled Loops ---");
        // Normally, 'break' only escapes the innermost loop.
        // What if you want to break out of a deeply nested loop completely? Use a Label.
        outerLoop: 
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if (row == 2 && col == 2) {
                    System.out.println("   Condition met! Breaking outerLoop completely.");
                    break outerLoop; // Exits BOTH loops entirely
                }
                System.out.println("Row: " + row + ", Col: " + col);
            }
        }


        System.out.println("\n--- 7. Advanced Edge Case: The ConcurrentModificationException Trap ---");
        List<String> dynamicList = new ArrayList<>(List.of("A", "B", "C"));
        
        // EDGE CASE: If you try to ADD or REMOVE elements from a collection while 
        // iterating over it with a for-each loop, Java throws a ConcurrentModificationException.
        try {
            for (String item : dynamicList) {
                if (item.equals("B")) {
                    // dynamicList.remove(item); // CRASHES! 
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.err.println("Caught ConcurrentModificationException!");
        }

        // The safe way to modify a collection during iteration is using an Iterator explicitely.
        System.out.println("Safe removal using Iterator:");
        Iterator<String> iterator = dynamicList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("B")) {
                iterator.remove(); // Safely removes the current element
                System.out.println("   Removed B safely.");
            }
        }
    }
}
