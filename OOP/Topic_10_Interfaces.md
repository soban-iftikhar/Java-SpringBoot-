# Interfaces: Theoretical Notes

## 1. What is an Interface?
An Interface is a 100% abstract blueprint used to establish a strict contract. When a class chooses to implement an interface, it signs a legal agreement stating: *"I promise to write the code for every single method listed in this interface."*

### Why do we need Interfaces?
1. **Total Abstraction:** It separates *what* needs to be done from *how* it gets done. 
2. **The Multiple Inheritance Loophole:** As we learned, Java completely forbids a class from extending two parents to avoid the Diamond Problem. However, a class **can implement an infinite number of interfaces**. This allows you to combine multiple behaviors into one class (e.g., a `Smartphone` can implement `Camera`, `Phone`, and `GPS` simultaneously).

---

## 2. The Ultimate Interview Question: Abstract Class vs. Interface

When an interviewer asks you the difference between an Abstract Class and an Interface, they are testing if you understand architectural design. Here is the concrete, master-level answer:

### The "IS-A" vs "CAN-DO" Rule
This is the core philosophical difference:
- **Abstract Class (Identity / IS-A):** Use an abstract class when you are defining the core identity of an object. A `Dog` **IS-A** `Animal`. An abstract class shares core DNA, state (variables), and common logic with its children.
- **Interface (Capability / CAN-DO):** Use an interface when you are assigning an ability or role to an object, regardless of what the object actually is. A `Bird` can fly. An `Airplane` can fly. Superman can fly. They share zero core DNA, but they share a **capability**. Therefore, they should all implement a `Flyable` interface.

### The Technical Comparison Table

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Inheritance Limit** | A child can only `extends` **ONE** abstract class. | A child can `implements` **MULTIPLE** interfaces. |
| **Variables** | Can have standard, mutable instance variables. | All variables are strictly `public static final` (Constants). |
| **Constructors** | Yes, it has constructors (called via `super()`). | No constructors whatsoever. You cannot instantiate an interface. |
| **Methods (Before Java 8)** | Can have a mix of abstract (empty) and concrete (filled) methods. | **Only** abstract methods were allowed. |
| **Methods (Java 8+)** | Can have a mix of abstract and concrete methods. | Introduced `default` and `static` methods which contain bodies, blurring the lines slightly. |
| **Access Modifiers** | Can use `private`, `protected`, `public`. | Everything is implicitly `public`. |

### Interview Summary Answer
*"An abstract class is used to establish a strong IS-A relationship and share core state/code among closely related objects. An interface is used to establish a CAN-DO contract, defining abilities that can be shared across completely unrelated classes, while also allowing us to bypass Java's restriction on multiple inheritance."*
