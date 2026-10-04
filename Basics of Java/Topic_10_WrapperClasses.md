# Wrapper Classes & Autoboxing: Theoretical Notes

## 1. What are Wrapper Classes?
Java is an Object-Oriented Language, but it is not *purely* object-oriented because it uses **Primitive Data Types** (`int`, `double`, `boolean`, etc.) for performance reasons. Primitives are just raw values in memory; they are not objects, they have no methods, and they don't live on the Heap in the same way objects do.

However, advanced Java features (like **Generics** and **Collections/ArrayLists**) absolutely demand Objects. You cannot create an `ArrayList<int>`. 

To bridge this gap, Java provides a **Wrapper Class** for every primitive:
- `int` ➡️ `Integer`
- `double` ➡️ `Double`
- `char` ➡️ `Character`
- `boolean` ➡️ `Boolean`

## 2. Boxing vs Autoboxing

Converting a primitive into a Wrapper object is called **Boxing**. Before Java 5, developers had to do this manually. 

### Manual Boxing & Unboxing (The Old Way)
- **Manual Boxing:** Explicitly writing the code to wrap a primitive. 
  - `Integer obj = Integer.valueOf(5);`
- **Manual Unboxing:** Explicitly writing the code to extract the primitive. 
  - `int raw = obj.intValue();`

### Autoboxing & Unboxing (Java 5+)
Today, the Java Compiler handles this invisibly. You just write the assignment, and the compiler injects `Integer.valueOf()` or `.intValue()` for you behind the scenes.
- **Autoboxing:** Automatic conversion of a primitive to a Wrapper object. (e.g., `Integer num = 10;`)
- **Autounboxing (Unboxing):** Automatic conversion of a Wrapper object back to a primitive. (e.g., `int raw = num;`)

---

## 3. Interview Traps (Master Level)

Wrapper classes introduce two incredibly common bugs that interviewers love to test you on.

### Trap 1: The NullPointerException
Primitives cannot be `null`. An `int` defaults to `0`. However, a Wrapper Class is an Object, meaning it **can** be `null`.
```java
Integer myScore = null;
int finalScore = myScore + 5; // CRASH! NullPointerException
```
**What happened?** The compiler saw you trying to do math with an `Integer` object, so it attempted to **Unbox** it into a primitive `int`. You cannot unbox a `null` object. The program crashes immediately.

### Trap 2: The Integer Cache
To save memory and increase performance, the JVM maintains an internal cache of `Integer` objects for values between **-128 and +127**.

If you autobox a number within that range, Java checks the cache. If the object already exists, Java just hands you a pointer to the existing object rather than creating a new one.
```java
Integer a = 100;
Integer b = 100;
System.out.println(a == b); // TRUE. They point to the exact same object in the cache!
```
However, if the number is outside that range, Java is forced to create brand new objects on the Heap.
```java
Integer x = 500;
Integer y = 500;
System.out.println(x == y); // FALSE. They are two completely different objects in memory!
```
**The Solution:** You should **never** use the `==` operator to compare Wrapper objects. You must treat them like Strings and always use the `.equals()` method to compare their actual values.
