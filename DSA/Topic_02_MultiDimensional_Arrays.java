import java.util.Arrays;

/*
 * Topic 2: Multi-Dimensional Arrays
 * 
 * --- LEVEL 0: BEGINNER ---
 * A multi-dimensional array is simply an array of arrays.
 * - The most common is the 2D array, which can be thought of as a table or grid with rows and columns.
 * - They are used to represent matrices, game boards (like Chess or Tic-Tac-Toe), or coordinates.
 */
public class Topic_02_MultiDimensional_Arrays {
    public static void main(String[] args) {

        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Declaring and Initializing a 2D Array ---");
        
        // Method A: Declare and allocate size (e.g., 3 rows, 4 columns)
        int[][] grid = new int[3][4];
        grid[0][0] = 1; // Top-left corner
        grid[2][3] = 9; // Bottom-right corner

        // Method B: Inline initialization (Matrix representation)
        int[][] matrix = {
            {1, 2, 3}, // Row 0
            {4, 5, 6}, // Row 1
            {7, 8, 9}  // Row 2
        };

        System.out.println("Value at Row 1, Col 2: " + matrix[1][2]); // Prints 6


        System.out.println("\n--- 2. Iterating Through a 2D Array ---");
        // We use nested loops: the outer loop goes through the rows, the inner loop goes through the columns.
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }


        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---

        System.out.println("\n--- 3. Advanced Concept: Jagged Arrays ---");
        // Because a 2D array is literally an "array of arrays", the inner arrays DO NOT have to be the same length!
        // This is called a Jagged (or Ragged) Array. It saves memory when you have uneven data.
        int[][] jaggedArray = new int[3][]; // Notice we don't define the column size yet!
        
        jaggedArray[0] = new int[2]; // Row 0 has 2 columns
        jaggedArray[1] = new int[4]; // Row 1 has 4 columns
        jaggedArray[2] = new int[1]; // Row 2 has 1 column
        
        // Inline jagged array
        int[][] triangle = {
            {1},
            {1, 2},
            {1, 2, 3},
            {1, 2, 3, 4}
        };
        
        System.out.println("Printing a Jagged Array:");
        for (int[] row : triangle) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }


        System.out.println("\n--- 4. Advanced Feature: Deep Printing ---");
        // Arrays.toString() doesn't work well for 2D arrays because it prints the memory addresses of the inner arrays.
        // EDGE CASE: You must use Arrays.deepToString() to correctly print multi-dimensional arrays.
        System.out.println("Wrong way (toString): " + Arrays.toString(matrix));
        System.out.println("Right way (deepToString): " + Arrays.deepToString(matrix));


        System.out.println("\n--- 5. Advanced Famous Example: Matrix Transposition ---");
        // Famous Algorithm: Transposing a Matrix
        // Transposing means flipping a matrix over its diagonal, switching its row and column indices.
        // It's a foundational concept in Linear Algebra and Computer Graphics.
        int[][] original = {
            {1, 2, 3},
            {4, 5, 6}
        }; // A 2x3 matrix

        int rows = original.length;       // 2
        int cols = original[0].length;    // 3

        // The transposed matrix will have its dimensions flipped (3x2)
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // The magic swap!
                transposed[j][i] = original[i][j];
            }
        }

        System.out.println("Original Matrix (2x3):");
        printMatrix(original);
        
        System.out.println("Transposed Matrix (3x2):");
        printMatrix(transposed);
    }

    // Helper method to print matrices neatly
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
