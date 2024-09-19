

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.*;



public class setting2page {
    JFrame mainFrame;
    JPanel settings;
    JLabel settingsPageLabel;
    Font headerFont = new Font("Arial",Font.BOLD,40);
    JButton addButton;
    int ypos = 50;
    JPopupMenu popUp;

    
    
    public setting2page(){
        HashMap<String, String> profile = new HashMap<>();
        profile = DataHandler.returnProfile();
        settings = new JPanel();
        settings.setLayout(null);
        // header
        settingsPageLabel = new JLabel("Settings Page");
        settingsPageLabel.setBounds(0,0,600,50);
        settingsPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsPageLabel.setFont(headerFont);
        settingsPageLabel.setBackground(new Color(180, 130, 255));
        settings.add(settingsPageLabel);
        // back to main button
        JButton main = new JButton("Back to main<<");
        main.setBounds(0,0,150,50);
        main.addActionListener((ActionEvent e) -> {
            mainpage.main(null);
            settings.setVisible(false);
        });

        settings.add(main);
        for (String key: profile.keySet()){
            if (!"Name".equals(key)){
                Component(key, profile);
                ypos += 70;
            }
        }
        settings.setPreferredSize(new java.awt.Dimension(600,ypos+70));

        addButton();
        


        // add this all to a scroll pane so that is can be scrolled through
        JScrollPane scrollPane = new JScrollPane(settings);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //mainFrame set up
        mainFrame = new JFrame("Settings Page");
        settings.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)){
                    
                    //System.out.println("detected");
                    
                    
                    String component = detectComponent(DataHandler.returnProfile(), e.getY());
                    popUpmenu(component);
                    popUp.show(settings,e.getX(),e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            
            }
            
        });
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700,500);
        mainFrame.add(scrollPane);
        mainFrame.setVisible(true);


        
    }
    private String detectComponent(HashMap<String, String>profile, int mouseY){
        String component;
        int numberOfComponents = profile.size();  // Total number of components
        int componentHeight = (ypos- 50) / numberOfComponents;  // Calculate height per component
        // Adjust mouseY to ignore the offset from the top
        int adjustedY = mouseY - 50;
        //System.out.println(ypos);
        //System.out.println(mouseY);
        
        // Determine which component was clicked
        int componentIndex = adjustedY / componentHeight;  // Find the index of the component clicked

        if (componentIndex >= 0 && componentIndex < numberOfComponents) {
            // Get the component based on the index (convert to array for access)
            component = (String) profile.keySet().toArray()[componentIndex];
            //System.out.println("Right-clicked on: " + component);
        } else {
            component = "null";
            //System.out.println("No component found at this position.");
        }
        return component;
       
    }
    private void popUpmenu(String component){
        popUp = new JPopupMenu();
        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener((ActionEvent e) -> {
            deleteComponent(DataHandler.returnProfile(),component);
        });
        popUp.add(delete);
    }
    private void refereshUI(HashMap<String,String> profile){
        settings.removeAll();
        settingsPageLabel = new JLabel("Settings Page");
        settingsPageLabel.setBounds(0,0,600,50);
        settingsPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsPageLabel.setFont(headerFont);
        settingsPageLabel.setBackground(new Color(180, 130, 255));
        settings.add(settingsPageLabel);
        // back to main button
        JButton main = new JButton("Back to main<<");
        main.setBounds(0,0,150,50);
        main.addActionListener((ActionEvent e) -> {
            mainpage.main(null);
            settings.setVisible(false);
        });

        settings.add(main);
        ypos = 50;  // Reset ypos
        for (String key : profile.keySet()) {
            if (!"Name".equals(key)) {
                Component(key, profile);
                ypos += 70;
            }
        }
        settings.setPreferredSize(new java.awt.Dimension(600, ypos + 70));
        addButton();
        settings.revalidate();
        settings.repaint();
    }
    private void deleteComponent(HashMap<String,String> profile,String component){
        if (component != null){
            profile.remove(component);

        }
        refereshUI(profile);
        //System.out.println("Deleted component: " + component);

    }
    private void Component(String component,HashMap<String,String> profile){
        

        JLabel label = new JLabel(component);
        label.setBounds(5,ypos,200,50);
        JTextField number = new JTextField(profile.get(component));
        sliderbar slider_bar = new sliderbar(number.getText());
        slider_bar.slider.setBounds(210,ypos,300,50);
        JButton button = new JButton("Apply");
        button.setBounds(520,ypos,100,50);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String valueChosen;
                if(slider_bar.sliderListener() == Double.valueOf(profile.get(component)).intValue()){
                    valueChosen = number.getText();
                }else{
                    valueChosen = String.valueOf(slider_bar.sliderListener());
                }
                System.out.println("Chosen value: "+valueChosen);
                
                DataHandler.UpdateValue(component,valueChosen,profile);
                refereshUI(profile);

                number.setText(valueChosen);
            }
            
        });
        number.setBounds(630,ypos,50,50);

        settings.add(label);
        settings.add(slider_bar.slider);
        settings.add(button);
        settings.add(number);



        
        
    }
    private void addButton(){
        JTextField addText = new JTextField();
        addText.setBounds(210,ypos,200,50);       
        addButton = new JButton("Add new option");
        addButton.setBounds(5,ypos, 200,50);
        addButton.addActionListener((ActionEvent e) -> {
            addComponent(addText.getText(),DataHandler.returnProfile());
            updateButton(addButton);
            updateButton(addText);
            settings.setPreferredSize(new java.awt.Dimension(600,ypos+160));
            settings.revalidate();
            settings.repaint();
          
        });
        settings.add(addButton);
        settings.add(addText);
    }
    private void addComponent(String component,HashMap<String,String> profile){
       
        profile.put(component,"0");

        JLabel label = new JLabel(component);
        label.setBounds(5,ypos,200,50);
        JTextField number = new JTextField(profile.get(component));
        sliderbar slider_bar = new sliderbar(number.getText());
        slider_bar.slider.setBounds(210,ypos,300,50);
        JButton button = new JButton("Apply");
        button.setBounds(520,ypos,100,50);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String valueChosen;
                if(slider_bar.sliderListener() == Double.valueOf(profile.get(component)).intValue()){
                    valueChosen = number.getText();
                    System.out.println(valueChosen);
              
                }else{
                    valueChosen = String.valueOf(slider_bar.sliderListener());
                    number.setText(valueChosen);
                }
                System.out.println("Chosen value: "+valueChosen);
                
                DataHandler.UpdateValue(component,valueChosen,DataHandler.returnProfile());
                refereshUI(profile);
                
            }
            
        });
        number.setBounds(630,ypos,50,50);

        settings.add(label);
        settings.add(slider_bar.slider);
        settings.add(button);
        settings.add(number);
        ypos += 70;

    }
    private void updateButton(JButton addButton){
        addButton.setBounds(5,ypos+70,200,50);
    }
    private void updateButton(JTextField textField){
        textField.setText("");
        textField.setBounds(210,ypos+70,200,50);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new setting2page());
    }

}
