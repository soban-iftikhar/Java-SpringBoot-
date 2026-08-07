# Java & Spring Boot: 0 to Master (Theoretical Notes)

A complete tutorial repository on Java with Spring Boot. This file serves as the gateway to all the core theoretical concepts you need to master Java.

To prevent this file from becoming endlessly long, the theoretical notes have been logically divided into the corresponding directories:

- **[Basics of Java Theoretical Notes](Basics%20of%20Java/theoretical%20notes.md)**: Core syntax, operators, control flow.
- **[OOP Theoretical Notes](OOP/theoretical%20notes.md)**: Classes, memory management (Stack vs Heap), and object-oriented principles.
- **[DSA Theoretical Notes](DSA/theoretical%20notes.md)**: Data structures, jagged arrays, and algorithmic drawbacks.

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
