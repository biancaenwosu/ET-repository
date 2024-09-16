

import javax.swing.*;



public class settingspage {
    JFrame settings;
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
    
    public settingspage(){
        // header
        settingsPageLabel = new JLabel("Settings Page");


                    
        //Rent 
        
        Rent = new JLabel("Rent");
        Rent.setBounds(5,50,70,50);
        sliderbar Rentbar = new sliderbar(1000,439);
        Rentbar.slider.setBounds(80,50, 300, 50);
        JButton applyRent = new JButton("Apply");
        applyRent.setBounds(400,50,100,50);
      

        
        //Groceries
        Groceries = new JLabel("Groceries");
        Groceries.setBounds(5,120,70,50);
        sliderbar Groceriesbar = new sliderbar(1000,439);
        Groceriesbar.slider.setBounds(80,120, 300, 50);
        JButton applyGroceries = new JButton("Apply");
        applyGroceries.setBounds(400,120,100,50);

        //Bills
        Bills = new JLabel("Bills");
        Bills.setBounds(5,190,70,50);
        sliderbar Billsbar = new sliderbar(1000,439);
        Billsbar.slider.setBounds(80,190, 300, 50);
        JButton applyBills = new JButton("Apply");
        applyBills.setBounds(400,190,100,50);
       
 


        // frame set-up
        settings = new JFrame();
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


        settings.setLayout(null);
        settings.setVisible(true);
        settings.setSize(600,500);
    

    }
    public static void main(String[] args) {
        new settingspage();
    }

}
