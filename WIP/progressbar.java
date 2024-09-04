package WIP;
import java.awt.*;
import javax.swing.*;

public class progressbar extends JPanel {
    private int progress = 0;  // Progress value (0 to 100)

    public progressbar() {
        this.setPreferredSize(new Dimension(300, 50));  // Set the preferred size of the progress bar
    }

    // Method to set the progress value
    public void setProgress(int progress) {
        this.progress = progress;
        repaint();  // Repaint the component to reflect the new progress
    }

    // Override the paintComponent method to draw the progress bar
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get the size of the component
        int width = getWidth();
        int height = getHeight();
        int arc = height;  // The arc for rounded edges (half of the height for fully rounded ends)

        // Draw the background of the progress bar
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRoundRect(0, 0, width, height, arc, arc);

        // Calculate the width of the progress
        int progressWidth = (int) ((width * progress) / 100.0);

        // Draw the progress bar
        g2d.setColor(Color.GREEN);
        g2d.fillRoundRect(0, 0, progressWidth, height, arc, arc);

        // Draw the progress text in the center of the bar
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
        JFrame frame = new JFrame("Rounded Progress Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the rounded progress bar component
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