# Polymorphism: Method Overloading vs. Overriding

Polymorphism translates to **"many forms."** In Java, it allows us to perform a single action in different ways. It is divided into two distinct categories: Compile-Time (Overloading) and Run-Time (Overriding).

This is one of the most frequently asked questions in Java interviews.

---

## 1. Method Overloading (Compile-Time Polymorphism)

Method Overloading occurs when two or more methods in the **same class** have the exact same name, but differ in their parameters.

### Rules for Overloading:
To successfully overload a method, you must change the method signature by doing at least one of the following:
1. Change the **number** of parameters (e.g., `print(String a)` vs `print(String a, String b)`).
2. Change the **data type** of parameters (e.g., `print(String a)` vs `print(int a)`).
3. Change the **sequence** of parameters (e.g., `print(String a, int b)` vs `print(int b, String a)`).

**The Return Type Trap:** You **cannot** overload a method simply by changing its return type. The compiler will throw an error because it wouldn't know which method to call if you didn't assign the result to a variable.

### Why is it called Compile-Time?
When you write `myPrinter.print(404);`, the Java Compiler looks at the argument (`404` is an `int`) and immediately knows exactly which version of the `print` method to bind it to. The decision is made before the program ever runs.

---

## 2. Method Overriding (Run-Time Polymorphism)

Method Overriding occurs when a **child class** provides its own specific implementation for a method that is already provided by its parent class.

### Rules for Overriding:
1. **Requires Inheritance:** It must happen between a parent class and a child class (`extends`).
2. **Exact Signature:** The method name, return type, and parameters must be exactly the same as the parent's method.
3. **The `@Override` Annotation:** While technically optional, you should always write `@Override` above your method. It acts as a safety net. If you make a typo in the method name, the compiler will instantly warn you that you aren't actually overriding anything.

### Why is it called Run-Time? (Dynamic Method Dispatch)
This is where the true power of OOP shines. Because of Upcasting, you can store a Child object in a Parent reference variable:
`Animal myPet = new Dog();`

If you call `myPet.makeSound();`, which sound is made? The generic Animal sound, or the Dog bark?
The answer is the Dog bark. The Java Compiler looks at the reference variable (`Animal`) and says "Okay, this method exists." But when the program actually runs, the **JVM** looks at the actual object residing in the Heap memory (`Dog`) and dynamically executes the overridden method. Since this decision happens during execution, it is called Run-Time Polymorphism.

---

## 3. The Ultimate Comparison Cheat Sheet

| Feature | Method Overloading | Method Overriding |
| :--- | :--- | :--- |
| **Location** | Happens within the **same class**. | Happens between **Parent and Child classes**. |
| **Method Name** | Must be the same. | Must be the same. |
| **Parameters** | Must be **different** (type, count, order). | Must be **exactly the same**. |
| **Return Type** | Can be different. | Must be the same (or a subtype/covariant). |
| **Binding Time** | Compile-Time (Early Binding). | Run-Time (Late Binding). |
| **Private/Static/Final**| Can be overloaded. | **Cannot** be overridden (they belong to the class/are locked). |
