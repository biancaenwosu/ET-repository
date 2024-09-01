import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataHandler {
    public static void createProfile(String name){
        HashMap<String,String> profile = new HashMap<String,String>();
        profile.put("Name", name);
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
        
        try {
            File file = new File("Database");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(profile);
                oos.flush();
                oos.close();
                fos.close();
            } catch (IOException i) {
                System.out.println("Error writing");
            }
        } catch (Exception x) {
            System.out.println("Error opening");
        }
    }
    public static HashMap<String,String> returnProfile(){
        HashMap<String,String> profile = new HashMap<String,String>();
        try {
        File file = new File("Database"); 
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            profile = (HashMap<String,String> )ois.readObject();
            System.out.println(profile.toString());
        } catch (IOException e) {
            System.out.println("Error writing");
        }
     } catch (Exception e) {
        System.out.println("Error opening");
     }
     
     return  profile;
    }


}
