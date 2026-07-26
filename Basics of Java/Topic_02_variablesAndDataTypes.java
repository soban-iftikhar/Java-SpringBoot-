class Topic_02_variablesAndDataTypes {
    public static void main(String args[]) {
        
        /*Variables are containers for storing data values. In Java, each variable must be declared with a data type.
        These below are general data types in Java: */

        //1. int - stores integers (whole numbers), without decimals, such as 123 or -123, takes 4 bytes of memory
        int myNum = 5;             

        //2. float - stores floating point numbers, with decimals, such as 19.99 or -19.99, takes 4 bytes of memory
        float myFloatNum = 5.99f;   

        //3. char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
        char myLetter = 'D';     

        //4. boolean - stores values with two states: true or false
        boolean myBool = true;  

        //5. String - stores text, such as "Hello World". String values are surrounded by double quotes
        String myText = "Hello! My name is Soban Iftikhar"; 

        //6. long - stores large integers, such as 1234567890123456789, takes 8 bytes of memory
        long myLongNum = 1234567890123456789L;

        //7. double - stores large floating point numbers, with decimals, such as 19.99 or -19.99, takes 8 bytes of memory
        double myDoubleNum = 19.99;  

        // 8. byte - stores whole numbers from 1 to 127 or -128 to -1, takes 1 byte of memory
        byte myByteNum = 127;      

        // 9. short - stores whole numbers from 1 to 32,767 or -32,768 to -1, takes 2 bytes of memory
        short myShortNum = 32767;    

        // 10. final - used to declare constants, which are variables whose values cannot be changed once assigned
        final int myFinalNum = 10;   

        // 11. var - used to declare variables with inferred data types, introduced in Java 10+
        var myVarNum = 15;            
        
   

        System.out.print("Integer: " + myNum);
        System.out.println("Float: " + myFloatNum);
        System.out.println("Character: " + myLetter);
        System.out.println("Boolean: " + myBool);
        System.out.println("String: " + myText);
        System.out.println("Long: " + myLongNum);
        System.out.println("Double: " + myDoubleNum);
        System.out.println("Byte: " + myByteNum);
        System.out.println("Short: " + myShortNum);
        System.out.println("Final: " + myFinalNum);
        System.out.println("Var: " + myVarNum);

        /*The  difference between print and println (Print Line) is that print does not add a newline character at the end 
        In short, println prints the result on a new line*/
    }
    
}
