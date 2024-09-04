//package PageStuff;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.*;

public class popup{
    JFrame screen;
    static JComboBox<String> menu;
    static String[] options = {"Rent","Groceries","Household bills","Going out","Transport","Takeaways and eating out","Clothes and shopping","Holidays and events","Health and wellbeing","Mobile phone","Course materials","Gifts and charity","Friends and family","Other"};
    public String[] popup_menu(){
        String[] results = {"Rent","5"};
        // create drop down menu
        menu = new JComboBox<>(options);
        menu.addActionListener((ActionEvent e) -> {
            Object selectedItem = menu.getSelectedItem();
            
            System.out.println(selectedItem);
        });
        screen = new JFrame("Choose option");
        screen.setLayout(new BorderLayout());
        screen.add(menu, BorderLayout.CENTER);
        screen.setSize(200,200);
        screen.setVisible(true);

        return results;

        
        
    }
    public static void main(String[] args) {
        popup myObj = new popup();
        String[] x = myObj.popup_menu();
        System.out.println(Arrays.toString(x));

    }
    
}
