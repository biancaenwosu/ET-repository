//package PageStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.*;


public class popup implements ActionListener{
    JFrame screen;
    static JComboBox<String> menu;
    JTextField amount;
    JLabel amount_text;
    JButton next;
    static String[] options = {"Rent","Groceries","Household bills","Going out","Transport","Takeaways and eating out","Clothes and shopping","Holidays and events","Health and wellbeing","Mobile phone","Course materials","Gifts and charity","Friends and family","Other"};
    public void popup_menu(){
        
        // create drop down menu
        menu = new JComboBox<>(options);
        menu.addActionListener((ActionEvent e) -> {
            Object selectedItem = menu.getSelectedItem();
            System.out.println(selectedItem);
                        
        });
        // set dimensions of dropdown menu and placement
        menu.setBounds(5,30,170,40);
     

        // create text box where user inputs amount
        amount = new JTextField();
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        amount.setBounds(280,30,50,40);
        // create label that prompts amount being added'
        amount_text = new JLabel("Amount (in £):");
        amount_text.setBounds(175,30,100,40);
        amount_text.setHorizontalAlignment(SwingConstants.RIGHT);

        // create submit button
        next = new JButton("Submit");
        next.setBounds(370,30,80,40);
        next.addActionListener(this);


        // create the screen
        screen = new JFrame("Choose option");
        screen.setLayout(null);
        // add things to the screen
        screen.add(menu);
        screen.add(amount_text); 
        screen.add(amount);
        screen.add(next);
        // adding dimensions and other routine stuff
        screen.setSize(500,150);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

    }
    public static void main(String[] args) {
        // call the method
        popup myObj = new popup();
        myObj.popup_menu();
        

    }
    @Override
    // if the submit button is pressed
    public void actionPerformed(ActionEvent f){
        if (f.getSource() == next) {
            HashMap<String, Double> profile = new HashMap<String, Double>();
            profile = DataHandler.returnCurrentValueProfile();
            String[] results = {menu.getSelectedItem().toString(),amount.getText()};
            DataHandler.UpdateCurrentValue(results[0],Double.parseDouble(results[1]),profile);
            System.out.println(Arrays.toString(results));

        }
        
    }
    
    
}
