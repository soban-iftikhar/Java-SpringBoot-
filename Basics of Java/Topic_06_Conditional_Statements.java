/*
 * Topic 6: Conditional Statements
 * 
 * --- LEVEL 0: BEGINNER ---
 * Conditional statements execute different blocks of code based on whether a condition is true or false.
 * - if / else if / else
 * - switch (for exact value matching)
 * - Ternary operator (shorthand for if/else)
 */
public class Topic_06_Conditional_Statements {

    public static void main(String[] args) {
        
        // --- LEVEL 0: BEGINNER (The absolute basics) ---
        System.out.println("--- 1. Basic If / Else ---");
        int number = 10;
        
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }


        System.out.println("\n--- 2. Basic Ternary Operator ---");
        // Syntax: (condition) ? value_if_true : value_if_false;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Number is: " + result);


        System.out.println("\n--- 3. Traditional Switch Statement ---");
        // Traditional switch requires 'break' statements to prevent fall-through.
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }



        // --- LEVEL 1: ADVANCED (Advanced concepts and edge cases) ---
        
        System.out.println("\n--- 4. Advanced Edge Case: The Dangling Else Trap ---");
        boolean condition1 = true;
        boolean condition2 = false;
        
        // EDGE CASE: If braces {} are omitted, an 'else' belongs to the nearest 'if'.
        // Formatting might trick you into thinking the else belongs to the first if.
        if (condition1)
            if (condition2)
                System.out.println("Condition 1 and 2 are true");
        else 
            System.out.println("Wait, which 'if' does this belong to?"); 
            // It actually belongs to condition2! Always use {} to prevent this bug.


        System.out.println("\n--- 5. Advanced Edge Case: Ternary Operator Type Promotion ---");
        // If the true and false expressions evaluate to different numeric types, 
        // Java automatically promotes the smaller type to the larger type for the ENTIRE expression.
        int intValue = 1;
        double doubleValue = 2.0;
        
        // Even though the condition is true and returns 'intValue' (which is an int), 
        // the return type of the ternary statement becomes 'double' because of 'doubleValue'.
        var promotedResult = (true) ? intValue : doubleValue; 
        System.out.println("Ternary promoted result (1 becomes 1.0): " + promotedResult);


        System.out.println("\n--- 6. Advanced Feature: Switch Expressions (Java 14+) ---");
        // Switch Expressions solve the fall-through problem using arrows (->).
        // They can also RETURN a value directly!
        int dayOfWeek = 3; 
        
        String dayType = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "Weekday"; // Multiple cases on one line
            case 6, 7 -> "Weekend";
            default -> "Invalid Day"; // Switch expressions MUST be exhaustive
        };
        System.out.println("Day 3 is a: " + dayType);


        System.out.println("\n--- 7. Advanced Feature: Switch Expressions with `yield` ---");
        // If a switch expression branch requires multiple lines of code before returning a value,
        // use a block {} and the `yield` keyword to return the value.
        String complexDayType = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("   Calculating weekday logic...");
                yield "Weekday"; // 'yield' is like 'return' specifically for switch expressions.
            }
            default -> "Other"; 
        };
        System.out.println("Yielded result: " + complexDayType);
    }
}
