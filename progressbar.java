
import java.awt.*;
import javax.swing.*;

public class progressbar extends JPanel {
    private int progress = 0;  // Progress value (0 to 100)

    public progressbar() {
        this.setPreferredSize(new Dimension(200, 200));  // Set the size of the progress bar
    }

    // Method to set the progress value
    public void setProgress(int progress) {
        this.progress = progress;
        repaint();  // Repaint the component to reflect the new progress
    }

    // Override the paintComponent method to draw the round progress bar
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get the size of the component
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height) - 10;  // Ensure the circle fits within the component
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        // Draw the background circle (full circle)
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(x, y, diameter, diameter);

        // Draw the progress arc
        g2d.setColor(Color.GREEN);
        int angle = (int) (360 * (progress / 100.0));
        g2d.fillArc(x, y, diameter, diameter, 90, -angle);

        // Draw the inner circle to create the "donut" effect
        int innerDiameter = diameter - 20;
        int innerX = x + 10;
        int innerY = y + 10;
        g2d.setColor(getBackground());
        g2d.fillOval(innerX, innerY, innerDiameter, innerDiameter);

        // Draw the progress text in the center of the circle
        String progressText = progress + "%";
        Font font = new Font("Arial", Font.BOLD, 18);
        FontMetrics metrics = g2d.getFontMetrics(font);
        int textX = (width - metrics.stringWidth(progressText)) / 2;
        int textY = (height - metrics.getHeight()) / 2 + metrics.getAscent();
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(progressText, textX, textY);
    }

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Round Progress Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the round progress bar component
        progressbar progressBar = new progressbar();
        frame.add(progressBar);
        frame.pack();
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);

        // Simulate progress
        new Timer(100, e -> {
            int progress = progressBar.progress + 1;
            if (progress > 100) {
                ((Timer) e.getSource()).stop();
            } else {
                progressBar.setProgress(progress);
            }
        }).start();
    }
}
    
