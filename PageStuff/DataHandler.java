
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataHandler {
    public static void createProfile(String name){
        HashMap<String,String> profile = new HashMap<String,String>(); // Creates a hashmap where the string value of the key (category) and the value (current price) is stored in pairs
        profile.put("Name", name);  // Putting in the category and its average value into the hashmap
        profile.put("Rent", "439.0");
        profile.put("Groceries", "133.0");
        profile.put("Household bills", "79.0");
        profile.put("Going out", "69.0");
        profile.put("Transport", "69.0");
        profile.put("Takeaways and eating out", "66.0");
        profile.put("Clothes and shopping", "48.0");
        profile.put("Holidays and events", "36.0");
        profile.put("Health and wellbeing", "26.0");
        profile.put("Other", "25.0");
        profile.put("Mobile phone", "24.0");
        profile.put("Course materials", "24.0");
        profile.put("Gifts and charity", "21.0");
        profile.put("Friends and family", "19.0");
        
        try { // Catching exceptions incase opening fails
            File file = new File("Database"); // Creating/Opening a file called Database with no filename extension as its unneeded 
            try {
                FileOutputStream fos = new FileOutputStream(file); // File Output Stream is used to write binary data from the hashmap 
                ObjectOutputStream oos = new ObjectOutputStream(fos);   // Works on the bytes of the given object
                oos.writeObject(profile); // Can write hashmap to the stream as it is serialilizable 
                oos.flush(); // A buffer which allows all the bytes to be written while the program waits
                oos.close();
                fos.close(); // Closing frees up system resources
            } catch (IOException i) { // IOExceptions are caused by errors in writing or reading files
                System.out.println("Error writing");
            }
        } catch (Exception x) {
            System.out.println("Error opening");
        }
    }
    public static HashMap<String,String> returnProfile(){
        HashMap<String,String> profile = new HashMap<String,String>();  // Creates a hashmap to store the pre existing hashmap
        try {
        File file = new File("Database"); 
        try {
            FileInputStream fis = new FileInputStream(file); // Reads binary data
            ObjectInputStream ois = new ObjectInputStream(fis); // Works on taking in the binary data of the object given
            profile = (HashMap<String,String> )ois.readObject(); // Sets the hashmap profile to the read hashmap from the file
            System.out.println(profile.toString()); // Outputs the hashmap to check it was received correctly
        } catch (IOException e) {
            System.out.println("Error writing");
        }
     } catch (Exception e) {
        System.out.println("Error opening");
     }
     
     return  profile; // Returns the previously saved hashmap to be used
    }

    public static void UpdateValue(String valueName, String value, HashMap<String,String> profile){
        profile.replace(valueName, value);
        try { // Catching exceptions incase opening fails
            File file = new File("Database"); // Creating/Opening a file called Database with no filename extension as its unneeded 
            try {
                FileOutputStream fos = new FileOutputStream(file); // File Output Stream is used to write binary data from the hashmap 
                ObjectOutputStream oos = new ObjectOutputStream(fos);   // Works on the bytes of the given object
                oos.writeObject(profile); // Can write hashmap to the stream as it is serialilizable 
                oos.flush(); // A buffer which allows all the bytes to be written while the program waits
                oos.close();
                fos.close(); // Closing frees up system resources
            } catch (IOException i) { // IOExceptions are caused by errors in writing or reading files
                System.out.println("Error writing");
            }
        } catch (Exception x) {
            System.out.println("Error opening");
        }
    }

    public static void createCurrentData(){
        HashMap<String,Double> profile = new HashMap<String,Double>(); // Creates a hashmap where the string value of the key (category) and the value (current price) is stored in pairs
        profile.put("Groceries", 0.0);
        profile.put("Household bills", 0.0);
        profile.put("Going out", 0.0);
        profile.put("Transport", 0.0);
        profile.put("Takeaways and eating out", 0.0);
        profile.put("Clothes and shopping", 0.0);
        profile.put("Holidays and events", 0.0);
        profile.put("Health and wellbeing", 0.0);
        profile.put("Other", 0.0);
        profile.put("Mobile phone", 0.0);
        profile.put("Course materials", 0.0);
        profile.put("Gifts and charity", 0.0);
        profile.put("Friends and family", 0.0);
        profile.put("Rent", 0.0);
        
        try { // Catching exceptions incase opening fails
            File file = new File("currentValueDatabase"); // Creating/Opening a file called Database with no filename extension as its unneeded 
            try {
                FileOutputStream fos = new FileOutputStream(file); // File Output Stream is used to write binary data from the hashmap 
                ObjectOutputStream oos = new ObjectOutputStream(fos);   // Works on the bytes of the given object
                oos.writeObject(profile); // Can write hashmap to the stream as it is serialilizable 
                oos.flush(); // A buffer which allows all the bytes to be written while the program waits
                oos.close();
                fos.close(); // Closing frees up system resources
            } catch (IOException i) { // IOExceptions are caused by errors in writing or reading files
                System.out.println("Error writing");
            }
        } catch (Exception x) {
            System.out.println("Error opening");
        }
    }

    public static HashMap<String,Double> returnCurrentValueProfile(){
        HashMap<String,Double> profile = new HashMap<String,Double>();  // Creates a hashmap to store the pre existing hashmap
        try {
        File file = new File("currentValueDatabase"); 
        try {
            FileInputStream fis = new FileInputStream(file); // Reads binary data
            ObjectInputStream ois = new ObjectInputStream(fis); // Works on taking in the binary data of the object given
            profile = (HashMap<String,Double> )ois.readObject(); // Sets the hashmap profile to the read hashmap from the file
            System.out.println(profile.toString()); // Outputs the hashmap to check it was received correctly
        } catch (IOException e) {
            System.out.println("Error writing");
        }
     } catch (Exception e) {
        System.out.println("Error opening");
     }
     
     return  profile; // Returns the previously saved hashmap to be used
    }

    public static void UpdateCurrentValue(String valueName, Double value, HashMap<String,Double> profile){
        profile.replace(valueName, value);
        
        try { // Catching exceptions incase opening fails
            File file = new File("currentValueDatabase"); // Creating/Opening a file called Database with no filename extension as its unneeded 
            try {
                FileOutputStream fos = new FileOutputStream(file); // File Output Stream is used to write binary data from the hashmap 
                ObjectOutputStream oos = new ObjectOutputStream(fos);   // Works on the bytes of the given object
                oos.writeObject(profile); // Can write hashmap to the stream as it is serialilizable 
                oos.flush(); // A buffer which allows all the bytes to be written while the program waits
                oos.close();
                fos.close(); // Closing frees up system resources
                System.out.println(profile.toString()); // Outputs the hashmap to check it was received correctly
            } catch (IOException i) { // IOExceptions are caused by errors in writing or reading files
                System.out.println("Error writing");
            }
        } catch (Exception x) {
            System.out.println("Error opening");
        }
    }

}
