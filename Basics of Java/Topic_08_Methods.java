public class Topic_08_Methods {
    public static void main(String[] args) {
        /*
        In Java, methods are blocks of code that perform a specific task. They are defined within a class and can be called
        to execute the code they contain. Methods can take parameters, return values. They help in organizing code, promoting reusability, and improving readability.
        Methods are written inside class and outside the main method. They can be called from the main method or from other methods within the class.
        */

        // Calling a method without parameters
        greet();

        // Calling a method with parameters
        int sum = add(5, 10);
        System.out.println("Sum: " + sum);

    }

    // Method without parameters
    static void greet() {
        System.out.println("Hello, welcome to the Java methods tutorial!");
    }

    // Method with parameters
    static int add(int a, int b) {
        return a + b;   
    }


    // Method Overloading:
    /*
    Method overloading is a feature in Java that allows a class to have more than one method with the same name, but different parameter lists. 
    This allows methods to perform similar tasks with different types or numbers of inputs. The compiler determines which method to call based 
    on the method signature (name and parameter types).
    */

    // Overloaded method with two integer parameters
    static int multiply(int a, int b) {
        return a * b;
    }

    // Overloaded method with three integer parameters
    static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // Overloaded method with two double parameters
    static double multiply(double a, double b) {
        return a * b;   
    }

    // now when we call the multiply method, the compiler will determine which version of the method to execute based on the arguments passed.

    // Returning Values from Methods:
    /*
    Methods can return values to the caller. The return type of a method is specified in its declaration. If a method does not return a value, 
    its return type is specified as 'void'. Return values are of following types: 
    primitive data types (int, double, etc.), objects, arrays, or even other methods. The return statement is used to return a value from a method.
    */
}
