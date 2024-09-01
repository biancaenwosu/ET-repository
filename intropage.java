import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject; 





public class intropage implements ActionListener {
    private final JFrame page;
    private final ImageIcon background; 
    private final JLabel bg_label;
    private final JLabel title;
    private final JTextField username;
    private final JLabel name;
    private final JButton submit;
    
    final Font titleFont = new Font("Verdana", Font.BOLD, 32 );
    final Font nameFont = new Font("Verdana", Font.ITALIC, 16);
    private final Color green = new Color(104,119,62,255);

    public void actionPerformer(ActionEvent e) {

        String name = username.getText();
        JSONObject profile = new JSONObject();

        profile.put("Name", name);

       try {
         
            File Database = new File("Database.json");
            FileWriter writer = new FileWriter(Database);
            writer.write(profile.toJSONString());
        
            writer.close();
       } catch (IOException no) {
           System.out.println("Error opening file");
       }
    }



    
    public intropage(){

        background = new ImageIcon(this.getClass().getResource("/background.jpg"));
        bg_label = new JLabel(background);
        bg_label.setSize(400,500);
        title = new JLabel("Expense Tracker");
        title.setFont(titleFont);
        title.setBounds(50, 100, 400, 32);
        username = new JTextField();
        name = new JLabel("Enter name");       
        username.setBounds(20, 250, 350,50);
        name.setFont(nameFont);
        name.setBounds(140, 200, 100, 50);
        submit = new JButton("Next");
        submit.setBounds(270, 300, 100,30);
        submit.setBackground(green);
     
        submit.addActionListener(this);
   
        bg_label.add(title);
        bg_label.add(username);
        bg_label.add(name);
        bg_label.add(submit);
        


        page = new JFrame("Intro page");
        page.add(bg_label);

        page.setSize(400,500);
        page.setLayout(null);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            File file = new File("Database.json");
            if(file.exists()){ // Check if their data exists
            // Open main page
            System.out.println("Main page opened");
            }else{ // If it doesnt exist start user from intro
                new intropage();
            }
        } catch (Exception e) {
            System.out.println("Error opening file");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}