import java.awt.Font;
import javax.swing.*;




public class intropage {
    private JFrame page;
    private ImageIcon background; 
    private JLabel bg_label;
    private final JLabel title;
    private JTextField username;
    private JLabel name;
    final Font titleFont = new Font("Verdana", Font.BOLD, 32 );
    final Font nameFont = new Font("Verdana", Font.ITALIC, 16);
    public intropage(){

        background = new ImageIcon(this.getClass().getResource("/background.jpg"));
        bg_label = new JLabel(background);
        bg_label.setSize(400,500);
        title = new JLabel("Expense Tracker");
        title.setFont(titleFont);
        title.setBounds(50, 100, 400, 32);
        username = new JTextField();
        name = new JLabel("Name");       
        username.setBounds(70, 250, 300,50);
        name.setFont(nameFont);
        name.setBounds(20, 250, 100, 50);

        bg_label.add(title);
        bg_label.add(username);
        bg_label.add(name);
        


        page = new JFrame("Intro page");
        page.add(bg_label);

        page.setSize(400,500);
        page.setLayout(null);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true);
    }
    public static void main(String[] args) {
        new intropage();

    }
    

}