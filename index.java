//                Introduction page

//class called adjustment 

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

class Adjustment{
    /*every category is an object*/
    // increase function
    //decrease function
    // edit name function
    // delete function
}

//                   Page layout
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


