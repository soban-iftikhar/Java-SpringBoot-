# Serialization & Deserialization: Theoretical Notes

## 1. What is Serialization?
In Java, objects exist in the **Heap memory** while the program is running. But what happens when you close the program? All that memory is wiped, and the objects are destroyed.

**Serialization** is the mechanism of converting the state of a live Java object into a continuous stream of bytes. 
- **Why?** Once an object is a byte stream, you can save it to a hard drive (like a save file in a video game), send it across a network to another computer, or store it in a database.
- **Deserialization** is the exact reverse process: taking a byte stream from a file or network and re-assembling it back into a live Java object in memory.

---

## 2. The `Serializable` Interface
To allow an object to be serialized, its class **must** implement the `java.io.Serializable` interface. 
- **The Marker Interface Concept:** If you look inside the `Serializable` interface in Java's source code, you will find absolutely nothing. It has zero methods. It is called a **Marker Interface**. It simply acts as a flag that tells the JVM: *"It is safe and permitted to serialize this object."*
- If you try to serialize an object that doesn't implement this interface, Java will throw a `NotSerializableException`.

---

## 3. The `transient` Keyword
When you serialize an object, Java automatically saves **all** of its variables. However, there are times when you absolutely do not want certain variables saved.
- Examples include passwords, social security numbers, or temporary variables (like a timer) that don't make sense to save.
- By placing the `transient` keyword in front of a variable (`private transient String password;`), you instruct the JVM to completely ignore it during serialization. 
- When the object is later deserialized, that variable will just default to its standard empty value (e.g., `null` for Strings, `0` for ints).

---

## 4. The `serialVersionUID` (Version Control)
When an object is serialized, Java stamps it with a unique ID number representing the current version of the class structure. This is the `serialVersionUID`.

### Why is it important?
Imagine you release a video game, and players save their `PlayerProfile` objects to their hard drives. The class has two variables: `name` and `level`.
A year later, you update the game and add a new variable to the class: `inventory`.

When the player tries to load their old save file, the JVM compares the `serialVersionUID` of the saved file with the ID of the new class. 
- If you didn't manually set the ID, the JVM auto-generates a new one because the class changed. The IDs won't match, and the JVM will throw an `InvalidClassException`, breaking all old save files!
- **Best Practice:** Always declare `private static final long serialVersionUID = 1L;` inside your serializable classes. This proves to the JVM that even if you added new variables, the core class is still compatible with older saved versions.
