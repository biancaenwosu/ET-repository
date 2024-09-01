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
    //create fonts for the different labels
    final Font titleFont = new Font("Verdana", Font.BOLD, 32 );
    final Font nameFont = new Font("Verdana", Font.ITALIC, 16);
    // set the colour green as it's rgb value
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
        // make a variable called background a picture called 'background.jpg'
        background = new ImageIcon(this.getClass().getResource("/background.jpg"));
        // create a JLabel with background on it
        bg_label = new JLabel(background);
        // create the dimensions of the label
        bg_label.setSize(400,500);
        // create a label called title and the text is 'Expense Tracker'
        title = new JLabel("Expense Tracker");
        // set the font of the title label 
        title.setFont(titleFont);
        // say where you want the label to be on the page
        title.setBounds(50, 100, 400, 32);
        // create a text box called user name where user can type
        username = new JTextField();
        // create a label that has the text "Enter name"
        name = new JLabel("Enter name");   
        // say where you want your username text box to go    
        username.setBounds(20, 250, 350,50);
        // make all the writing in the textbox have a centre alignment
        username.setHorizontalAlignment(JTextField.CENTER);
        // set the font of the name label 
        name.setFont(nameFont);
        // say where you want it to go on the screen 
        name.setBounds(140, 200, 100, 50);
        // create a button with the text "next"
        submit = new JButton("Next");
        // say where you want the button to go
        submit.setBounds(270, 300, 100,30);
        // colour th ebackground of the button green which is a variable for an rgb value
        submit.setBackground(green);
        // check whether the button has been clicked with an action listener
        submit.addActionListener(this);
        //add all the labels, buttons and textfield to the background label so it shows infront of the background picture
        bg_label.add(title);
        bg_label.add(username);
        bg_label.add(name);
        bg_label.add(submit);
        

        // create a frame so you can add stuff to the screen
        page = new JFrame("Intro page");
        // add your bg label (which has everything added to it already)
        page.add(bg_label);
        // dimensions of the screen
        page.setSize(400,500);
        // the type of layout of the screen is no layout because I manually decide where I want everything to be with '.setBounds'
        page.setLayout(null);
        // when the user clicks 'x' then page (our frame) will close
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // so you can see this window
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
        DataHandler.createProfile(username.getName());
        // Here is datahandler class
    }
    

}