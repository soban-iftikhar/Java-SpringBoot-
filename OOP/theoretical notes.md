# OOP Theoretical Notes

## 1. Memory Management: Stack vs. Heap Memory

When a Java program runs, the JVM divides the available memory into several distinct areas. The two most important areas for object-oriented programming are the Stack and the Heap.

### The Stack Memory (Local Variables & Method Calls)
The Stack is a highly organized, linear memory space used for thread execution. It operates on a Last-In, First-Out (LIFO) principle.
- **What goes here:** The Stack stores **local variables** (primitives like `int`, `double`, `boolean` declared inside a method) and the execution history of method calls. It also stores **references** (the memory addresses) to objects, but not the objects themselves.
- **How it works:** Whenever you call a method in Java, a new block of memory called a "Stack Frame" is instantly created at the top of the Stack. This frame holds all the local variables for that specific method.
- **Lifecycle:** The lifecycle of variables on the Stack is strictly tied to their method. As soon as a method finishes executing, its Stack Frame is immediately "popped" off the stack, and all its local variables are destroyed and cleared from memory instantly. 
- **Performance:** Because of this strict, sequential behavior, allocating and deallocating memory on the Stack is incredibly fast. However, the Stack size is very limited. If you have too many nested method calls (like infinite recursion), the Stack will run out of space and throw a `StackOverflowError`.

### The Heap Memory (Objects & Instance Variables)
The Heap is a massive, unstructured pool of memory used for dynamic allocation. 
- **What goes here:** The Heap stores **all objects**, no matter where or how they were created, as well as their **instance variables** (the state/properties belonging to that object). Even if an object is created inside a method, the object itself goes to the Heap, while only a small reference variable (acting like a remote control) is placed on the Stack to point to it.
- **How it works:** Because objects can vary wildly in size and their lifespan isn't neatly tied to a single method call, they cannot be stored in the rigid Stack. Instead, they are placed in the Heap, where they can be shared globally across multiple methods and threads. 
- **Lifecycle:** Variables on the Heap do not die when a method ends. An object will remain in the Heap for as long as there is at least one active reference pointing to it from the Stack. When an object has no more references pointing to it (it becomes "unreachable"), the JVM's Garbage Collector automatically identifies it and destroys it to free up memory.
- **Performance:** Accessing data on the Heap is slower than the Stack because it requires following pointers, and memory management is more complex. If your application creates too many large objects and fills up the Heap, it will throw an `OutOfMemoryError`.
