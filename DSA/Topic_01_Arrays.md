# Arrays: Theoretical Notes

## Drawbacks of Arrays

While arrays are incredibly fast and fundamental to Java, they come with several significant limitations that you must consider when designing software.

### 1. Fixed Size (Static Allocation)
This is the most severe limitation of traditional arrays. When you create an array (e.g., `new int[10]`), its size is permanently locked. 
- **The Problem:** If you fill all 10 slots and need to add an 11th item, you cannot simply "expand" the array. You are forced to create a brand new, larger array and manually copy all the old elements over. Conversely, if you allocate an array of 10,000 slots but only use 5, you have permanently wasted a massive chunk of Heap memory.
- **The Solution:** Use dynamic data structures like `ArrayList` (which handles the resizing and copying behind the scenes).

### 2. Homogeneous Data Restriction
Arrays in Java are strictly typed. An `int[]` can only hold integers, and a `String[]` can only hold Strings.
- **The Problem:** You cannot mix data types in a single standard array. 
- **The Workaround:** You *can* create an `Object[]` array to hold mixed types, but this destroys type safety. You would have to constantly cast objects back to their original types, risking `ClassCastException`s at runtime.

### 3. Contiguous Memory Requirement
When the JVM allocates an array, it searches the Heap for a **contiguous** (unbroken, side-by-side) block of memory large enough to hold the entire array.
- **The Problem:** If you try to allocate an absolutely massive array, the JVM might throw an `OutOfMemoryError`. This can happen even if your computer actually has enough total free RAM, simply because the free memory is fragmented and there isn't a single contiguous block big enough to fit the array all at once.

### 4. Inefficient Insertions and Deletions
Arrays do not have built-in methods to "insert" an item in the middle or "delete" an item.
- **The Problem:** If you want to insert a new element at index 0 of an existing array, you must manually shift every single existing element one position to the right to make room. Similarly, deleting an element leaves an empty gap (usually `0` or `null`) unless you manually shift all elements to the left to close the gap. Both of these operations take **O(n) time**, making arrays highly inefficient for frequently modified lists.
