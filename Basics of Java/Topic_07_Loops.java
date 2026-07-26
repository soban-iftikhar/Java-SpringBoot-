public class Topic_07_Loops {
    public static void main(String[] args) {
        // Loops in Java
        /*
        Loops are used to execute a block of code repeatedly until a certain condition is met. Java provides several types of loops:
        1. for loop
        2. while loop
        3. do-while loop
        4. enhanced for loop (for-each loop)
        */

        /*
        For Loop: 
        The for loop is used when the number of iterations is known beforehand. It consists of three parts: 
        initialization, condition, and increment/decrement. 
        Usecase: When you want to repeat a block of code a specific number of times.
        */

        System.out.println("For Loop Example:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }

        /*
        While Loop:
        The while loop is used when the number of iterations is not known beforehand. It continues to execute as long as 
        the condition is true.
        Usecase: When you want to repeat a block of code until a certain condition is met, but you don't know how many times it will run.
        */
        System.out.println("\nWhile Loop Example:");
        int j = 0;
        while (j < 5) {
            System.out.println("Iteration: " + j);
            j++;
        }

        /*
        Do-While Loop:
        The do-while loop is similar to the while loop, but it guarantees that the code block will be executed at least once, 
        even if the condition is false initially. 
        Usecase: When you want to ensure that the loop body is executed at least once, regardless of the condition.
        */
        System.out.println("\nDo-While Loop Example:");
        int k = 0;
        do {
            System.out.println("Iteration: " + k);
            k++;
        } while (k < 5);

        /*
        Enhanced For Loop (For-Each Loop):
        The enhanced for loop is used to iterate over arrays or collections. It simplifies the syntax and eliminates the need 
        for an index variable. 
        Usecase: When you want to iterate over all elements in an array or collection without needing to manage an index.
        */
        System.out.println("\nEnhanced For Loop Example:");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }
    }
}
