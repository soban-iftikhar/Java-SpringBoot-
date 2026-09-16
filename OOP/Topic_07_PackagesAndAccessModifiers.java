/*
 * Topic 7: Packages & Access Modifiers
 * 
 * --- LEVEL 0: BEGINNER ---
 * Packages are simply folders/directories used to organize related classes and avoid name conflicts.
 * Access Modifiers are security tags you put on classes, variables, and methods to control 
 * who is allowed to see or use them.
 * 
 * The 4 Access Modifiers in Java:
 * 1. public    (Accessible everywhere)
 * 2. protected (Accessible in the same package, OR in child classes even in different packages)
 * 3. default   (No keyword written - Accessible ONLY within the exact same package)
 * 4. private   (Accessible ONLY within the exact same class)
 */

class AccessDemo {
    public String publicMsg = "I am public! Anyone can see me.";
    protected String protectedMsg = "I am protected! My package or my children can see me.";
    String defaultMsg = "I am default! Only my package can see me.";
    private String privateMsg = "I am private! Only THIS class can see me.";

    public void showPrivate() {
        // The only way to see privateMsg is from inside the class itself!
        System.out.println(privateMsg);
    }
}

public class Topic_07_PackagesAndAccessModifiers {
    public static void main(String[] args) {
        System.out.println("--- 1. Testing Access Modifiers ---");
        
        AccessDemo demo = new AccessDemo();
        System.out.println(demo.publicMsg);
        System.out.println(demo.protectedMsg);
        System.out.println(demo.defaultMsg);
        
        // System.out.println(demo.privateMsg); // COMPILER ERROR! 
        // "privateMsg has private access in AccessDemo"
        
        System.out.print("Accessing private via public method: ");
        demo.showPrivate(); // Valid!
    }
}
