import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;  
import java.lang.*;
import javax.swing.text.DefaultCaret;


public class MarcsScrollingPane extends JPanel {
    private static String total;
    private static JLabel titleheader;
    private final Color purple = new Color(200, 160, 255);
    private Font Header = new Font("Verdana",Font.BOLD,25);
    private static JTextArea tA = new JTextArea();
    public MarcsScrollingPane(double c, double m){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400,400));
        this.setBorder(new LineBorder(new Color(0,0,0),1));
        total = "Total: £"+ String.valueOf(c) + "/£" + String.valueOf(m);
        
        titleheader = new JLabel(total);
        titleheader.setHorizontalAlignment(JLabel.CENTER);
        titleheader.setFont(Header);
        titleheader.setBackground(purple);
        titleheader.setOpaque(true);
        titleheader.setToolTipText(total);
        
        tA.setEditable(false);
        tA.setFont(new Font("Arial", Font.PLAIN, 20));
        DefaultCaret caret = (DefaultCaret) tA.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);  
        tA.setCaret(caret);
        tA.getCaret().setVisible(false);
    
        JScrollPane scrollPane = new JScrollPane(tA);



        HashMap<String, Double> dataMap = DataHandler.returnCurrentValueProfile();

        for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
            tA.setText(tA.getText()+" \r\n "+entry.getKey()+": "+entry.getValue());
        }











       
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane,BorderLayout.CENTER);
        this.add(titleheader,BorderLayout.NORTH);

    }

    public static void updateLegend( HashMap<String, Double> dataMap){

        total = "Total: £"+ String.valueOf(Double.valueOf(DataHandler.returnCurrentTotal())/100) + "/£" + String.valueOf(Double.valueOf(DataHandler.returnTotal())/100);
        titleheader.setText(total);
        titleheader.setToolTipText(total);



        tA.setText("");
        for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
            tA.setText(tA.getText()+" \r\n "+entry.getKey()+": "+entry.getValue());
        }
    }
}
