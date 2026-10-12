/*
 * Topic 13: Enums (Enumerations)
 * 
 * --- LEVEL 0: BEGINNER ---
 * An Enum is a special data type that enables a variable to be a set of predefined constants.
 * The variable must be equal to one of the values that have been predefined for it.
 * Common examples: Compass directions (NORTH, SOUTH, EAST, WEST), Days of the week, Status codes.
 * 
 * Key Advantages:
 * 1. Type Safety: You cannot pass an invalid value (unlike using raw Strings or ints).
 * 2. Readability: Self-documenting code.
 * 3. Works seamlessly with switch statements.
 */

// ==========================================
// 1. BASIC ENUM
// ==========================================
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// ==========================================
// 2. ADVANCED ENUM (Enums as Full Classes)
// ==========================================
// In Java, an enum is actually a special class that extends java.lang.Enum behind the scenes.
// Because it is a class, it can have fields, constructors, and methods!
enum OrderStatus {
    // Each constant calls the constructor defined below.
    PENDING(101, "Order received, awaiting payment"),
    PROCESSING(102, "Payment confirmed, preparing shipment"),
    SHIPPED(103, "Package is on the way"),
    DELIVERED(104, "Package delivered to customer"),
    CANCELLED(105, "Order was cancelled");

    // Fields for each enum constant
    private final int statusCode;
    private final String description;

    // CONSTRUCTOR RULE:
    // Enum constructors MUST be private (or package-private).
    // You CANNOT call 'new OrderStatus(...)'. The JVM creates these instances once at startup.
    private OrderStatus(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    // Getters to access the fields
    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    // Concrete method inside an enum
    public boolean isTerminalState() {
        return this == DELIVERED || this == CANCELLED;
    }
}

// ==========================================
// 3. ENUMS IMPLEMENTING INTERFACES
// ==========================================
// Note: Enums CANNOT extend other classes (they already extend java.lang.Enum implicitly).
// However, they CAN implement interfaces!
interface Describable {
    String getSummary();
}

enum Priority implements Describable {
    LOW {
        @Override
        public String getSummary() {
            return "Low priority: Can be addressed later.";
        }
    },
    MEDIUM {
        @Override
        public String getSummary() {
            return "Medium priority: Address within 48 hours.";
        }
    },
    HIGH {
        @Override
        public String getSummary() {
            return "High priority: Urgent action required!";
        }
    }
}


public class Topic_13_Enums {
    public static void main(String[] args) {

        System.out.println("--- 1. Basic Enum Usage & Switch ---");
        Day today = Day.FRIDAY;

        // Using enums in a switch statement
        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week.");
                break;
            case FRIDAY:
                System.out.println("Weekend is almost here!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend vibes.");
                break;
            default:
                System.out.println("Midweek grind.");
                break;
        }

        // Built-in Enum methods: values(), ordinal(), name()
        System.out.println("\nAll Days with their ordinals (index position):");
        for (Day d : Day.values()) {
            System.out.println("Index " + d.ordinal() + ": " + d.name());
        }


        System.out.println("\n--- 2. Advanced Enum with Custom Fields & Methods ---");
        OrderStatus currentOrder = OrderStatus.SHIPPED;

        System.out.println("Status: " + currentOrder.name());
        System.out.println("Code: " + currentOrder.getStatusCode());
        System.out.println("Description: " + currentOrder.getDescription());
        System.out.println("Is Terminal State? " + currentOrder.isTerminalState());

        OrderStatus finalOrder = OrderStatus.DELIVERED;
        System.out.println("Delivered is Terminal? " + finalOrder.isTerminalState());


        System.out.println("\n--- 3. Enum valueOf() & Comparison Edge Case ---");
        // valueOf() converts a String to an Enum constant (case-sensitive)
        OrderStatus parsed = OrderStatus.valueOf("PENDING");
        System.out.println("Parsed from String: " + parsed);

        // EDGE CASE: Comparing Enums with == vs .equals()
        // With Enums, '==' is preferred over '.equals()' because:
        // 1. Each constant is a true Singleton instance in memory.
        // 2. '==' is null-safe (doesn't throw NullPointerException if one side is null).
        OrderStatus nullStatus = null;
        // nullStatus.equals(OrderStatus.PENDING); // Throws NullPointerException!
        boolean isSafe = (nullStatus == OrderStatus.PENDING); // Safe! Evaluates to false.
        System.out.println("Null-safe comparison with ==: " + isSafe);


        System.out.println("\n--- 4. Enums Implementing Interfaces ---");
        for (Priority p : Priority.values()) {
            System.out.println(p.name() + " -> " + p.getSummary());
        }
    }
}
