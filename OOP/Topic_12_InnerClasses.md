# Inner Classes: Theoretical Notes

## 1. Inner Classes
An Inner Class is a class declared inside another class. 
- **Why use them?** They are used to logically group classes that are only used in one place. It increases encapsulation.
- **The Superpower:** An Inner Class has direct access to all variables and methods of its Outer Class, **including `private` ones**.
- **How to instantiate:** You must create an object of the Outer class first, before you can create an object of the Inner class.
  ```java
  Outer out = new Outer();
  Outer.Inner in = out.new Inner();
  ```

---

## 2. Anonymous Inner Classes
An Anonymous Inner Class is an inner class **without a name**, created and instantiated in a single expression on the fly.
- **Why use them?** If you need to override a method of a class or an interface for a **one-time use**, it is a waste of time and file-space to create an entire named class just for that single object. Instead, you create an anonymous class right exactly where you need it.
- **Syntax Trap:** Because you are declaring a class during object instantiation, the massive code block actually ends with a semicolon `};`.
```java
Animal oneTimeDog = new Animal() {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
};
```
