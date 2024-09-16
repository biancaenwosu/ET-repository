

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;



public class settingspage {
    JFrame mainFrame;
    JPanel settings;
    JLabel settingsPageLabel;
    JLabel Rent;
    JLabel Groceries;
    JLabel Bills;
    JLabel goingout;
    JLabel Transport;
    JLabel Takeaways;
    JLabel shopping;
    JLabel events;
    JLabel Health;
    JLabel Mobilephone;
    JLabel school;
    JLabel charity;
    JLabel family;
    Font headerFont = new Font("Arial",Font.BOLD,40);
    JButton addButton;
    int ypos = 50;
    HashMap<String, Double> profile = new HashMap<>();
    profile = DataHandler.returnCurrentValueProfile();
    
    public settingspage(){
        // header
        settingsPageLabel = new JLabel("Settings Page");
        settingsPageLabel.setBounds(0,0,600,50);
        settingsPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsPageLabel.setFont(headerFont);


                    
        //Rent 
        Rent = new JLabel("Rent");
        Rent.setBounds(5,ypos,70,50);
        sliderbar Rentbar = new sliderbar(1000, profile.get("Rent"), 100);
        Rentbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyRent = new JButton("Apply");
        applyRent.setBounds(400,ypos,100,50);
        JLabel rent_number = new JLabel(String.valueOf(Rentbar.sliderListener()));
        applyRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rent_number.setText(String.valueOf(Rentbar.sliderListener()));
            }
            
        });
        rent_number.setBounds(510,ypos,50,50);
        ypos += 70;
        //Groceries
        Groceries = new JLabel("Groceries");
        Groceries.setBounds(5,ypos,70,50);
        sliderbar Groceriesbar = new sliderbar(300,profile.get("Groceries"),30);
        Groceriesbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyGroceries = new JButton("Apply");
        applyGroceries.setBounds(400,ypos,100,50);
        JLabel Groceries_number = new JLabel(String.valueOf(Groceriesbar.sliderListener()));
        applyGroceries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Groceries_number.setText(String.valueOf(Groceriesbar.sliderListener()));
            }
            
        });
        Groceries_number.setBounds(510,ypos,50,50);
        ypos += 70;

        //Bills
        Bills = new JLabel("Bills");
        Bills.setBounds(5,ypos,70,50);
        sliderbar Billsbar = new sliderbar(200,profile.get("Household bills"),20);
        Billsbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyBills = new JButton("Apply");
        applyBills.setBounds(400,ypos,100,50);
        JLabel Bills_number = new JLabel(String.valueOf(Billsbar.sliderListener()));
        applyBills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bills_number.setText(String.valueOf(Billsbar.sliderListener()));
            }
            
        });
        Bills_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //goingout
        goingout = new JLabel("goingout");
        goingout.setBounds(5,ypos,70,50);
        sliderbar goingoutbar = new sliderbar(100,profile.get("Going out"),10);
        goingoutbar.slider.setBounds(80,ypos, 300, 50);
        JButton applygoingout = new JButton("Apply");
        applygoingout.setBounds(400,ypos,100,50);
        JLabel goingout_number = new JLabel(String.valueOf(goingoutbar.sliderListener()));
        applygoingout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goingout_number.setText(String.valueOf(goingoutbar.sliderListener()));
            }
            
        });
        goingout_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //Transport
        Transport = new JLabel("Transport");
        Transport.setBounds(5,ypos,70,50);
        sliderbar Transportbar = new sliderbar(150,profile.get("Transport"),15);
        Transportbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyTransport = new JButton("Apply");
        applyTransport.setBounds(400,ypos,100,50);
        JLabel Transport_number = new JLabel(String.valueOf(Transportbar.sliderListener()));
        applyTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transport_number.setText(String.valueOf(Transportbar.sliderListener()));
            }
            
        });
        Transport_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //Takeaways
        Takeaways = new JLabel("Takeaways");
        Takeaways.setBounds(5,ypos,70,50);
        sliderbar Takeawaysbar = new sliderbar(150,profile.get("Takeaways and eating out"),15);
        Takeawaysbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyTakeaways = new JButton("Apply");
        applyTakeaways.setBounds(400,ypos,100,50);
        JLabel Takeaways_number = new JLabel(String.valueOf(Takeawaysbar.sliderListener()));
        applyTakeaways.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Takeaways_number.setText(String.valueOf(Takeawaysbar.sliderListener()));
            }
            
        });
        Takeaways_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //shopping
        shopping = new JLabel("shopping");
        shopping.setBounds(5,ypos,70,50);
        sliderbar shoppingbar = new sliderbar(70,profile.get("Clothes and shopping"),7);
        shoppingbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyshopping = new JButton("Apply");
        applyshopping.setBounds(400,ypos,100,50);
        JLabel shopping_number = new JLabel(String.valueOf(shoppingbar.sliderListener()));
        applyshopping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopping_number.setText(String.valueOf(shoppingbar.sliderListener()));
            }
            
        });
        shopping_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //events
        events = new JLabel("events");
        events.setBounds(5,ypos,70,50);
        sliderbar eventsbar = new sliderbar(100,profile.get("Holidays and events"),10);
        eventsbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyevents = new JButton("Apply");
        applyevents.setBounds(400,ypos,100,50);
        JLabel events_number = new JLabel(String.valueOf(eventsbar.sliderListener()));
        applyevents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                events_number.setText(String.valueOf(eventsbar.sliderListener()));
            }
            
        });
        events_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //Health
        Health = new JLabel("Health");
        Health.setBounds(5,ypos,70,50);
        sliderbar Healthbar = new sliderbar(60,profile.get("Health and wellbeing"),6);
        Healthbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyHealth = new JButton("Apply");
        applyHealth.setBounds(400,ypos,100,50);
        JLabel Health_number = new JLabel(String.valueOf(Healthbar.sliderListener()));
        applyHealth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Health_number.setText(String.valueOf(Healthbar.sliderListener()));
            }
            
        });
        Health_number.setBounds(510,ypos,50,50);

        ypos += 70;


        //Mobilephone
        Mobilephone = new JLabel("Mobilephone");
        Mobilephone.setBounds(5,ypos,70,50);
        sliderbar Mobilephonebar = new sliderbar(50,profile.get("Mobile phone"),5);
        Mobilephonebar.slider.setBounds(80,ypos, 300, 50);
        JButton applyMobilephone = new JButton("Apply");
        applyMobilephone.setBounds(400,ypos,100,50);
        JLabel Mobilephone_number = new JLabel(String.valueOf(Mobilephonebar.sliderListener()));
        applyMobilephone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mobilephone_number.setText(String.valueOf(Mobilephonebar.sliderListener()));
            }
            
        });
        Mobilephone_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //school
        school = new JLabel("school");
        school.setBounds(5,ypos,70,50);
        sliderbar schoolbar = new sliderbar(50,profile.get("Course materials"),5);
        schoolbar.slider.setBounds(80,ypos, 300, 50);
        JButton applyschool = new JButton("Apply");
        applyschool.setBounds(400,ypos,100,50);
        JLabel school_number = new JLabel(String.valueOf(schoolbar.sliderListener()));
        applyschool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school_number.setText(String.valueOf(schoolbar.sliderListener()));
            }
            
        });
        school_number.setBounds(5,ypos,50,50);

        ypos += 70;

        //charity
        charity = new JLabel("charity");
        charity.setBounds(5,ypos,70,50);
        sliderbar charitybar = new sliderbar(50,profile.get("Gifts and charity"),5);
        charitybar.slider.setBounds(80,ypos, 300, 50);
        JButton applycharity = new JButton("Apply");
        applycharity.setBounds(400,ypos,100,50);
        JLabel charity_number = new JLabel(String.valueOf(charitybar.sliderListener()));
        applycharity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charity_number.setText(String.valueOf(charitybar.sliderListener()));
            }
            
        });
        charity_number.setBounds(510,ypos,50,50);

        ypos += 70;

        //family
        family = new JLabel("family");
        family.setBounds(5,ypos,70,50);
        sliderbar familybar = new sliderbar(50,profile.get("Friends and family"),5);
        familybar.slider.setBounds(80,ypos, 300, 50);
        JButton applyfamily = new JButton("Apply");
        applyfamily.setBounds(400,ypos,100,50);
        JLabel family_number = new JLabel(String.valueOf(familybar.sliderListener()));
        applyfamily.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                family_number.setText(String.valueOf(familybar.sliderListener()));
            }
            
        });
        family_number.setBounds(510,ypos,50,50);
       
       
 


        // frame set-up
        settings = new JPanel();
        settings.setLayout(null);
        settings.setPreferredSize(new java.awt.Dimension(600,1100));
        //add header
        settings.add(settingsPageLabel);
        //add rent section to frame
        settings.add(Rent);
        settings.add(Rentbar.slider);
        settings.add(applyRent);
        settings.add(rent_number);
        // add groceries section to frame
        settings.add(Groceries);
        settings.add(Groceriesbar.slider);
        settings.add(applyGroceries);
        settings.add(Groceries_number);
        // add Bills section to frame
        settings.add(Bills);
        settings.add(Billsbar.slider);
        settings.add(applyBills);
        settings.add(Bills_number);
        // add goingout section to frame
        settings.add(goingout);
        settings.add(goingoutbar.slider);
        settings.add(applygoingout);
        settings.add(goingout_number);
        // add Transport section to frame
        settings.add(Transport);
        settings.add(Transportbar.slider);
        settings.add(applyTransport);
        settings.add(Transport_number);
     
        // add Takeaways section to frame
        settings.add(Takeaways);
        settings.add(Takeawaysbar.slider);
        settings.add(applyTakeaways);
        settings.add(Takeaways_number);
  
        // add shopping section to frame
        settings.add(shopping);
        settings.add(shoppingbar.slider);
        settings.add(applyshopping);
        settings.add(shopping_number);
    
        // add events section to frame
        settings.add(events);
        settings.add(eventsbar.slider);
        settings.add(applyevents);
        settings.add(events_number);

        // add Health section to frame
        settings.add(Health);
        settings.add(Healthbar.slider);
        settings.add(applyHealth);
        settings.add(Health_number);
   
    
        // add Mobilephone section to frame
        settings.add(Mobilephone);
        settings.add(Mobilephonebar.slider);
        settings.add(applyMobilephone);
        settings.add(Mobilephone_number);
   
        // add school section to frame
        settings.add(school);
        settings.add(schoolbar.slider);
        settings.add(applyschool);
    
        // add charity section to frame
        settings.add(charity);
        settings.add(charitybar.slider);
        settings.add(applycharity);
        settings.add(charity_number);

        // add family section to frame
        settings.add(family);
        settings.add(familybar.slider);
        settings.add(applyfamily);
        settings.add(family_number);

    
        JTextField addText = new JTextField();
        addText.setBounds(210,ypos+70,200,50);

       
        addButton = new JButton("Add new option");
        addButton.setBounds(5,ypos+70, 200,50);
        
        addButton.addActionListener((ActionEvent e) -> {
            
            addComponent(addText.getText());
            updateButton(addButton);
            updateButton(addText);
            settings.setPreferredSize(new java.awt.Dimension(600,ypos+160));
            settings.revalidate();
            settings.revalidate();
            
          
        });

        settings.add(addButton);
        settings.add(addText);
        




        // add this all to a scroll pane so that is can be scrolled through
        JScrollPane scrollPane = new JScrollPane(settings);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //mainFrame set up
        mainFrame = new JFrame("Settings Page");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600,500);
        mainFrame.add(scrollPane);
        mainFrame.setVisible(true);


        
    

    }
    private void addComponent(String component){
        ypos += 70;

        JLabel label = new JLabel(component);
        label.setBounds(5,ypos,100,50);
        sliderbar slider_bar = new sliderbar(1000,0.0,100);
        slider_bar.slider.setBounds(80,ypos,300,50);
        JButton button = new JButton("Apply");
        button.setBounds(400,ypos,100,50);

        settings.add(label);
        settings.add(slider_bar.slider);
        settings.add(button);

        

        
        
    }
    private void updateButton(JButton addButton){
        addButton.setBounds(5,ypos+70,200,50);
    }
    private void updateButton(JTextField textField){
        textField.setText("");
        textField.setBounds(210,ypos+70,200,50);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new settingspage());
    }

}
