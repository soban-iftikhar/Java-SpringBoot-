# The `super` Keyword: Theoretical Notes

The `super` keyword is one of the most important concepts when dealing with inheritance. It acts as a direct bridge to your immediate **Parent** class.

It is used in three distinct scenarios:

---

## 1. The "You Can't See Me" Effect (Variable Hiding)

If a Child class creates a variable with the **exact same name** as a variable in the Parent class, the Child's variable acts like John Cena: *You can't see the parent's variable anymore!* It completely hides the parent's data from standard view.

```java
class Parent {
    String name = "Old Parent";
}
class Child extends Parent {
    String name = "YOU CAN'T SEE ME! (John Cena)";
}
```

If you print `name` from inside the child, you will only ever get the child's version. 
**The Solution:** To pierce through the child's overriding variable and access the hidden parent data, you must use the `super` keyword: `System.out.println(super.name);`.

---

## 2. Calling Overridden Methods

Similar to variable hiding, if a Child class overrides a method (e.g., `speak()`), calling `speak()` will execute the child's new logic. If you need to trigger the parent's original, unmodified logic from inside the child, you use `super.speak()`.

---

## 3. Controlling Parent Constructors

This is a massive interview topic. **You cannot create a Child object without first creating the Parent object it relies on.**

When you write `new Child();`, the JVM must execute the Parent's constructor first to build the foundational data. 
- **The Invisible `super()`:** To achieve this, the Java compiler secretly injects a blank `super();` statement as the very first line of your child's constructor. This automatically calls the Parent's default, no-argument constructor in the background.
- **How to stop it:** If you do NOT want the default parent constructor to run (perhaps you want to run a parameterized one instead), you must manually write `super(arguments)` as the very first line of your child's constructor. 

By manually writing `super("The Champ")`, you override Java's invisible injection and force it to call the parameterized constructor instead of the default one!
