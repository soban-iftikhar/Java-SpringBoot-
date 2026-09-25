# Array of Objects: Theoretical Notes

## Understanding References in Arrays

When dealing with primitive arrays (like `int[]` or `double[]`), the actual values (`5`, `10.5`) are stored directly inside the array's memory slots.

However, when you create an array of custom objects (like `Student[]`), the behavior changes entirely due to how Java handles memory:

### 1. The Array Stores Pointers, Not Objects
An array of objects **does not store the objects themselves**. Instead, it stores **references** (memory addresses or pointers). 
- When you initialize `Student[] classroom = new Student[3];`, you are simply creating an array with 3 empty slots. 
- At this point, the default value for each slot is `null`. No `Student` objects exist in memory yet.

### 2. The Heap Allocation
When you actually instantiate an object (e.g., `classroom[0] = new Student("Alice");`), the JVM:
1. Creates the `Student` object somewhere in the massive **Heap** memory.
2. Takes the memory address of that object and places it into `classroom[0]`.

### 3. The `NullPointerException` Trap
Because arrays of objects start filled with `null`, attempting to access a property or method on an uninitialized slot (e.g., `classroom[1].getName()`) will instantly crash your program with a `NullPointerException`. You must always instantiate the object first before interacting with it.

### 4. The Need for `toString()`
Because the array holds references, if you try to print the array directly (e.g., `System.out.println(Arrays.toString(classroom));`), Java will simply print the memory hashes of the objects. To see the actual data, you **must override the `toString()` method** inside your custom class.
