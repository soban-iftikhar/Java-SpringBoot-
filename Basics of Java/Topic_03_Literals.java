import java.util.Scanner;

/*
 * Topic 3: Literals
 * 
 * --- LEVEL 0: BEGINNER ---
 * A literal is a fixed, hardcoded value written directly into the source code.
 * Think of it as the raw data itself (e.g., 42, 'A', "hello").
 * The left side of an assignment is the variable; the right side is often a literal.
 */
public class Topic_03_Literals {
    public static void main(String[] args) {
        
        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Basic Literals ---");
        
        // Integer literals
        int decimalLiteral = 42; 
        
        // Floating-point literals
        double doubleLiteral = 3.14; 
        float floatLiteral = 3.14f; 
        
        // Character and String literals
        char charLiteral = 'A'; 
        String stringLiteral = "Hello, World!"; 
        
        // Boolean literals
        boolean trueLiteral = true; 
        
        System.out.println("Integer literal: " + decimalLiteral);
        System.out.println("String literal: " + stringLiteral);


        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        System.out.println("\n--- 2. Advanced Numeric Literals ---");
        
        // You can represent numbers in different bases
        int octalLiteral = 052; // Prefix '0' means base 8
        int hexLiteral = 0x2A;  // Prefix '0x' means base 16
        int binaryLiteral = 0b101010; // Prefix '0b' means base 2
        
        // To improve readability of large numbers, Java 7 introduced underscores.
        // EDGE CASE: Underscores cannot be at the start/end, adjacent to a decimal, or before an F/L suffix.
        int oneMillion = 1_000_000; 
        long creditCardNumber = 1234_5678_9012_3456L;
        
        System.out.println("Binary literal (0b101010): " + binaryLiteral);
        System.out.println("One Million with underscores: " + oneMillion);

        
        System.out.println("\n--- 3. Unicode and Escape Sequences ---");
        // Characters in Java are 16-bit Unicode. 
        char unicodeLiteral = '\u0041'; // Hex 41 is decimal 65 ('A')
        char smileyFace = '\u263A';     // Unicode for ☺
        
        // Escape sequences for special formatting
        char newLine = '\n';
        char tab = '\t';
        char backslash = '\\';

        System.out.println("Unicode Literal (\\u0041): " + unicodeLiteral);
        System.out.println("Smiley Face: " + smileyFace);


        System.out.println("\n--- 4. String Literals vs Text Blocks (Java 15+) ---");
        String standardString = "This is a single line string.\nIf I want a new line, I must use \\n.";
        
        // Text blocks provide a way to format multi-line strings effortlessly (great for JSON/SQL).
        // It automatically handles formatting, indentation, and newlines without escape characters.
        String jsonTextBlock = """
                {
                    "name": "Soban Iftikhar",
                    "role": "Java Developer",
                    "skills": ["Java", "Spring Boot"]
                }
                """;
                
        System.out.println("Text Block JSON:\n" + jsonTextBlock);

        
        System.out.println("--- 5. Literal vs Runtime Input ---");
        // A literal is ONLY a hardcoded value in source code.
        // Data obtained at runtime (like user input or calculations) is NOT a literal.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number (This is runtime data, not a literal!): ");
        if (input.hasNextInt()) {
            int score = input.nextInt(); 
            System.out.println("You entered: " + score);
        }
        input.close();
    }
}
