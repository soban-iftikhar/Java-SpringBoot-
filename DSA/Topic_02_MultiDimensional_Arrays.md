# Multi-Dimensional Arrays: Theoretical Notes

## Jagged (Ragged) Arrays

In Java, a multi-dimensional array is not a flat, continuous block of memory like in some other languages (e.g., C or C++). Instead, it is strictly an **array of arrays**. This fundamental design choice allows for the creation of Jagged Arrays.

### What is a Jagged Array?
A jagged array (also known as a ragged array) is a 2D array where the rows (the inner arrays) do not all have to be the same length. For example, the first row could have 2 columns, the second row could have 5 columns, and the third row could have just 1 column.

### How it Works in Memory
When you declare a 2D array like `int[][] jagged = new int[3][]`, you are actually creating a single one-dimensional array on the **Heap** with a length of 3. However, instead of storing integers, this outer array stores **references (pointers)**. 
- At this point, all 3 elements are `null` because the inner arrays haven't been created yet.
- When you initialize a row (`jagged[0] = new int[2];`), the JVM creates a brand new, separate 1D array of length 2 somewhere else on the Heap, and stores its memory address in `jagged[0]`.
- Because every row is an entirely independent array object living in the Heap, there is no strict requirement for them to share the same length.

### Why Use Jagged Arrays?
The primary benefit of jagged arrays is **memory optimization**. 
If you are working with irregular data (for example, representing a triangle of numbers, storing the varying number of days in different months, or keeping a list of variable-length schedules for employees), a traditional rectangular matrix would force you to allocate memory for the longest possible row. You would waste memory padding the shorter rows with zeros or nulls. A jagged array ensures you only allocate exactly the amount of Heap memory you need.
