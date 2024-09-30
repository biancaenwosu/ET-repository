
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.*;
import java.lang.*;


public class mainpage extends JFrame{
    //initialise all the components
    private JFrame mainframe;
   // static JProgressBar Bar = new JProgressBar();
    private JLabel titleheader;
    private String username;
    private String message;
    private final Color purple = new Color(200, 160, 255);
    private Font Header = new Font("Verdana",Font.BOLD,30);
    private MarcsScrollingPane Legend;
    void buildConstraints(GridBagConstraints gbc, int gx, int gy, int gw, int gh, int wx, int wy){
        gbc.gridx = gx;
        gbc.gridy = gy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;
        gbc.weightx = wx;
        gbc.weighty = wy;
    }
    public mainpage(){
        // get the profile of the user
        HashMap<String, String> profile = new HashMap<String, String>();
        profile = DataHandler.returnProfile();

        /*              Header              */ 
        
        username = profile.get("Name");
        message = String.format("Welcome %s", username);
        titleheader = new JLabel(message);
        titleheader.setHorizontalAlignment(JLabel.CENTER);
        titleheader.setFont(Header);
        titleheader.setBackground(purple);
        titleheader.setOpaque(true);




        // create the mainframe
        mainframe = new JFrame();
        // dimensions of the main frame
        mainframe.setSize(1000,700);
        // choose the type of layout the main frome will have
      
        GridBagLayout gB = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();



        mainframe.setLayout(gB);
     
        




        //JPanel barPanel = new JPanel(new BorderLayout());
        double currentTotal = Double.valueOf(DataHandler.returnCurrentTotal())/100;
        double finalTotal = Double.valueOf(DataHandler.returnTotal())/100;
     

        MarcsBar  barPanel = new  MarcsBar(DataHandler.returnCurrentTotal(), DataHandler.returnTotal());
  
        Legend = new MarcsScrollingPane(currentTotal, finalTotal);
        // int percentage = (int) Math.round((DataHandler.returnCurrentTotal()/DataHandler.returnTotal())*100);

        // Bar.setValue(percentage);
       

       /* 
       
        mainframe.add(Legend,BorderLayout.WEST);
        mainframe.add(barPanel,BorderLayout.SOUTH);





        */
        PieChartPanel pieChartPanel = new PieChartPanel("Total Spending Chart", PieChartPanel.createExpenseDataset());

        pieChartPanel.setPreferredSize(getPreferredSize());
       
        /* 
        mainframe.add(pieChartPanel,BorderLayout.CENTER);
        // add things to the mainframe
        mainframe.add(titleheader, BorderLayout.NORTH);
 
        */
        constraints.fill = GridBagConstraints.NONE;
        buildConstraints(constraints,2,0,1,1,1,1);
        JButton b = new JButton("Settings");
        gB.setConstraints(b, constraints);
        constraints.fill = GridBagConstraints.BOTH;
        buildConstraints(constraints,0,0,3,1,100,50);
        gB.setConstraints(titleheader, constraints);

        buildConstraints(constraints,1,1,2,1,500,500);
        gB.setConstraints(pieChartPanel, constraints);
        
        buildConstraints(constraints,0,1,1,1,100,250);
        gB.setConstraints(Legend, constraints);

        buildConstraints(constraints,0,2,3,1,50,50);
        gB.setConstraints(barPanel, constraints);

  
        
       
        mainframe.add(titleheader);
        mainframe.add(b);
        mainframe.add(pieChartPanel);
        mainframe.add(Legend);
        mainframe.add(barPanel);

        // check if you can see the page
        mainframe.setVisible(true);
        // if user clicks 'x' then mainframe closes
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    
        

    }
    public static void main(String[] args) {
        new mainpage();
    }
    
}
