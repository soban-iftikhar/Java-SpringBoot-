# Packages and Access Modifiers: Theoretical Notes

## 1. Packages
A **package** in Java is a mechanism to encapsulate a group of classes, sub-packages, and interfaces. Think of them as strictly organized folders on your computer.
- **Why use them?** They prevent naming conflicts (you can have two classes named `User` as long as they are in different packages) and they provide controlled access through Access Modifiers.
- **Built-in Packages:** Examples include `java.util` (Scanner, ArrayList) and `java.io` (File handling). 
- **The `import` Keyword:** If you want to use a class from a completely different package, you must `import` it at the top of your file. (Note: `java.lang` is imported automatically, which is why you don't have to import `String` or `System`).

## 2. Access Modifiers Cheat Sheet

Access Modifiers dictate the visibility (security level) of a class, method, or variable. 

| Modifier | Same Class | Same Package | Subclass (Diff Package) | Anywhere (Diff Package) |
| :--- | :---: | :---: | :---: | :---: |
| **`public`** | Yes | Yes | Yes | Yes |
| **`protected`**| Yes | Yes | Yes | No |
| **Default** (No keyword)| Yes | Yes | No | No |
| **`private`** | Yes | No | No | No |

### The "Default" Trap
If you do not write an access modifier (e.g., `String name = "Alice";`), it defaults to **Package-Private**. This is a massive interview trap. It means the variable is fully visible to any other class residing in the exact same folder (package), but completely invisible to the outside world, even to child classes!

### The `protected` Power
`protected` is nearly identical to Default, with one magical exception: A Child class located in a completely different package/folder is still allowed to access a `protected` variable of its Parent class through inheritance.
