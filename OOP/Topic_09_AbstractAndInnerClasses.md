# Abstraction and Inner Classes: Theoretical Notes

## 1. Abstraction (The `abstract` Keyword)
Abstraction is the process of hiding implementation details and showing only the necessary features to the user. It helps reduce complexity and effort.

### Abstract Classes
- You **cannot instantiate** an abstract class (you cannot use the `new` keyword on it). It exists solely to be inherited by child classes.
- An abstract class acts as a rigid blueprint. It can contain both regular methods (with code blocks) and abstract methods.

### Abstract Methods
- An abstract method has **no body** (no curly braces `{}`). It just ends with a semicolon: `public abstract void drive();`.
- **The Contract:** If a Parent class has an abstract method, any Child class that inherits from it is **forced** by the Java Compiler to provide an implementation for that method (unless the child class also declares itself as abstract).

---

## 2. Inner Classes
An Inner Class is a class declared inside another class. 
- **Why use them?** They are used to logically group classes that are only used in one place. It increases encapsulation.
- **The Superpower:** An Inner Class has direct access to all variables and methods of its Outer Class, **including `private` ones**.
- **How to instantiate:** You must create an object of the Outer class first, before you can create an object of the Inner class.
  ```java
  Outer out = new Outer();
  Outer.Inner in = out.new Inner();
  ```

---

## 3. Anonymous Inner Classes
An Anonymous Inner Class is an inner class **without a name**, created and instantiated in a single expression on the fly.
- **Why use them?** If you need to override a method of a class or an interface for a **one-time use**, it is a waste of time and file-space to create an entire named class just for that single object. Instead, you create an anonymous class.
- **Syntax Trap:** Because you are declaring a class during object instantiation, the massive code block actually ends with a semicolon `};`.
```java
Animal oneTimeDog = new Animal() {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
};
```
