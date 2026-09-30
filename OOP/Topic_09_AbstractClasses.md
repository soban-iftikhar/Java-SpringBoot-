# Abstraction: Theoretical Notes

## 1. Abstraction (The `abstract` Keyword)
Abstraction is the process of hiding implementation details and showing only the necessary features to the user. It helps reduce complexity and effort.

### Abstract Classes
- You **cannot instantiate** an abstract class (you cannot use the `new` keyword on it). It exists solely to be inherited by child classes.
- An abstract class acts as a rigid blueprint. It can contain both regular methods (with code blocks) and abstract methods.

### Abstract Methods
- An abstract method has **no body** (no curly braces `{}`). It just ends with a semicolon: `public abstract void drive();`.
- **The Contract:** If a Parent class has an abstract method, any Child class that inherits from it is **forced** by the Java Compiler to provide an implementation for that method (unless the child class also declares itself as abstract).
