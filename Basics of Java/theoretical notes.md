# Basics of Java Theoretical Notes

This file contains the core theoretical concepts covering basic syntax, data types, operators, and control flow.

---

## Interview Cheat Sheet: The Basics
When preparing for a technical interview or quickly revisiting the fundamentals of Java, these are the critical, high-yield concepts and common "trick" questions you must remember.

### 1. Java is strictly Pass-by-Value
This is one of the most common interview traps.
- **Primitives:** When you pass an `int` to a method, you are passing a *copy* of the value. Modifying it inside the method does not affect the original variable.
- **Objects:** When you pass an object, you are passing a *copy of the reference (memory address)*. 
  - If you **mutate** the object (e.g., `person.setName("Bob")`), the change is reflected outside because both the original reference and the copy point to the same object on the Heap.
  - If you **reassign** the reference (e.g., `person = new Person()`), it only affects the local copy of the reference inside the method. The original object outside remains completely untouched.

### 2. String Pool, Immutability, and `==` vs `.equals()`
Strings in Java are objects, but they are treated specially.
- **Immutability:** Strings cannot be changed once created. Any operation that modifies a String actually creates a brand new String object. This is done for security, thread-safety, and caching optimization.
- **The String Pool:** To save memory, Java maintains a special area in the Heap called the String Pool. If you create a String using a literal (`String a = "hello";`), Java checks the pool. If "hello" already exists, it just returns a reference to it.
- **The `==` Trap:** 
  - `==` compares **memory addresses** (do these references point to the exact same object in memory?).
  - `.equals()` compares the actual **value/content** of the objects.
  - Using `new String("hello")` forces Java to create a new object OUTSIDE the String pool. Thus, `("hello" == new String("hello"))` will evaluate to `false` in an interview question!

### 3. Wrapper Classes and Integer Caching (Autoboxing)
Every primitive (`int`) has an Object wrapper (`Integer`). Java automatically converts between them (Autoboxing/Unboxing).
- **The Unboxing Trap:** If a wrapper class is `null` and Java tries to automatically unbox it into a primitive (e.g., during math operations), it will throw a `NullPointerException`.
- **The Integer Cache Trick:** To save memory, Java caches `Integer` objects for values between `-128` and `127`.
  - `Integer a = 100; Integer b = 100;` -> `a == b` is **true** (they point to the exact same cached object).
  - `Integer x = 500; Integer y = 500;` -> `x == y` is **false** (outside the cache, two separate objects are created on the Heap).

### 4. `final`, `finally`, and `finalize`
A classic interview question asks you to distinguish between these three similar-sounding but completely unrelated concepts:
- **`final`:** A keyword used to define constants (variables that can't be reassigned), prevent method overriding, or prevent class inheritance.
- **`finally`:** A block used in `try-catch` exception handling. Code inside the `finally` block is **guaranteed** to execute regardless of whether an exception was thrown or caught (used for closing files or database connections).
- **`finalize()`:** A method in the `Object` class called by the Garbage Collector right before an object is destroyed. (Note: It is considered bad practice to use this, and it was deprecated in Java 9).

### 5. Floating-Point Precision Loss
Never use `float` or `double` for precise calculations like currency.
- Due to how floating-point numbers are represented in binary (as fractions of powers of 2), simple math often results in precision loss (e.g., `0.1 + 0.2` results in `0.30000000000000004`).
- **Interview Answer:** Always use `BigDecimal` for financial calculations where exact precision is required.

### 6. The "Dangling Else" and Switch Fall-Through
- **Dangling Else:** If you omit curly braces `{}` in nested `if` statements, an `else` clause will automatically attach itself to the *nearest* `if` above it, regardless of your indentation. Always use braces.
- **Switch Fall-Through:** In a traditional `switch` statement, if you forget a `break;` command, the code will execute the matching case AND continue executing all subsequent cases until it hits a break or the end of the block. (Note: Modern Java 14+ switch expressions using the `->` arrow syntax do not suffer from fall-through).
