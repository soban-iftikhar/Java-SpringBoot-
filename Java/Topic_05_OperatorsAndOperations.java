public class Topic_05_OperatorsAndOperations {
    public static void main(String[] args) {

        // Operators and Operations
        /*
        In Java, operators are special symbols that perform operations on variables and values. There are several types of operators in Java, including:
        - Arithmetic Operators: +, -, *, /, %
        - Relational Operators: ==, !=, >, <, >=, <=
        - Logical Operators: &&, ||, !
        - Assignment Operators: =, +=, -=, *=, /=, %=
        - Unary Operators: +, -, ++, --
        - Bitwise Operators: &, |, ^, ~, <<, >>, >>>
        */

        // Example Code for Arithmetic Operators
        int a = 10;
        int b = 5;
        int sum = a + b; // Addition
        int difference = a - b; // Subtraction
        int product = a * b; // Multiplication
        int quotient = a / b; // Division
        int remainder = a % b; // Modulus - gives the remainder of the division

        // Example Code for Relational Operators
        boolean isEqual = (a == b); // false
        boolean isNotEqual = (a != b); // true
        boolean isGreater = (a > b); // true
        boolean isLess = (a < b); // false

        // Example Code for Logical Operators
        boolean result1 = (a > 0) && (b > 0); // true
        boolean result2 = (a > 0) || (b < 0); // true
        boolean result3 = !(a < 0); // true

        // Example Code for Assignment Operators
        int c = 10;
        c += 5; // c = c + 5; now c is 15  
        c -= 3; // c = c - 3; now c is 12
        c *= 2; // c = c * 2; now c is 24
        c /= 4; // c = c / 4; now c is 6
        c %= 2; // c = c % 2; now c is 0

        // Example Code for Unary Operators
        int d = 5;
        d++; // Increment operator, now d is 6
        d--; // Decrement operator, now d is 5
        // Differece between prefix and postfix increment/decrement operators
        int x = 5;
        int y = ++x; // Prefix increment: x is incremented first, then assigned to y, so y is 6 and x is 6
        int z = x++; // Postfix increment: x is assigned to z first, then incremented, so z is 6 and x is 7

        // Example Code for Bitwise Operators
        int e = 5; // 0101 in binary
        int f = 3; // 0011 in binary
        int andResult = e & f; // 0101 & 0011 = 0001 (1 in decimal)
        int orResult = e | f; // 0101 | 0011 = 0111 (7 in decimal)
        int xorResult = e ^ f; // 0101 ^ 0011 = 0110 (6 in decimal)



        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);  

        System.out.println("isEqual: " + isEqual);
        System.out.println("isNotEqual: " + isNotEqual);
        System.out.println("isGreater: " + isGreater);
        System.out.println("isLess: " + isLess);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);

        System.out.println("c: " + c);
        System.out.println("d: " + d);

        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("x: " + x);

        System.out.println("AND Result: " + andResult);
        System.out.println("OR Result: " + orResult);
        System.out.println("XOR Result: " + xorResult);
    }
}
