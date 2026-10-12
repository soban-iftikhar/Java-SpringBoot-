# Enums (Enumerations): Theoretical Notes

## 1. What is an Enum?
An `enum` (short for enumeration) is a special data type in Java that represents a fixed set of predefined constants. It was introduced in Java 5 to replace primitive constant anti-patterns (such as defining groups of `public static final int` or `String` values).

### Why use Enums instead of Constants?
Before enums, developers used constants like:
```java
public static final int STATUS_PENDING = 0;
public static final int STATUS_COMPLETED = 1;
```
**The Problem:** There was zero type safety. Any method accepting an `int` could be passed `999` or `-5`, causing silent bugs.

With an enum:
```java
public void updateStatus(OrderStatus status) { ... }
```
The compiler strictly enforces that only valid values (`OrderStatus.PENDING`, `OrderStatus.COMPLETED`) can ever be passed.

---

## 2. Under the Hood: Enums are Full Classes
A common misconception is that enums are merely syntactic sugar for integers or strings. In Java, **every enum is compiled into a full class** that implicitly inherits from `java.lang.Enum`.

### The Decompiled View
When you declare:
```java
enum Day { MONDAY, TUESDAY }
```
The compiler generates something resembling:
```java
public final class Day extends java.lang.Enum<Day> {
    public static final Day MONDAY = new Day("MONDAY", 0);
    public static final Day TUESDAY = new Day("TUESDAY", 1);
    
    private Day(String name, int ordinal) { super(name, ordinal); }
    public static Day[] values() { ... }
    public static Day valueOf(String name) { ... }
}
```

Because an enum is a class:
- It can have **instance variables** and **constructors**.
- It can have **methods** (both concrete and abstract).
- It can implement **interfaces**.

---

## 3. Strict Rules and Limitations of Enums

### Rule 1: Constructors Must Be Private
You can never use the `new` operator with an enum:
```java
// Compilation Error!
OrderStatus s = new OrderStatus(101, "Pending");
```
All enum instances are created once by the JVM when the class is loaded. Therefore, enum constructors are implicitly `private`. Specifying `public` or `protected` will cause a compile error.

### Rule 2: Cannot Extend Other Classes
Because every enum automatically extends `java.lang.Enum`, and Java does not support multiple class inheritance, an enum cannot extend any other class:
```java
// Forbidden in Java:
enum Status extends BaseClass { ... }
```
However, an enum **can implement one or more interfaces**.

### Rule 3: Enum Constants Must Be Listed First
If an enum defines fields, constructors, or methods, the list of enum constants must appear as the very first statement, terminated by a semicolon `;`.

---

## 4. Built-in Methods Provided by `java.lang.Enum`

| Method | Return Type | Description |
| :--- | :--- | :--- |
| `name()` | `String` | Returns the exact name of the constant as declared. |
| `ordinal()` | `int` | Returns the zero-based index position of the constant in its declaration order. |
| `values()` | `EnumType[]` | Static method returning an array of all constants in order of declaration. |
| `valueOf(String)` | `EnumType` | Static method returning the constant matching the string (case-sensitive; throws `IllegalArgumentException` if not found). |
| `compareTo(EnumType)` | `int` | Compares constants based on their ordinal order. |

> [!WARNING]
> Avoid relying on `ordinal()` for business logic (e.g., storing `ordinal()` in a database). If someone reorders or inserts a new constant in the enum declaration, all ordinal numbers will shift, corrupting persisted data. Instead, store a custom, immutable field (like a status code or string identifier).

---

## 5. Interview Questions & Edge Cases

### Question 1: Should you use `==` or `.equals()` to compare Enums?
**Answer:** Always prefer `==`.
- **Reason 1 (Null Safety):** If `status` is `null`, `status.equals(OrderStatus.PENDING)` will throw a `NullPointerException`. In contrast, `status == OrderStatus.PENDING` safely evaluates to `false`.
- **Reason 2 (Type Safety at Compile Time):** If you accidentally compare two different enum types (e.g., `Day.MONDAY == OrderStatus.PENDING`), the compiler catches it immediately. Using `.equals()` would compile without error and simply return `false` at runtime.
- **Reason 3 (Instance Guarantee):** Because each enum constant is guaranteed to have only one instance per JVM classloader, `==` and `.equals()` are functionally equivalent in memory comparison.

### Question 2: Why are Enums considered the best way to implement a Singleton in Java?
**Answer:** Joshua Bloch (author of *Effective Java*) famously noted that a single-element enum is the best way to implement a Singleton pattern.
- **Thread Safety:** The JVM guarantees that enum instances are created in a thread-safe manner upon class initialization.
- **Serialization Safety:** The JVM has special handling for enums during serialization. Standard singletons can accidentally create multiple instances when deserialized unless `readResolve()` is implemented; enums handle this natively.
- **Reflection Proof:** Java's Reflection API (`Constructor.newInstance()`) explicitly forbids creating instances of enum types, throwing an `IllegalArgumentException`. Traditional private constructors can be bypassed via reflection; enums cannot.
