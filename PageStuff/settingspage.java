

import java.awt.Font;
import java.awt.event.ActionEvent;
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
    JLabel Other;
    JLabel Mobilephone;
    JLabel school;
    JLabel charity;
    JLabel family;
    Font headerFont = new Font("Arial",Font.BOLD,40);
    JButton addButton;
    int lastPlace = 970;
    
    public settingspage(){
        // header
        settingsPageLabel = new JLabel("Settings Page");
        settingsPageLabel.setBounds(0,0,600,50);
        settingsPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsPageLabel.setFont(headerFont);


                    
        //Rent 
        Rent = new JLabel("Rent");
        Rent.setBounds(5,50,70,50);
        sliderbar Rentbar = new sliderbar(1000,439,100);
        Rentbar.slider.setBounds(80,50, 300, 50);
        JButton applyRent = new JButton("Apply");
        applyRent.setBounds(400,50,100,50);
        
        //Groceries
        Groceries = new JLabel("Groceries");
        Groceries.setBounds(5,120,70,50);
        sliderbar Groceriesbar = new sliderbar(300,133,30);
        Groceriesbar.slider.setBounds(80,120, 300, 50);
        JButton applyGroceries = new JButton("Apply");
        applyGroceries.setBounds(400,120,100,50);

        //Bills
        Bills = new JLabel("Bills");
        Bills.setBounds(5,190,70,50);
        sliderbar Billsbar = new sliderbar(200,79,20);
        Billsbar.slider.setBounds(80,190, 300, 50);
        JButton applyBills = new JButton("Apply");
        applyBills.setBounds(400,190,100,50);

        //goingout
        goingout = new JLabel("goingout");
        goingout.setBounds(5,260,70,50);
        sliderbar goingoutbar = new sliderbar(100,69,10);
        goingoutbar.slider.setBounds(80,260, 300, 50);
        JButton applygoingout = new JButton("Apply");
        applygoingout.setBounds(400,260,100,50);

        //Transport
        Transport = new JLabel("Transport");
        Transport.setBounds(5,330,70,50);
        sliderbar Transportbar = new sliderbar(150,69,15);
        Transportbar.slider.setBounds(80,330, 300, 50);
        JButton applyTransport = new JButton("Apply");
        applyTransport.setBounds(400,330,100,50);

        //Takeaways
        Takeaways = new JLabel("Takeaways");
        Takeaways.setBounds(5,400,70,50);
        sliderbar Takeawaysbar = new sliderbar(150,66,15);
        Takeawaysbar.slider.setBounds(80,400, 300, 50);
        JButton applyTakeaways = new JButton("Apply");
        applyTakeaways.setBounds(400,400,100,50);

        //shopping
        shopping = new JLabel("shopping");
        shopping.setBounds(5,470,70,50);
        sliderbar shoppingbar = new sliderbar(70,48,7);
        shoppingbar.slider.setBounds(80,470, 300, 50);
        JButton applyshopping = new JButton("Apply");
        applyshopping.setBounds(400,470,100,50);

        //events
        events = new JLabel("events");
        events.setBounds(5,540,70,50);
        sliderbar eventsbar = new sliderbar(100,36,10);
        eventsbar.slider.setBounds(80,540, 300, 50);
        JButton applyevents = new JButton("Apply");
        applyevents.setBounds(400,540,100,50);

        //Health
        Health = new JLabel("Health");
        Health.setBounds(5,610,70,50);
        sliderbar Healthbar = new sliderbar(60,26,6);
        Healthbar.slider.setBounds(80,610, 300, 50);
        JButton applyHealth = new JButton("Apply");
        applyHealth.setBounds(400,610,100,50);

        //Other
        Other = new JLabel("Other");
        Other.setBounds(5,680,70,50);
        sliderbar Otherbar = new sliderbar(50,25,5);
        Otherbar.slider.setBounds(80,680, 300, 50);
        JButton applyOther = new JButton("Apply");
        applyOther.setBounds(400,680,100,50);

        //Mobilephone
        Mobilephone = new JLabel("Mobilephone");
        Mobilephone.setBounds(5,750,70,50);
        sliderbar Mobilephonebar = new sliderbar(50,24,5);
        Mobilephonebar.slider.setBounds(80,750, 300, 50);
        JButton applyMobilephone = new JButton("Apply");
        applyMobilephone.setBounds(400,750,100,50);

        //school
        school = new JLabel("school");
        school.setBounds(5,820,70,50);
        sliderbar schoolbar = new sliderbar(50,24,5);
        schoolbar.slider.setBounds(80,820, 300, 50);
        JButton applyschool = new JButton("Apply");
        applyschool.setBounds(400,820,100,50);

        //charity
        charity = new JLabel("charity");
        charity.setBounds(5,900,70,50);
        sliderbar charitybar = new sliderbar(50,21,5);
        charitybar.slider.setBounds(80,900, 300, 50);
        JButton applycharity = new JButton("Apply");
        applycharity.setBounds(400,900,100,50);

        //family
        family = new JLabel("family");
        family.setBounds(5,970,70,50);
        sliderbar familybar = new sliderbar(50,19,5);
        familybar.slider.setBounds(80,970, 300, 50);
        JButton applyfamily = new JButton("Apply");
        applyfamily.setBounds(400,970,100,50);
       
       
 


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
        // add groceries section to frame
        settings.add(Groceries);
        settings.add(Groceriesbar.slider);
        settings.add(applyGroceries);
        // add Bills section to frame
        settings.add(Bills);
        settings.add(Billsbar.slider);
        settings.add(applyBills);
        // add goingout section to frame
        settings.add(goingout);
        settings.add(goingoutbar.slider);
        settings.add(applygoingout);
        // add Transport section to frame
        settings.add(Transport);
        settings.add(Transportbar.slider);
        settings.add(applyTransport);
     
        // add Takeaways section to frame
        settings.add(Takeaways);
        settings.add(Takeawaysbar.slider);
        settings.add(applyTakeaways);
  
        // add shopping section to frame
        settings.add(shopping);
        settings.add(shoppingbar.slider);
        settings.add(applyshopping);
    
        // add events section to frame
        settings.add(events);
        settings.add(eventsbar.slider);
        settings.add(applyevents);

        // add Health section to frame
        settings.add(Health);
        settings.add(Healthbar.slider);
        settings.add(applyHealth);
   
        // add Other section to frame
        settings.add(Other);
        settings.add(Otherbar.slider);
        settings.add(applyOther);
    
        // add Mobilephone section to frame
        settings.add(Mobilephone);
        settings.add(Mobilephonebar.slider);
        settings.add(applyMobilephone);
   
        // add school section to frame
        settings.add(school);
        settings.add(schoolbar.slider);
        settings.add(applyschool);
    
        // add charity section to frame
        settings.add(charity);
        settings.add(charitybar.slider);
        settings.add(applycharity);

        // add family section to frame
        settings.add(family);
        settings.add(familybar.slider);
        settings.add(applyfamily);

        //addComponent("Ezinwa");

        JTextField addText = new JTextField();
        addText.setBounds(210,lastPlace+70,100,50);

       
        addButton = new JButton("Add new option");
        addButton.setBounds(5,lastPlace+70, 200,50);
        
        addButton.addActionListener((ActionEvent e) -> {
            
            addComponent(addText.getText());
            updateButton(addButton);
            updateButton(addText);
            settings.setPreferredSize(new java.awt.Dimension(600,lastPlace+160));
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
        lastPlace += 70;
        
        JLabel label = new JLabel(component);
        label.setBounds(5,lastPlace,100,50);
        sliderbar slider_bar = new sliderbar(1000,439,100);
        slider_bar.slider.setBounds(80,lastPlace,300,50);
        JButton button = new JButton("Apply");
        button.setBounds(400,lastPlace,100,50);

        settings.add(label);
        settings.add(slider_bar.slider);
        settings.add(button);

        
        
    }
    private void updateButton(JButton addButton){
        addButton.setBounds(5,lastPlace+70,200,50);
    }
    private void updateButton(JTextField textField){
        textField.setText("");
        textField.setBounds(210,lastPlace+70,200,50);
    }
    public static void main(String[] args) {
        new settingspage();
    }

}
