
public class Topic_06_Conditional_Statements {

    public static void main(String[] args) {
        
        /* 
        Conditional statements in Java are used to perform different actions based on different conditions. 
        The most common conditional statements are if, else if, else, and switch statements.
        */

        // Example Code for if statement
        // Checking if a number is positive
        int number = 10;
        if (number > 0) {
            System.out.println("The number is positive.");
        }

        // Example Code for if-else statement
        // Checking if numbers is even or odd
        if (number % 2 == 0) {
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");   
        }

        // Example Code for if-else-if statement
        // Checking if a number is positive, negative or zero
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // Example Code for nested if statement
        // Checking if a number is positive and even
        if (number > 0) {
            if (number % 2 == 0) {
                System.out.println("The number is positive and even.");
            } else {
                System.out.println("The number is positive and odd.");
            }
        }


        /*
        Traditional Switch statements are used to perform different actions based on different conditions.
        The switch statement evaluates an expression and matches the expression's value to a case label.
        If there is a match, the associated block of code is executed. If there is no match, the default block of code is executed.
        */
        // Checking the day of the week
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        /*
        Rule Switch:
        Introduced in modern Java (standardized in Java 14), a rule switch uses the arrow (->) syntax. 
        When a case matches, only the code to the right of the arrow executes, completely eliminating 
        the risk of accidental fall-through bugs. 
        */
        int day2 = 3;
        switch (day2) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Invalid day");
        }

        /*
        The difference between traditional switch and rule switch is that the traditional switch uses the colon (:) syntax,
        while the rule switch uses the arrow (->) syntax. The rule switch is more concise and eliminates the risk of accidental 
        fall-through bugs, making it a safer choice for switch statements. Beacuse if we miss a break statement in a traditional switch, 
        the code will continue to execute the next case, which can lead to unexpected behavior. On the other hand, the rule switch 
        does not have this issue, as it does not allow fall-through behavior.
        */


        
        /* 
        Ternary Operators:
        are a shorthand way of writing an if-else statement. 
        It takes three operands: a condition, a result for true, and a result for false.
        */

        // Checking if a number is positive or negative
        String result = (number > 0) ? "The number is positive." : "The number is negative.";
        System.out.println(result);

        // Example Code for nested ternary operator
        // Checking if a number is positive, negative or zero
        String result2 = (number > 0) ? "The number is positive." : (number < 0) ? "The number is negative." : "The number is zero.";
        System.out.println(result2);



   }
}
