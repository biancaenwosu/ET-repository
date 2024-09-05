
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.*;



public class mainpage extends JFrame{
    //initialise all the components
    private JFrame mainframe;
    static JProgressBar Bar = new JProgressBar();
    private JLabel titleheader;
    private String username;
    private String message;
    private final Color purple = new Color(200, 160, 255);
    private Font Header = new Font("Verdana",Font.BOLD,30);
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



        // create  the centre of the page with the pie chart
        
        // create the mainframe
        mainframe = new JFrame();
        // choose the type of layout the main frome will have
        mainframe.setLayout(new BorderLayout());
        // dimensions of the main frame
        mainframe.setSize(1000,700);


        JPanel p = new JPanel();
        Bar.setValue(0);
 
        Bar.setStringPainted(true);
        p.add(Bar);
        mainframe.add(p);
        PieChartPanel pieChartPanel = new PieChartPanel("Total Spending Chart", PieChartPanel.createExpenseDataset());

        pieChartPanel.setPreferredSize(getPreferredSize());
        mainframe.add(pieChartPanel,BorderLayout.CENTER);


        // add things to the mainframe
        mainframe.add(titleheader, BorderLayout.NORTH);



        // check if you can see the page
        mainframe.setVisible(true);
        // if user clicks 'x' then mainframe closes
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    
        

    }
    public static void main(String[] args) {
        new mainpage();
    }
    
}
