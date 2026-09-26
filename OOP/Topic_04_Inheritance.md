# Inheritance: Theoretical Notes

## 1. What is Inheritance?

Inheritance is one of the foundational pillars of Object-Oriented Programming (OOP). It is a mechanism where one class (the **Child** or **Subclass**) is allowed to inherit the fields and methods of another class (the **Parent** or **Superclass**).

### Why do we use it?
1. **Code Reusability:** If you have multiple classes that share the same logic (like `Car`, `Truck`, and `Motorcycle` all having a `startEngine()` method), you can place that method inside a `Vehicle` parent class. The children will inherit it automatically, preventing you from writing the exact same code three times.
2. **Method Overriding (Polymorphism):** Inheritance is required to achieve Runtime Polymorphism. A child class can override a parent's method to provide its own specific implementation.

---

## 2. Types of Inheritance in Java

Java supports some, but not all, theoretical forms of inheritance.

### ✅Single Inheritance
A single child class inherits from a single parent class. 
*(e.g., `AdvancedCalculator extends Calculator`)*

### ✅ Multi-Level Inheritance
A child class inherits from a parent, which inherits from a grandparent. The child gains the traits of all ancestors above it in the chain.
*(e.g., `ScientificCalculator extends AdvancedCalculator`, which extends `Calculator`)*

### ✅ Hierarchical Inheritance
Multiple different child classes inherit from a single parent class.
*(e.g., `Dog extends Animal` AND `Cat extends Animal`)*

### ❌ Multiple Inheritance (NOT SUPPORTED WITH CLASSES)
In C++, a single child class can inherit from two completely different parent classes simultaneously (e.g., `Child extends Father, Mother`). **Java completely forbids this.**

**Why? The Diamond Problem.**
If both the `Father` class and the `Mother` class have a method named `speak()`, and the `Child` tries to call `speak()`, the JVM would be fatally confused about which parent's method to execute. To prevent this ambiguity, Java strictly enforces that a class can only have **one direct parent** (one `extends` keyword). 
*(Note: Java bypasses this limitation later through the use of **Interfaces**, which we will cover in a future topic).*

---

## 3. The `IS-A` Relationship

Inheritance is technically known as an **"IS-A"** relationship. 
- A `ScientificCalculator` **IS-A** `Calculator`. 
- A `Dog` **IS-A** `Animal`.

Because of this relationship, Java allows an incredibly powerful feature: **Upcasting**. You can store a Child object inside a Parent reference variable:
```java
// Perfectly valid code!
Calculator myCalc = new ScientificCalculator();
```
*(This concept acts as the absolute backbone of Polymorphism and flexible software design).*

---

## 4. The `super` Keyword in Inheritance

When dealing with inheritance, you often need to refer back to the parent class. The `super` keyword is your bridge to the parent.

1. **Calling the Parent's Constructor:** `super()` calls the constructor of the parent class. (As discussed in Encapsulation, this is implicitly injected as the first line of any child constructor).
2. **Accessing Hidden Variables:** If the Child class has a variable named `x`, and the Parent class *also* has a variable named `x`, using `super.x` from the child explicitly targets the parent's version of the variable.
3. **Calling Overridden Methods:** If the Child overrides the Parent's `calculate()` method, the child can still trigger the parent's original version of the code by calling `super.calculate()`.
