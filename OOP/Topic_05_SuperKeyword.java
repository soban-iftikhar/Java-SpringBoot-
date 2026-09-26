/*
 * Topic 5: The 'super' Keyword (And the Invisible Parent)
 * 
 * --- LEVEL 0: BEGINNER ---
 * The 'super' keyword is a reference variable used to refer to the immediate PARENT class object.
 * It is used for 3 main things:
 * 1. To call the parent class's constructor.
 * 2. To access parent class variables hidden by the child class (The John Cena effect).
 * 3. To call parent class methods overridden by the child class.
 */

// PARENT CLASS
class Wrestler {
    String catchphrase = "I am just a normal wrestler.";

    // Default Constructor
    public Wrestler() {
        System.out.println("[Wrestler Parent] Default constructor called silently in the background!");
    }

    // Parameterized Constructor
    public Wrestler(String name) {
        System.out.println("[Wrestler Parent] Parameterized constructor called for: " + name);
    }

    public void taunt() {
        System.out.println("Generic taunt!");
    }
}

// CHILD CLASS
class JohnCena extends Wrestler {
    
    // 1. VARIABLE HIDING (The "You Can't See Me" Effect)
    // Because this variable has the exact same name as the parent's variable, 
    // it completely HIDES the parent's variable from view!
    String catchphrase = "YOU CAN'T SEE ME! 👋";

    // 2. CONSTRUCTOR CHAINING
    public JohnCena() {
        // If we do NOT write super() here, Java invisibly injects a blank `super();` 
        // as the first line, which calls the Parent's default constructor automatically!
        
        // Let's stop the default behavior and explicitly call the Parameterized parent constructor instead:
        super("The Champ"); // This stops the blank default constructor from running!
        
        System.out.println("[JohnCena Child] Constructor finished building John Cena.");
    }

    public void showCatchphrases() {
        System.out.println("\n--- Variable Hiding Demonstration ---");
        // Prints the Child's variable
        System.out.println("Child's Catchphrase: " + this.catchphrase);
        
        // Prints the hidden Parent's variable using 'super'
        System.out.println("Hidden Parent's Catchphrase: " + super.catchphrase);
    }
    
    @Override
    public void taunt() {
        System.out.println("\n--- Method Overriding Demonstration ---");
        // We override the taunt, but we can still trigger the parent's original taunt!
        super.taunt(); 
        System.out.println("🎺 🎺 🎺 🎺 (John Cena Theme Song Plays) 🎺 🎺 🎺 🎺");
    }
}

public class Topic_05_SuperKeyword {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Constructor Chaining ---");
        // Watch the console output carefully. 
        // Building the child forces the parent to be built first!
        JohnCena cena = new JohnCena();
        
        // Demonstrate accessing hidden variables
        cena.showCatchphrases();
        
        // Demonstrate calling overridden parent methods
        cena.taunt();
    }
}
