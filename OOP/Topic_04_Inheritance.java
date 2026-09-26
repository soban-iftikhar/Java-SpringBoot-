/*
 * Topic 4: Inheritance
 * 
 * --- LEVEL 0: BEGINNER ---
 * Inheritance is one of the pillars of OOP. It allows a new class (Child/Subclass) 
 * to acquire the properties and methods of an existing class (Parent/Superclass).
 * 
 * Why use Inheritance?
 * 1. Code Reusability: You don't have to rewrite common methods.
 * 2. Method Overriding: For Runtime Polymorphism (covered in the next topic!).
 * 
 * Key Keyword: 'extends'
 */

// ==========================================
// 1. THE PARENT CLASS (Superclass)
// ==========================================
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}

// ==========================================
// 2. SINGLE INHERITANCE (Child extends Parent)
// ==========================================
// AdvancedCalculator inherits everything from Calculator.
class AdvancedCalculator extends Calculator {
    
    // It gets add(), subtract(), etc., FOR FREE. We just add new features!
    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    public int modulus(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot perform modulus by zero");
        }
        return a % b;
    }
}

// ==========================================
// 3. MULTI-LEVEL INHERITANCE (Child extends Child)
// ==========================================
// ScientificCalculator inherits from AdvancedCalculator (which inherits from Calculator).
// It now has the features of BOTH ancestors!
class ScientificCalculator extends AdvancedCalculator {
    
    public double squareRoot(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(a);
    }

    public double logarithm(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot calculate logarithm of zero or negative number");
        }
        return Math.log(a);
    }
}

// ==========================================
// 4. HIERARCHICAL INHERITANCE (Multiple Children extend 1 Parent)
// ==========================================
// FinancialCalculator directly extends Calculator. 
// It sits right next to AdvancedCalculator in the family tree.
class FinancialCalculator extends Calculator {
    
    public double calculateInterest(double principal, double rate) {
        return principal * (rate / 100);
    }
}

// ==========================================
// 5. MULTIPLE INHERITANCE (FORBIDDEN IN JAVA)
// ==========================================
// In languages like C++, a child can have MULTIPLE parents. 
// Java strictly FORBIDS this for classes to avoid the "Diamond Problem" (ambiguity if both parents have the same method).
/*
class ForbiddenCalculator extends AdvancedCalculator, FinancialCalculator { 
    // ^ COMPILER ERROR: Syntax error on token ",", { expected
    // Java forces you to pick exactly ONE parent using 'extends'.
}
*/


public class Topic_04_Inheritance {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing the Parent Class (Calculator) ---");
        Calculator basicCalc = new Calculator();
        System.out.println("Basic Addition (10 + 5): " + basicCalc.add(10, 5));
        
        System.out.println("\n--- 2. Testing Single Inheritance (AdvancedCalculator) ---");
        AdvancedCalculator advCalc = new AdvancedCalculator();
        // Calling a method inherited from the Parent
        System.out.println("Inherited Multiplication (6 * 7): " + advCalc.multiply(6, 7));
        // Calling its own specific method
        System.out.println("Self Power (2 ^ 3): " + advCalc.power(2, 3));

        System.out.println("\n--- 3. Testing Multi-Level Inheritance (ScientificCalculator) ---");
        ScientificCalculator sciCalc = new ScientificCalculator();
        // Calling method from Grandparent (Calculator)
        System.out.println("Grandparent Division (20 / 5): " + sciCalc.divide(20, 5));
        // Calling method from Parent (AdvancedCalculator)
        System.out.println("Parent Modulus (10 % 3): " + sciCalc.modulus(10, 3));
        // Calling its own specific method
        System.out.println("Self Square Root (√16): " + sciCalc.squareRoot(16));
        System.out.println("Self Logarithm (log 10): " + sciCalc.logarithm(10));
        
        System.out.println("\n--- 4. Testing Hierarchical Inheritance (FinancialCalculator) ---");
        FinancialCalculator finCalc = new FinancialCalculator();
        // Calling method from Parent (Calculator)
        System.out.println("Parent Addition (100 + 50): " + finCalc.add(100, 50));
        // Calling its own specific method
        System.out.println("Self Interest (1000 at 5%): " + finCalc.calculateInterest(1000, 5));
        
        // --- LEVEL 1: MASTER EDGE CASE (Object Types) ---
        // An object is considered an "instanceof" its own class AND all its parents!
        System.out.println("\n--- 4. Master Concept: 'instanceof' operator ---");
        System.out.println("Is sciCalc a ScientificCalculator? " + (sciCalc instanceof ScientificCalculator)); // true
        System.out.println("Is sciCalc a Calculator? " + (sciCalc instanceof Calculator)); // true (Because it inherits it!)
    }
}