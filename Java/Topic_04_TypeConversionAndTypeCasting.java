class Topic_04_TypeConversionAndTypeCasting {
    public static void main(String[] args) {

        // Type Conversion and Type Casting
        /*
        In Java you can't directly convert between incompatible types. For example, you can't directly convert a String to an int.
        You need to use methods like Integer.parseInt() or Double.parseDouble() to perform the conversion. The other way to
        perform type conversion is through type casting, which is only possible when the types are compatible.
        Compatible types are those that can be converted to each other without losing information. For example, you can cast an
        int to a double, but you can't cast a String to an int.
        */
        // Type Conversion - Code Example
        String str = "123";
        int num = Integer.parseInt(str); // Converts String to int

        Double doubleNum = 10.99;
        String strNum = Double.toString(doubleNum); // Converts Double to String

        // Type Casting - Code Example
        double d = 10.5;
        int i = (int) d; // Casts double to int, but loses the decimal part
        System.out.println("The value of i is: " + i);

        // Type Conversion vs Type Casting
        /*
        The main difference between type conversion and type casting is that type conversion is an automatic process, while
        type casting is a manual process.
        */

        // Type Promotion
        /*
        Type promotion is the process of converting a smaller data type to a larger data type. For example, when you perform an
        arithmetic operation on an int and a double, the int is automatically promoted to a double.
        */
        // Example Code
        int a = 5;
        double b = 10.5;
        double c = a + b; // int is promoted to double
    }
}

// Bonus: Type Conversion and Type Casting in Java
/*
You cannot convert a String to primitive numbers using type casting because String is an object type that does not share an
inheritance relationship with primitive types. In Java, type casting like (int) "123" only works between compatible types—either
among numeric primitive types (like double to int) or within the same object class hierarchy.
To turn text into a number, you must use parsing methods provided by Java's wrapper classes. This is commonly referred to as
data type conversion or parsing.

Why Casting Fails vs. Why Parsing Works?

Type Casting (int) text:
Casting tells the Java compiler to treat an existing piece of memory as a different type.
Because a String object structured in memory looks nothing like a primitive binary integer, Java completely blocks this at compile-time.
For Casting Conversions... you can only cast
(1) variables of the same type
(2) widening/narrowing primitives
(3) widening/narrowing references (up/down cast)
(4) boxed/unboxed variables.

Type Conversion/Parsing Integer.parseInt():
Methods like parseInt() are built-in algorithms. They read through the string character-by-character (e.g., checking for '1', then '2',
then '3'), calculate the actual mathematical value, and return a brand new primitive numeric value.

Note:
When using parsing methods, always watch out for a NumberFormatException, which happens if your string contains non-numeric text like "abc".
*/