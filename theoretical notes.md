# Java & Spring Boot: 0 to Master (Theoretical Notes)

A complete tutorial repository on Java with Spring Boot. This README serves as an ever-growing, comprehensive guide for all the core theoretical concepts you need to master Java.

---

## 1. The Java Ecosystem Architecture: JDK, JRE, and JVM

To truly understand how Java works behind the scenes, you must understand its three core components and how they wrap around one another like Russian nesting dolls. 

### The Core: JVM (Java Virtual Machine)
At the very center of the Java ecosystem is the JVM. The JVM is an abstract machine—a piece of software that simulates a physical computer. 
When you compile a Java program, it is not compiled into machine code (1s and 0s) that your specific operating system (like Windows or Linux) can understand. Instead, it is compiled into **bytecode** (a `.class` file). 
The JVM's primary job is to take that bytecode and translate it line-by-line into the native machine code of whatever system it happens to be running on. This is what makes Java platform-independent and gives it the famous motto: *"Write Once, Run Anywhere."* The JVM contains the Just-In-Time (JIT) compiler to optimize performance and the Garbage Collector to manage memory. However, the JVM by itself cannot run a program because it doesn't have the standard libraries (like `System.out.println` or `String`) available to it.

### The Runtime Wrapper: JRE (Java Runtime Environment)
Wrapping entirely around the JVM is the JRE. The JRE provides the physical environment where the JVM runs. 
If you simply want to **run** a Java application that someone else has already built, you only need to install the JRE on your computer. The JRE contains the JVM, but it also provides all the core Java Class Libraries (the standard packages like `java.util`, `java.lang`, `java.io`) and other supporting files. When your program needs to interact with the file system, network, or use complex data structures, the JRE provides those pre-written libraries to the JVM during execution.

### The Developer Wrapper: JDK (Java Development Kit)
Wrapping entirely around both the JRE and the JVM is the JDK. The JDK is the full-fledged software development environment used to **develop** Java applications. 
If you are a programmer writing Java code, you must install the JDK. It contains everything inside the JRE (so you can run your code), but it adds all the necessary development tools. The most important tool included is `javac` (the Java Compiler), which converts your human-readable `.java` source code into the `.class` bytecode that the JVM needs. It also includes other crucial tools like `javadoc` (for generating documentation), `jar` (for packaging your application into a single archive), and debugging tools. 

---

## 2. Memory Management: Stack vs. Heap Memory

When a Java program runs, the JVM divides the available memory into several distinct areas. The two most important areas for developers to understand are the Stack and the Heap.

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
