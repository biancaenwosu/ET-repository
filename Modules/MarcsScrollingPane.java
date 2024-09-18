import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;  
import java.lang.*;



public class MarcsScrollingPane extends JScrollPane {
    private String total;
    private JLabel titleheader;
    private final Color purple = new Color(200, 160, 255);
    private Font Header = new Font("Verdana",Font.BOLD,30);

    public MarcsScrollingPane(int c, int m){
        this.setLayout(new ScrollPaneLayout());
        this.setPreferredSize(new Dimension(400,400));
        total = "Total: "+ String.valueOf(c) + "/" + String.valueOf(m);

        titleheader = new JLabel(total);
        titleheader.setHorizontalAlignment(JLabel.CENTER);
        titleheader.setFont(Header);
        titleheader.setBackground(purple);
        titleheader.setOpaque(true);

        //this.add(titleheader,BorderLayout.NORTH);

    }
}
