import java.util.Arrays;

/*
 * Topic 1: Arrays (Single Dimensional)
 * 
 * --- LEVEL 0: BEGINNER ---
 * An array is a container object that holds a fixed number of values of a single type.
 * - The length of an array is established when the array is created. After creation, its length is fixed.
 * - Each item in an array is called an element, and each element is accessed by its numerical index (starting from 0).
 */
public class Topic_01_Arrays {
    public static void main(String[] args) {
        
        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Declaring and Initializing Arrays ---");
        
        // Method A: Declare, allocate, and initialize separately
        int[] numbers = new int[5]; // Allocates memory for 5 integers. Default value is 0.
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Method B: Inline initialization (Syntactic Sugar)
        String[] fruits = {"Apple", "Banana", "Cherry"};

        System.out.println("First number: " + numbers[0]);
        System.out.println("Fruit at index 1: " + fruits[1]);
        System.out.println("Length of fruits array: " + fruits.length);


        System.out.println("\n--- 2. Iterating Through an Array ---");
        // Standard For Loop (Useful when you need the index)
        System.out.print("Standard Loop: ");
        for (int i = 0; i < fruits.length; i++) {
            System.out.print(fruits[i] + " ");
        }
        
        // Enhanced For Loop / For-Each (Cleaner when you just need the values)
        System.out.print("\nEnhanced Loop: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 3. Advanced Edge Case: Out of Bounds Exception ---");
        // Because arrays are fixed in size and zero-indexed, accessing length or beyond crashes the program.
        try {
            int outOfBounds = numbers[5]; // numbers only goes from 0 to 4!
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException! You tried to access an index that doesn't exist.");
        }


        System.out.println("\n--- 4. Advanced Concept: Anonymous Arrays ---");
        // You can create and pass an array without assigning it to a variable first.
        // Useful for one-time use, like passing to a method.
        System.out.println("Sum of anonymous array: " + sum(new int[]{1, 2, 3, 4, 5}));


        System.out.println("\n--- 5. Advanced Feature: The Arrays Utility Class ---");
        // The java.util.Arrays class provides powerful static methods to manipulate arrays.
        int[] randomData = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8};
        
        // 1. Printing directly (instead of looping)
        System.out.println("Unsorted: " + Arrays.toString(randomData));
        
        // 2. Sorting (Uses Dual-Pivot Quicksort internally)
        Arrays.sort(randomData);
        System.out.println("Sorted:   " + Arrays.toString(randomData));
        
        // 3. Binary Search (Array MUST be sorted first!)
        int index = Arrays.binarySearch(randomData, 42);
        System.out.println("The number 42 is at index: " + index);
        
        // 4. Filling an array rapidly
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 9); // Fills all elements with 9
        System.out.println("Filled Array: " + Arrays.toString(filledArray));


        System.out.println("\n--- 6. Advanced Famous Example: Reversing an Array In-Place ---");
        // Famous Algorithm: Two-Pointer Technique
        // Instead of creating a new array, we swap elements from the outside moving inwards.
        // This is highly memory efficient (O(1) space complexity).
        char[] letters = {'J', 'A', 'V', 'A', 'S', 'P', 'R', 'I', 'N', 'G'};
        System.out.println("Original: " + Arrays.toString(letters));
        
        int left = 0;
        int right = letters.length - 1;
        
        while (left < right) {
            // Swap the elements
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            
            // Move pointers towards the center
            left++;
            right--;
        }
        
        System.out.println("Reversed: " + Arrays.toString(letters));
    }

    // Helper method for the anonymous array example
    static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        return total;
    }
}