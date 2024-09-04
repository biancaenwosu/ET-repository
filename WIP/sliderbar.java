
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
public class sliderbar {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("JSlider Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Create a JLabel to display the current value of the slider
        JLabel valueLabel = new JLabel("Value: 1", JLabel.CENTER);

        // Create a JSlider with a range from 1 to 200
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 200, 1);
        slider.setMajorTickSpacing(50);  // Major ticks every 50 units
        slider.setMinorTickSpacing(10);  // Minor ticks every 10 units
        slider.setPaintTicks(true);      // Show tick marks
        slider.setPaintLabels(true);     // Show labels for major ticks

        // Add a ChangeListener to update the label when the slider value changes
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                valueLabel.setText("Value: " + value);
            }
        });

        // Add the slider and label to the frame
        frame.add(slider, BorderLayout.CENTER);
        frame.add(valueLabel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
    
