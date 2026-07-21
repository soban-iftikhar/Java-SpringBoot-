import java.util.Scanner;

public class Topic_03_Literals {
    public static void main(String[] args) {
        /*
        A literal is a fixed, source-code representation of a constant value. 
        Unlike a variable, which acts as a container for data that can change, 
        a literal is the actual data itself (e.g., 42, 'A', "hello"). 
        In short, a literal is a value that is written directly in the code.
        */

        // Integer literals
        int decimalLiteral = 42; // Decimal literal
        int octalLiteral = 052; // Octal literal (base 8)
        int hexLiteral = 0x2A; // Hexadecimal literal (base 16)
        int binaryLiteral = 0b101010; // Binary literal (base 2)

        // Floating-point literals
        double doubleLiteral = 3.14; // Double literal
        float floatLiteral = 3.14f; // Float literal
        
        // Character literals
        char charLiteral = 'A'; // Character literal

        // String literals
        String stringLiteral = "Hello, World!"; // String literal

        // Boolean literals
        boolean trueLiteral = true; // Boolean literal
        boolean falseLiteral = false; // Boolean literal
        /*
        Unlike C or JavaScript, integers like 0 or 1 are not booleans in Java. boolean flag = 1; will not compile. 
        */



        System.out.println("Integer literals: " + decimalLiteral + ", " + octalLiteral + ", " + hexLiteral + ", " + binaryLiteral);
        System.out.println("Floating-point literals: " + doubleLiteral + ", " + floatLiteral);
        System.out.println("Character literal: " + charLiteral);
        System.out.println("String literal: " + stringLiteral);
        System.out.println("Boolean literals: " + trueLiteral + ", " + falseLiteral);




        //Bonus Note
        /*
        The left side is the variable (the named storage location in memory), and the right side is an expression that 
        produces a value. When you write a hardcoded raw value directly in your code, like int age = 21;, 
        that right-side value is a literal.
        However, the right side does not have to be a literal. It can be another variable, an arithmetic calculation
        or dynamic runtime input.
        When you declare a variable without assigning it, or when a user inputs data at runtime, there are indeed no literals involved
        */

        // 1. Declared without an assignment: No literal here
        int score;

        // 2. Runtime user input: The value is created dynamically in memory, not from source code literals
        Scanner input = new Scanner(System.in);
        score = input.nextInt(); 
        System.out.println("Score: " + score);


        // 3. Computed expression: The final value of 'total' comes from a calculation, not a literal
        int bonus = 10;
        int total = score + bonus;
        System.out.println("Total: " + total);
    }
    
}
