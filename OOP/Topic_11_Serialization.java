/*
 * Topic 11: Serialization & Deserialization
 * 
 * --- LEVEL 0: BEGINNER ---
 * Serialization is the process of converting an Object's state (its variables) into a stream of bytes.
 * This byte stream can then be saved to a file, database, or sent across a network.
 * 
 * Deserialization is the exact reverse: reading the byte stream and converting it back into a live Java Object.
 * 
 * Key Interface: 'java.io.Serializable'
 * Key Keyword: 'transient'
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// ==========================================
// 1. CREATING A SERIALIZABLE CLASS
// ==========================================
// To allow an object to be serialized, its class MUST implement the 'Serializable' interface.
// Notice that 'Serializable' has zero methods to override! It is a "Marker Interface" 
// that simply gives the JVM permission to serialize it.
class UserProfile implements Serializable {
    
    // The serialVersionUID is a unique ID for this specific version of the class.
    // If you modify the class later (e.g., add a new variable) but try to load an old save file,
    // the JVM will check this ID. If they don't match, it throws an InvalidClassException!
    private static final long serialVersionUID = 1L;

    public String username;
    public int level;
    
    // The 'transient' keyword tells the JVM: "DO NOT save this variable during serialization!"
    // This is crucial for sensitive data like passwords or temporary cache data.
    public transient String password;

    public UserProfile(String username, int level, String password) {
        this.username = username;
        this.level = level;
        this.password = password;
    }

    public void displayProfile() {
        System.out.println("Username: " + username);
        System.out.println("Level: " + level);
        System.out.println("Password: " + password + " (If null, it was skipped due to 'transient')");
    }
}

public class Topic_11_Serialization {
    public static void main(String[] args) {
        
        UserProfile myUser = new UserProfile("DragonSlayer99", 50, "superSecretPassword123");
        String filename = "user_save_data.ser";

        System.out.println("--- 1. Original Live Object ---");
        myUser.displayProfile();

        // ==========================================
        // 2. SERIALIZATION (Saving Object to File)
        // ==========================================
        try {
            // FileOutputStream creates the physical file.
            FileOutputStream fileOut = new FileOutputStream(filename);
            // ObjectOutputStream writes the Java object into the file stream.
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            out.writeObject(myUser); // This is where the magic happens!
            
            out.close();
            fileOut.close();
            System.out.println("\n[Success] Object state has been serialized and saved to: " + filename);
        } catch (Exception e) {
            System.out.println("Serialization Failed: " + e.getMessage());
        }

        // ==========================================
        // 3. DESERIALIZATION (Loading Object from File)
        // ==========================================
        UserProfile loadedUser = null;
        
        try {
            // FileInputStream reads the physical file.
            FileInputStream fileIn = new FileInputStream(filename);
            // ObjectInputStream converts the byte stream back into a Java object.
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            // We must explicitly cast (downcast) the returned Object back into a UserProfile.
            loadedUser = (UserProfile) in.readObject(); 
            
            in.close();
            fileIn.close();
            System.out.println("[Success] Object state has been deserialized from: " + filename);
        } catch (Exception e) {
            System.out.println("Deserialization Failed: " + e.getMessage());
        }

        System.out.println("\n--- 4. Loaded Object ---");
        if (loadedUser != null) {
            loadedUser.displayProfile();
            // You will notice the password is 'null' because it was marked as 'transient'!
        }
    }
}
