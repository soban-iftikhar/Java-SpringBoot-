/*
    A class is a blueprint for creating objects. It defines the properties (attributes) and behaviors (methods) that the objects
    created from the class will have.
    An object is an instance of a class. It is created using the 'new' keyword followed by the class constructor.
    This example demonstrates the basic concepts of classes and objects in Java. The Car class has two properties: 
    color and model, and one method: startEngine(). An object of the Car class is created, its properties are set, 
    and its method is called.
    The other way to create class is by creating a separate file for the class and then importing it into the main file. 
    This is useful when you have multiple classes in your project and want to keep them organized.
*/

class Car {
    // Properties (Attributes)
    String color;
    String model;

    /*
    Constructor:
    Constructors are special methods that are called when an object is created. They have the same name as the class and 
    do not have a return type.
    */

    // Default Constructor
    public Car() {
        this.color = "Unknown";
        this.model = "Unknown";
    }

    // Parameterized Constructor
    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    // Behaviors (Methods)
    void startEngine() {
        System.out.println("The engine of the " + color + " " + model + " is starting.");
    }
}


// Main Class
public class Topic_01_ClassesAndObjects {
    public static void main(String[] args) {
        /*
        Once you have defined a class, you can create objects of that class using the 'new' keyword in the main class. 
        You can then access the properties and methods of the object using the dot (.) operator.
        */

        // Creating an object of the Car class using the default constructor
        Car defaultCar = new Car(); // Creating an object of the Car class
        System.out.println("Default Car Color: " + defaultCar.color);   
        System.out.println("Default Car Model: " + defaultCar.model);
        defaultCar.startEngine(); // Calling the startEngine method of the defaultCar object
        
        // Creating an object of the Car class using the parameterized constructor
        Car myCar = new Car("Red", "Toyota"); // Creating an object of the Car class
        myCar.startEngine(); // Calling the startEngine method of the myCar object
    }
}