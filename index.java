//                Introduction page

//class called adjustment 

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

class Adjustment{
    /*every category is an object*/
    // change in amount function
    // edit name function
    // delete function



    private String name;
    private double currentValue;

    public Adjustment(String name, double currentValue){
        this.name = name;
        this.currentValue = currentValue;
    }

    public String getName(){
        return this.name;
    }
    public double getCurrentValue(){
        return this.currentValue;
    }

    public void changeCurrentValue(double newValue){
        this.currentValue = newValue;
    }
    // Delete made later


}

//Page layout
// title/ header
// categories
// sliders
// footer
// scroll bar
// frame
public class index extends JFrame {
    final private Font header = new Font("Segoe print", Font.BOLD, 30);
    public void initialise() {
        /*              Header/ Title Label          */
        JLabel Welcome = new JLabel("Welcome to ET");
        Welcome.setFont(header);
        /*              Categories Panel             */

        JLabel Rent = new JLabel("Rent");
        JLabel Groceries = new JLabel("Groceries");
        JLabel Bills = new JLabel("Household bills");
        JLabel out = new JLabel("Going out");
        JLabel Transport = new JLabel("Transport");
        JLabel Takeaways = new JLabel("Restraunts and takeaways");
        JLabel Shopping = new JLabel("Shopping");
        JLabel Events = new JLabel("Events");
        JLabel Health = new JLabel("Health");
        JLabel Other = new JLabel("Other");
        JLabel Phone = new JLabel("Mobile phone");
        JLabel School = new JLabel("Course material");
        JLabel Gifts = new JLabel("Gifts and charity");
        JLabel FF = new JLabel("Friends and Family");

        








        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(Welcome, BorderLayout.NORTH);

        add(mainPanel);
        setTitle("Welcome to ET!");
        setSize(400,500);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
    public static void main(String[] args) {
        index mainframe = new index();
        mainframe.initialise();
    }

}


